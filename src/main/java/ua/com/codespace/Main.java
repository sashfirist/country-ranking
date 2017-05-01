package ua.com.codespace;

import ua.com.codespace.service.jsoup.DataPersistence;
import ua.com.codespace.service.jsoup.DataPersistenceImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        DataPersistence dataPersistence = new DataPersistenceImpl();
        try {
            dataPersistence.saveArea();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        CountryDetails countryDetails = new CountryDetails();
        countryDetails.setInformation(InformationType.POPULATION);
        countryDetails.setValue(40000000);
        countryDetails.setYear(2017);

        CountryDetails countryDetails1 = new CountryDetails();
        countryDetails1.setInformation(InformationType.AREA);
        countryDetails1.setValue(191919);
        countryDetails1.setYear(2017);

        Country country = new Country();
        country.setName("Ukraine");
        countryDetails.setCountry(country);
        countryDetails1.setCountry(country);
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
        sessionFactory.close();*/
    }
}
