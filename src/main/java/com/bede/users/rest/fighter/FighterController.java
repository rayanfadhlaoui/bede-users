package com.bede.users.rest.fighter;

import com.bede.users.dto.fighter.FighterDto;
import com.bede.users.service.fighter.FighterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/fighter")
public class FighterController {

    private static final Map<Long, FighterDto> fightersById = new HashMap<>();

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FighterDto> create(@RequestBody FighterCreationRequest fighterCreationRequest) {
        FighterDto fighterDto = fighterService.create(fighterCreationRequest.getUserId(), fighterCreationRequest.getInformation());
        fightersById.put(fighterDto.getId(), fighterDto);
        return ResponseEntity.ok(fighterDto);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<FighterDto>> getAll() {
        Collection<FighterDto> allFighters = fightersById.values();
        return ResponseEntity.ok(allFighters);
    }

    @RequestMapping(value = "/mainCharacter/{userId}", method = RequestMethod.GET)
    public ResponseEntity<FighterDto> getMainCharacter(@PathVariable long userId) {
        return fightersById.values()
                .stream()
                .filter(f -> f.getIdMainUser() == userId)
                .map(ResponseEntity::ok)
                .findFirst()
                .orElse(ResponseEntity.noContent().build());
    }
}