import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseMotionListener;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

import javax.swing.Timer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePlay extends JPanel implements KeyListener, ActionListener,MouseMotionListener { 

	private boolean play=false; 
	private int score = 0; 
	private int currScore; 
	private int lives=2; 
	private int writinglives=lives+1;
	private int level=1;
	private int totalBricks = 27;
	private Timer timer;
	
	String curr; //for pause and return options
	
	private int delay=10;
	
	int temp=0;
	int puan=0;
	
	private int panelX= 310; // panel's starting position
	private int ballposX= 350; //ball's starting position
	private int ballposY= 350; //ball's ending position
	private int ballXdir = -2; 
	private int ballYdir = -2; 
	private int x=0;
	private int y=0;
	

	ArrayList <String>name2= new ArrayList<String>();
	ArrayList <String>date2= new ArrayList<String>();
	ArrayList <String>time2= new ArrayList<String>();
	ArrayList <Integer>scores2= new ArrayList<Integer>();
	
	String [] array=new String[4];
	
	ArrayList <Infos2>ýnf2= new ArrayList<Infos2>();
	ArrayList <String>t= new ArrayList<String>();
	ArrayList <String>t2= new ArrayList<String>();
	ArrayList <String>t3= new ArrayList<String>();
	
	private Audio sound;
	private Audio sound2;
	private Audio sound3;

	Image image;
	Infos2 ýnf = new Infos2();
	String nm = null;
	int p=0;
	
	int num=0;
	int add=0;
	int date_c=1;
	int time_c=2;
	int score_c=3;
	int name_c=0;
	

	private Map map; 
	private Map2 map2;
	private Map3 map3;
	
	String name;
	String scores;
	String date;
	String time;
	
	private Menu menu; 
	
	
	public GamePlay()
	{
		map=new Map(3,9);
		map2=new Map2(3,9);
		map3=new Map3(3,9);
		
		setFocusable(true);
		addKeyListener(this); 
		addMouseMotionListener(this);
	
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		sound=new Audio("/Sound/beep.wav");
		sound2= new Audio("/Sound/beep2.wav");
		sound3= new Audio("/Sound/lost_sound.wav");
		
		menu=new Menu();
		this.addMouseListener(new Mouse()); 
		timer.start();
		
	}
	
	
	public static enum State 
	{
		MENU, 
		HELP,
		OPTIONS,
		LEVEL1,
		LEVEL2,
		LEVEL3,
		SCORES,
		ABOUT,
		PAUSE,
		GAME
	};
	public static State state=State.MENU; 
	
	public void paint( Graphics graph)
	{
		if(state==state.GAME || state==state.LEVEL1 || state==state.LEVEL2 || state==state.LEVEL3) { 
		//background
		curr=state.GAME.toString();
		graph.setColor(Color.black);
		graph.fillRect(1,1,692,592);
		
		//borders
		graph.setColor(Color.orange);
		graph.fillRect(0,0,5,592);
		graph.fillRect(0,0,692,5);
		graph.fillRect(683,0,5,592);
		
		//scores
		graph.setColor(Color.pink);
		graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
		graph.drawString("Score:"+score,5,30);//score 
		
		
		//lives 
		graph.setColor(Color.pink);
		graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
		graph.drawString("Lives:"+writinglives,590,30);
		
		//level
		graph.setColor(Color.pink);
		graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
		graph.drawString("Level:"+level,325,30); 
		
		//the panel
		graph.setColor(Color.yellow);
		graph.fillRect(panelX, 550,100,8);
		
		//the ball
		graph.setColor(Color.pink);
		graph.fillOval(ballposX, ballposY,13,13); 
		
		
		
		
		if(state==State.LEVEL1 ) //if the user chooses level 1 on the options window
		{
			level=1;
			curr=State.LEVEL1.toString(); 
			
			//background
			curr=State.GAME.toString();
			graph.setColor(Color.black);
			graph.fillRect(1,1,692,592);
			
			//borders
			graph.setColor(Color.orange);
			graph.fillRect(0,0,5,592);
			graph.fillRect(0,0,692,5);
			graph.fillRect(683,0,5,592);
			
			//scores
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Score:"+score,5,30);//score 
			
			
			//lives 
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Lives:"+writinglives,590,30);//score 
			
			//level
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Level:"+level,325,30);//score 
			
			//the panel
			graph.setColor(Color.yellow);
			graph.fillRect(panelX, 550,100,8);
			
			//the ball
			graph.setColor(Color.pink);
			graph.fillOval(ballposX, ballposY,13,13);
			
			menu.draw((Graphics2D)graph);
		}
		else if(state==State.LEVEL2 )
		{
		
			level=2;
			curr=State.LEVEL2.toString();
		
			//background
			curr=State.GAME.toString();
			graph.setColor(Color.black);
			graph.fillRect(1,1,692,592);
			
			//borders
			graph.setColor(Color.orange);
			graph.fillRect(0,0,5,592);
			graph.fillRect(0,0,692,5);
			graph.fillRect(683,0,5,592);
			
			//scores
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Score:"+score,5,30);//score 
			
			
			//lives 
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Lives:"+writinglives,590,30);//score 
			
			//level
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Level:"+level,325,30);//score 
			
			//the panel
			graph.setColor(Color.yellow);
			graph.fillRect(panelX, 550,100,8);
			
			//the ball
			graph.setColor(Color.pink);
			graph.fillOval(ballposX, ballposY,13,13);
			
			//map2.draw((Graphics2D)graph);
			menu.draw((Graphics2D)graph);
			
		}
		else if(state==State.LEVEL3 )
		{
			level=3;

			//background
			curr=State.GAME.toString();
			graph.setColor(Color.black);
			graph.fillRect(1,1,692,592);
			
			//borders
			graph.setColor(Color.orange);
			graph.fillRect(0,0,5,592);
			graph.fillRect(0,0,692,5);
			graph.fillRect(683,0,5,592);
			
			//scores
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Score:"+score,5,30);//score 
			
			
			//lives 
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Lives:"+writinglives,590,30);//score 
			
			//level
			graph.setColor(Color.pink);
			graph.setFont(new Font("TimesRoman",Font.BOLD,25)); 
			graph.drawString("Level:"+level,325,30);//score 
			
			//the panel
			graph.setColor(Color.yellow);
			graph.fillRect(panelX, 550,100,8);
			
			//the ball
			graph.setColor(Color.pink);
			graph.fillOval(ballposX, ballposY,13,13);
			 
			menu.draw((Graphics2D)graph);
		
		}
		
		
		
		if(totalBricks<=0)
		{   
			if(state==State.LEVEL1) 
			{
				 state=State.LEVEL2;
				
				 repaint();
			}
			else if(state==State.LEVEL2)
			{
				 state=State.LEVEL3;
				
				 repaint();
			}
		    if(lives >=0) 
		    {
		    	level++;
		    	if(level==1 ) 
		    	{
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-2;
					ballYdir=-2;
					panelX=310;
					score=currScore;
					totalBricks=27;
					level=1;
					lives=lives;
					map=new Map(3,9);
					repaint();
		    	}
		    	
		    	if(level==2 )
		    	{
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-3;
					ballYdir=-3;
					panelX=310;
					score=currScore;
					level=2;
					totalBricks=27;
					map2=new Map2(3,9);
					repaint();
		    	}
		    	
		    	if(level==3 )
		    	{
		    		
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-4;
					ballYdir=-4;
					level=3;
					panelX=310;
					score=currScore;
					totalBricks=27;
					map3=new Map3(3,9);
					repaint();
		    	}
		    }
		    
		    if(level>3)
		    {
		    	play=false;
				ballXdir=0;
				ballYdir=0;
				level=3;
		    }
		    
		}
		
		if(ballposY>570) 
		{
			if(lives==0) 
			{
				
				play=false;
				ballXdir=0;
				ballYdir=0;
				lives=0;
				writinglives=0;
				graph.setColor(Color.red);
				graph.setFont(new Font("TimesRoman",Font.BOLD,20)); 
				graph.drawString("GAME OVER,Score: "+score,200,400);
				
				
				graph.setFont(new Font("TimesRoman",Font.BOLD,20)); 
				graph.drawString("Press M to go to menu",230,450);
				
			}
			
			else if(lives>0) 
			{
				
				if(level==1) 
		    	{
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-2;
					ballYdir=-2;
					panelX=310;
					level=1;
					lives--;
					writinglives--;
					score=currScore;
		    	}
		    	
				
				if(level==2)
		    	{
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-3;
					ballYdir=-3;
					panelX=310;
					score=currScore;
					lives--;
					writinglives--;
		    	}
		    	
		    	if(level==3) 
		    	{
		    		play=true;
					ballposX=120;
					ballposY=350;
					ballXdir=-4;
					ballYdir=-4;
					panelX=310;
					score=currScore;
					lives--;
					writinglives--;
		    	}
				
			}
			else
			{
				lives--;
				writinglives--;
			}
		}
		if(level==1)
		{
			map.draw((Graphics2D)graph);  //draw level 1
		}
		if(level==2)
		{
			map2.draw((Graphics2D)graph); //draw level 2
		}
		if(level==3)
		{
			map3.draw((Graphics2D)graph);  //draw level 3
		}
		graph.dispose();
		
		
	}
		else if(state==State.MENU) 
		{
		
			graph.setColor(Color.yellow);
			graph.fillRect(1,1,692,592);
	
			menu.draw((Graphics2D)graph);
			graph.dispose();
		}
		
		else if(state==State.OPTIONS) 
		{
			graph.setColor(Color.darkGray);
			graph.fillRect(1,1,692,592);
			
			menu.draw((Graphics2D)graph);
			graph.dispose();
		}
	
		else if(state==State.PAUSE)
		{
			graph.setColor(Color.black);
			graph.fillRect(1,1,692,592);
			
			menu.draw((Graphics2D)graph);
			graph.dispose();
		}
		
		else if(state== State.HELP)
		{
			graph.setColor(Color.magenta);
			graph.fillRect(1,1,692,592);
			menu.draw((Graphics2D)graph);
			graph.dispose();
					
		}
		
		else if(state==State.ABOUT)
		{
			graph.setColor(Color.pink);
			graph.fillRect(1,1,692,592);
			menu.draw((Graphics2D)graph);
			graph.dispose();
		}
		
		else if(state==State.SCORES) 
		{
			
			
			
			graph.setColor(Color.lightGray);
			graph.fillRect(1,1,692,592);
			Font font2=new Font("calibri",Font.BOLD,25);
			graph.setFont(font2);
			graph.setColor(Color.red);
			graph.drawString("SCORE TABLE",250, 40);
			
			Font font1=new Font("calibri",Font.BOLD,18);
			graph.setFont(font1);
			graph.setColor(Color.black);
			Files obj = new Files();
			
				MyComp2 comp2 = new MyComp2();
				Collections.sort(ýnf2,comp2.new Sort());
				
				
				int a,b,c,d,m=0;
				
				try {
					String s=obj.readScore();
					String lines[] = s.split("\\r?\\n"); 
					Collections.addAll(t,lines);
					lines=null;
					for(int x= 0; x<t.size();x++)
					{
						String n=t.get(x);
						String lines2[] = n.split(" "); 
						Collections.addAll(t3,lines2);
						//System.out.println(t3);
						lines2=null;
					}
					t3.removeAll(Arrays.asList("", null, " ", "exit")); 
					
				   while(m<t3.size()/4 && name_c<t3.size() && date_c<t3.size() && score_c<t3.size() )
					{
						name2.add(t3.get(name_c));
						date2.add(t3.get(date_c));
						time2.add(t3.get(time_c));
						p = Integer.parseInt(t3.get(score_c));
						scores2.add(p);
					    name_c=name_c+4;
					    date_c=date_c+4;
					    time_c=time_c+4;
					    score_c=score_c+4;
					  
	               }
					
					
					 a= name2.size();
				     b= scores2.size();
				     c= date2.size();
				     d= time2.size();
					M: while(a>0 && b>0 && c>0 && d>0)
					{
						if(ýnf2.isEmpty())
						{
							for(int x=0; x<name2.size() && x<scores2.size() && x<date2.size() && x<time2.size();x++)
							{
								
								ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
								
								num=x;
							}
							
						
							break M;
						}
						
						else
						{
							ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
						
							num++;
							break M;
						}
					
					}

					name2.clear();
					scores2.clear();
					date2.clear();
					time2.clear();
					t.clear();
					t2.clear();
					t3.clear();
					lines= null;
				
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
		
			for(int i=0;i<ýnf2.size();i++ )
			{	
				
				if(i==0)
				{
					graph.setColor(Color.red);
					graph.drawString("1st ",40, 80);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,40, 100);
					graph.drawString("Date: "+ýnf2.get(i).date,40, 130);
					graph.drawString("Time: "+ýnf2.get(i).time,40, 160);
					graph.drawString("Score: "+ýnf2.get(i).score,40,190);
					
					graph.drawString("---------------------------",40,210);
				}
				else if(i==1)
				{
					graph.setColor(Color.red);
					graph.drawString("2nd ",40, 220);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,40, 240);
					graph.drawString("Date: "+ýnf2.get(i).date,40, 270);
					graph.drawString("Time: "+ýnf2.get(i).time,40, 300);
					graph.drawString("Score: "+ýnf2.get(i).score,40,330);
					
					graph.drawString("---------------------------",40,350);
				}
				else if(i==2)
				{
					graph.setColor(Color.red);
					graph.drawString("3rd ",40, 360);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,40, 380);
					graph.drawString("Date: "+ýnf2.get(i).date,40, 410);
					graph.drawString("Time: "+ýnf2.get(i).time,40, 440);
					graph.drawString("Score: "+ýnf2.get(i).score,40,470);
					
					graph.drawString("---------------------------",40,490);
				}
				
				else if(i==3)
				{
					graph.setColor(Color.red);
					graph.drawString("4th ",210, 80);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,210, 100);
					graph.drawString("Date: "+ýnf2.get(i).date,210, 130);
					graph.drawString("Time: "+ýnf2.get(i).time,210,160);
					graph.drawString("Score: "+ýnf2.get(i).score,210,190);
					
					graph.drawString("---------------------------",210,210);
				}
				else if(i==4)
				{
					graph.setColor(Color.red);
					graph.drawString("5th ",210, 220);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,210, 240);
					graph.drawString("Date: "+ýnf2.get(i).date,210, 270);
					graph.drawString("Time: "+ýnf2.get(i).time,210,300);
					graph.drawString("Score: "+ýnf2.get(i).score,210,330);
					
					graph.drawString("---------------------------",210,350);
				}
				else if(i==5)
				{
					graph.setColor(Color.red);
					graph.drawString("6th ",210, 360);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,210, 380);
					graph.drawString("Date: "+ýnf2.get(i).date,210, 410);
					graph.drawString("Time: "+ýnf2.get(i).time,210,440);
					graph.drawString("Score: "+ýnf2.get(i).score,210,470);
					
					graph.drawString("---------------------------",210,490);
				}
				else if(i==6)
				{
					graph.setColor(Color.red);
					graph.drawString("7th",380, 80);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,380, 100);
					graph.drawString("Date: "+ýnf2.get(i).date,380, 130);
					graph.drawString("Time: "+ýnf2.get(i).time,380, 160);
					graph.drawString("Score: "+ýnf2.get(i).score,380,190);
					
					graph.drawString("---------------------------",380,210);
				}
				else if(i==7)
				{
					graph.setColor(Color.red);
					graph.drawString("8th ",380, 220);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,380, 240);
					graph.drawString("Date: "+ýnf2.get(i).date,380, 270);
					graph.drawString("Time: "+ýnf2.get(i).time,380, 300);
					graph.drawString("Score: "+ýnf2.get(i).score,380,330);
					
					graph.drawString("---------------------------",380,350);
				}
				else if(i==8)
				{
					graph.setColor(Color.red);
					graph.drawString("9th ",380, 360);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,380, 380);
					graph.drawString("Date: "+ýnf2.get(i).date,380, 410);
					graph.drawString("Time: "+ýnf2.get(i).time,380, 440);
					graph.drawString("Score: "+ýnf2.get(i).score,380,470);
					
					graph.drawString("---------------------------",380,490);
				}
				else if(i==9)
				{
					graph.setColor(Color.red);
					graph.drawString("10th",550, 80);
					graph.setColor(Color.black);
					graph.drawString("Name: "+ýnf2.get(i).name,550, 100);
					graph.drawString("Date: "+ýnf2.get(i).date,550, 130);
					graph.drawString("Time: "+ýnf2.get(i).time,550, 160);
					graph.drawString("Score: "+ýnf2.get(i).score,550,190);
					
					graph.drawString("---------------------------",550,210);
				}
			
			}
			menu.draw((Graphics2D)graph);
			//graph.dispose();
			//ýnf2.clear();
		}
	
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
	
		
	   if(state==state.GAME || state==state.LEVEL1 || state==state.LEVEL2 || state==state.LEVEL3)
		{
			name2.clear();
			scores2.clear();
			
			
		if(play==true)
		{
			timer.start();
			
			if(new Rectangle(ballposX, ballposY,13,13).intersects(new Rectangle(panelX, 550,100,8))) //Eðer top panele deðiyorsa
			{
				sound.play();
				ballYdir=-ballYdir; 
			}
			
			if(state==state.LEVEL1|| state==state.GAME) {
			if(level==1)
			{
				timer.start();

			A:for(int i=0; i<map.brickMap.length;i++) 
			{
				for(int j=0; j<map.brickMap[0].length;j++)
				{
					if(map.brickMap[i][j]>0)
					{
						int brickX= j*map.brickWidth+80;
						int brickY= i*map.brickHeight+50; 
						int brickWidth=map.brickWidth;
						int brickHeight=map.brickHeight; 
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight); 
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13); 
					
						
						if(ballRect.intersects(brickRect)) //if ball hits the brþck
						{
							sound2.play();
							map.setBrick(0, i, j); //delete the brick
							totalBricks--;
							score=score+5;
							currScore=score;
							
							if(ballposX+15<=brickRect.x || ballposX+1 >= brickRect.width) 
							{
								ballXdir=-ballXdir;
							}
							
							else
							{
								ballYdir=-ballYdir;
							}
							break A; 
						}
					}
				}
			}
			}}
			
			if(state==state.LEVEL2 || state==state.GAME) {
				timer.start();
				if(level==2)
			{
			
			B:for(int i=0; i<map2.brickMap.length ;i++)
			{

				
				for(int j=0; j<map2.brickMap[0].length;j++)
				{
					if(map2.brickMap[i][j]>0 && map2.brickMapLife[i][j]>1)
					{
						int brickX= j*map2.brickWidth+80;
						int brickY= i*map2.brickHeight+50;
						int brickWidth=map2.brickWidth;
						int brickHeight=map2.brickHeight;
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13);
						
						if(ballRect.intersects(brickRect)) 
						{	
							sound2.play();
							map2.setBrick(1, i, j); 
							map2.setBrickLife(1, i,j); 
							ballYdir=-ballYdir; 
						}
					}
					
					else if(map2.brickMap[i][j]>0 && map2.brickMapLife[i][j]==1) 
					{
						int brickX= j*map2.brickWidth+80;
						int brickY= i*map2.brickHeight+50;
						int brickWidth=map2.brickWidth;
						int brickHeight=map2.brickHeight;
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13);
						
						if(ballRect.intersects(brickRect))
						{	
							sound2.play();
							map2.setBrick(0, i, j); 
							map2.setBrickLife(0, i,j); 
							totalBricks--;
							score=score+5;
							currScore=score;
							
							if(ballposX+15<=brickRect.x || ballposX+1 >= brickRect.width) 
							{
								
								ballXdir=-ballXdir;
							}
							
							else
							{
							
								ballYdir=-ballYdir;
							}
							break B; 
						}
					}
				}
			}
			}}
			
			if(state==State.LEVEL3|| state==State.GAME) {
				timer.start();
				if(level==3)
					
			{
			C:for(int i=0; i<map3.brickMap.length;i++) 
			{
				for(int j=0; j<map3.brickMap[0].length;j++)
				{
					if(map3.brickMap[i][j]>0 && map3.brickMapLife[i][j]==3) 
					{
						int brickX= j*map3.brickWidth+80;
						int brickY= i*map3.brickHeight+50;
						int brickWidth=map3.brickWidth;
						int brickHeight=map3.brickHeight;
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13);
					
						
						if(ballRect.intersects(brickRect)) 
						{	
							sound2.play();
							map3.setBrick(1, i, j); 
							map3.setBrickLife(2, i,j); 
							ballYdir=-ballYdir; 
						}
						
						
					}
					
					else if(map3.brickMap[i][j]>0 && map3.brickMapLife[i][j]==2) 
					{
						int brickX= j*map3.brickWidth+80;
						int brickY= i*map3.brickHeight+50;
						int brickWidth=map3.brickWidth;
						int brickHeight=map3.brickHeight;
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13);
						
						if(ballRect.intersects(brickRect))
						{	sound2.play();
							map3.setBrick(1, i, j); 
							map3.setBrickLife(1, i,j);
							ballYdir=-ballYdir;
						}
						
					}
					
					else if(map3.brickMap[i][j]>0 && map3.brickMapLife[i][j]==1)
					{
						
						int brickX= j*map3.brickWidth+80;
						int brickY= i*map3.brickHeight+50;
						int brickWidth=map3.brickWidth;
						int brickHeight=map3.brickHeight;
						
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect= new Rectangle(ballposX, ballposY, 13,13);
			
						if(ballRect.intersects(brickRect))
						{	
							sound2.play();
							map3.setBrick(0, i, j); 
							map3.setBrickLife(0, i,j); 
							totalBricks--;
							score=score+5;
							currScore=score;
							
							if(ballposX+15<=brickRect.x || ballposX+1 >= brickRect.width) 
							{
								ballXdir=-ballXdir;
							}
							
							else
							{
								ballYdir=-ballYdir;
							}
							break C; 
						}
						
					}
				}
			}
			}}
			
          	
			
			
			ballposX= ballposX+ ballXdir; 
			ballposY= ballposY+ ballYdir;
			
			if(ballposX<3)
			{
				sound.play();
				ballXdir=-ballXdir; 
			}
			
			if(ballposY<3) 
			{
				sound.play();
				ballYdir=-ballYdir;
			}
			
			if(ballposX>670)
			{
				sound.play();
				ballXdir=-ballXdir;
			}
		}
		
		repaint(); 
		
		if(totalBricks<=0)
		{
			if(level>=3) 
			{
				while(y==0) 
				{
					play=false;
					ballXdir=0;
					ballYdir=0;
					totalBricks=27;
					level=3;
					int a=0;
					int b=0;
					int m=0;
					int c,d=0;
					name=JOptionPane.showInputDialog(null,"Enter nickname: ");
					date=JOptionPane.showInputDialog(null,"Enter date: ");
					time = JOptionPane.showInputDialog(null,"Enter time: ");
					scores=JOptionPane.showInputDialog(null,"Enter your score: ");

					Files obj=new Files();
					
					if(name!=null && scores!=null && date!=null && time!=null)
					{
						int puan = Integer.parseInt(scores);
						obj.writeScore2(name,date,time,puan);
					}
					
					
					try {
						String s=obj.readScore();
						String lines[] = s.split("\\r?\\n");
					
						Collections.addAll(t,lines);
						lines=null;
						for(int x= 0; x<t.size();x++)
						{
							String n=t.get(x);
							String lines2[] = n.split(" ");
							Collections.addAll(t2,lines2);
							lines2=null;
						}
					
						for(int x= 0; x<t2.size();x++)
						{
							String n=t2.get(x);
							String lines3[] = n.split(" ");
							Collections.addAll(t3,lines3);
							lines3=null;
						}
						t3.removeAll(Arrays.asList("", null, " ", "exit"));
						
						
					   while(m<t3.size()/4 && name_c<t3.size() && date_c<t3.size() && score_c<t3.size() )
						{
							name2.add(t3.get(name_c));
							date2.add(t3.get(date_c));
							time2.add(t3.get(time_c));
							 p = Integer.parseInt(t3.get(score_c));
							scores2.add(p);
						    name_c=name_c+4;
						    date_c=date_c+4;
						    time_c=time_c+4;
						    score_c=score_c+4;
						    
		               }
						
						 a= name2.size();
					     b= scores2.size();
					     c= date2.size();
					     d= time2.size();
					   
						M: while(a>0 && b>0 && c>0 && d>0)
						{
							if(ýnf2.isEmpty())
							{
								for(int x=0; x<name2.size() && x<scores2.size() && x<date2.size() && x<time2.size();x++)
								{
									
									ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
									//System.out.println(""+ýnf2.get(x).name+" "+ýnf2.get(x).date+" "+ýnf2.get(x).time+" "+ýnf2.get(x).score);
									num=x;
								}
								break M;
							}
							
							else
							{
								ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
								//System.out.println(""+ýnf2.get(x).name+" "+ýnf2.get(x).date+" "+ýnf2.get(x).time+" "+ýnf2.get(x).score);
								break M;
							}
						
						}
						name2.clear();
						scores2.clear();
						date2.clear();
						time2.clear();
						t.clear();
						t2.clear();
						t3.clear();
						lines= null;
					
						
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
                  	
					repaint();
					y=1;
				}
				
			}
			repaint(); //HEREE
		}
		else if(ballposY>570)
		{
			if(lives==0)
			{
				while(x==0)
				{
					{
						play=false;
						ballXdir=0;
						ballYdir=0;
						lives=0;
						writinglives=0;
						sound3.play();
						name=JOptionPane.showInputDialog(null,"Enter nickname: "); 
						date=JOptionPane.showInputDialog(null,"Enter date: ");
						time = JOptionPane.showInputDialog(null,"Enter time: ");
						scores=JOptionPane.showInputDialog(null,"Enter your score: ");
						sound3.stop();
						
						int a=0;
						int b=0;
						int c=0;
						int d=0;
						int m=0;
						
						Files obj=new Files();
				
						if(name!=null && scores!=null && date!=null && time!=null)
						{
							int puan = Integer.parseInt(scores);
							 obj.writeScore2(name,date,time,puan);
						}
						
						 
						
						try {
							String s=obj.readScore();
							String lines[] = s.split("\\r?\\n");
						
							Collections.addAll(t,lines);
							lines=null;
							for(int x= 0; x<t.size();x++)
							{
								String n=t.get(x);
								String lines2[] = n.split(" ");
								Collections.addAll(t2,lines2);
								lines2=null;
							}
						
							for(int x= 0; x<t2.size();x++)
							{
								String n=t2.get(x);
								String lines3[] = n.split(" ");
								Collections.addAll(t3,lines3);
								lines3=null;
							}
							t3.removeAll(Arrays.asList("", null, " ", "exit"));
							
						   while(m<t3.size()/4 && name_c<t3.size() && date_c<t3.size() && score_c<t3.size() ) 
							{
								name2.add(t3.get(name_c));
								date2.add(t3.get(date_c));
								time2.add(t3.get(time_c));
								 p = Integer.parseInt(t3.get(score_c));
								scores2.add(p);
							    name_c=name_c+4;
							    date_c=date_c+4;
							    time_c=time_c+4;
							    score_c=score_c+4;
			               }
							
							 a= name2.size();
						     b= scores2.size();
						     c= date2.size();
						     d= time2.size();
						 
							M: while(a>0 && b>0 && c>0 && d>0)
							{
								if(ýnf2.isEmpty())
								{
									for(int x=0; x<name2.size() && x<scores2.size() && x<date2.size() && x<time2.size();x++)
									{
										
										ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
										//System.out.println(""+ýnf2.get(x).name+" "+ýnf2.get(x).date+" "+ýnf2.get(x).time+" "+ýnf2.get(x).score);
										num=x;
									}
									break M;
								}
								
								else
								{
									ýnf2.add(new Infos2(name2.get(x),date2.get(x),time2.get(x),scores2.get(x)));
									//System.out.println(""+ýnf2.get(x).name+" "+ýnf2.get(x).date+" "+ýnf2.get(x).time+" "+ýnf2.get(x).score);
									num++;
									break M;
								}
							
							}
							name2.clear();
							scores2.clear();
							date2.clear();
							time2.clear();
							t.clear();
							t2.clear();
							t3.clear();
							lines= null;
						
							
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						repaint();
					
						x=1;
				}
			}
			
		}}
		
	    else
		{
			x=0;
			y=0;
		}
		
	} 
		
		
	repaint();
	requestFocusInWindow();
	}
	
	boolean [] arr= new boolean[5000]; //for ctrl+q key combination
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {} 

	@Override
	public void keyPressed(KeyEvent e) {
		
		arr[e.getKeyCode()]=true;
		
		if(arr[KeyEvent.VK_CONTROL] && arr[KeyEvent.VK_Q]) 
		{
			System.out.println("ctrl q");
			System.exit(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_M) 
		{
			
			if(level==1|| state==state.LEVEL1)
				
			{
				play=true;
				ballposX=120;
				ballposY=350;
				ballXdir=-2;
				ballYdir=-2;
				panelX=310;
				score=0;
				lives=2;
				writinglives=lives+1;
				level=1;
				totalBricks=27;
				map=new Map(3,9);
				repaint();
				state=State.MENU;
				
			}
			else if(level==2 || state==state.LEVEL2)
			{
				play=true;
				ballposX=120;
				ballposY=350;
				ballXdir=-2;
				ballYdir=-2;
				panelX=310;
				score=0;
				lives=2;
				writinglives=lives+1;
				level=1;
				totalBricks=27;
				map2=new Map2(3,9);
				repaint();
				state=State.MENU;
			}
			else if(level==3|| state==state.LEVEL3)
			{
				play=true;
				ballposX=120;
				ballposY=350;
				ballXdir=-2;
				ballYdir=-2;
				panelX=310;
				score=0;
				lives=2;
				writinglives=lives+1;
				level=1;
				totalBricks=27;
				map3=new Map3(3,9);
				repaint();
				state=State.MENU;
			}
			
			
			
			
			
		}
		if(e.getKeyCode()==KeyEvent.VK_N) 
		{
			if(curr==GamePlay.State.GAME.toString())
			{
				state=State.GAME; 
			}
			else if(curr==State.LEVEL1.toString())
			{
				state=State.LEVEL1;
			}
			else if(curr==State.LEVEL2.toString())
			{
				state=State.LEVEL2;
			}
			else if(curr==State.LEVEL3.toString())
			{
				state=State.LEVEL3;
			}
			
		}
		if(state==State.GAME || state==State.LEVEL1 || state==State.LEVEL2 || state==State.LEVEL3) {
		// TODO Auto-generated method stub
			
			if(state==State.GAME)
			{
				curr=State.GAME.toString(); 
			}
			if(state==State.LEVEL1)
			{
				curr=State.LEVEL1.toString();
			}
			if(state==State.LEVEL2)
			{
				curr=State.LEVEL2.toString();
			}
			if(state==State.LEVEL3)
			{
				curr=State.LEVEL3.toString();
			}
			
			if(e.getKeyCode()==KeyEvent.VK_SPACE) 
			{
				state=State.PAUSE;
			     
			}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			if(panelX <10) 
			{
				panelX=10;
			}
			else
			{
				play=true;
				panelX=panelX-20; 
			}
			repaint();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		{
			if(panelX >=600) 
			{
				panelX=600;
			}
			else
			{
				play=true;
				panelX=panelX+20; 
			}
			repaint();
		}}}
	

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		play=true;
		if(e.getX()<=600 && e.getX()>5) 
		{
			panelX=e.getX();
		}
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	

	
}