package com.bede.users.dto.fighter;

public class FighterDto {
    private long id;
    private long idMainUser;
    private InformationDto information;
    private CharacteristicsDto characteristics;

    public FighterDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformationDto getInformation() {
        return information;
    }

    public void setInformation(InformationDto information) {
        this.information = information;
    }

    public CharacteristicsDto getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(CharacteristicsDto characteristics) {
        this.characteristics = characteristics;
    }

    public long getIdMainUser() {
        return idMainUser;
    }

    public void setIdMainUser(long idMainUser) {
        this.idMainUser = idMainUser;
    }
}
