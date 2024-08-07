package org.example.nested2;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(uses = {HouseMapper.class})
public interface CityMapper {
    CityMapper instance = getMapper(CityMapper.class);

    @Mapping(target = "houses", source = "city.houseIds", qualifiedByName = "resolveHouses")
    City map(City city, Collection<House> houses, Collection<Person> members);

    @Named("resolveHouses")
    default Collection<House> resolveHouses(Collection<House> houses, Collection<Person> members) {
        return houses.stream()
                .map(house -> HouseMapper.instance.map(house, members))
                .toList();
    }
}
