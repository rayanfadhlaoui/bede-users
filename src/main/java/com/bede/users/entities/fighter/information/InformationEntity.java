package com.bede.users.entities.fighter.information;

public class InformationEntity {
    private long id;
    private String firstName;
    private String lastName;
    private RaceEnum race;
    private ClassEnum classEnum;
    private GenderEnum gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RaceEnum getRaceEnum() {
        return race;
    }

    public void setRaceEnum(RaceEnum race) {
        this.race = race;
    }

    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
    }

    public GenderEnum getGenderEnum() {
        return gender;
    }

    public void setGenderEnum(GenderEnum gender) {
        this.gender = gender;
    }

}
