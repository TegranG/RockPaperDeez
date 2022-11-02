import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;


public class rockpaperdeezj {
	//global integers

	public static int choice;
	public static int Aichoice;
	
	public static void main(String[] args) {
		
		//line seperator for console
		
		String newLine = System.getProperty("line.separator");
		
		//AI Enemy code

		int AIr = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		System.out.print(AIr);
		
		if (AIr == 1) {
			rockpaperdeezj.Aichoice = 1;
			System.out.print(newLine + "AI chose rock");
			
		}else if (AIr ==2) {
			rockpaperdeezj.Aichoice = 2;
			System.out.print(newLine + "AI chose paper");
			
		} else {
			rockpaperdeezj.Aichoice = 3;
			System.out.print(newLine + "AI chose deez!");
		}
		
		
		//define objects
		
		JFrame frame = new JFrame();
		JButton rock = new JButton("rock"); 
		JButton paper = new JButton("paper");
		JButton deez = new JButton("deez");
		JButton gamestart = new JButton("Confirm Choice");
		JTextField abox = new JTextField("deez");
		
		//add stuff to the frame
		
		frame.add(abox);
		frame.add(rock);
		frame.add(paper);
		frame.add(deez);
		frame.add(gamestart);
		
		//get frame info
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int screenx = (int)size.getWidth();
		int screeny = (int)size.getHeight();
		
		
		//frame assembly 

		//simple geometry. We want the center of the gui so we first need the width and height of the montior in pixels. Once we do that we divide the width and 
		//height by 2 to get the center point. However we need to take into account that our button or text isnt one pixel, it usually 80 pixels. So we need to
		//divide that by 2 to get its center then offplace it by that value. The finally equation is below
		//centerbuttonxposition = screenx / 2 - (width of button / 2)
		//centerbuttonyposition = screeny / 2 - (height of button / 2)
		
		rock.setBounds(screenx/2 - 40,screeny/2 + 100,80,50); 
		paper.setBounds(screenx / 2 - 40, screeny / 2 + 150, 80, 50);
		deez.setBounds(screenx / 2 - 40, screeny / 2 + 50,80, 50);
		gamestart.setBounds(screenx / 2 -  60, screeny / 2 + 200, 120, 50);
		abox.setBounds(screenx / 2 - 100, screeny / 2 - 20, 200, 30);
		
		//frame + text config

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setVisible(true);
		abox.setEditable(false);
		
		//button actionlistener for rock
		
		rock.addActionListener(new ActionListener() {
			@Override //override the main public void
			public void actionPerformed(ActionEvent e) {
				rockpaperdeezj.choice = 1;
				System.out.print(choice);
			}
			
		});
		
		//button actionlistener for paper
		
		paper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
				rockpaperdeezj.choice = 2;
				System.out.print(newLine + choice);
			}
		});
		
		//button actionlistener for DEEZ
		
		deez.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rockpaperdeezj.choice = 3;
				System.out.print(newLine + choice);
			}
			
		});
		
		//Confim player choice + game code
		
		gamestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int pchoice = rockpaperdeezj.choice;
				int aichoice = rockpaperdeezj.Aichoice;
				
				if (pchoice == 1 && aichoice == 2) {
					System.out.print(newLine + "Ai Won!!!");//code for ai win
					abox.setText("AI Wins! Player Loses!");
				} else if (pchoice == 1 && aichoice == 3) {
					System.out.print(newLine + "AI win");// code for you win
					abox.setText("AI Wins! Player Loses!");
				} else if (pchoice == 2 && aichoice == 3) {
					System.out.print(newLine + "gg ai won"); //end of ai win
					abox.setText("AI Wins! Player Loses!");
				} else if (aichoice == 1 && pchoice == 2) {
					System.out.print(newLine + "You won!");
					abox.setText("Player wins! AI Loses!");
				} else if (aichoice == 1 && pchoice == 3) {
					System.out.print(newLine + "You won!!!!!");
					abox.setText("Player wins! AI Loses!");
				} else if (aichoice == 2 && pchoice == 3) {
					System.out.print(newLine + "deez won");
					abox.setText("Player wins! AI Loses!");
				} else if (aichoice == pchoice) {
					System.out.print(newLine + "deex?!?");
					abox.setText("Tie!");
				}
			} 
		});
	}

}
