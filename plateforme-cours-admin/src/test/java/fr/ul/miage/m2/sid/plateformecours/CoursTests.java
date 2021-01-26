package fr.ul.miage.m2.sid.plateformecours;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.ul.miage.m2.sid.plateformecours.entity.Cours;
import fr.ul.miage.m2.sid.plateformecours.entity.Episode;
import fr.ul.miage.m2.sid.plateformecours.entity.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { PlateformeCoursApplication.class })
@AutoConfigureTestDatabase
@Transactional
class CoursTests {

	@Resource
	private CoursRepository cr;

	private Cours c;

	@Resource
	private EpisodeRepository er;

	private Episode e;
	
	@Resource
	private UtilisateurRepository ur;

	@BeforeEach
	public void initialize() {
		c = new Cours(Long.valueOf("1"), "Titre", "Description", 10.5, new ArrayList<Utilisateur>(), new ArrayList<Episode>());
		e = new Episode(Long.valueOf("1"), "Nom", "Lien");
		c.getEpisodes().add(e);
	}

	@Test
	void sauvegarderCours() {
		er.save(e);
		Cours c2 = cr.save(c);
		assertEquals(c, c2);
	}

	@Test
	void chercherCoursId() {
		er.save(e);
		cr.save(c);
		Cours c3 = cr.findById(Long.valueOf("1")).get();
		assertEquals(c, c3);
	}

	@Test
	void updateCours() {
		cr.save(c);
		Cours c4 = cr.findById(Long.valueOf("1")).get();
		c4.setTitre("Titre Modifié");
		cr.save(c4);
		Cours c5 = cr.findById(Long.valueOf("1")).get();
		assertEquals(c4, c5);
	}

	@Test
	void sauvegarderEpisode() {
		cr.save(c);
		Episode e2 = er.save(e);
		assertEquals(e, e2);
	}

	@Test
	void chercherEpisodeId() {
		cr.save(c);
		er.save(e);
		Episode e3 = er.findById(Long.valueOf("1")).get();
		assertEquals(e, e3);
	}

	@Test
	void updateEpisode() {
		cr.save(c);
		er.save(e);
		Episode e4 = er.findById(Long.valueOf("1")).get();
		e4.setNom("Nom Modifié");
		er.save(e4);
		Episode e5 = er.findById(Long.valueOf("1")).get();
		assertEquals(e4, e5);
	}

	@Test
	void listerEpisodesCours() {
		cr.save(c);
		er.save(e);
		List<Episode> episodes = cr.findById(Long.valueOf("1")).get().getEpisodes();
		assertEquals(e, episodes.get(0));
		assertEquals(1, episodes.size());
	}
	
	@Test
	void listerUtilisateursCours() {
		Cours c = cr.findById(Long.valueOf("1")).get();
		Utilisateur u = ur.findById(Long.valueOf("1")).get();
		assertEquals(u, c.getUtilisateurs().get(0));
		assertEquals(1, c.getUtilisateurs().size());
	}

}
