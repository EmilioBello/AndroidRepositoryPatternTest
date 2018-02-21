package com.example.metaenlaceebello.templaterepositories;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.metaenlaceebello.templaterepositories.bean.Address;
import com.example.metaenlaceebello.templaterepositories.bean.Geo;
import com.example.metaenlaceebello.templaterepositories.bean.User;
import com.example.metaenlaceebello.templaterepositories.realmDAO.UserRealmDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;

/**
 * Created by metaenlace.ebello on 13/02/2018.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ModelMapperTest {

    @Test
    public void mapperUserToUserRealm(){
        ModelMapper modelMapper = new ModelMapper();

        User user = createUser();

        UserRealmDAO dao = modelMapper.map(user, UserRealmDAO.class);

        assertEquals (dao.getId(), user.getId());
        assertEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
        //assertEquals (dao.getAddress(), user.getAddress());
    }

    private User createUser(){
        User user = new User();

        user.setId(1);
        user.setName("Tino");
        user.setUsername("Tovar");
        user.setEmail("tino@tovar.com");
        user.setAddress(createAddress());

        return user;
    }

    private Address createAddress() {
        Address address = new Address();

        address.setStreet("Av Pery Junquera");
        address.setSuite("Avenida");
        address.setCity("Cadiz");
        address.setZipcode("11100");
        address.setGeo(createGeo());

        return address;
    }

    private Geo createGeo() {
        Geo geo = new Geo();

        geo.setLat("111");
        geo.setLng("000");

        return geo;
    }
}
