package com.bede.users.service.fighter;

import com.bede.users.dto.fighter.FighterDto;
import com.bede.users.dto.fighter.InformationDto;
import com.bede.users.entities.fighter.FighterEntity;
import com.bede.users.entities.fighter.information.InformationEntity;
import com.bede.users.function.fighter.FighterFactory;
import com.bede.users.mapping.fighter.FighterMapper;
import com.bede.users.mapping.fighter.information.InformationMapper;
import org.springframework.stereotype.Service;

@Service
public class FighterService {

    private final InformationMapper informationMapper;
    private final FighterMapper fighterMapper;
    private final FighterFactory fighterFactory;

    public FighterService(InformationMapper informationMapper,
                          FighterMapper fighterMapper,
                          FighterFactory fighterFactory) {
        this.informationMapper = informationMapper;
        this.fighterMapper = fighterMapper;
        this.fighterFactory = fighterFactory;
    }

    public FighterDto create(long userId, InformationDto information) {
        InformationEntity informationEntity = informationMapper.mapToEntity(information);
        FighterEntity fighter = fighterFactory.create(userId, informationEntity);
        return fighterMapper.mapToDto(fighter);
    }
}
