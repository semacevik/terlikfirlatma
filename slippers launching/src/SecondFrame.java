import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class SecondFrame extends JFrame {
	static int count;
	int counter;
    JLabel score;
	Image img;
	final HighScoreManager h ;
	Lives v,v1,v2;
	boolean s=true;
	final JButton [] buton;
	final JButton c1;
	final JButton c2;
	final JButton c3;
	final JButton c4;
	Timer time;
	Clip clip1 ;
	
	
	
	public SecondFrame(int sec,final int k){
	    
		count=0;
	//secondframe özellikleri
		setTitle("Slippers Launching");
        setSize(600,470);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	    
		//secondframe panel eklenmesi
		final JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				 img = new ImageIcon("Adsýz1.png").getImage();
				g.drawImage(img, 0, 0, null);
			}
		};
		
		//oyunun arkaplan müziði
		if(s){
			try{
  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("komik.wav").getAbsoluteFile());
  			    clip1 = AudioSystem.getClip();
  				clip1.open(audioInputStream);
  				clip1.loop(100);
  			}catch(Exception ex){
  				System.out.println("Error with playing sound");
  				ex.printStackTrace();
  			}
		}
		
		//highscore objesi oluþturuldu
		h=new HighScoreManager();
		
		//score labeli panele eklendi
         score = new JLabel("");
         score.setFont(new Font("ComicSans",Font.BOLD,32));
         score.setBounds(520, 120, 90, 50);
         score.setForeground(Color.CYAN);
         score.setVisible(true);
         panel.add(score);

       
        
        
		
	   
		//canlar oluþturuldu ve panele eklendi
		panel.setLayout(null);
		v=new Lives();
		v.setBounds(470, 5, 27, 60);
		v1=new Lives();
		v1.setBounds(510, 5, 27, 60);
		v2=new Lives();
		v2.setBounds(550, 5, 27, 60);
		
		
		panel.add(v);
		panel.add(v1);
		panel.add(v2);
		
		repaint();
		
		//çocuk butonlarý için image oluþturuldu ve butonlar panele eklendi
		final ImageIcon a = new ImageIcon("çocuk9.jpg");
		final ImageIcon b = new ImageIcon("çocuk10.png");
		final ImageIcon c = new ImageIcon("çocuk11.png");
		final ImageIcon d = new ImageIcon("çocuk12.png");
		c1 = new JButton(a);
		c2 = new JButton(b);
	    c3 = new JButton(c);
		c4 = new JButton(d);
		c1.setBounds(304, 0, 82, 88);
		c2.setBounds(415, 144, 74, 80);
		c3.setBounds(48, 0, 81, 65);
		c4.setBounds(185, 96, 73, 93);
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		c4.setVisible(false);
		c1.setBorderPainted(false);
		c2.setBorderPainted(false);
		c3.setBorderPainted(false);
		c4.setBorderPainted(false);
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		
		add(panel);
		
	    time = new Timer(sec,new TimerListener());
		time.start();
		
		//menubar oluþtu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		
		JMenu newgame = new JMenu("New Game");
		menuBar.add(newgame);
		
		
		
			
		
		JMenuItem menu1 = new JMenuItem("New Game");
		newgame.add(menu1);			
		JMenuItem menu2 = new JMenuItem("Exit");
		newgame.add(menu2);
		
        //newgame butonuna action verildi
		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("newgame bastýnýz");
				//butona basýlýnca yeni frame'e easy ve hard butonlarý eklendi
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
				
				//easy butonuna action verildi
				easy.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e ){
						
						frm2.setVisible(false);
						setVisible(false);
					    SecondFrame f2 = new SecondFrame(1500,5);
					    f2.setVisible(true);
					}
				});
				
				//hard butonuna action verildi
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
		//menubardaki exit butonuna action verildi
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("exit bastýnýz");
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		
		//4. çocuk butonuna action verildi 
		c4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi deðiþiyor
				ImageIcon g = new ImageIcon("c3.png");
				c4.setIcon(g);
				c4.setLocation(185, 100);
				
				//score artýrýlýyor
				count++;
				System.out.println(count);
				counter=1;
				score.setText(String.valueOf(k*count));
				
				//butona müzik eklendi
				if(s){
				try{
	  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("doink.wav").getAbsoluteFile());
	  				Clip clip = AudioSystem.getClip();
	  				clip.open(audioInputStream);
	  				clip.start();
	  			}catch(Exception ex){
	  				System.out.println("Error with playing sound");
	  				ex.printStackTrace();
	  			}
			}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi eski haline geliyor
				ImageIcon g = new ImageIcon("çocuk12.png");
				c4.setIcon(g);
				c4.setLocation(185, 96);
				counter=0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
		
		//3. çocuk butonuna action verildi
		c3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//çocuk butonunun resmi deðiþiyor
				ImageIcon g = new ImageIcon("c1.png");
				c3.setIcon(g);
				
				c3.setLocation(55,0);
				
				//butona basýlýnca score artýyor
				count++;
				System.out.println(count);
				score.setText(String.valueOf(k*count));
				
				//butona ses ekleme
				if(s){
				try{
	  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("doink.wav").getAbsoluteFile());
	  				Clip clip = AudioSystem.getClip();
	  				clip.open(audioInputStream);
	  				clip.start();
	  			}catch(Exception ex){
	  				System.out.println("Error with playing sound");
	  				ex.printStackTrace();
	  			}
			}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi eski haline geliyor
				ImageIcon g = new ImageIcon("çocuk11.png");
				c3.setIcon(g);
				
				c3.setLocation(48,0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//2. çocuk butonuna action verildi
		c2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi deðiþiyor
				ImageIcon g = new ImageIcon("c4.png");
				c2.setIcon(g);
			    c2.setLocation(421, 140);
			    
			    //score artýyor
			    count++;
				System.out.println(count);
				score.setText(String.valueOf(k*count));
				
				//butona ses ekleme
				if(s){
				try{
	  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("doink.wav").getAbsoluteFile());
	  				Clip clip = AudioSystem.getClip();
	  				clip.open(audioInputStream);
	  				clip.start();
	  			}catch(Exception ex){
	  				System.out.println("Error with playing sound");
	  				ex.printStackTrace();
	  			}
			}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi eski haline dönüyor
				ImageIcon g = new ImageIcon("çocuk10.png");
				c2.setIcon(g); 
				c2.setLocation(415, 144);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//1. çocuk butonuna action verildi
		c1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi deðiþiyor
				ImageIcon g = new ImageIcon("c2.png");
				c1.setIcon(g);
				c1.setLocation(315, 0);
				
				//score artýyor
				count++;
				System.out.println(count);
				score.setText(String.valueOf(k*count));
				
				//butona ses ekleme
				if(s){
				try{
	  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("doink.wav").getAbsoluteFile());
	  				Clip clip = AudioSystem.getClip();
	  				clip.open(audioInputStream);
	  				clip.start();
	  			}catch(Exception ex){
	  				System.out.println("Error with playing sound");
	  				ex.printStackTrace();
	  			}
			}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//butonun resmi eski haline geliyor
				ImageIcon g = new ImageIcon("çocuk9.jpg");
				c1.setIcon(g);
				c1.setLocation(304,0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//panele action ekleme
		panel.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			
			//panele basýldýðýnda canlarýn biri yok oluyor
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("sssss");
				if(v.isVisible()==true){
					v.setVisible(false);
				}
				else if(v1.isVisible()==true){
					v1.setVisible(false);
				}
				else if(v2.isVisible()==true){
					v2.setVisible(false);
				}
				
				//panele ses ekleme
				if(s){
					try{
		  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("kahkaha.wav").getAbsoluteFile());
		  				Clip clip = AudioSystem.getClip();
		  				clip.open(audioInputStream);
		  				clip.start();
		  			}catch(Exception ex){
		  				System.out.println("Error with playing sound");
		  				ex.printStackTrace();
		  			}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//canlar bittiðinde oyunun bitmesi
		  		if(v.isVisible()==false && v1.isVisible()==false && v2.isVisible()==false ){
		  			time.stop();
		  			clip1.stop();
		  			
		  			//oyun bittiðinde ses çalýyor
		  			try{
		  				javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("fail2.wav").getAbsoluteFile());
		  				Clip clip = AudioSystem.getClip();
		  				clip.open(audioInputStream);
		  				clip.start();
		  			}catch(Exception ex){
		  				System.out.println("Error with playing sound");
		  				ex.printStackTrace();
		  			}
		  			
		  			//oyun bitince isim girilmesi için frame açýlýyor
		  			final JFrame frm = new JFrame();
					frm.setTitle("Player");
					JPanel panel2 = new JPanel();
					JButton ok = new JButton("OK");
					ok.setBackground(Color.PINK);
					final JTextField name = new JTextField(10);
					JLabel label = new JLabel("Enter your name: "); 
					frm.setSize(270,100);
					frm.setLocationRelativeTo(null);
					frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					panel2.add(label);
					panel2.add(name);
					panel2.add(ok);
					panel2.setBackground(Color.LIGHT_GRAY);
					frm.add(panel2);
					frm.setVisible(true);
					frm.setResizable(false);
					
					//ok butonuna basýlýnca highscore dodyaya yazýlýyor
					ok.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent a){
							
							h.addScore(name.getText(), count*k); 
							frm.setVisible(false);
							
						
                    //newgame ve exit butonu açýlýyor
		  			final JFrame frm2 = new JFrame();
		  			final JPanel panel3 = new JPanel();
		  			JButton ng = new JButton("NEW GAME");
		  			ng.setBackground(Color.PINK);
		  			JButton ext = new JButton("EXIT");
		  			ext.setBackground(Color.PINK);
		  		
		  			JLabel label1 = new JLabel("THE GAME IS OVER");
		  			frm2.setSize(270,150);
		  			frm2.setLocationRelativeTo(null);
		  			frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  			panel3.setBackground(Color.LIGHT_GRAY);
		  			panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		  			panel3.add(label1);
		  			panel3.add(ng);
		  			panel3.add(ext);

		  			frm2.add(panel3);

		  			
		  			frm2.setVisible(true);
		  			frm2.setResizable(false);
		  			
		  			ng.addActionListener(new ActionListener(){
		  				public void actionPerformed(ActionEvent e){
		  					System.out.println("newgame bastýnýz");
		  					
		  					frm2.setVisible(false);
		  					final JFrame frm3 = new JFrame();
							frm3.setSize(270, 100);
							frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frm3.setLocationRelativeTo(null);
							JButton easy = new JButton("EASY");
							easy.setBackground(Color.PINK);
							JButton hard = new JButton("HARD");
							hard.setBackground(Color.PINK);
							JPanel panel3=new JPanel();
							panel3.setLayout(new GridLayout(2,1));
							panel3.add(easy);
							panel3.add(hard);
							frm3.add(panel3);
							frm3.setVisible(true);
							frm3.setResizable(false);
							easy.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e ){
									
									frm3.setVisible(false);
									setVisible(false);
								    SecondFrame f2 = new SecondFrame(1500,5);
								    f2.setVisible(true);
								}
							});
							hard.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e ){
									
									frm3.setVisible(false);
									setVisible(false);
								    SecondFrame f2 = new SecondFrame(500,10);
								    f2.setVisible(true);	
								}
							});
						
		  				    
		  					
		  				}
		  			});
		  			
		  			ext.addActionListener(new ActionListener(){
		  				public void actionPerformed(ActionEvent e){
		  					System.out.println("exit bastýnýz");
		  					frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  					frm2.setVisible(false);
		  					setVisible(false);
		  				}
		  			});
		  				
						}});
		  		}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
	    buton = new JButton[4];
	    buton[0]=c1;
	    buton[1]=c2;
	    buton[2]=c3;
	    buton[3]=c4;
	    
	  
	  		repaint();
	  		
	}
	
	//butonlar rasgele görünür oluyor
	public class TimerListener implements ActionListener{
		int k,l;
		@Override
		  public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Random rnd1 = new Random();
			k=rnd1.nextInt(4);
			buton[l].setVisible(false);	
			buton[k].setVisible(true);
			Random rnd2 = new Random();
			l=rnd2.nextInt(4);
			
			buton[k].setVisible(false);
			buton[l].setVisible(true);
			
		
		}
}}
