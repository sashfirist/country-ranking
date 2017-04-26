package ua.com.codespace;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.CountryDetails;
import ua.com.codespace.configuration.InformationType;

import java.util.*;

@SpringBootApplication
public class CountryRankingApplication {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		CountryDetails countryDetails = new CountryDetails();
		countryDetails.setInformation(InformationType.POPULATION);
		countryDetails.setValue(40000000);
		countryDetails.setYear(2017);

		CountryDetails countryDetails1 = new CountryDetails();
		countryDetails1.setInformation(InformationType.AREA);
		countryDetails1.setValue(191919);
		countryDetails.setYear(2017);

		Country country = new Country();
		country.setName("Ukraine");
		List<CountryDetails> list = new ArrayList<>();
		list.add(countryDetails);
		list.add(countryDetails1);
		country.setCountryDetailsList(list);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(country);

		Country country1 = session.get(Country.class,1L);
		System.out.println(country1);
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
