package com.bede.users.service.tournament;

import com.bede.users.dto.fighter.FighterDto;
import com.bede.users.dto.tournament.TournamentDto;
import com.bede.users.service.fighter.FighterService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private static final Map<String, TournamentDto> tournamentByName = new HashMap<>();

    private final FighterService fighterService;

    public TournamentService(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    public TournamentDto create(String name, Integer participantsNumber) {
        TournamentDto tournamentDto = new TournamentDto();
        tournamentDto.setName(name);
        tournamentDto.setParticipantsNumber(participantsNumber);
        List<FighterDto> potentialParticipants = new ArrayList<>(fighterService.getAll());
        Collections.shuffle(potentialParticipants);
        List<FighterDto> participants = potentialParticipants.stream()
                .limit(participantsNumber)
                .collect(Collectors.toList());
        tournamentDto.setFighters(participants);

        tournamentByName.put(name, tournamentDto);
        return tournamentDto;

    }

    public Collection<TournamentDto> getAll() {
        return tournamentByName.values();
    }
}
