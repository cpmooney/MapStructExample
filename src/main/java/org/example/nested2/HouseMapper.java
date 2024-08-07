package org.example.nested2;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface HouseMapper {
    HouseMapper instance = getMapper(HouseMapper.class);

    @Mapping(target = "members", source = "house.memberIds", qualifiedByName = "resolveMembers")
    House map(House house, Collection<Person> members);

    @Named("resolveMembers")
    default Collection<Person> resolveMembers(Collection<String> memberIds, @Context Collection<Person> members) {
        return members.stream()
                .filter(person -> memberIds.contains(person.id))
                .toList();
    }
}