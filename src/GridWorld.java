import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class GridWorld {
	private static int maxRows = 10;
	private static int maxColumns = 10;
	private static Random aleatoire = new Random();
	private static World myWord = new World();
	private static GridWorld workingGridWord;

	public static void main(String[] args) {
		workingGridWord = new GridWorld();
		// TODO Auto-generated method stub

		//1. Figure out how to get the World to show.
		myWord.show();

		// 2. Figure out how to add a Bug to the world (clue: you will need the Bug and Location objects)
		Bug bug1 = new Bug();
		Location case1 = new Location(3, 2);
		myWord.add(case1, bug1);

		// 3. Add another bug at a random location in the world.
		Bug bug2 = new Bug();
		int rowPosition = aleatoire.nextInt(maxRows);
		int positionColonne = aleatoire.nextInt(maxColumns);
		System.out.println("positionLigne: " + rowPosition + "positionColonne: " + positionColonne);
		Location case2 = new Location(rowPosition, positionColonne);
		myWord.add(case2, bug2);

		// 4. Change the color of that bug to blue.
		bug2.setColor(Color.BLUE);

		// 5. Make the bug face to the right.
		bug2.turn();
		bug2.turn();

		// 6. Add flowers to the left and right of the bug.
		Flower flowerRed = new Flower();
		flowerRed.setColor(Color.PINK);
		Flower flowerBlue = new Flower();
		flowerBlue.setColor(Color.BLUE);
		
		if (positionColonne > 0)
			myWord.add(new Location(rowPosition, positionColonne-1), flowerRed);
			
		if (positionColonne < maxColumns-1)
			myWord.add(new Location(rowPosition, positionColonne+1), flowerBlue);
		
		// 7. Fill the whole world with flowers!
		for (int row = 0; row < maxRows; row++){
			System.out.println("row % 2 = " + row % 2);
			
			for (int col = 0; col < maxColumns; col++){
				if ((row % 2) == 0){
					myWord.add(new Location(row, col), flowerRed);
				} else {
					myWord.add(new Location(row, col), flowerBlue);

				}
			}
			
		}

		// 8. [Optional] Color the flowers in rows like the American flag (red & white)

		// 9. [Optional] Use a new class to make an X out of bugs.
		GridWorld.XBugs severalBugs = workingGridWord.new XBugs(7);
		severalBugs.displayBugs();

	}
	
	class XBugs{
		private final int nbBugs;
		public XBugs(int nbBugs) {
			// TODO Auto-generated constructor stub
			this.nbBugs = nbBugs;
		}
		
		private void displayBugs(){
			Bug aBug = new Bug();
			for (int i = 0; i < nbBugs; i++){
				myWord.add(new Location(aleatoire.nextInt(maxRows), aleatoire.nextInt(maxColumns)), aBug);

			}
		}
	}

}
