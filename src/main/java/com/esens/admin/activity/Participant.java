package com.esens.admin.activity;

public class Participant {

    private String name;
    private String lastName;

    private Participant() {
    }

    static Participant aParticipant(String name, String lastName) {
        Participant participant = new Participant();
        participant.name = name;
        participant.lastName = lastName;
        return participant;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
