package com.example.metaenlaceebello.templaterepositories.realmDAO;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
@RealmClass
public class UserRealmDAO implements RealmModel {
    @PrimaryKey
    private int id;

    private String name;
    private String username;
    private String email;
    private AddressRealmDAO address;
}
