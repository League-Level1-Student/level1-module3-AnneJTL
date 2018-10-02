/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.applet.AudioClip;
import javax.swing.JApplet;

public class CowTimer {
	/*
	 * This is an advanced recipe. There may be more than one line of code for each
	 * instruction. Work in seconds when testing, then change to minutes
	 */

	public static void main(String[] args) throws InterruptedException {
		/* 1. Make a CowTimer, set the time and start it. */
		CowTimer aTimer = new CowTimer();
		aTimer.setTime(6);
		aTimer.start();

	}

	private int minutes;

	public void setTime(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow set to " + minutes + " minutes.");
	}

	public void start() throws InterruptedException {
		/*
		 * 2. Count down the minutes, print the current minute then sleep for 60 seconds
		 * using Thread.sleep(int milliseconds).
		 */
		for (int min = minutes; min > 0 ; min--){
			System.out.println("minute: " + min);
			// in minutes
			// Thread.sleep(1000*60);

			// in seconds
			Thread.sleep(1000);
		}

		/*
		 * 3. When the timer is finished, use the playSound method to play a moo sound.
		 * You can use the .wav file in the default package, or you can download one
		 * from freesound.org, then drag it into the default package.
		 */
		playSound("creepy-noise.wav");
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		System.out.println(sound.toString());
		sound.play();
	}
/*
	private void speak(String stuffToSay) {
		try {
			Runtime.getRuntime().exec("say " + stuffToSay).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
