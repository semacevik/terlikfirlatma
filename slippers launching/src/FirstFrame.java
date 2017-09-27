
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstFrame extends JFrame implements ActionListener{
	
	
	final HighScoreManager h ;
   
	public FirstFrame(){
		
		setTitle("Slippers Launching");
		setSize(600,470);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		final JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = new ImageIcon("terlik.jpg").getImage();
				g.drawImage(img, 0, 0, null);
			}
		};
		 h =new HighScoreManager();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,500,65));
		JButton play = new JButton("PLAY");
	    play.setBackground(Color.PINK);
		JButton high = new JButton("HIGHSCORES");
		high.setBackground(Color.PINK);
		JButton how = new JButton("HOW TO PLAY");
		how.setBackground(Color.PINK);
		
		
		
		panel.add(play);
		panel.add(high);
		panel.add(how);
		panel.setVisible(true);
		add(panel);
		setVisible(true);
		setResizable(false);
		
		
		add(panel);
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				
						final JFrame frm2 = new JFrame();
						frm2.setSize(270, 100);
						frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frm2.setLocationRelativeTo(null);
						JButton easy = new JButton("EASY");
						easy.setBackground(Color.PINK);
						JButton hard = new JButton("HARD");
						hard.setBackground(Color.PINK);
						JPanel panel3=new JPanel();
						panel3.setLayout(new GridLayout(2,1));
						panel3.add(easy);
						panel3.add(hard);
						frm2.add(panel3);
						frm2.setVisible(true);
						frm2.setResizable(false);
						
						
						easy.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e ){
								
								frm2.setVisible(false);
								setVisible(false);
							    SecondFrame f2 = new SecondFrame(1500,5);
							    f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
							    f2.setVisible(true);
							}
						});
						hard.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e ){
								
								frm2.setVisible(false);
								setVisible(false);
							    SecondFrame f2 = new SecondFrame(500,10);
							    f2.setVisible(true);	
							}
						});
					
					}
				});
				
				
					    
			
			
		
		high.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, h.getHighscoreString());
			}
		});
		how.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "The game is played with mause."+"\n The aim of the game is to hit most children."+"\n Players have three lives."+"\n If player don't hit the children three times, the game is over.");
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		
		JMenu newgame = new JMenu("New Game");
		menuBar.add(newgame);
		
		
		
			
		
		JMenuItem menu1 = new JMenuItem("New Game");
		newgame.add(menu1);			
		JMenuItem menu2 = new JMenuItem("Exit");
		newgame.add(menu2);
		

		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("newgame bastýnýz");
				
				final JFrame frm2 = new JFrame();
				frm2.setSize(270, 100);
				frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm2.setLocationRelativeTo(null);
				JButton easy = new JButton("EASY");
				easy.setBackground(Color.PINK);
				JButton hard = new JButton("HARD");
				hard.setBackground(Color.PINK);
				JPanel panel3=new JPanel();
				panel3.setLayout(new GridLayout(2,1));
				panel3.add(easy);
				panel3.add(hard);
				frm2.add(panel3);
				frm2.setVisible(true);
				frm2.setResizable(false);
				easy.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e ){
						
						frm2.setVisible(false);
						setVisible(false);
					    SecondFrame f2 = new SecondFrame(1500,5);
					    f2.setVisible(true);
					}
				});
				hard.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e ){
						
						frm2.setVisible(false);
						setVisible(false);
					    SecondFrame f2 = new SecondFrame(500,10);
					    f2.setVisible(true);	
					}
				});
			
				
			}
		});
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("exit bastýnýz");
			    setVisible(false);
			    
			}
		});

	}
	
	 

	    	
			
			
			
			
	    
	public static void main(String args []) throws IOException{
		
	new FirstFrame();
	}









	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	}
