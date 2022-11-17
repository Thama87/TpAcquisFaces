package dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Livres;
import utils.HibernateUtils;

@ManagedBean(name="livresDao")
public class LivresDao {
	private Livres livre;
	private int id;
	private String titre;
	private List<Livres> listLivres = getAll();

	public LivresDao() {}
	
	

	public Livres getLivre() {
		return livre;
	}
	public void setLivre(Livres livre) {
		this.livre = livre;
	}


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


	public List<Livres> getListLivres() {
		return listLivres;
	}
	public void setListLivres(List<Livres> listLivres) {
		this.listLivres = listLivres;
	}

	
	public List<Livres> getAll() {
		Session session = (Session) HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Livres> q = session.createQuery("SELECT l FROM livres l", Livres.class);
			transaction.commit();
			return (q.list());
		}
		catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			transaction.rollback();
			return new ArrayList<Livres>();
		}
	}

	
	public void persist(Livres l) {
		Session session = (Session) HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.persist(l);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			transaction.rollback();
		}
		session.close();
	}
	
	
	public void getUn(String s) {
		this.titre = s;
	}
	public void getDeux(Livres l) {
		this.livre = l;
	}
	
	
	public void update(Livres l) {
		Session session = (Session) HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(l);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			System.out.println("Erreur à la modification : "+e.getMessage());
		}
		session.close();
	}
	
	public void delete(Livres l) {
		Session session = (Session) HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(l);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			System.out.println("Erreur à la suppression : "+e.getMessage());
		}
		session.close();
	}
	
}
