package entity;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.LivresDao;

@ManagedBean(name="livres")
@Entity(name="livres")
@Table(name="livres")
public class Livres {
	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Arguments ----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id=0;
	@Column(name="titre")
	private String titre;
	@Column(name="auteur")
	private String auteur;
	@Column(name="date")
	private String date;
	@Column(name="prix")
	private int prix;
	

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Contructeurs -------------------------------------------//
	//-------------------------------------------------------------------------------------------------//
	
	public Livres() {}
	
	
	public Livres(String titre, String auteur, String date, int prix) {
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.prix = prix;
	}
	

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Getters et Setters -------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getprix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- CRUD ---------------------------------------------------//
	//-------------------------------------------------------------------------------------------------//
	
	public void get() {
		LivresDao dao = new LivresDao();
		dao.getDeux(this);
	}
	
	public void ajouter() {
		LivresDao dao = new LivresDao();
		dao.persist(this);
	}
	
	public void update() {
		LivresDao dao = new LivresDao();
		dao.update(this);
	}
	
	public void delete() {
		LivresDao dao = new LivresDao();
		dao.delete(this);
	}
	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Méthodes -----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		return titre;
	}

	
	
}
