package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	
	@Id
	@GeneratedValue
	int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "population")
	private int population;
	
	@OneToMany(mappedBy="country")
	private Set<City> cities;
	
	public Country() {}
	
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
