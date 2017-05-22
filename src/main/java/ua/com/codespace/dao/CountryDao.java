package ua.com.codespace.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.CountryDetails;
import ua.com.codespace.entities.InformationType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Repository
@Transactional
public class CountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public CountryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> findRankingByArea() {
        return getRankingByParameter(InformationType.AREA);
    }

    public List<Country> findRankingByPopulation() {
        return getRankingByParameter(InformationType.POPULATION);
    }

    public List<Country> findRankingByLifeDuration() {
        return getRankingByParameter(InformationType.AVG_LIFE_DURATION);
    }

    public List<Country> findRankingByLifeQuality() {
        return getRankingByParameter(InformationType.LIFE_QUALITY_INDEX);
    }

    private List<Country> getRankingByParameter(InformationType type) {
        Session session = sessionFactory.openSession();
        String hql = "from Country c inner join c.countryDetailList d where d.information = :ranking order by 4 asc";
        Query query = session.createQuery(hql);
        query.setParameter("ranking", type);
        List cntList = query.list();
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < cntList.size(); i++) {
            Object[] row = (Object[]) cntList.get(i);
            Country country = (Country) row[0];
            list.add(country);
        }
        session.close();
        return list;
    }

    public void saveCountries(List<Country> cntList) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Country cnt : cntList) {
            cnt.setId(getIdByName(cnt.getName()));
            session.save(cnt);
        }
        session.getTransaction().commit();
        session.close();
    }

    private long getIdByName(String name) {
        String hql = "select c.id from Country c where c.name = :name";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("name", name);
        return (Long)query.getSingleResult();
    }

    public Country findCountryById(Long id) {
        Session session = sessionFactory.openSession();
        Country cnt =  session.get(Country.class, id);
        session.close();
        return cnt;
    }

    public void saveCountry(Country entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
