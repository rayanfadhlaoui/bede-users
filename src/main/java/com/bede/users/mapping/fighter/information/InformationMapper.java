package com.bede.users.mapping.fighter.information;

import com.bede.users.dto.fighter.InformationDto;
import com.bede.users.entities.fighter.information.InformationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClassEnumMapper.class, RaceEnumMapper.class, GenderEnumMapper.class})
public interface InformationMapper {

    @Mapping(target = "classEnum", source = "fighterClass")
    @Mapping(target = "genderEnum", source = "gender")
    @Mapping(target = "raceEnum", source = "race")
    InformationEntity mapToEntity(InformationDto informationDto);

    @InheritInverseConfiguration
    InformationDto mapToDto(InformationEntity informationEntity);

}
