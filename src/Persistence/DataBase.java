package Persistence;

import java.util.Random;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.instrumentation.file.FileInstrumentationClassSource;

import Model.Question;

public class DataBase {

	ObjectContainer db;
	
	private void openDb () {
		db = Db4o.openFile("c:/showdomilhao.yap");
	}
	
	public Question getQuestion(){
		Question question = new Question();
		try {
			this.openDb();
			ObjectSet<Question> questions = db.query(Question.class);
			Random random = new Random();
			int questionNumber = random.nextInt(questions.size());
			question = questions.get(questionNumber);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			db.close();
		}
		
		return question;
	}
	
	public boolean insertQuestion(Question question) {
		this.openDb();
		try {
			
			db.store(question);
			db.commit();
			return true;
		} catch(Exception e) {
			return  false;
		} finally {
			db.close();
		}

		
	}
	
	

}
