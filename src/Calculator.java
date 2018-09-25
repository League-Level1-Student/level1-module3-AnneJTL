import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator implements MouseListener {
	private JFrame fenetre;
	private JTextField number1, number2;
	private JButton addBtn, subBtn, mulBtn, divBtn;
	private JLabel resultat;
	
	 Calculator(){
		initializeGUI();
	}

	private void initializeGUI(){
		JFrame fenetre = new JFrame("Calculator");
		fenetre.setPreferredSize(new Dimension(300,200));
		fenetre.setTitle("Calculator");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponentsToPane(fenetre.getContentPane());
		
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	public void addComponentsToPane(Container calque0) {
		calque0.setLayout(new BorderLayout());
		
		JPanel calqueNumbers = new JPanel();
		JPanel calqueBtn = new JPanel();
		
		/* ******************************************* */
		/* *************** 1ere ligne **************** */
		/* ******************************************* */
		number1 = new JTextField();
		number1.setPreferredSize(new Dimension(50, 20));
		number2 = new JTextField();
		number2.setPreferredSize(new Dimension(50, 20));
		calqueNumbers.add(number1, BorderLayout.PAGE_START);
		calqueNumbers.add(number2, BorderLayout.CENTER);

		/* ******************************************* */
		/* *************** 2eme ligne **************** */
		/* ******************************************* */		
		addBtn = new JButton("add");
		addBtn.addMouseListener(this);

		subBtn = new JButton("sub");
		subBtn.addMouseListener(this);

		mulBtn = new JButton("mul");
		mulBtn.addMouseListener(this);

		divBtn = new JButton("div");
		divBtn.addMouseListener(this);
		
		calqueBtn.add(addBtn);
		calqueBtn.add(subBtn);
		calqueBtn.add(mulBtn);
		calqueBtn.add(divBtn);

		calque0.add(calqueNumbers, BorderLayout.PAGE_START);
		calque0.add(calqueBtn,  BorderLayout.CENTER );

		/* ******************************************* */
		/* *************** 3eme ligne **************** */
		/* ******************************************* */	
		resultat = new JLabel("0");
		resultat.setBackground(Color.LIGHT_GRAY);
		calque0.add(resultat, BorderLayout.PAGE_END);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if ((!isValidInteger(number1.getText())) || (!isValidInteger(number2.getText()))){
			JOptionPane.showMessageDialog
			(null, "Il faut saisir deux entiers", "Erreur de saisie", JOptionPane.ERROR_MESSAGE );
			return;
		}
		
		int num1 = Integer.valueOf(number1.getText());
		int num2 = Integer.valueOf(number2.getText());
		int calcul;
				
		if (arg0.getSource() == addBtn){
			resultat.setText(String.valueOf(num1 + num2));			
		} else if (arg0.getSource() == subBtn){
			resultat.setText(String.valueOf(num1 - num2));		
		} else if (arg0.getSource() == mulBtn){
			resultat.setText(String.valueOf(num1 * num2));			

		} else if (arg0.getSource() == divBtn){
			if (num2 == 0){
				JOptionPane.showMessageDialog
				(null, "Division par 0 interdite", "Division par 0", JOptionPane.ERROR_MESSAGE );
				return;
			}
			resultat.setText(String.valueOf(num1 / num2));			

		} else {
			JOptionPane.showMessageDialog
			(null, "Cette opération n'existe pas", "Erreur étrange !!!", JOptionPane.ERROR_MESSAGE );
			return;
		}
			
			
		
	}
	
	boolean isValidInteger(String value){
		Integer entier;
		if (value == null || value.isEmpty()) return false;

		try {
			entier = Integer.valueOf(value);
		} catch (NumberFormatException ex){
			return false;
		}
		
		return true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


