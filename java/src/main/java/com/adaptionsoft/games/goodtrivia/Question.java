package com.adaptionsoft.games.goodtrivia;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Question {

    private static final int NB_QUESTIONS = 50;

    private final LinkedList<String> qlist = new LinkedList<>();
    private final Category type;

    public Question(Category type) {
        this.type = type;
        initQuestions();
    }

    void askQuestion() {
        System.out.println(qlist.removeFirst());
    }

    private void initQuestions() {
        IntStream.range(0, NB_QUESTIONS)
                 .forEachOrdered(i -> qlist.addLast(type.getLibelle() + " Question " + i));
    }
}
