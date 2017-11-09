package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmShowDoMilho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmShowDoMilho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public void setVisible (boolean visible) {
		this.frmShowDoMilho.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShowDoMilho = new JFrame();
		frmShowDoMilho.setTitle("Show do Milh\u00E3o");
		frmShowDoMilho.setForeground(Color.YELLOW);
		frmShowDoMilho.setBackground(Color.YELLOW);
		frmShowDoMilho.getContentPane().setForeground(Color.YELLOW);
		frmShowDoMilho.setBounds(100, 100, 450, 300);
		frmShowDoMilho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShowDoMilho.getContentPane().setLayout(null);
		
		JLabel lblShowDoMilho = new JLabel("SHOW DO MILH\u00C3O!");
		lblShowDoMilho.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblShowDoMilho.setForeground(Color.RED);
		lblShowDoMilho.setBounds(93, 11, 251, 40);
		frmShowDoMilho.getContentPane().add(lblShowDoMilho);
		
		JButton btnNewButton = new JButton("JOGAR");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				openGameWindow();
			
			}
			
						
		});
		btnNewButton.setBounds(31, 124, 111, 23);
		frmShowDoMilho.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CADASTRAR PERGUNTAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRegisterQuestionWindow();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(182, 124, 207, 23);
		frmShowDoMilho.getContentPane().add(btnNewButton_1);
	
	
	
	}
	
	
	private void openRegisterQuestionWindow() {
		this.frmShowDoMilho.dispose();
		RegisterQuestions registerQuestionWindow = new RegisterQuestions();
		registerQuestionWindow.setVisible(true);
		
		
	}
	
	private void openGameWindow() {
		this.frmShowDoMilho.dispose();
		Game gameWindow = new Game();
		gameWindow.setVisible(true);
		
		
	}
	
}
