package com.bede.users.mapping.fighter.information;

import com.bede.users.entities.fighter.information.RaceEnum;
import org.springframework.stereotype.Component;

@Component
public class RaceEnumMapper {

    RaceEnum mapToEnum(String raceAsString) {
        switch (raceAsString.toLowerCase()) {
            case "human":
                return RaceEnum.HUMAN;
            case "orc":
                return RaceEnum.ORC;
            case "dwarf":
                return RaceEnum.DWARF;
            case "elf":
                return RaceEnum.ELF;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + raceAsString);
        }
    }

    String mapToString(RaceEnum raceEnum) {
        switch (raceEnum) {
            case HUMAN:
                return "human";
            case ORC:
                return "orc";
            case DWARF:
                return "dwarf";
            case ELF:
                return "elf";
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + raceEnum);
        }
    }
}
