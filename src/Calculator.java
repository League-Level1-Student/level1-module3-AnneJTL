import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Calculator implements ActionListener {
	private JFrame fenetre;
	private JPanel calque;
	private JTextField number1, number2;
	private JButton addBtn, subBtn, mulBtn, divBtn;
	private JLabel resultat;
	
	 Calculator(){
		initializeGUI();
	}

	private void initializeGUI(){
		fenetre = new JFrame("Calculator");
		//fenetre.setPreferredSize(new Dimension(300,200));
		fenetre.setSize(400,300);

		fenetre.setTitle("Calculator");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		calque = new JPanel();
		calque.setSize(380,300);

		
		/* ******************************************* */
		/* *************** 1ere ligne **************** */
		/* ******************************************* */
		number1 = new JTextField(15);
		number2 = new JTextField(15);
		calque.add(number1);
		calque.add(number2);

		/* ******************************************* */
		/* *************** 2eme ligne **************** */
		/* ******************************************* */		
		addBtn = new JButton("add");
		addBtn.setPreferredSize(new Dimension(80, 25));
		//addBtn.addMouseListener(this);
		addBtn.addActionListener(this);

		subBtn = new JButton("sub");
		subBtn.setPreferredSize(new Dimension(80, 25));
		//subBtn.addMouseListener(this);
		subBtn.addActionListener(this);


		mulBtn = new JButton("mul");
		mulBtn.setPreferredSize(new Dimension(80, 25));
		//mulBtn.addMouseListener(this);
		mulBtn.addActionListener(this);


		divBtn = new JButton("div");
		divBtn.setPreferredSize(new Dimension(80, 25));
		//divBtn.addMouseListener(this);
		divBtn.addActionListener(this);

		
		calque.add(addBtn);
		calque.add(subBtn);
		calque.add(mulBtn);
		calque.add(divBtn);

		/* ******************************************* */
		/* *************** 3eme ligne **************** */
		/* ******************************************* */	
		resultat = new JLabel(" ");
		resultat.setPreferredSize(new Dimension(150, 25));
		resultat.setOpaque(true);
		resultat.setBackground(Color.ORANGE);
		resultat.setHorizontalAlignment(SwingConstants.RIGHT);
		resultat.setBorder(BorderFactory.createLineBorder(Color.black));
		calque.add(resultat);
		
		fenetre.add(calque);
		fenetre.setVisible(true);


	}

	boolean isValidInteger(String value){
		if (value == null || value.isEmpty()) return false;

		try {
			Integer.valueOf(value);
		} catch (NumberFormatException ex){
			return false;
		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		JButton buttonPressed = (JButton) arg0.getSource();
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource());
		
		// TODO Auto-generated method stub
		if ((!isValidInteger(number1.getText())) || (!isValidInteger(number2.getText()))){
			JOptionPane.showMessageDialog
			(null, "Il faut saisir deux entiers", "Erreur de saisie", JOptionPane.ERROR_MESSAGE );
			return;
		}
		
		int num1 = Integer.valueOf(number1.getText());
		int num2 = Integer.valueOf(number2.getText());
				
		if (arg0.getSource() == addBtn){
			resultat.setText(String.valueOf(num1 + num2)+ " ");			
		} else if (arg0.getSource() == subBtn){
			resultat.setText(String.valueOf(num1 - num2)+ " ");		
		} else if (arg0.getSource() == mulBtn){
			resultat.setText(String.valueOf(num1 * num2)+ " ");			

		} else if (arg0.getSource() == divBtn){
			if (num2 == 0){
				JOptionPane.showMessageDialog
				(null, "Division par 0 interdite", "Division par 0", JOptionPane.ERROR_MESSAGE );
				return;
			}
			resultat.setText(String.valueOf(num1 / num2)+ " ");			

		} else {
			JOptionPane.showMessageDialog
			(null, "Cette opération n'existe pas", "Erreur étrange !!!", JOptionPane.ERROR_MESSAGE );
			return;
		}
		
	}
}


