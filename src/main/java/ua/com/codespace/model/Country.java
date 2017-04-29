package ua.com.codespace.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private List<CountryDetails> countryDetailsList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountryDetails> getCountryDetailsList() {
        return countryDetailsList;
    }

    public void setCountryDetailsList(List<CountryDetails> countryDetailsList) {
        this.countryDetailsList = countryDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getId() != country.getId()) return false;
        if (getName() != null ? !getName().equals(country.getName()) : country.getName() != null) return false;
        return getCountryDetailsList() != null ? getCountryDetailsList().equals(country.getCountryDetailsList()) : country.getCountryDetailsList() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCountryDetailsList() != null ? getCountryDetailsList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryDetailsList=" + countryDetailsList +
                '}';
    }
}
