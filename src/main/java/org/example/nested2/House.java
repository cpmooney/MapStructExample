package org.example.nested2;

import java.util.Collection;

public class House {
    public House(String id, String address, Collection<String> memberIds) {
        this.id = id;
        this.address = address;
        this.memberIds = memberIds;
    }

    public String id;
    public String address;
    public Collection<String> memberIds;

    public Collection<Person> members;
}
