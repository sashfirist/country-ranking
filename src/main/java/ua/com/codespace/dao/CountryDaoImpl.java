package ua.com.codespace.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ua.com.codespace.model.Country;

import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Long,Country> implements CountryDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        Criteria criteria = createCriteria();
        return (List<Country>) criteria.list();
    }

    @Override
    public Country getById(long id) {
        return getByKey(id);
    }

    @Override
    public Country getByName(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Country) criteria.uniqueResult();
    }

    @Override
    public void save(Country country) {
        persist(country);
    }

    @Override
    public void deleteByName(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("name", name));
        delete((Country) criteria.uniqueResult());
    }
}
