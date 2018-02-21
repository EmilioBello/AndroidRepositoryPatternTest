package com.example.metaenlaceebello.templaterepositories.bean;

import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        if (!super.equals(o)) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (suite != null ? !suite.equals(address.suite) : address.suite != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (zipcode != null ? !zipcode.equals(address.zipcode) : address.zipcode != null)
            return false;
        return geo != null ? geo.equals(address.geo) : address.geo == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (suite != null ? suite.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (geo != null ? geo.hashCode() : 0);
        return result;
    }
}
