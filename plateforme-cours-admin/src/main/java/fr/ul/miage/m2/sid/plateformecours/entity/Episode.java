package fr.ul.miage.m2.sid.plateformecours.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Data = Getter + Setter + Hashcode/Equals + toString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "episode")
public class Episode extends RepresentationModel<Episode> {

	@Id
	@GeneratedValue
	private Long id;

	private String nom;

	private String lien;

	public Episode(String nom, String lien) {
		setNom(nom);
		setLien(lien);
	}

}
