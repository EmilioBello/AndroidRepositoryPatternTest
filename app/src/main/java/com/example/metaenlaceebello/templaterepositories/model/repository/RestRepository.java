package com.example.metaenlaceebello.templaterepositories.model.repository;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.modelmapper.ModelMapper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by metaenlace.ebello on 16/02/2018.
 */

public class RestRepository<In, Out> {

    private final Class<In> typeIn;
    private final Class<Out> typeOut;

    public RestRepository(Class<In> typeIn, Class<Out> typeOut) {
        this.typeIn = typeIn;
        this.typeOut = typeOut;
    }

    public List<In> get(final String url){
        List<In> entities = new ArrayList<>();

        try {
            // Create URL
            final URL endpoint = new URL(url);

            // Create connection
            HttpsURLConnection myConnection = (HttpsURLConnection) endpoint.openConnection();
            myConnection.setRequestProperty("UserRealmDAO-Agent", "Template-Repository-v0.1");

            if (myConnection.getResponseCode() == 200) {
                final InputStream responseBody = myConnection.getInputStream();
                final InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                JsonReader reader = new JsonReader(responseBodyReader);
                final Gson gson = new Gson();
                final ModelMapper modelMapper = new ModelMapper();

                reader.beginArray();

                while (reader.hasNext()) {
                    final Out dao = gson.fromJson(reader, typeOut);
                    final In entity = modelMapper.map(dao, typeIn);
                    entities.add(entity);
                }

                reader.endArray();
                reader.close();
            }
        }
        catch (Exception e){}

        return entities;
    }

    public void post(final List<In> entities, final String url){

        try {
            // Create URL
            final URL endpoint = new URL(url);

            // Create connection
            HttpsURLConnection myConnection = (HttpsURLConnection) endpoint.openConnection();
            myConnection.setRequestProperty("UserRealmDAO-Agent", "Template-Repository-v0.1");

            if (myConnection.getResponseCode() == 200) {
                final InputStream responseBody = myConnection.getInputStream();
                final InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                JsonReader reader = new JsonReader(responseBodyReader);
                final Gson gson = new Gson();
                final ModelMapper modelMapper = new ModelMapper();

                reader.beginArray();

                while (reader.hasNext()) {
                    final Out dao = gson.fromJson(reader, typeOut);
                    final In entity = modelMapper.map(dao, typeIn);
                    entities.add(entity);
                }

                reader.endArray();
                reader.close();
            }
        }
        catch (Exception e){}
    }

    public void post(final In entity, final String url){

    }
}
