package org.chatbot.model;

import java.util.ArrayList;

import org.chatbot.algorithms.lcs.LCS;

public class DataBase {

	private ArrayList<QA> QAList;

	public DataBase() {
		QAList = new ArrayList<QA>();
	}

	public String answer(String question) {
		float max = match(question, QAList.get(0));
		int answerIndex = 0;
		for (int i = 1; i < QAList.size(); i++) {
			if (match(question, QAList.get(i)) > max) {
				max = match(question, QAList.get(i));
				answerIndex = i;
			}
		}

		System.out.println(QAList.get(answerIndex).getAnswer());
		System.out.println("answered this question with " + max * 100 + "% certainty");
		return QAList.get(answerIndex).getAnswer();
	}

	public float match(String question, QA qa) {
		float max = LCS.match(question, qa.get(0));
		for (int i = 1; i < qa.Size(); i++) {
			if (LCS.match(question, qa.get(i)) > max) {
				max = LCS.match(question, qa.get(i));
			}
		}
		return max;
	}

	public void add(QA qa) {
		QAList.add(qa);
	}

	public void remove(QA qa) {
		QAList.add(qa);
	}

	public QA get(int index) {
		return QAList.get(index);
	}

	public ArrayList<QA> getQAList() {
		return QAList;
	}

	@Override
	public String toString() {
		return "DataBase [QAList=" + QAList + "]";
	}

}
