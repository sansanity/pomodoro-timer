package main;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main {

	JFrame window;
	JLabel counterLabel;
	JLabel workLabel;
	Font font1 = new Font("Times New Roman", Font.PLAIN, 60);
	Timer timer;
	Timer break_timer;
	int second, minute;
	DecimalFormat dFormat = new DecimalFormat("00");
	String ddSecond, ddMinute;
	JButton button;
	int timer_counter;

	
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
			
			workLabel = new JLabel("Do work now");
			workLabel.setBounds(300, 150, 200, 100);
			workLabel.setHorizontalAlignment(JLabel.CENTER);
			
			
			
			// Creating the button
			button = new JButton("Start/Stop your 25m Timer");
			button.setBounds(250, 325, 300, 150);
			timer_counter = 0;
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Implementing the start and stop timer function
					timer_counter++;
					
					if (timer_counter % 2 != 0) {
						timer.start();
				} 
				
					else {
						timer.stop();
					}
					
				}});
			
			
			window.add(counterLabel);
			window.add(workLabel);
			window.setVisible(true);
			window.add(button);
			
			// Initializing Countdown Timer for the 25 minute timer
			counterLabel.setText("0:01");
			second = 1;
			minute = 0;
			countDown();
			
		}
		
		// Creating the countdown timer
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
						System.out.println("hello");
						
						// Redefine the timer? The timer object does not manage to move onto the nested if statements
						minute = 0;
						second = 3;
//						minute --;
						ddSecond = dFormat.format(second);
						ddMinute = dFormat.format(minute);
						counterLabel.setText(ddMinute + ":" + ddSecond); // Sets the label text;
						workLabel.setText("Rest now");
						if(second == -1) {
							System.out.println("world");
							second = 59;
							minute --;
							ddSecond = dFormat.format(second);
							ddMinute = dFormat.format(minute);
							counterLabel.setText(ddMinute + ":" + ddSecond); // Sets the label text
//							timer.restart();
						}
						else if (minute == 0 && second == 0) {
							timer.stop();
						}
						
						};
							
				}
			});
			
		}
		
		
		// To do list: Make the on screen message change depending on whether it's work or break time
		// Include a reset button
	
		 
		// Set a 25 minute timer
		// After the 25 minute timer, automatically starts a 5 minute break timer. Plays a sound afterwards
		// Add in a pause function
		// After 4 rounds of 25 minute timers, automatically starts a 20 minute break timer

	
		
		
		
}
