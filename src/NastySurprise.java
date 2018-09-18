import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NastySurprise implements MouseListener{
	private JFrame fenetre;
	private JPanel calque;
	private JButton trickBtn, treatBtn;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NastySurprise().initGUI();

	}

	private void initGUI(){
		fenetre = new JFrame("Nasty Surprise");
		fenetre.setVisible(true);
		fenetre.setSize(600, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		calque = new JPanel();
		
		trickBtn = new JButton("Trick !");
		trickBtn.setSize(60, 100);
		trickBtn.addMouseListener(this);
		
		treatBtn = new JButton("Treat");
		treatBtn.addMouseListener(this);

		calque.add(trickBtn);
		calque.add(treatBtn);
		
		fenetre.add(calque);
		//fenetre.pack();
		
		
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getComponent() == treatBtn){
			System.out.println("TREAT demandé");
		showPictureFromTheInternet("http://www.warsawcdc.org/images/site/halloween-trick-or-treating-neighborhoods-boston.jpg");
		}
		else if (arg0.getSource() == trickBtn) {
			System.out.println("TRICK demandé");
			showPictureFromTheInternet("https://cdns.klimg.com/merdeka.com/i/w/news/2016/07/18/730522/content_images/670x335/20160718181722-1-gambar-ilusi-optik-karya-jordan-molina-004-tantri-setyorini.png");
		}
		else {
			System.out.println("Oups");
		}
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
