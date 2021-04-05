package com.bede.users.entities.fighter;

import com.bede.users.entities.fighter.information.InformationEntity;

public class FighterEntity {
    private long id;
    private long idMainUser;
    private InformationEntity information;
    private CharacteristicsEntity characteristics;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformationEntity getInformation() {
        return information;
    }

    public void setInformation(InformationEntity information) {
        this.information = information;
    }

    public CharacteristicsEntity getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(CharacteristicsEntity characteristics) {
        this.characteristics = characteristics;
    }

    public long getIdMainUser() {
        return idMainUser;
    }

    public void setIdMainUser(long idMainUser) {
        this.idMainUser = idMainUser;
    }
}
