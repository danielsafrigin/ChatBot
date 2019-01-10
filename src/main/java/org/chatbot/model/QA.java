package org.chatbot.model;

import java.util.ArrayList;

public class QA {

	private ArrayList<String> questions;
	private String answer;

	public QA() {
		questions = new ArrayList<String>();
	}

	public QA(String answer) {
		questions = new ArrayList<String>();
		this.answer = answer;
	}

	public QA(String question, String answer) {
		questions = new ArrayList<String>();
		questions.add(question);
		this.answer = answer;
	}

	public QA(ArrayList<String> questions, String answer) {
		this.questions = questions;
		this.answer = answer;
	}

	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public String get(int index) {
		return questions.get(index);
	}
	
	public void add(String question){
		questions.add(question);
	}
	
	public int Size() {
		return questions.size();
	}


	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QA [questions=" + questions.toString() + ", answer=" + answer + "]";
	}

}
