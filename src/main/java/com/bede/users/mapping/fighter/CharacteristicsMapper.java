package com.bede.users.mapping.fighter;

import com.bede.users.dto.fighter.CharacteristicsDto;
import com.bede.users.entities.fighter.CharacteristicsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacteristicsMapper {

    CharacteristicsEntity mapToEntity(CharacteristicsDto characteristicsDto);

    @InheritInverseConfiguration
    CharacteristicsDto mapToDto(CharacteristicsEntity fighterEntity);
}
