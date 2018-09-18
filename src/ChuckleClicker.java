import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ChuckleClicker implements MouseListener {
	JFrame window;
	JPanel calque;
	JButton joke, punchline;
	
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}
	
	public void makeButtons() {
		JOptionPane.showMessageDialog(null, "Make Buttons");
		window = new JFrame();
		
		window = new JFrame("ChuckleClicker");
		window.setVisible(true);
		window.setSize(600, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		calque = new JPanel();
		
		joke = new JButton("joke");
		joke.setSize(60, 100);
		joke.addMouseListener(this);
		
		punchline = new JButton("punchline");
		punchline.addMouseListener(this);

		calque.add(joke);
		calque.add(punchline);
		
		window.add(calque);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == joke)
			JOptionPane.showMessageDialog(null, "This is a joke");
		if (arg0.getSource() == punchline)
			JOptionPane.showMessageDialog(null, "This is a punchline");	
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
