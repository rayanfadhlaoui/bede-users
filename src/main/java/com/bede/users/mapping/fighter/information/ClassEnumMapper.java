package com.bede.users.mapping.fighter.information;

import com.bede.users.entities.fighter.information.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ClassEnumMapper {

    public static final String NO_CLASS = "no class";

    ClassEnum mapToEnum(String classEnum) {
        switch (classEnum.toLowerCase()) {
            case NO_CLASS:
                return ClassEnum.NO_CLASS;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + classEnum);
        }
    }

    String mapToString(ClassEnum classEnum) {
        switch (classEnum) {
            case NO_CLASS:
                return NO_CLASS;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + classEnum);
        }
    }
}
