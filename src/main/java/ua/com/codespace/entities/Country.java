package ua.com.codespace.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<CountryDetails> countryDetailList = new ArrayList<>();

    public List<CountryDetails> getCountryDetailList() {
        return countryDetailList;
    }

    public void setCountryDetailList(List<CountryDetails> countryDetailList) {
        this.countryDetailList = countryDetailList;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        return countryDetailList != null ? countryDetailList.equals(country.countryDetailList) : country.countryDetailList == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (countryDetailList != null ? countryDetailList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryDetailList=" + countryDetailList +
                '}';
    }
}
