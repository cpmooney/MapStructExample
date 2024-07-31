package org.example;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HouseholdMapper {
    HouseholdMapper instance = Mappers.getMapper(HouseholdMapper.class);

    @Mapping(target = "address", source = "addressId", qualifiedByName = "resolveAddress")
    @Mapping(target = "people", source = "personIds", qualifiedByName = "resolvePeople")
    Household map(Household source, @Context List<Address> addresses, @Context List<Person> people);

    List<Household> map(List<Household> source, @Context List<Address> addresses, @Context List<Person> people);

    @Named("resolveAddress")
    default Address resolveAddress(String addressId, @Context List<Address> addresses) {
        return addresses.stream()
                .filter(address -> address.id.equals(addressId))
                .findFirst()
                .orElse(null);
    }

    @Named("resolvePeople")
    default Person[] resolvePeople(String[] personIds, @Context List<Person> people) {
        return people.stream()
                .filter(person -> List.of(personIds).contains(person.id))
                .toArray(Person[]::new);
    }
}
