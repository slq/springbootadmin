package com.esens.admin.activity;

import java.util.Objects;

public class Participant {

    private Long id;
    private String name;
    private String lastName;

    private Participant() {
    }

    static Participant aParticipant(Long id, String name, String lastName) {
        Participant participant = new Participant();
        participant.id = id;
        participant.name = name;
        participant.lastName = lastName;
        return participant;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }
}
