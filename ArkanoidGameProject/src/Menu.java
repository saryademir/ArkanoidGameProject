import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JOptionPane;


public class Menu {

	public Rectangle playButton = new Rectangle(280,100,100,50);
	public Rectangle optionsButton = new Rectangle(280,170,100,50);
	public Rectangle scoresButton = new Rectangle(280,240,100,50);
	public Rectangle helpButton = new Rectangle(280,310,100,50);
	public Rectangle aboutButton = new Rectangle(280,380,100,50);
	public Rectangle quitButton = new Rectangle(280,450,100,50);
	public Rectangle goBackButton = new Rectangle(270,490,125,50);
	public Rectangle Level1Button = new Rectangle(280,240,100,50);
	public Rectangle Level2Button = new Rectangle(280,300,100,50);
	public Rectangle Level3Button = new Rectangle(280,360,100,50);
	public void draw(Graphics2D graph)
	{

		if(GamePlay.state==GamePlay.State.MENU)
		{
			//game name
			Font font= new Font("Courier New",Font.BOLD,30);
			graph.setFont(font);
			graph.setColor(Color.red);
			graph.drawString("ARKANOID GAME",220,60); 
			
			//BUTTONS
			graph.setColor(Color.white);
			graph.fillRect(280, 310,100, 50);//help
			graph.fillRect(280,100,100,50);//play
			graph.fillRect(280,170,100,50);//option
			graph.fillRect(280,240,100,50);//scores
			graph.fillRect(280,380,100,50);//about
			graph.fillRect(280,450,100,50);//quit
			
			
			Font font1=new Font("calibri",Font.BOLD,20);
			graph.setFont(font1);
			graph.setColor(Color.black);
			graph.drawString("Play",playButton.x+25,playButton.y+32);
			graph.drawString("Options",optionsButton.x+15,optionsButton.y+32);
			graph.drawString("Scores",scoresButton.x+15,scoresButton.y+32);
			graph.drawString("About",aboutButton.x+15,aboutButton.y+32);
			graph.drawString("Help",helpButton.x+25,helpButton.y+32);
			graph.drawString("Quit",quitButton.x+25,quitButton.y+32);
			
			graph.draw(playButton);
			graph.draw(optionsButton);
			graph.draw(helpButton);
			graph.draw(quitButton);
			graph.draw(aboutButton);
			graph.draw(scoresButton);
			
		}
		
		
		else if(GamePlay.state==GamePlay.State.HELP ) //if the user presses help button
		{
			graph.setColor(Color.white);
			graph.fillRect(270,490,125,50);//go back
			graph.setColor(Color.black);
			Font font2=new Font("calibri",Font.BOLD,20);
			graph.setFont(font2);
			graph.drawString("Go Back",goBackButton.x+25,goBackButton.y+32);
			graph.draw(goBackButton);
			
			String info="WELCOME TO THE MOST FUN (BUT AS EQUALLY BASIC) GAME IN THE WORLD!";
			String info2="Playing this game is actually very simple.";
			String info3="1)We have three levels. And each level has different difficulties.";
			String info4="2)You have to break every brick in three levels in order to win the game.";
			String info5="3)You also have three lives, if you drop the ball you lose one life :(";
			String info6="4)In level 1, we have 27 white bricks";
			String info7="5)In level 2, we have 18 white bricks and 9 red bricks";
			String info8="6)In level 3, we have 9 white, 9 red 9 blue bricks.";
			String info9="7)White bricks break when the ball hits them once.";
			String info10="8)Red bricks break when the ball hits them twice.";
			String info11="9)Blue bricks break when the ball hits them three times.";
			String info13="10)You can pause the game by pressing SPACE button while playing";
			String info14="And return playing by pressing N button";
			String info15="11)You can return to menu at any time by pressing M button";
			String info12="THESE ARE ALL THE RULES. NOW GO PLAY THE GAME AND ENJOY IT :)";
		
			graph.setColor(Color.white);
			graph.drawString(""+info, 15, 30);
			graph.drawString(""+info2,150, 60);
			graph.drawString(""+info3,110, 90);
			graph.drawString(""+info4,70, 120);
			graph.drawString(""+info5,110, 150);
			graph.drawString(""+info6,150, 180);
			graph.drawString(""+info7,150, 210);
			graph.drawString(""+info8,150, 240);
			graph.drawString(""+info9,150,270);
			graph.drawString(""+info10,150,300);
			graph.drawString(""+info11,150,330);
			graph.drawString(""+info13,70,360);
			graph.drawString(""+info14,150,390);
			graph.drawString(""+info15,150,420);
			graph.drawString(""+info12,70,450);
			
		}
		
		else if(GamePlay.state==GamePlay.State.OPTIONS) 
		{
			graph.setColor(Color.LIGHT_GRAY);
			graph.fillRect(280,240,100,50);//level 1
			graph.fillRect(280,300,100,50);//level 2
			graph.fillRect(280,360,100,50);//level 3
			Font font2=new Font("arial",Font.BOLD,20);
			graph.setFont(font2);
			graph.setColor(Color.white);
			graph.drawString("PLEASE CHOOSE THE LEVEL YOU WANT TO START THE GAME!",40,60);
			graph.drawString("Level1",Level1Button.x+20,Level1Button.y+32);
			graph.drawString("Level2",Level2Button.x+20,Level2Button.y+32);
			graph.drawString("Level3",Level3Button.x+20,Level3Button.y+32);
			graph.draw(Level1Button);
			graph.draw(Level2Button);
			graph.draw(Level3Button);
			graph.setColor(Color.red);
			graph.drawString("Go Back",goBackButton.x+20,goBackButton.y+32);	
			graph.draw(goBackButton);
		}
		else if(GamePlay.state==GamePlay.State.PAUSE) 
		{
			Font font2=new Font("arial",Font.BOLD,20);
			graph.setFont(font2);
			graph.setColor(Color.white);
			graph.drawString("YOU PAUSED THE GAME",40,60);
			graph.drawString("PRESS N TO CONTINUE THE GAME", 40, 90);
		}
		
		else if(GamePlay.state==GamePlay.State.ABOUT)
		{
			
			Font font1=new Font("calibri",Font.BOLD,30);
			graph.setFont(font1);
			graph.setColor(Color.white);
			
		
			String info="About window";
			String info2="You can write infos about the developer";
			graph.drawString("ABOUT THE DEVELOPER",190,60);
			graph.drawString(""+info,250, 180);
			graph.drawString(""+info2,140, 220);
			
			graph.setColor(Color.red);
			graph.drawString("Go Back",goBackButton.x+15,goBackButton.y+32);	
			graph.draw(goBackButton);
		}
		
		else if(GamePlay.state== GamePlay.State.SCORES)
		{
			graph.setColor(Color.red);
			graph.fillRect(270,490,125,50);//go back
			graph.setColor(Color.white);
			Font font2=new Font("calibri",Font.BOLD,20);
			graph.setFont(font2);
			graph.drawString("Go Back",goBackButton.x+25,goBackButton.y+32);
			graph.draw(goBackButton);
			
			
		}

	}
	
}
