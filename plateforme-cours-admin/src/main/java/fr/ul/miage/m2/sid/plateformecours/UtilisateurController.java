package fr.ul.miage.m2.sid.plateformecours;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ul.miage.m2.sid.plateformecours.entity.Cours;
import fr.ul.miage.m2.sid.plateformecours.entity.Episode;
import fr.ul.miage.m2.sid.plateformecours.entity.Utilisateur;

@Controller
@EnableAutoConfiguration
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository ur;

	@Autowired
	private CoursRepository cr;

	@Autowired
	private EpisodeRepository er;

	/*
	 * --------------------- PARTIE UTILISATEUR ---------------------
	 */

	/*
	 * Page d'accueil
	 */
	@GetMapping("/")
	public String home() {
		return "projet";
	}

	@GetMapping("/accueil")
	public String accueil(ModelMap modelMap, HttpSession httpSession) {
		if (httpSession.getAttribute("id") != null) {
			modelMap.put("session", true);
		}
		return "accueil";
	}

	/*
	 * Page de connection
	 */
	@GetMapping("/connexion")
	public ModelAndView connexion(@RequestParam("erreur") Optional<String> erreur, ModelMap modelMap,
			HttpSession httpSession) {
		if (httpSession.getAttribute("id") != null) {
			return new ModelAndView("redirect:/profil");
		}
		if (erreur.isPresent()) {
			modelMap.put("erreur", erreur);
		}
		return new ModelAndView("connexion");
	}

	@PostMapping("/connexion/check")
	public ModelAndView verificationConnexion(@RequestParam("email") String email, ModelMap modelMap,
			HttpSession httpSession) {
		Utilisateur u = ur.findByEmail(email);
		if (u == null) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("erreur", true);
			mav.setViewName("redirect:/connexion");
			return mav;
		} else {
			httpSession.setAttribute("id", u.getId());
			httpSession.setAttribute("email", u.getEmail());
			return new ModelAndView("redirect:/profil", modelMap);
		}
	}

	/*
	 * Page pour déconnecter l'utilisateur
	 */
	@GetMapping("/deconnexion")
	public ModelAndView deconnexion(HttpSession httpSession) {
		httpSession.invalidate();
		return new ModelAndView("redirect:/connexion");// ou accueil ?
	}

	/*
	 * Page d'inscription
	 */
	@GetMapping("/inscription")
	public ModelAndView inscription(HttpSession httpSession) {
		if (httpSession.getAttribute("id") != null) {
			return new ModelAndView("redirect:/profil");
		}
		return new ModelAndView("inscription");
	}

	/*
	 * Valider une inscription
	 */
	@PostMapping("/inscription/valide")
	public String validationInscription(@RequestParam("email") String email, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, ModelMap modelMap) {
		Utilisateur u = ur.save(new Utilisateur(email, nom, prenom));
		modelMap.put("nom", u.getNom());
		modelMap.put("prenom", u.getPrenom());
		modelMap.put("email", u.getEmail());
		modelMap.put("inscription", true);
		return "profil";
	}

	/*
	 * Accéder à son profil
	 */
	@GetMapping("/profil")
	public String getProfil(ModelMap modelMap, HttpSession httpSession) {
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			Utilisateur u = ur.findById(userId).get();
			modelMap.put("nom", u.getNom());
			modelMap.put("prenom", u.getPrenom());
			modelMap.put("email", u.getEmail());
			return "profil";
		}
		return "connexion";
	}

	/*
	 * Visualiser la liste des cours
	 */
	@GetMapping("/cours")
	public String listeCours(ModelMap modelMap) {
		List<Cours> listeCours = cr.findAll();
		for (Cours c : listeCours) {
			Link link = WebMvcLinkBuilder.linkTo(UtilisateurController.class).slash("cours").slash(c.getId())
					.withSelfRel();
			c.add(link);
		}
		modelMap.put("cours", listeCours);
		return "listeCours";
	}

	/*
	 * Voir le contenu d'un cours
	 */
	@GetMapping("/cours/{id}")
	public String voirCours(@PathVariable Long id, ModelMap modelMap, HttpSession httpSession) {
		Cours c = cr.findById(id).get();
		modelMap.put("titre", c.getTitre());
		modelMap.put("description", c.getDescription());
		modelMap.put("prix", c.getPrix());
		List<Episode> episodes = c.getEpisodes();
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			if (ur.findById(userId).get().getCours().contains(c)) {
				modelMap.put("possede", true);
				for (Episode e : episodes) {
					Link link = WebMvcLinkBuilder.linkTo(UtilisateurController.class).slash("bibliotheque")
							.slash(c.getId()).slash(e.getId()).withSelfRel();
					e.add(link);
				}
			}
		}
		modelMap.put("episodes", episodes);
		return "cours";
	}

	/*
	 * Acheter un cours
	 */
	@GetMapping("/cours/{id}/achat")
	public String acheterCours(@RequestParam("erreurTransaction") Optional<String> erreurTransaction,
			@PathVariable Long id, ModelMap modelMap, HttpSession httpSession) {
		if (erreurTransaction.isPresent()) {
			modelMap.put("erreurTransaction", erreurTransaction);
		}
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			Cours c = cr.findById(id).get();
			Utilisateur u = ur.findById(userId).get();
			if (u.getCours().contains(c)) {
				modelMap.put("contenuDejaAchete", true);
			} else {
				modelMap.put("titre", c.getTitre());
				modelMap.put("prix", c.getPrix());
			}
		} else {
			modelMap.put("accesRefuse", true);
		}
		return "achat";
	}

	/*
	 * Valider achat d'un cours
	 */
	@PostMapping("/cours/{idCours}/valide")
	public ModelAndView validerAchatCours(@RequestParam("numeroCarte") String numeroCarte,
			@RequestParam("dateExpiration") String dateExpiration, @RequestParam("codeCarte") String codeCarte,
			@PathVariable Long idCours, ModelMap modelMap, HttpSession httpSession) {
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			if (VerificationCarteBancaire.transactionBancaireValide(numeroCarte, dateExpiration, codeCarte)) {
				Utilisateur u = ur.findById(userId).get();
				Cours c = cr.findById(idCours).get();
				u.getCours().add(c);
				ur.save(u);
				return new ModelAndView("redirect:/bibliotheque");
			} else {
				ModelAndView mav = new ModelAndView();
				mav.addObject("erreurTransaction", true);
				mav.setViewName("redirect:/cours/" + idCours + "/achat");
				return mav;
			}

		}
		modelMap.put("accesRefuse", true);
		return new ModelAndView("cours");
	}

	/*
	 * Voir les cours achetés
	 */
	@GetMapping("/bibliotheque")
	public String listeCoursAchetes(ModelMap modelMap, HttpSession httpSession) {
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			List<Cours> listeCours = ur.findById(userId).get().getCours();
			for (Cours c : listeCours) {
				Link link = WebMvcLinkBuilder.linkTo(UtilisateurController.class).slash("bibliotheque").slash(c.getId())
						.withSelfRel();
				c.add(link);
			}
			modelMap.put("cours", listeCours);
		} else {
			modelMap.put("accesRefuse", true);
		}
		return "listeCours";
	}

	/*
	 * Visionner un cours acheté et la liste des épisodes
	 */
	@GetMapping("/bibliotheque/{id}")
	public String contenuCoursAchete(@PathVariable Long id, ModelMap modelMap, HttpSession httpSession) {
		Cours c = cr.findById(id).get();
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			if (ur.findById(userId).get().getCours().contains(c)) {
				modelMap.put("connexion", true);
				modelMap.put("possede", true);
			}
		}
		modelMap.put("titre", c.getTitre());
		modelMap.put("description", c.getDescription());
		modelMap.put("prix", c.getPrix());
		List<Episode> episodes = c.getEpisodes();
		for (Episode e : episodes) {
			Link link = WebMvcLinkBuilder.linkTo(UtilisateurController.class).slash("bibliotheque").slash(c.getId())
					.slash(e.getId()).withSelfRel();
			e.add(link);
		}
		modelMap.put("episodes", episodes);
		return "cours";
	}

	/*
	 * Visionner un épisode d'un cours acheté
	 */
	@GetMapping("/bibliotheque/{idCours}/{idEpisode}")
	public String contenuEpisodeAchete(@PathVariable Long idCours, @PathVariable Long idEpisode, ModelMap modelMap,
			HttpSession httpSession) {
		Cours c = cr.findById(idCours).get();
		Object user = httpSession.getAttribute("id");
		if (user instanceof Long) {
			Long userId = (Long) user;
			modelMap.put("session", true);
			if (ur.findById(userId).get().getCours().contains(c)) {
				Episode e = er.findById(idEpisode).get();
				modelMap.put("nom", e.getNom());
				modelMap.put("lien", e.getLien());
				return "episode";
			}
		}
		modelMap.put("refuse", true);
		return "episode";
	}

}
