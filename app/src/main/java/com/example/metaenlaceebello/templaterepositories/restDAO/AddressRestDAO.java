package com.example.metaenlaceebello.templaterepositories.restDAO;

import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
public class AddressRestDAO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoRestDAO geo;
}
