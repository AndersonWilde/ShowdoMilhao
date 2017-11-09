package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Question;
import Persistence.DataBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterQuestions {

	private JFrame frame;
	private JTextField questionTestField;
	private JTextField correctAnsweeTestfield;
	private JTextField alternativeBTestField;
	private JTextField alternativeCTestField;
	private JTextField alternativeATestField;
	private JTextField alternativeDTestField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterQuestions window = new RegisterQuestions();
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
	public RegisterQuestions() {
		initialize();
	}

	public void setVisible (boolean visible) {
		this.frame.setVisible(visible);
	}
	
	private void saveQuestion(){
		String description = questionTestField.getText();
		String correctAnswer = correctAnsweeTestfield.getText();
		String alternativeA = alternativeATestField.getText();
		String alternativeB = alternativeBTestField.getText();
		String alternativeC = alternativeCTestField.getText();
		String alternativeD = alternativeDTestField.getText();
	
		Question question = new Question(description, correctAnswer, alternativeA, alternativeB, alternativeC, alternativeD);
	
		DataBase db = new DataBase ();
		db.insertQuestion(question);
		
	}
	
	
	
	private void goBackMainWindow() {
		this.frame.dispose();
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastreSuaPergunta = new JLabel("CADASTRE SUA PERGUNTA");
		lblCadastreSuaPergunta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCadastreSuaPergunta.setForeground(Color.RED);
		lblCadastreSuaPergunta.setBounds(72, 11, 282, 25);
		frame.getContentPane().add(lblCadastreSuaPergunta);
		
		questionTestField = new JTextField();
		questionTestField.setToolTipText("DIGITE AQUI SUA PERGUNTA");
		questionTestField.setBounds(134, 47, 250, 57);
		frame.getContentPane().add(questionTestField);
		questionTestField.setColumns(10);
		
		JLabel lblPergunta = new JLabel("PERGUNTA:");
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPergunta.setForeground(Color.BLUE);
		lblPergunta.setBounds(23, 68, 89, 14);
		frame.getContentPane().add(lblPergunta);
		
		JLabel lblRespostaCorreta = new JLabel("RESPOSTA CORRETA:");
		lblRespostaCorreta.setForeground(Color.BLUE);
		lblRespostaCorreta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCorreta.setBounds(3, 118, 132, 14);
		frame.getContentPane().add(lblRespostaCorreta);
		
		correctAnsweeTestfield = new JTextField();
		correctAnsweeTestfield.setBounds(134, 115, 250, 20);
		frame.getContentPane().add(correctAnsweeTestfield);
		correctAnsweeTestfield.setColumns(10);
		
		JLabel lblAlternativas = new JLabel("ALTERNATIVA A:");
		lblAlternativas.setForeground(Color.BLUE);
		lblAlternativas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativas.setBounds(2, 159, 110, 14);
		frame.getContentPane().add(lblAlternativas);
		
		alternativeBTestField = new JTextField();
		alternativeBTestField.setBounds(134, 190, 250, 20);
		frame.getContentPane().add(alternativeBTestField);
		alternativeBTestField.setColumns(10);
		
		alternativeCTestField = new JTextField();
		alternativeCTestField.setBounds(134, 221, 250, 20);
		frame.getContentPane().add(alternativeCTestField);
		alternativeCTestField.setColumns(10);
		
		alternativeATestField = new JTextField();
		alternativeATestField.setColumns(10);
		alternativeATestField.setBounds(134, 156, 250, 20);
		frame.getContentPane().add(alternativeATestField);
		
		JLabel lblAlternativaB_1 = new JLabel("ALTERNATIVA B:");
		lblAlternativaB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativaB_1.setForeground(Color.BLUE);
		lblAlternativaB_1.setBounds(3, 193, 110, 14);
		frame.getContentPane().add(lblAlternativaB_1);
		
		JLabel lblAlternativaB = new JLabel("ALTERNATIVA C:");
		lblAlternativaB.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativaB.setForeground(Color.BLUE);
		lblAlternativaB.setBounds(3, 222, 110, 14);
		frame.getContentPane().add(lblAlternativaB);
		
		JButton btnNewButton = new JButton("CANCELAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackMainWindow();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(295, 288, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveQuestion();
				goBackMainWindow();
			}
		});
		btnSalvar.setBounds(196, 288, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		alternativeDTestField = new JTextField();
		alternativeDTestField.setColumns(10);
		alternativeDTestField.setBounds(134, 257, 250, 20);
		frame.getContentPane().add(alternativeDTestField);
		
		JLabel lblAlternativaD = new JLabel("ALTERNATIVA D:");
		lblAlternativaD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternativaD.setForeground(Color.BLUE);
		lblAlternativaD.setBounds(10, 260, 95, 14);
		frame.getContentPane().add(lblAlternativaD);
	
	
	}
	
}
