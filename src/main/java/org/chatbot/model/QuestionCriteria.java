package org.chatbot.model;

import org.hibernate.validator.constraints.NotBlank;

public class QuestionCriteria {

    @NotBlank(message = "question can't be empty!")
    String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
    	System.out.println(question);
        this.question = question;
    }
}