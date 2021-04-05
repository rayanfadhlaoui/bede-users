package com.bede.users.function.fighter.enhancer.characteristics.classEnhancer;

import com.bede.users.entities.fighter.information.ClassEnum;
import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancer;
import com.bede.users.function.fighter.enhancer.characteristics.DefaultEnhancer;
import org.springframework.stereotype.Component;

@Component
public class ClassEnhancerProvider {
    public CharacteristicsEnhancer get(ClassEnum classEnum) {
        switch (classEnum) {
            case NO_CLASS:
                return new DefaultEnhancer();
            default:
                throw new IllegalArgumentException("No enhancer for class :" + classEnum);
        }
    }
}
