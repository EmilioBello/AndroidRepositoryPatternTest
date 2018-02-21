package com.example.metaenlaceebello.templaterepositories.realmDAO;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;
import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
@RealmClass
public class AddressRealmDAO implements RealmModel {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoRealmDAO geo;
}
