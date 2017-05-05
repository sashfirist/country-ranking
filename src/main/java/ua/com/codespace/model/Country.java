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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CountryDetails> countryDetails = new ArrayList<>();

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

    public List<CountryDetails> getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(List<CountryDetails> countryDetails) {
        this.countryDetails = countryDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getId() != country.getId()) return false;
        if (!getName().equals(country.getName())) return false;
        return getCountryDetails() != null ? getCountryDetails().equals(country.getCountryDetails()) : country.getCountryDetails() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getCountryDetails() != null ? getCountryDetails().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryDetails=" + countryDetails +
                '}';
    }
}
