package ua.com.codespace.entities;

import java.util.List;

/**
 * Created by D10020 on 12.04.2017.
 */
public class Country {

    String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
