package jpa.vehiculeEclipseLink.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class VehiculeDaoJpaImpl implements VehiculeDao {
	
	private EntityManager em;
	public VehiculeDaoJpaImpl(EntityManager em) {
		this.em= em;
		}
	
	@Override
	protected void finalize() throws Throwable {
		if((this.em!= null) && !this.em.isOpen()) {
			
			try{
				this.em.close();
				} 
			catch(Exception e) {e.printStackTrace();}}
		super.finalize();}
	
	public void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation) {
		EntityTransaction etx= null;
		
		try{
			// Initialiser une transaction JPA 
			etx= this.em.getTransaction();
			etx.begin();
			
			// Construire l'objet Vehicule
			Vehicule vehicule= new Vehicule();
			vehicule.setCodeInterne(_codeInterne);
			vehicule.setImmatriculation(_immatriculation);
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			Date utildate= simpleDateFormat.parse(_dateMiseEnCirculation);
			vehicule.setDateMiseEnCirculation(utildate);
			
			// Insérer 
			this.em.persist(vehicule);
			
			// Commiter la transaction JPA
			etx.commit();
			
		} 
		
		catch(Exception e) {e.printStackTrace(); if(etx!= null) {etx.rollback();}}
		
		
	}
	public void insererVehicule(Vehicule _vehicule) {
		EntityTransaction etx= null;
		
		try{
			// Initialiser une transaction JPA 
			etx= this.em.getTransaction();
			etx.begin();
						
			// Insérer 
			this.em.persist(_vehicule);
			
			// Commiter la transaction JPA
			etx.commit();
			
		} 
		
		catch(Exception e) {e.printStackTrace(); if(etx!= null) {etx.rollback();}}
		
	}
	
	public List<Vehicule> rechercherTousLesVehicules() {
			String queryString= "select * from Vehicule;";
			Query query= this.em.createNativeQuery(queryString, Vehicule.class);
			return query.getResultList();
	}
	public List<Vehicule> rechercherVehiculeParImmatriculation(String _immatriculation) {
		String queryString= "select * from Vehicule where immatriculation= :immatriculation";
		Query query= this.em.createNativeQuery(queryString, Vehicule.class);
		query.setParameter("immatriculation", _immatriculation);
		return query.getResultList();
	}
	
	public Vehicule rechercherVehiculeParId(long _id) {
		// Find retournel'entité si elle existe si non null
		return this.em.find(Vehicule.class, _id);
	}
	
	public void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne) {
		
		// Chercher le vehicule
		Vehicule vehicule= this.em.find(Vehicule.class, _id);
		
		if(vehicule!= null) {
			EntityTransaction etx= null;
			try {
			// Initialiserunetransaction JPA
			etx= this.em.getTransaction();
			etx.begin();
			
			// Modifier l'entité
			// La modification nenécessite pas d'instruction particulière
			vehicule.setCodeInterne(_codeInterne);
			
			// Commiter latransaction JPA
			etx.commit();
			} 
			catch(Exception e) {e.printStackTrace();if(etx!= null) {etx.rollback();}}}
		}
		
	
	
	public void supprimerVehiculeParId(Long _id) {
			// Chercher le vehicule
				Vehicule vehicule= this.em.find(Vehicule.class, _id);
				
				if(vehicule!= null) {
					EntityTransaction etx= null;
					try {
					// Initialiserunetransaction JPA
					etx= this.em.getTransaction();
					etx.begin();
					
					// supprimer l'entité
					this.em.remove(vehicule);
					
					// Commiter latransaction JPA
					etx.commit();
					} 
					catch(Exception e) {e.printStackTrace();if(etx!= null) {etx.rollback();}}}
				}
		
	
	
	public void modifierVehiculeCodeInterneParId(Vehicule _vehicule) {
		EntityTransaction etx= null;
		try{
			// Initialiser une transaction JPA
			etx= this.em.getTransaction();
			etx.begin();
			// Pour modifier l'entité il faut la rattacher au contexte persisant 
			this.em.merge(_vehicule);
			// Commiterlatransaction JPA
			etx.commit();
			} 
		catch(Exception e) {e.printStackTrace();if(etx!= null) {etx.rollback();}}
		
		
	}
	
	public void supprimerVehiculeParId(Vehicule _vehicule) {
		// Chercher le vehicule
		Vehicule vehicule= this.em.find(Vehicule.class, _vehicule.getId());
		
			EntityTransaction etx= null;
			try {
			// Initialiserunetransaction JPA
			etx= this.em.getTransaction();
			etx.begin();
			
			// supprimer l'entité
			this.em.remove(vehicule);
			
			// Commiter latransaction JPA
			etx.commit();
			} 
			catch(Exception e) {e.printStackTrace();if(etx!= null) {etx.rollback();}}
		}

	}
