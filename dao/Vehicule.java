package jpa.vehiculeEclipseLink.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A Vehicule.
 */
@Entity
@Table(name = "Vehicule")

public class Vehicule implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code_interne", nullable = false)
	private String codeInterne;
	
	@Column(name = "immatriculation", nullable = false)
	private String immatriculation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateMiseEnCirculation")
	private Date dateMiseEnCirculation;

	public Long getId() {
		return id;
	}



	public Vehicule() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeInterne() {
		return codeInterne;
	}

	public void setCodeInterne(String codeInterne) {
		this.codeInterne = codeInterne;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}
	

}