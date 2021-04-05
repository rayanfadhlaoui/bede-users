package com.bede.users.mapping.fighter.information;

import com.bede.users.entities.fighter.information.GenderEnum;
import org.springframework.stereotype.Component;

@Component
public class GenderEnumMapper {

    GenderEnum mapToEnum(String genderEnum) {
        switch (genderEnum.toLowerCase()) {
            case "female":
                return GenderEnum.FEMALE;
            case "male":
                return GenderEnum.MALE;

            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + genderEnum);
        }
    }

    String mapToString(GenderEnum genderEnum) {
        switch (genderEnum) {
            case FEMALE:
                return "female";
            case MALE:
                return "male";

            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + genderEnum);
        }
    }
}
