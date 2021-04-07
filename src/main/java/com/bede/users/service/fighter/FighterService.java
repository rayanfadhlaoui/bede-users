package com.bede.users.service.fighter;

import com.bede.users.dto.fighter.FighterDto;
import com.bede.users.dto.fighter.InformationDto;
import com.bede.users.entities.fighter.FighterEntity;
import com.bede.users.entities.fighter.information.InformationEntity;
import com.bede.users.function.fighter.FighterFactory;
import com.bede.users.mapping.fighter.FighterMapper;
import com.bede.users.mapping.fighter.information.InformationMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FighterService {
    private static final Map<Long, FighterDto> fightersById = new HashMap<>();
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

    public FighterDto create(Long userId, InformationDto information) {
        InformationEntity informationEntity = informationMapper.mapToEntity(information);
        FighterEntity fighter = fighterFactory.create(userId, informationEntity);

        FighterDto fighterDto = fighterMapper.mapToDto(fighter);
        fightersById.put(fighterDto.getId(), fighterDto);

        return fighterDto;
    }

    public Collection<FighterDto> getAll() {
        return fightersById.values();
    }

    public Optional<FighterDto> getMainCharacter(long userId) {
        return Optional.ofNullable(fightersById.get(userId));
    }
}
