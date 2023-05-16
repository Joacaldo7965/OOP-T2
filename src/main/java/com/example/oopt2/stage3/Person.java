package com.example.oopt2.stage3;

public class Person {
    private final PersonView personView;

    public Person(PersonView personView){
        this.personView = personView;
        this.personView.setPersonModel(this);
    }

    public PersonView getPersonView() {
        return personView;
    }
}
