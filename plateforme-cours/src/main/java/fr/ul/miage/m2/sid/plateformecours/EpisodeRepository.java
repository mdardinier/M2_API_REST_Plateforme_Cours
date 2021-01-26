package fr.ul.miage.m2.sid.plateformecours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ul.miage.m2.sid.plateformecours.entity.Cours;
import fr.ul.miage.m2.sid.plateformecours.entity.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
	
//	@Query("Select c from Episode e, Cours c where e.Cours = c.id and e.id = :id")
//	Cours findCours(@Param("id") Long id);
}
