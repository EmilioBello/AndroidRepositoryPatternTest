package com.example.metaenlaceebello.templaterepositories;

import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.metaenlaceebello.templaterepositories.bean.User;
import com.example.metaenlaceebello.templaterepositories.model.repository.RestRepository;
import com.example.metaenlaceebello.templaterepositories.restDAO.UserRestDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by metaenlace.ebello on 21/02/2018.
 */

@RunWith(AndroidJUnit4.class)
@MediumTest
public class RepositoryRestTest {

    @Test
    public void testGetEntity(){
        RestRepository<User, UserRestDAO> repository = new RestRepository<>(User.class, UserRestDAO.class);

        List<User> users = repository.get("https://jsonplaceholder.typicode.com/users");

        for(User user : users){
            assertNotNull (user.getName());
            assertNotNull (user.getUsername());
            assertNotNull (user.getId());
            assertNotNull (user.getEmail());
            assertNotNull (user.getAddress());
        }
    }

    @Test
    public void testPostEntity(){
        RestRepository<User, UserRestDAO> repository = new RestRepository<>(User.class, UserRestDAO.class);

        List<User> users = repository.get("https://jsonplaceholder.typicode.com/users");

        for(User user : users){
            assertNotNull (user.getName());
            assertNotNull (user.getUsername());
            assertNotNull (user.getId());
            assertNotNull (user.getEmail());
            assertNotNull (user.getAddress());
        }
    }
}
