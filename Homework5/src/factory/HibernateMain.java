package factory;

import java.util.List;

import org.hibernate.Session;
import entity.City;
import entity.Country;

public class HibernateMain {
	
	static Session session;
	
	@SuppressWarnings("unchecked")
	public static void listCities() {
        List<City> cities = session.createCriteria(City.class).list();
        for (City city : cities) {
            System.out.println(city);
        }
        System.out.println();
    }
	
	@SuppressWarnings("unchecked")
	public static void listCountries() {
		List<Country> contries = session.createCriteria(Country.class).list();
        for (Country country : contries) {
            System.out.println(country);
        }
        System.out.println();
    }
	
	public static void addCountry() {
        System.out.println("What is the country's name?");
        String name = TextIO.getlnString();
        
        Country country = new Country();
        country.setName(name);
        
        System.out.println("What is the population of the country?");
        int pop = TextIO.getlnInt();
        country.setPopulation(pop);
        
        session.persist(country);
    }
	
	public static void main(String[] args) {
		addCountry();
	}

}
