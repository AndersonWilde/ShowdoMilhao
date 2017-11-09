package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.Question;
import Persistence.DataBase;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Game {

	private JFrame frame;

	JLabel questionValueLabel;
	JLabel questionLabel;
	JButton altenativeALabel;
	JButton altenativeBLabel;
	JButton altenativeCLabel;
	JButton altenativeDLabel;
	JButton altenativeELabel;
	
	private int questionNumber = 0;
	private int lestQuestionNumber = 16;	
	private Question question;
	private String[] questionValue = {"R$ 1000", "R$2000", "R$3000", "R$4000", "R$5000", "R$10000", "R$20000", "R$30000", "R$40000", "R$50000", "R$100000", "R$200000", "R$300000", "R$400000", "R$500000", "R$1000000"};
	
	private void nextQuestion(){
		
		if (questionNumber == lestQuestionNumber){
			showWinMessage();
			
		} else {
			DataBase database = new DataBase();
			this.question = database.getQuestion();
				
			this.questionValueLabel.setText(questionValue[questionNumber]);
			this.questionLabel.setText(this.question.getDescription());
			ArrayList<String> answers = this.question.getRandomlyAnswers();
			this.altenativeALabel.setText(answers.get(0));
			this.altenativeBLabel.setText(answers.get(1));
			this.altenativeCLabel.setText(answers.get(2));
			this.altenativeDLabel.setText(answers.get(3));
			this.altenativeELabel.setText(answers.get(4));
			
			questionNumber++;
		}
		
		
	}
	
	private void chooseAnswer(String answer) {
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Está certo disto? ", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			if (question.isCorrectAnswer(answer)){
				
				this.nextQuestion();
			}else{
				showLooseMessage();
			}
			
		}
	}
	
	private void showLooseMessage(){
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Você ganhou " + this.questionValue[this.questionNumber-1], "Resposta Errada!", JOptionPane.OK_CANCEL_OPTION);
		if(dialogResult == JOptionPane.OK_OPTION){
			goBackMainWindow();
			
		}
		
	}
	
	private void showWinMessage(){
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Você ganhou " + this.questionValue[this.questionNumber-1], "Você foi o vencedor!", JOptionPane.OK_CANCEL_OPTION);
		if(dialogResult == JOptionPane.OK_OPTION){
			goBackMainWindow();
		}
	}
	
	
	private void goBackMainWindow() {
		this.frame.dispose();
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
		nextQuestion();
	}
	
	public void setVisible (boolean visible) {
		this.frame.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShowDoMilho = new JLabel("SHOW DO MILH\u00C3O!");
		lblShowDoMilho.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblShowDoMilho.setForeground(Color.RED);
		lblShowDoMilho.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowDoMilho.setBounds(88, 11, 227, 25);
		frame.getContentPane().add(lblShowDoMilho);
		
		questionValueLabel = new JLabel("R$ 1000000");
		questionValueLabel.setBounds(327, 48, 67, 14);
		frame.getContentPane().add(questionValueLabel);
		
		questionLabel = new JLabel("PERGUNTA");
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setBounds(46, 100, 348, 46);
		frame.getContentPane().add(questionLabel);
		
		altenativeALabel = new JButton("RESPOSTA A");
		altenativeALabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseAnswer(altenativeALabel.getText());
			}
		});
		altenativeALabel.setBounds(46, 159, 348, 23);
		frame.getContentPane().add(altenativeALabel);
		
		altenativeBLabel = new JButton("RESPOSTA B");
		altenativeBLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseAnswer(altenativeBLabel.getText());
			}
		});
		altenativeBLabel.setBounds(46, 195, 348, 23);
		frame.getContentPane().add(altenativeBLabel);
		
		altenativeCLabel = new JButton("RESPOSTA C");
		altenativeCLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseAnswer(altenativeCLabel.getText());
			}
		});
		altenativeCLabel.setBounds(46, 229, 348, 23);
		frame.getContentPane().add(altenativeCLabel);
		
		altenativeDLabel = new JButton("RESPOSTA D");
		altenativeDLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseAnswer(altenativeDLabel.getText());
			}
		});
		altenativeDLabel.setBounds(46, 263, 348, 23);
		frame.getContentPane().add(altenativeDLabel);
		
		altenativeELabel = new JButton("RESPOSTA E");
		altenativeELabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseAnswer(altenativeELabel.getText());
			}
		});
		altenativeELabel.setBounds(46, 297, 348, 23);
		frame.getContentPane().add(altenativeELabel);
		
		JButton btnDesistir = new JButton("DESISTIR");
		btnDesistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int dialogResult = JOptionPane.showConfirmDialog(frame, "Tem certeza que vai desistir? ", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					goBackMainWindow();
					
				}
			}
		});
		btnDesistir.setBounds(327, 348, 89, 23);
		frame.getContentPane().add(btnDesistir);
	}

}
