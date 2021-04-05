package com.bede.users.mapping.fighter;

import com.bede.users.dto.fighter.FighterDto;
import com.bede.users.entities.fighter.FighterEntity;
import com.bede.users.mapping.fighter.information.InformationMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {InformationMapper.class, CharacteristicsMapper.class})
public interface FighterMapper {

    FighterEntity mapToEntity(FighterDto fighterDto);

    @InheritInverseConfiguration
    FighterDto mapToDto(FighterEntity fighterEntity);
}
