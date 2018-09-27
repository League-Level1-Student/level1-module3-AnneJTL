
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class WhackAMole implements ActionListener{
	private JFrame fenetre;
	private JPanel calque;
	private final static int NB_BUTTONS = 24;
	private final static String BUTTON_TEXT = "mole!";
	private JButton[] allButtons = new JButton[NB_BUTTONS];
	private Random aleatoire = new Random();
	private int moleButton;
	private int goodAttempt = 0;
	private int badAttempt = 0;
	private static Date timeStart  = new Date();
	

	public static void main(String[] args) {
		new WhackAMole();
	}

	public WhackAMole() {
		initializeGUI();
	}
	
	private void initializeGUI() {
		fenetre = new JFrame();	
		calque = new JPanel();
		fenetre.setSize(350, 500);
		fenetre.setPreferredSize(new Dimension(350, 500));
		fenetre.setTitle("Whack a Button for Fame and Glory");
		//fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		fenetre.add(calque);
		moleButton = aleatoire.nextInt(NB_BUTTONS);
		drawButtons(moleButton);
		
		fenetre.setVisible(true);
		//timeStart = new Date();
	}
	
	private void redraw(){
		fenetre.setVisible(false);

		fenetre.remove(calque);
		calque = new JPanel();	
		moleButton = aleatoire.nextInt(NB_BUTTONS);
		drawButtons(moleButton);
		fenetre.add(calque);
		fenetre.setVisible(true);
		
	}

	private void drawButtons(int aleatoire){
		
		//System.out.println("size:" + allButtons.length + " - aleatoire: " + aleatoire);
		
		for (int i=0; i < allButtons.length; i++){
			allButtons[i] = new JButton();
			allButtons[i].setPreferredSize(new Dimension(100, 50));
			allButtons[i].addActionListener(this);
			//allButtons[i].addMouseListener(this);

			if (i == aleatoire){
				allButtons[i].setText(BUTTON_TEXT);			
			}
			calque.add(allButtons[i]);
		}
		
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		JButton clickedButton = (JButton) arg0.getSource();
		System.out.println("Bouton: " + clickedButton.getText());
		
		if (!(clickedButton.getText() == BUTTON_TEXT)){
			String badTest;
			badAttempt++;

			switch (badAttempt) {
			case 1:
				badTest = "first bad attempt";
				break;
			case 2:
				badTest = "second bad attempt";
				break;
			case 3:
				badTest = "third bad attempt";
				break;
			case 4:
				badTest = "fourth bad attempt";
				break;
			case 5:
				badTest = "fifth bad attempt";
				break;
			default:
				badTest = "Strange !!!";
				break;
			}
			JOptionPane.showMessageDialog(null, badTest);

		}
		else {
			playSound("moo.wav");
			JOptionPane.showMessageDialog(null, "Good Job !!!");
			goodAttempt++;
		}
		
		if (goodAttempt >= 9){
			endGame(timeStart, goodAttempt);
		} else if (badAttempt >= 5){
			endGame(timeStart, badAttempt);
		} 

		redraw();
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}
}




