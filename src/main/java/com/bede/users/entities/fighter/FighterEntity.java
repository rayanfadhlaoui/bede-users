package com.bede.users.entities.fighter;

import com.bede.users.entities.fighter.information.InformationEntity;

public class FighterEntity {
    private Long id;
    private Long idMainUser;
    private InformationEntity information;
    private CharacteristicsEntity characteristics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getIdMainUser() {
        return idMainUser;
    }

    public void setIdMainUser(Long idMainUser) {
        this.idMainUser = idMainUser;
    }
}
