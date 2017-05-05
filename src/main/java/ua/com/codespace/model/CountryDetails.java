package ua.com.codespace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "country_details")
public class CountryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "information")
    private InformationType information;

    @Column(name = "value")
    private double value;

    @Column(name = "year")
    private int year;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformationType getInformation() {
        return information;
    }

    public void setInformation(InformationType information) {
        this.information = information;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDetails)) return false;

        CountryDetails that = (CountryDetails) o;

        if (getId() != that.getId()) return false;
        if (Double.compare(that.getValue(), getValue()) != 0) return false;
        if (getYear() != that.getYear()) return false;
        if (getInformation() != that.getInformation()) return false;
        return getCountry().equals(that.getCountry());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getInformation().hashCode();
        temp = Double.doubleToLongBits(getValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getYear();
        result = 31 * result + getCountry().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CountryDetails{" +
                "id=" + id +
                ", information=" + information +
                ", value=" + value +
                ", year=" + year +
                '}';
    }
}
