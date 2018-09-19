
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** We are going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {

	/*
	 * Here we are instantiating our BookOfIllusions class and calling it's createBook() method. 
	 * This is because we want to get out of the
	 * static main method, so that we can add a click listener to each illusion.
	 */

	public static void main(String[] args) throws Exception {
		BookOfIllusions illusions = new BookOfIllusions();
		illusions.createBook();
	}

	// 1. Make a JFrame variable and initialize it using "new JFrame()"
	JFrame window = new JFrame();
	JLabel displayImage;
	String imageName;
	boolean firstImage = true;

	private void createBook() {
		// 2. make the frame visible
		window.setVisible(true);
		// 3. set the size of the frame
		window.setSize(413, 413);
		window.setTitle("Book of Illusions");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 4. find 2 images and save them to your projects default package
		// 5. make a variable to hold the location of your image. e.g. "illusion.jpg"
		imageName = "illusion1.jpg";
		// 6. create a variable of type "JLabel" but dont initialize it yet
		//JLabel displayImage;
		// 7. use the "loadImage..." methods below to initialize your JLabel
		
		displayImage = loadImageFromComputer(imageName);	
		System.out.println("Height: "+ displayImage.getIcon().getIconHeight());

		// 8. add your JLabel to the frame
		window.add(displayImage);
		// 9. call the pack() method on the frame
		window.pack();
		// 10. add a mouse listener to your frame (hint: use *this*)
		window.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		// 11. Print "clicked!" to the console when the mouse is pressed
		System.out.println("clicked!");
		// 12. remove everything from the frame that was added earlier
		window.getContentPane().removeAll();

		
		// 13. load a new image like before (this is more than one line of code)
		if (firstImage){
			firstImage = false;
			imageName = "illusion2.jpg";
		} else {
			firstImage = true;
			imageName = "illusion1.jpg";
		}
		displayImage = loadImageFromComputer(imageName);		
		window.add(displayImage);

		//window.setVisible(true);

		// 14. pack the frame
		window.pack();
	}

	// [OPTIONAL] 15. goad your users with some annoying or witty pop-ups

	/*
	 * To use this method, the image must be placed in your Eclipse project under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}


