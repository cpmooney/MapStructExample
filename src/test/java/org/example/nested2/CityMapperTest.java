package org.example.nested2;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CityMapperTest {

    @Test
    void map() {
        City city = new City("SPH", "Spring Hill", "TN",
                List.of("portview", "bern"));
        Collection<House> houses = List.of(
                new House("portview", "1871 Portview Dr",
                        List.of("dude", "bear", "bean")),
                new House("bern", "1434 Bern Dr",
                        List.of("mom", "dad")));
        Collection<Person> members = List.of(
                new Person("dude", "Ben", "Mooney"),
                new Person("bear", "Lily", "Mooney"),
                new Person("bean", "Hannah", "Mooney"),
                new Person("mom", "Stephany", "Mooney"),
                new Person("dad", "Chris", "Mooney"));

        City resolvedCity = CityMapper.instance.map(city, houses, members);

        assertThat(resolvedCity.houses).hasSize(2);
        assertThat(resolvedCity.houses.stream().toList().getFirst().members).hasSize(3);
        assertThat(resolvedCity.houses.stream().toList().getFirst().members.stream().toList().getFirst().firstName).isEqualTo("Ben");
    }
}