package com.adaptionsoft.games.goodtrivia;

class Player {

    private String name;
    private int place = 0;
    private int purse = 0;
    private boolean penalty = false;

    Player(String name) {
        this.name = name;
    }

    boolean gotPenalty() {
        return penalty == true;
    }

    void setPenalty(boolean penalty) {
        this.penalty = penalty;
    }

    int getPurse() {
        return purse;
    }

    void increasePurse() {
        this.purse++;
    }

    int getPlace() {
        return place;
    }

    void increasePlace(int place) {
        this.place += place;
    }

    void decreasePlace(int place) {
        this.place -= place;
    }

    @Override
    public String toString() {
        return name;
    }
}
