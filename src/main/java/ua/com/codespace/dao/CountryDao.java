package ua.com.codespace.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.codespace.entities.Country;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Repository
public class CountryDao {

    private final Logger logger = Logger.getLogger(CountryDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public CountryDao(SessionFactory sessionFactory) {
        logger.info("CountryDao: return session factory");
        this.sessionFactory = sessionFactory;
    }

    public Country findCountryById(int id) {
        logger.info("CountryDao: find country with id: " + id);
        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, id);
        return country;
    }
}
