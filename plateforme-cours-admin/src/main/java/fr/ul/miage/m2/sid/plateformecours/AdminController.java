package fr.ul.miage.m2.sid.plateformecours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.ul.miage.m2.sid.plateformecours.entity.Utilisateur;

@Controller
@EnableAutoConfiguration
public class AdminController {
	
	@Autowired
	private UtilisateurRepository ur;

	@Autowired
	private CoursRepository cr;

	@Autowired
	private EpisodeRepository er;

	/*
	 * --------------------- PARTIE ADMINISTRATEUR ---------------------
	 */

	/*
	 * Consulter la liste des utilisateurs existants
	 */
	@GetMapping("/utilisateurs")
	public String getUtilisateurs(ModelMap modelMap) {
		List<Utilisateur> utilisateurs = ur.findAll();
		for (Utilisateur u : utilisateurs) {
			Link link = WebMvcLinkBuilder.linkTo(UtilisateurController.class).slash("utilisateurs").slash(u.getId())
					.withSelfRel();
			u.add(link);
		}
		modelMap.put("utilisateurs", ur.findAll());
		return "utilisateurs";
	}

	/*
	 * Consulter les informations d'un utilisateur par son ID
	 */
	@GetMapping("/utilisateurs/{id}")
	public String getUtilisateurbyId(@PathVariable Long id, ModelMap modelMap) {
		Utilisateur u = ur.findById(id).get();
		modelMap.put("nom", u.getNom());
		modelMap.put("prenom", u.getPrenom());
		modelMap.put("email", u.getEmail());
		return "profil";
	}

	/*
	 * Mettre à jour un utilisateur
	 */

	/*
	 * Supprimer un utilisateur (changer son statut)
	 */

	/*
	 * Créer un cours
	 */

	/*
	 * Mettre à jour un cours
	 */

	/*
	 * Supprimer un cours
	 */

	/*
	 * Créer un épisode
	 */

	/*
	 * Mettre à jour un épisode
	 */

	/*
	 * Supprimer un épisode
	 */
}