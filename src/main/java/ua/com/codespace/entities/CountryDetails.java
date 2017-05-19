package ua.com.codespace.entities;

import javax.persistence.*;

@Entity
@Table(name = "country_details")
public class CountryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "information")
    @Enumerated(EnumType.STRING)
    private InformationType information;

    @Column(name = "value")
    private double value;

    @Column(name = "year")
    private int year;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryDetails details = (CountryDetails) o;

        if (id != details.id) return false;
        if (Double.compare(details.value, value) != 0) return false;
        if (year != details.year) return false;
        return information == details.information;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (information != null ? information.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + year;
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
