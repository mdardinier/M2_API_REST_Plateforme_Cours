package fr.ul.miage.m2.sid.plateformecours;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ul.miage.m2.sid.plateformecours.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long>{
}
