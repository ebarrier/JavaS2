package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="city")
public class City {
	
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "population")
	private int population;
	
	@ManyToOne
	private Country country;
	
	public City() {}
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	

}
