package com.adaptionsoft.games.goodtrivia;

import java.util.HashMap;
import java.util.Map;

class Categories {

    private final Map<Category, Question> categories;

    Categories() {
        categories = new HashMap<>();
        initQuestions();
    }

    private void initQuestions() {
        for (Category type : Category.values()) {
            categories.put(type, new Question(type));
        }
    }

    Category currentCategory(int playerPlace) {
        for (int i = 0; i <= 8; i += 4) if (playerPlace == i) return Category.POP;
        for (int i = 1; i <= 9; i += 4) if (playerPlace == i) return Category.SCIENCE;
        for (int i = 2; i <= 10; i += 4) if (playerPlace == i) return Category.SPORT;
        return Category.ROCK;
    }

    void askQuestion(int playerPlace) {
        System.out.println("The category is " + currentCategory(playerPlace).getLibelle());
        categories.get(currentCategory(playerPlace)).askQuestion();
    }
}
