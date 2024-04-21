package com.quiz.frontend.dto;

public class Quiz {
    Integer gameParticipants = 0;
    public String gameCategory = "";

    String type = "quiz";

    Integer currentQuestion = 0;

    public Quiz(String category, Integer participants) {
        gameCategory = category;
        gameParticipants = participants;
}
        
    public Integer getCurrentQuestion() {
        return currentQuestion;
    }

    public Integer nextQuestion() {
        return currentQuestion;
    }
    
}
