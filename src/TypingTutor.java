import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TypingTutor implements KeyListener{
	private JFrame window;

	private JLabel displayChar;
	private char currentLetter;
	private int countCorrectCaracter = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypingTutor typeOrDie =  new TypingTutor();
		typeOrDie.initGUI();


	}
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
	Date timeAtStart = new Date();
	
	private void initGUI(){
		window = new JFrame("Type or Die");
		window.setVisible(true);
		window.setSize(600, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentLetter = generateRandomLetter();
		displayChar = new JLabel(String.valueOf(currentLetter));
		displayChar.setFont(displayChar.getFont().deriveFont(28.0f));
		displayChar.setHorizontalAlignment(JLabel.CENTER);
		
		window.add(displayChar);
		window.addKeyListener(this);
	}
	
	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char userChar = arg0.getKeyChar();
		System.out.println("You typed: " + userChar);
		if (userChar == currentLetter){
			window.getContentPane().setBackground(Color.green);
			System.out.println("Correct !");
			countCorrectCaracter++;

		} else {
			window.getContentPane().setBackground(Color.red);

		}

		if (countCorrectCaracter >= 15){
			showTypingSpeed(countCorrectCaracter);
			countCorrectCaracter = 0;

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		displayChar.setText(String.valueOf(currentLetter));
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
