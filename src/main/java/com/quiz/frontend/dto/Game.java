package com.quiz.frontend.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;

public class Game {
     final int maxPlayers = 1;

    @NotEmpty
    public String categoryName = "";

    @NotEmpty
    public String gameMode = "";

    @Nonnull
    public String gameType = "";

    @Max(maxPlayers)
    public int gamePlayers = 0;
    public int questionsNumber = 0;
    public String type = "quiz";

    public Game() {
    }

    public String getCategoryName() {
        return categoryName;
    }
    public Integer getGamePlayers() {
        return gamePlayers;
    }
    public String getGameMode() {
        return gameMode;
    }
    public String getGameType() {
        return gameType;
    }
    public Integer getQuestionsNumber() {
        return questionsNumber;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setGamePlayers(Integer gamePlayers) {
        this.gamePlayers = gamePlayers;
    }
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
    public void setGameType(String gameType) {
        this.gameType = gameType;
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
