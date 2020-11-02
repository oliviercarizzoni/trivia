package com.adaptionsoft.games.goodtrivia;

enum Category {

    POP("Pop"),
    SCIENCE("Science"),
    SPORT("Sports"),
    ROCK("Rock");

    private final String libelle;

    Category(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
