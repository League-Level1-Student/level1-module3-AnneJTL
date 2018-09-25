import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class GetLatestTweet implements MouseListener{
	JFrame fenetre;
	//JPanel calque;
	Container calque;

	JButton searchBtn;
	JTextField term;
	JLabel latestTweet;
	
	public GetLatestTweet(){
		initializeGUI();
	}

	private void initializeGUI() {
		fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(500, 150));
		
		searchBtn = new JButton("Search the Twitterverse");
		searchBtn.addMouseListener(this);
		
		term = new JTextField();
		term.setPreferredSize(new Dimension(150, 30));
		
		latestTweet = new JLabel("              \n");
		
		/* *****************************/
		/*  PANE
		/* *****************************/
		//calque = new JPanel();
		calque = new Container();

		calque.setLayout(new BoxLayout(calque, BoxLayout.Y_AXIS));


		calque.add(term);
		calque.add(searchBtn);
		calque.add(latestTweet);

		
		fenetre.add(calque);
		fenetre.setTitle("The Amazing Tweet Retriever !!!");
		
		
		
		
		fenetre.setVisible(true);
		fenetre.pack();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Tweet, Tweet");
		String criteria = term.getText().trim();
				
		if (criteria != null && criteria.length()>0){
			latestTweet.setText(getLatestTweet(criteria));
			
		}
		else
			JOptionPane.showMessageDialog(null, "Erreur... vide", "Il faut entrer un critere de recherche", JOptionPane.ERROR_MESSAGE);
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
	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}


}
