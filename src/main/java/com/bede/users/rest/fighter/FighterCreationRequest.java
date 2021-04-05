package com.bede.users.rest.fighter;

import com.bede.users.dto.fighter.InformationDto;

public class FighterCreationRequest {

    private long userId;
    private InformationDto information;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public InformationDto getInformation() {
        return information;
    }

    public void setInformation(InformationDto information) {
        this.information = information;
    }
}
