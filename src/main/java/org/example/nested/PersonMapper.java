package org.example.nested;

import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface PersonMapper {
    PersonMapper instance = getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);
}
