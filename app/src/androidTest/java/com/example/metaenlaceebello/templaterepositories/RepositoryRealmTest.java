package com.example.metaenlaceebello.templaterepositories;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.metaenlaceebello.templaterepositories.bean.Address;
import com.example.metaenlaceebello.templaterepositories.bean.Geo;
import com.example.metaenlaceebello.templaterepositories.bean.Person;
import com.example.metaenlaceebello.templaterepositories.bean.User;
import com.example.metaenlaceebello.templaterepositories.model.realm.ADRealm;
import com.example.metaenlaceebello.templaterepositories.model.repository.RealmRepository;
import com.example.metaenlaceebello.templaterepositories.realmDAO.PersonRealmDAO;
import com.example.metaenlaceebello.templaterepositories.realmDAO.UserRealmDAO;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by metaenlace.ebello on 14/02/2018.
 */


@RunWith(AndroidJUnit4.class)
@MediumTest
@RunListener.ThreadSafe
public class RepositoryRealmTest {

    @BeforeClass
    public static void setUpClass() {
        Context context = InstrumentationRegistry.getTargetContext();
        ADRealm realm = new ADRealm();

        realm.init(context);
    }

    @Test
    public void testSaveAndFetchEntity(){
        User user = createUser();

        RealmRepository<User, UserRealmDAO> repository = new RealmRepository<>(User.class, UserRealmDAO.class);

        repository.save(user);
        User dao = repository.fetch(buildQueryOneValue());

        assertEquals (dao.getId(), user.getId());
        assertEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
    }

    @Test
    public void testSaveAndFetchEntities(){
        List<User> entities = createUserList();

        RealmRepository<User, UserRealmDAO> repository = new RealmRepository<>(User.class, UserRealmDAO.class);

        repository.save(entities);
        List<User> entitiesSaved = repository.fetchAll(buildQueryAll());

        for(int i = 0; i < entities.size(); i++){
            assertEquals (entities.get(i).getId(), entitiesSaved.get(i).getId());
            assertEquals (entities.get(i).getName(), entitiesSaved.get(i).getName());
            assertEquals (entities.get(i).getUsername(), entitiesSaved.get(i).getUsername());
            assertEquals (entities.get(i).getEmail(), entitiesSaved.get(i).getEmail());
        }
    }

    @Test
    public void testUpdateAndFetchEntity(){
        User user = updateUser();

        RealmRepository<User, UserRealmDAO> repository = new RealmRepository<>(User.class, UserRealmDAO.class);

        repository.update(user);
        User dao = repository.fetch(buildQueryOneValue());

        user = createUser();

        assertEquals (dao.getId(), user.getId());
        assertNotEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
    }

    @Test
    public void testUpdateAndFetchEntities(){
        List<User> entities = updateUserList();

        RealmRepository<User, UserRealmDAO> repository = new RealmRepository<>(User.class, UserRealmDAO.class);

        repository.update(entities);
        List<User> entitiesSaved = repository.fetchAll(buildQueryAll());

        entities = createUserList();

        for(int i = 0; i < entities.size(); i++){
            assertEquals (entities.get(i).getId(), entitiesSaved.get(i).getId());
            assertNotEquals (entities.get(i).getName(), entitiesSaved.get(i).getName());
            assertEquals (entities.get(i).getUsername(), entitiesSaved.get(i).getUsername());
            assertEquals (entities.get(i).getEmail(), entitiesSaved.get(i).getEmail());
        }
    }

    @Test
    public void testDeleteAndFetchEntity(){
        RealmRepository<User, UserRealmDAO> repository = new RealmRepository<>(User.class, UserRealmDAO.class);

        repository.delete(buildQueryOneValue());
        User entityDeleted = repository.fetch(buildQueryOneValue());

        assertNull (entityDeleted);
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

    private User updateUser() {
        User user = createUser();
        user.setName("Antonio");

        return user;
    }

    private List<User> createUserList(){
        List<User> entities = new ArrayList<>();

        for(int i = 0; i < 10; i++) {

            final User user = new User();

            user.setId(1 + i);
            user.setName("Tino" + i);
            user.setUsername("Tovar" + i);
            user.setEmail("tino@tovar.com" + i);
            user.setAddress(createAddress());

            entities.add(user);
        }

        return entities;
    }

    private List<User> updateUserList(){
        List<User> entities = createUserList();

        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).setName("Antonio" + i);
        }

        return entities;
    }

    private RealmQuery<UserRealmDAO> buildQueryOneValue() {
        RealmQuery<UserRealmDAO> query;
        Realm realm = Realm.getDefaultInstance();

        query = realm.where(UserRealmDAO.class);
        query.equalTo("id", 1);

        return query;
    }

    private RealmQuery<UserRealmDAO> buildQueryAll() {
        RealmQuery<UserRealmDAO> query;
        Realm realm = Realm.getDefaultInstance();

        query = realm.where(UserRealmDAO.class).sort("id");

        return query;
    }
}
