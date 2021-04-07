package com.bede.users.dto.tournament;

import com.bede.users.dto.fighter.FighterDto;

import java.util.ArrayList;
import java.util.List;

public class TournamentDto {

    private String name;
    private Integer participantsNumber;
    private List<FighterDto> fighters = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public List<FighterDto> getFighters() {
        return fighters;
    }

    public void setFighters(List<FighterDto> fighters) {
        this.fighters = fighters;
    }
}
