package com.example.metaenlaceebello.templaterepositories.bean;

import lombok.Data;

/**
 * Created by metaenlace.ebello on 20/02/2018.
 */

@Data
public class Geo {
    private String lat;
    private String lng;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geo)) return false;
        if (!super.equals(o)) return false;

        Geo geo = (Geo) o;

        if (!lat.equals(geo.lat)) return false;
        return lng.equals(geo.lng);
    }
}
