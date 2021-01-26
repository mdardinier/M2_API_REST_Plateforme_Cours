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
class UtilisateurTests {

	@Resource
	private UtilisateurRepository ur;

	@Resource
	private CoursRepository cr;

	private Utilisateur u;

	private String email;

	@BeforeEach
	public void initialize() {
		email = "test@email.com";
		u = new Utilisateur(Long.valueOf("1"), email, "TestNom", "TestPrenom", new ArrayList<Cours>());
	}

	@Test
	void sauvegarderUser() {
		Utilisateur u2 = ur.save(u);
		assertEquals(u, u2);
	}

	@Test
	void chercherUserId() {
		ur.save(u);
		Utilisateur u3 = ur.findById(Long.valueOf("1")).get();
		assertEquals(u, u3);
	}

	@Test
	void chercherUserEmail() {
		ur.save(u);
		Utilisateur u4 = ur.findByEmail(email);
		assertEquals(u, u4);
	}

	@Test
	void updateUser() {
		ur.save(u);
		Utilisateur u5 = ur.findByEmail(email);
		u5.setPrenom("PrenomModifié");
		ur.save(u5);
		Utilisateur u6 = ur.findByEmail(email);
		assertEquals(u5, u6);
	}

	@Test
	void listerCours() {
		Cours c = new Cours(Long.valueOf("1"), "Titre", "Description", 10.5, new ArrayList<Utilisateur>(), new ArrayList<Episode>());
		u.getCours().add(c);
		cr.save(c);
		ur.save(u);
		List<Cours> listeCours = ur.findById(Long.valueOf("1")).get().getCours();
		assertEquals(c, listeCours.get(0));
		assertEquals(1, listeCours.size());
	}

	@Test
	void listerAucunCours() {
		List<Cours> listeCours = ur.findById(Long.valueOf("2")).get().getCours();
		assertEquals(0, listeCours.size());
	}
}
