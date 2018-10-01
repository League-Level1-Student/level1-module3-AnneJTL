import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SlotMachine implements ActionListener{
	private JFrame fenetre;
	private JPanel calque;
	private JLabel slot1, slot2, slot3;
	private JButton spinButton;
	private Icon cherriesIcon, heartIcon, orangeIcon;
	private Random imageRandom = new Random();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SlotMachine();

	}
	
	public SlotMachine(){
		initializeGUI();
	}

	private void initializeGUI(){
		fenetre = new JFrame("Slot Machine");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(900,  500);
		
		calque = new JPanel();
		
		cherriesIcon = loadImageToIcon("cherries.jpg");
		//slot7Icon = loadImageToIcon("slotMachine7.png");
		heartIcon = loadImageToIcon("heart.jpg");

		orangeIcon = loadImageToIcon("orange.jpg");

		slot1 = new JLabel(cherriesIcon);
		slot2 = new JLabel(heartIcon);
		slot3 = new JLabel(orangeIcon);
		
		spinButton = new JButton("Spin");
		spinButton.setPreferredSize(new Dimension(200, 150));
		spinButton.addActionListener(this);
		
		
		calque.add(slot1);
		calque.add(slot2);
		calque.add(slot3);

		calque.add(spinButton);
		
		fenetre.add(calque);
		fenetre.setVisible(true);
		
	}
	
	private Icon loadImageToIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		return new ImageIcon(imageURL);
	}

	/*
	private JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}
	*/
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		slot1.setIcon(randomIcon());
		slot2.setIcon(randomIcon());
		slot3.setIcon(randomIcon());

		if (slot1.getIcon() == slot2.getIcon() && slot1.getIcon()== slot3.getIcon())
			JOptionPane.showMessageDialog(null, "YOU WIN !!!");
		
	}
	
	private Icon randomIcon(){
		
		switch (imageRandom.nextInt(3)){
		case 0:
			return cherriesIcon;			
		case 1:
			return heartIcon;
		case 2:
			return orangeIcon;
		default:
			return cherriesIcon;
		}
	}
	
}
