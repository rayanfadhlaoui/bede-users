package com.bede.users.rest.game;

import com.bede.users.dto.game.GameInformationDto;
import com.bede.users.service.game.GameInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/gameInformation")
public class GameController {
    private static final Map<String, GameInformationDto> gameInformations = new HashMap<>();
    private final GameInformationService gameInformationService;

    public GameController(GameInformationService gameInformationService) {
        this.gameInformationService = gameInformationService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<GameInformationDto> get(@PathVariable long userId) {
        return gameInformations.values()
                .stream()
                .filter(g -> g.getIdMainUser() == userId)
                .map(ResponseEntity::ok)
                .findFirst()
                .orElse(ResponseEntity.noContent().build());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<GameInformationDto> create(@RequestBody Long userId) {
        GameInformationDto gameInformation = gameInformationService.createGameInformation(userId);
        gameInformations.put(String.valueOf(userId), gameInformation);
        return ResponseEntity.ok(gameInformation);
    }
}