import javax.swing.JOptionPane;


public class NetflixRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	    1. Instantiate some Movie objects (at least 5).

		Movie level0Movie = new Movie("L'approche Finale", 0);
		Movie level1Movie = new Movie("Alien", 1);
		Movie level2Movie = new Movie("Les Gardiens de la Galaxie", 2);
		Movie level3Movie = new Movie("6ème Sens", 3);
		Movie level4Movie = new Movie("Experience Interdite", 4);
		
	    // 2. Use the Movie class to get the ticket price of one of your movies.
		JOptionPane.showMessageDialog(null, level0Movie.getTicketPrice(), level0Movie.toString() , JOptionPane.INFORMATION_MESSAGE);
		
	    // 3. Instantiate a NetflixQueue.
		NetflixQueue moviesList = new NetflixQueue();
		
	    // 4. Add your movies to the Netflix queue.
		moviesList.addMovie(level0Movie);
		moviesList.addMovie(level1Movie);
		moviesList.addMovie(level2Movie);
		moviesList.addMovie(level3Movie);
		moviesList.addMovie(level4Movie);

		
	    // 5. Print all the movies in your queue.
		moviesList.printMovies();
		
		
	    // 6. Use your NetflixQueue object to finish the sentence "the best movie is...."
		JOptionPane.showMessageDialog
			(null, "the best movie is " + moviesList.getBestMovie(), "The Best movie", JOptionPane.INFORMATION_MESSAGE);

		
	    // 7. Use your NetflixQueue to finish the sentence "the second best movie is...." 
		moviesList.sortMoviesByRating();
		moviesList.printMovies();
		
		JOptionPane.showMessageDialog
		(null, "The second best movie is " + moviesList.getMovie(1), "The Second Best Movie", JOptionPane.INFORMATION_MESSAGE);
	}

}
