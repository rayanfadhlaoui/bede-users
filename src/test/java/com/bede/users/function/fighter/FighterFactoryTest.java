package com.bede.users.function.fighter;

import com.bede.users.entities.fighter.*;
import com.bede.users.entities.fighter.information.ClassEnum;
import com.bede.users.entities.fighter.information.GenderEnum;
import com.bede.users.entities.fighter.information.InformationEntity;
import com.bede.users.entities.fighter.information.RaceEnum;
import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancerProvider;
import com.bede.users.function.fighter.enhancer.characteristics.DefaultEnhancer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class FighterFactoryTest {

    @InjectMocks
    private FighterFactory fighterFactory;

    @Mock
    private CharacteristicsEnhancerProvider characteristicsEnhancerProvider;

    @BeforeEach
    void setup() {
        given(characteristicsEnhancerProvider.getForClass(ClassEnum.NO_CLASS)).willReturn(new DefaultEnhancer());
        given(characteristicsEnhancerProvider.getForRace(RaceEnum.HUMAN)).willReturn(new DefaultEnhancer());
        given(characteristicsEnhancerProvider.getForGender(GenderEnum.FEMALE)).willReturn(new DefaultEnhancer());
    }

    @Test
    void createSimpleFighter() {
        InformationEntity informationEntity = new InformationEntity();
        informationEntity.setClassEnum(ClassEnum.NO_CLASS);
        informationEntity.setGenderEnum(GenderEnum.FEMALE);
        informationEntity.setRaceEnum(RaceEnum.HUMAN);
        FighterEntity fighterEntity = fighterFactory.create(1, informationEntity);

        assertThat(fighterEntity.getInformation()).isEqualToComparingFieldByFieldRecursively(informationEntity);
        assertCharacteristics(fighterEntity.getCharacteristics());
    }

    private void assertCharacteristics(CharacteristicsEntity characteristics) {
        assertThat(characteristics.getStrength()).isEqualTo(3);
        assertThat(characteristics.getSpeed()).isEqualTo(3);
        assertThat(characteristics.getDexterity()).isEqualTo(3);
        assertThat(characteristics.getDefense()).isEqualTo(3);
        assertThat(characteristics.getVitality()).isEqualTo(3);
        assertThat(characteristics.getCourage()).isEqualTo(3);
        assertThat(characteristics.getDodge()).isEqualTo(3);
        assertThat(characteristics.getStamina()).isEqualTo(3);
    }
}