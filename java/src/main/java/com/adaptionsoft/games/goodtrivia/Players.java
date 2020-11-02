package com.adaptionsoft.games.goodtrivia;

import java.util.ArrayList;

class Players {

    private final ArrayList<Player> players = new ArrayList<>();
    private int currentPlayer = 0;

    void add(String playerName) {
        players.add(new Player(playerName));
    }

    int getNbPlayers() {
        return players.size();
    }

    Player getCurrentAndUpdate() {
        if (isLastPlayer()) {
            int actual = currentPlayer;
            currentPlayer = 0;
            return players.get(actual);
        }
        return players.get(currentPlayer++);
    }

    private boolean isLastPlayer() {
        return currentPlayer == players.size() - 1;
    }
}
