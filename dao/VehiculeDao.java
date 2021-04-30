package jpa.vehiculeEclipseLink.dao;

import java.util.List;

public interface VehiculeDao { 
	
	void insererVehicule(String _codeInterne, String _immatriculation, String _dateMiseEnCirculation);
	
	void insererVehicule(Vehicule _vehicule);
	
	List<Vehicule> rechercherTousLesVehicules();
	
	List<Vehicule> rechercherVehiculeParImmatriculation(String _immatriculation);
	
	Vehicule rechercherVehiculeParId(long _id);

	void modifierVehiculeCodeInterneParId(Long _id, String _codeInterne);
	
	void supprimerVehiculeParId(Long _id);
	
	void modifierVehiculeCodeInterneParId(Vehicule _vehicule);
	
	void supprimerVehiculeParId(Vehicule _vehicule);

	
}

