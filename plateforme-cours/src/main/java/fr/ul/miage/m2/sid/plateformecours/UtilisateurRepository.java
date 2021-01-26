package fr.ul.miage.m2.sid.plateformecours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.ul.miage.m2.sid.plateformecours.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	@Query("Select u from Utilisateur u where email = :email")
	Utilisateur findByEmail(@Param("email") String email);

}
