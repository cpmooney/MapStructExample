package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HouseholdMapperTest {

    @Test
    void resolveAddress() {
        List<Address> addresses = List.of(
                new Address("address1", "123 Maple St", "Burlington", "WI", "53179"),
                new Address("address2", "456 Oak St", "Waterford", "WI", "53179")
        );

        Address address = HouseholdMapper.instance.resolveAddress("address1", addresses);

        assertThat(address.city).isEqualTo("Burlington");
    }

    @Test
    void mapMultiple() {
        List<Household> households = List.of(
                new Household("address1", new String[]{"personId3", "personId2"}),
                new Household("address2", new String[]{"personId1"})
        );

        List<Address> addresses = List.of(
                new Address("address1", "123 Maple St", "Burlington", "WI", "53179"),
                new Address("address2", "456 Oak St", "Waterford", "WI", "53179")
        );
        List<Person> people = List.of(
                new Person("personId1", "Hannah", "Mooney"),
                new Person("personId2", "Lily", "Mooney"),
                new Person("personId3", "Ben", "Mooney")
        );

        List<Household> resolvedHouseholds = HouseholdMapper.instance.map(households, addresses, people);

        assertThat(resolvedHouseholds.get(0).address.city).isEqualTo("Burlington");
        assertThat(resolvedHouseholds.get(0).people).hasSize(2);
        assertThat(resolvedHouseholds.get(0).people[1].firstName).isEqualTo("Ben");
        assertThat(resolvedHouseholds.get(0).people[0].firstName).isEqualTo("Lily");
    }

    @Test
    void mapSingle() {
        Household household = new Household("address1", new String[]{"personId3", "personId2"});
        List<Address> addresses = List.of(
                new Address("address1", "123 Maple St", "Burlington", "WI", "53179"),
                new Address("address2", "456 Oak St", "Waterford", "WI", "53179")
        );
        List<Person> people = List.of(
                new Person("personId1", "Hannah", "Mooney"),
                new Person("personId2", "Lily", "Mooney"),
                new Person("personId3", "Ben", "Mooney")
        );

        Household resolvedHousehold = HouseholdMapper.instance.map(household, addresses, people);

        assertThat(resolvedHousehold .address.city).isEqualTo("Burlington");
        assertThat(resolvedHousehold .people).hasSize(2);
        assertThat(resolvedHousehold .people[1].firstName).isEqualTo("Ben");
        assertThat(resolvedHousehold .people[0].firstName).isEqualTo("Lily");
    }
}