package fr.ul.miage.m2.sid.plateformecours.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cours")
public class Cours extends RepresentationModel<Cours> {

	@Id
	@GeneratedValue
	@Column(name = "id_cours")
	private Long id;

	private String titre;

	@Column(length=600)
	private String description;

	private Double prix;

	@ManyToMany
    @JoinTable(
            name = "Utilisateur_Cours", 
            joinColumns = {@JoinColumn(name = "id_cours")}, inverseJoinColumns = {@JoinColumn(name = "id")}
        )
	private List<Utilisateur> utilisateurs;
	
    @OneToMany
    private List<Episode> episodes;

	public Cours(String titre, String descr, Double prix) {
		setTitre(titre);
		setDescription(descr);
		setPrix(prix);
		setEpisodes(new ArrayList<Episode>());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (episodes == null) {
			if (other.episodes != null)
				return false;			
		} 	
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		//Modification pour comparer uniquement le contenu des épisodes un par un
		if(episodes.size() != other.episodes.size()) {
			return false;
		}
		for(int i = 0; i < episodes.size();i++) {
			if(! episodes.get(i).equals(other.episodes.get(i))) {
				return false;
			}
		}	
		return true;
	}
	
}
