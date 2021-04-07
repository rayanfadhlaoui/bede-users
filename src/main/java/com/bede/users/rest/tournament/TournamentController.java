package com.bede.users.rest.tournament;

import com.bede.users.dto.tournament.TournamentDto;
import com.bede.users.service.tournament.TournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/tournament")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TournamentDto> create(@RequestBody TournamentCreationRequest tournamentCreationRequest) {
        String name = tournamentCreationRequest.getName();
        int participantsNumber = tournamentCreationRequest.getParticipantsNumber();
        TournamentDto tournamentDto = tournamentService.create(name, participantsNumber);
        return ResponseEntity.ok(tournamentDto);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<TournamentDto>> getAll() {
        return ResponseEntity.ok(tournamentService.getAll());
    }
}