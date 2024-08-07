package org.example.nested2;

import java.util.Collection;

public class City {
    public City(String id, String name, String state, Collection<String> houseIds) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.houseIds = houseIds;
    }

    public String id;
    public String name;
    public String state;
    public Collection<String> houseIds;

    public Collection<House> houses;
}
