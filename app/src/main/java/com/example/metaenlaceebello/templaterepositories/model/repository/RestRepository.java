package com.example.metaenlaceebello.templaterepositories.model.repository;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
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

    public List<In> get(String url){
        try {
            // Create URL
            URL endpoint = new URL(url);

            // Create connection
            HttpsURLConnection myConnection = (HttpsURLConnection) endpoint.openConnection();
            myConnection.setRequestProperty("UserRealmDAO-Agent", "Template-Repository-v0.1");

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");




            } else {
                // Error handling code goes here
            }
        }
        catch (Exception e){}

    }

    public void post(In entity, String url){

    }

    public void post(List<In> entities, String url){

    }
}
