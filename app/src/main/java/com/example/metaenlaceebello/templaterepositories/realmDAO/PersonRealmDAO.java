package com.example.metaenlaceebello.templaterepositories.realmDAO;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import lombok.Data;

/**
 * Created by metaenlace.ebello on 13/02/2018.
 */

@Data
@RealmClass
public class PersonRealmDAO implements RealmModel {
    @PrimaryKey
    private int id;

    private String name;
    private String lastName;
}
