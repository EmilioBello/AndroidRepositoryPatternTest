package com.example.metaenlaceebello.templaterepositories.restDAO;

import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
public class UserRestDAO {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressRestDAO address;
}
