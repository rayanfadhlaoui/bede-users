package com.bede.users.function.fighter.enhancer.characteristics.gender;

import com.bede.users.entities.fighter.information.GenderEnum;
import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancer;
import org.springframework.stereotype.Component;

@Component
public class GenderEnhancerProvider {
    public CharacteristicsEnhancer get(GenderEnum genderEnum) {
        switch (genderEnum) {
            case MALE:
                return new GenderEnhancer(3,0);
            case FEMALE:
                return new GenderEnhancer(0,3);
            default:
                throw new IllegalArgumentException("No enhancer for genderEnum :" + genderEnum);
        }
    }
}
