package com.bede.users.service.game;

import com.bede.users.dto.fighter.InformationDto;
import com.bede.users.dto.game.GameInformationDto;
import com.bede.users.function.fighter.RandomNameGenerator;
import com.bede.users.mapping.fighter.information.ClassEnumMapper;
import com.bede.users.service.fighter.FighterService;
import org.springframework.stereotype.Service;

@Service
public class GameInformationService {

    private final FighterService fighterService;

    public GameInformationService(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    public GameInformationDto createGameInformation(Long userId) {
        GameInformationDto gameInformationDto = new GameInformationDto();
        gameInformationDto.setId(1);
        gameInformationDto.setIdMainUser(userId);
        createFighter("human", 63);
        createFighter("orc", 64);
        createFighter("dwarf", 64);
        createFighter("elf", 64);
        return gameInformationDto;
    }

    private void createFighter(String race, int nb) {
        for (int i = 0; i < nb; i++) {
            InformationDto information = new InformationDto();
            information.setLastName("Ramdom");
            information.setFighterClass(ClassEnumMapper.NO_CLASS);
            information.setAge(30);
            if (i < 32) {
                information.setFirstName(RandomNameGenerator.getMale());
                information.setGender("male");

            } else {
                information.setFirstName(RandomNameGenerator.getFemale());
                information.setGender("female");
            }
            information.setRace(race);
            fighterService.create(null, information);
        }
    }
}
