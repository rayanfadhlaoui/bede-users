package com.bede.users.function.fighter.enhancer.characteristics;

import com.bede.users.entities.fighter.information.GenderEnum;
import com.bede.users.entities.fighter.information.RaceEnum;
import com.bede.users.entities.fighter.information.ClassEnum;
import com.bede.users.function.fighter.enhancer.characteristics.classEnhancer.ClassEnhancerProvider;
import com.bede.users.function.fighter.enhancer.characteristics.gender.GenderEnhancerProvider;
import com.bede.users.function.fighter.enhancer.characteristics.race.RaceEnhancerProvider;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicsEnhancerProvider {

    private final ClassEnhancerProvider classEnhancerProvider;
    private final RaceEnhancerProvider raceEnhancerProvider;
    private final GenderEnhancerProvider genderEnhancerProvider;

    public CharacteristicsEnhancerProvider(ClassEnhancerProvider classEnhancerProvider,
                                           RaceEnhancerProvider raceEnhancerProvider,
                                           GenderEnhancerProvider genderEnhancerProvider) {
        this.classEnhancerProvider = classEnhancerProvider;
        this.raceEnhancerProvider = raceEnhancerProvider;
        this.genderEnhancerProvider = genderEnhancerProvider;
    }

    public CharacteristicsEnhancer getForClass(ClassEnum classEnum) {
        return classEnhancerProvider.get(classEnum);
    }

    public CharacteristicsEnhancer getForRace(RaceEnum raceEnum) {
        return raceEnhancerProvider.get(raceEnum);
    }

    public CharacteristicsEnhancer getForGender(GenderEnum genderEnum) {
        return genderEnhancerProvider.get(genderEnum);
    }
}
