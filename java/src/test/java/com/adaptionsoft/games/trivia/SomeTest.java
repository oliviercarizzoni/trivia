package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.goodtrivia.Game;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.approvaltests.Approvals.verify;

public class SomeTest extends RecordTestCase {

    @Test
    public void test_standard_game() {
        recordAndTestGame(3, 5, 3);
    }

    @Test
    public void test_5players_10roll_0fails() {
        recordAndTestGame(5, 10, 0);
    }

    @Test(expected = RuntimeException.class)
    public void test_1player_26roll_0fails() {
        recordAndTestGame(1, 26, 0);
    }

    @Test
    public void can_play_with_more_than_5_players() {
        recordAndTestGame(6, 1, 1);
    }

    private void recordAndTestGame(int nbPlayers, int rollNumber, int nbFails) {
        recording();
        runGame(nbPlayers, rollNumber, nbFails);
        stopRecording();
        verify(getRecording());
    }

    private void runGame(int nbPlayers, int rollNumber, int nbFails) {
        Game aGame = new Game();
        boolean notAWinner;
        IntStream.rangeClosed(1, nbPlayers).forEach(nb -> aGame.add("User" + nb));
        do {
            aGame.roll(rollNumber);
            if (nbFails > 0) {
                notAWinner = aGame.wrongAnswer();
                nbFails--;
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }

}
