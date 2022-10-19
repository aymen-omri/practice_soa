package tn.ejb3.webservices;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the learner database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Learner.findAll", query="SELECT l FROM Learner l"),
		@NamedQuery(name="Learner.findByName" , query="SELECT l FROM Learner l WHERE l.name=?1"),
		@NamedQuery(name="Learner.emailName" , query="SELECT l fROM Learner l WHERE l.name=?1 and l.email=?2"),
})

public class Learner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int learnerId;

	private String city;

	private String email;

	private String name;

	public Learner() {
	}
	public Learner(String name , String email , String city) {
		this.name = name ; 
		this.email = email;
		this.city = city;
	}

	public int getLearnerId() {
		return this.learnerId;
	}

	public void setLearnerId(int learnerId) {
		this.learnerId = learnerId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}