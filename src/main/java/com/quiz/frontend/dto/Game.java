package com.quiz.frontend.dto;

public class Game {
    public String categoryName = "";
    public Integer questionsNumber = 0;
    public String type = "quiz";

    public Game() {
    }

    public String getCategoryName() {
        return categoryName;
    }
    public Integer getQuestionsNumber() {
        return questionsNumber;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setQuestionsNumber(Integer questionsNumber) {
        this.questionsNumber = questionsNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
