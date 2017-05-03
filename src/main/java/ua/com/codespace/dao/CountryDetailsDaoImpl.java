package ua.com.codespace.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ua.com.codespace.model.CountryDetails;
import ua.com.codespace.model.InformationType;

import java.util.List;

@Repository
public class CountryDetailsDaoImpl extends AbstractDao<Long, CountryDetails> implements CountryDetailsDao {

    public CountryDetails getById(long id) {
        return getByKey(id);
    }

    public CountryDetails getByYear(int year) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("year",year));
        return (CountryDetails) criteria.uniqueResult();
    }

    public CountryDetails getByInformationType(InformationType informationType) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("information", informationType));
        return (CountryDetails) criteria.uniqueResult();
    }

    public void save(CountryDetails countryDetails) {
        persist(countryDetails);
    }

    public void deleteCountryDetails(CountryDetails countryDetails) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("country", countryDetails.getCountry()));
        criteria.add(Restrictions.eq("information", countryDetails.getInformation()));
        criteria.add(Restrictions.eq("year", countryDetails.getYear()));
        delete((CountryDetails) criteria.uniqueResult());
    }

    @SuppressWarnings("unchecked")
    public List<CountryDetails> getAllCountryDetails() {
        Criteria criteria = createCriteria();
        return (List<CountryDetails>) criteria.list();
    }
}
