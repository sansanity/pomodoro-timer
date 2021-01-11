package main;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	JFrame window;
	JLabel counterLabel;
	Font font1 = new Font("Times New Roman", Font.PLAIN, 60);
	Timer timer;
	int second, minute;
	
	DecimalFormat dFormat = new DecimalFormat("00");
	
	String ddSecond, ddMinute
	
	public static void main(String[] args) {
		
		new Main();
		
	}
		// Creating a separate window
		public Main() {
			
			window = new JFrame();
			window.setSize(800, 800);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLayout(null);
			
			counterLabel = new JLabel("placeholder text");
			counterLabel.setBounds(300, 230, 200, 100); // The arguments are the for x, y, width and height of the label. You can choose any number you want
			counterLabel.setHorizontalAlignment(JLabel.CENTER); // Moves the text to the centre
			counterLabel.setFont(font1);
			
			window.add(counterLabel);
			window.setVisible(true);
			
			// Initializing Countdown Timer
			counterLabel.setText("3:00");
			second = 0;
			minute = 0;
			countdown();
			timer.start();
			
		}
		
		
		public void countDown() {
			
			timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					second --;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					counterLabel.setText(ddMinute + ":" + ddSecond); // Sets the label text
					
					if (second == -1) {
						second = 59;
						minute --;
						ddSecond = dFormat.format(second);
						ddMinute = dFormat.format(minute);
						counterLabel.setText(ddMinute + ":" + ddSecond); // Sets the label text
					}
					
					if (minute == 0 && second == 0) {
						timer.stop();
					}
				}
			});
		}
		
		
		
		
		// Set a 25 minute timer
		// After the 25 minute timer, automatically starts a 5 minute break timer. Plays a sound afterwards
		// Add in a pause function
		// After 4 rounds of 25 minute timers, automatically starts a 20 minute break timer

	
		
		
		
}
