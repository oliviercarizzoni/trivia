package com.adaptionsoft.games.goodtrivia;

public class Game {

    public static final int MAX_PLAYER_PLACE = 12;
    public static final int PURSES_TO_WIN = 6;
    public static final int MIN_NB_PLAYER = 2;

    private final Players players = new Players();
    private final Categories categories = new Categories();
    private Player currentPlayer = null;

    public boolean isPlayable() {
        return (players.getNbPlayers() >= MIN_NB_PLAYER);
    }

    public void add(String playerName) {
        players.add(playerName);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.getNbPlayers());
    }

    public void roll(int roll) {
        checkConditionsToPlay();

        currentPlayer = players.getCurrentAndUpdate();
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.gotPenalty()) {
            if (conditionToGetRideOfPenalty(roll)) {
                currentPlayer.setPenalty(false);
                System.out.println(
                        currentPlayer + " is getting out of the penalty box");
            } else {
                System.out.println(
                        currentPlayer + " is not getting out of the penalty box");
            }
        }
        updatePlaceAndAskQuestion(roll);
    }

    private void checkConditionsToPlay() {
        if (!isPlayable()) throw new RuntimeException(
                "Game is not playable for players less than " + MIN_NB_PLAYER);
    }

    private boolean conditionToGetRideOfPenalty(int roll) {
        return roll % 2 != 0;
    }

    private void updatePlaceAndAskQuestion(int roll) {
        currentPlayer.increasePlace(roll);
        updatePlaceIfOverLimit();
        printPlayerLocation();
        categories.askQuestion(currentPlayer.getPlace());
    }

    private void updatePlaceIfOverLimit() {
        if (currentPlayer.getPlace() >= MAX_PLAYER_PLACE)
            currentPlayer.decreasePlace(MAX_PLAYER_PLACE);
    }

    private void printPlayerLocation() {
        System.out.println(currentPlayer
                           + "'s new location is "
                           + currentPlayer.getPlace());
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer.gotPenalty()) return true;
        System.out.println("Answer was correct!!!!");
        currentPlayer.increasePurse();
        System.out.println(currentPlayer
                           + " now has "
                           + currentPlayer.getPurse()
                           + " Gold Coins.");
        return didPlayerWin();
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setPenalty(true);
        return true;
    }

    private boolean didPlayerWin() {
        return !(currentPlayer.getPurse() == PURSES_TO_WIN);
    }
}
