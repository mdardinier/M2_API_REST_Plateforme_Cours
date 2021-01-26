package fr.ul.miage.m2.sid.plateformecours.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur extends RepresentationModel<Utilisateur> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String nom;

	private String prenom;
	
    @ManyToMany
    @JoinTable(
            name = "Utilisateur_Cours", 
            joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "ID_COURS")}
        )
    private List<Cours> cours;

	public Utilisateur(String email, String nom, String prenom) {
		setEmail(email);
		setNom(nom);
		setPrenom(prenom);
		setCours(new ArrayList<Cours>());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (cours == null) {
			if (other.cours != null)
				return false;
		}
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		//Modification pour comparer uniquement le contenu des cours achetés un par un
		if(cours.size() != other.cours.size()) {
			return false;
		}
		for(int i = 0; i < cours.size();i++) {
			if(! cours.get(i).equals(other.cours.get(i))) {
				return false;
			}
		}	
		return true;
	}
}
