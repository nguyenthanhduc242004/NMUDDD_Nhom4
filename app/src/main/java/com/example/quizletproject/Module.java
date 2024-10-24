package com.example.quizletproject;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Module {
    private String name;
    private List<Flashcard> flashcards;
    private Date createdTime;

    public Module( String name, List<Flashcard> flashcards) {
        this.flashcards = flashcards;
        this.name = name;
        this.createdTime = Calendar.getInstance().getTime();;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
