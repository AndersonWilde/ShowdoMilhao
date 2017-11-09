package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Question {

	private String description;
	private String correctAnswer;
	private String alternativeA;
	private String alternativeB;
	private String alternativeC;
	private String alternativeD;
	
	public Question(){
		
	}
	
	public Question(String description,
					String correctAnswer,
					String alternativeA,
					String alternativeB,
					String alternativeC,
					String alternativeD) {
		this.description = description;
		this.correctAnswer = correctAnswer;
		this.alternativeA = alternativeA;
		this.alternativeB = alternativeB;
		this.alternativeC = alternativeC;
		this.alternativeD = alternativeD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getAlternativeA() {
		return alternativeA;
	}

	public void setAlternativeA(String alternativeA) {
		this.alternativeA = alternativeA;
	}

	public String getAlternativeB() {
		return alternativeB;
	}

	public void setAlternativeB(String alternativeB) {
		this.alternativeB = alternativeB;
	}

	public String getAlternativeC() {
		return alternativeC;
	}

	public void setAlternativeC(String alternativeC) {
		this.alternativeC = alternativeC;
	}

	public String getAlternativeD() {
		return alternativeD;
	}

	public void setAlternativeD(String alternativeD) {
		this.alternativeD = alternativeD;
	}
	
	public ArrayList<String> getRandomlyAnswers(){
	
		ArrayList<String> questions = new ArrayList<>();
		questions.add(this.correctAnswer);
		questions.add(this.alternativeA);
		questions.add(this.alternativeB);
		questions.add(this.alternativeC);
		questions.add(this.alternativeD);
		
		Collections.shuffle(questions);
		return questions;
	}
	
	public boolean isCorrectAnswer(String answer){
		
		return this.correctAnswer.equals(answer);
	
	}
	
}

