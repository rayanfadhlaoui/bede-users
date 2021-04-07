package com.bede.users.function.fighter;

import com.bede.users.entities.fighter.CharacteristicsEntity;
import com.bede.users.entities.fighter.FighterEntity;
import com.bede.users.entities.fighter.information.InformationEntity;
import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancer;
import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancerProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FighterFactory {
    private long lastId = 1L;

    private final CharacteristicsEnhancerProvider characteristicsEnhancerProvider;

    public FighterFactory(CharacteristicsEnhancerProvider characteristicsEnhancerProvider) {
        this.characteristicsEnhancerProvider = characteristicsEnhancerProvider;
    }

    public FighterEntity create(Long userId, InformationEntity informationEntity) {
        FighterEntity fighterEntity = createFighter(userId, informationEntity);
        getEnhancers(informationEntity).forEach(en -> en.improve(fighterEntity.getCharacteristics()));
        return fighterEntity;
    }

    private FighterEntity createFighter(Long userId, InformationEntity informationEntity) {
        FighterEntity fighterEntity = new FighterEntity();
        CharacteristicsEntity characteristicsEntity = new CharacteristicsEntity();
        fighterEntity.setId(lastId++);
        fighterEntity.setIdMainUser(userId);
        fighterEntity.setInformation(informationEntity);
        fighterEntity.setCharacteristics(characteristicsEntity);
        return fighterEntity;
    }

    private List<CharacteristicsEnhancer> getEnhancers(InformationEntity informationEntity) {
        List<CharacteristicsEnhancer> enhancers = new ArrayList<>();
        enhancers.add(characteristicsEnhancerProvider.getForClass(informationEntity.getClassEnum()));
        enhancers.add(characteristicsEnhancerProvider.getForRace(informationEntity.getRaceEnum()));
        enhancers.add(characteristicsEnhancerProvider.getForGender(informationEntity.getGenderEnum()));
        return enhancers;
    }
}
