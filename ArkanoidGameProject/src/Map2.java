import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Map2 extends Map{ //level 2 map

	public int brickMapLife[][]; //for colorful bricks hit count

	public Map2(int row, int col)
	{
		super(row,col);
		
		brickMapLife = new int[row][col];
		for(int i=0; i<brickMap.length; i++)
		{
			for(int j=0;j<brickMap[0].length;j++) 
			{
				if(i==0)
				{
					brickMapLife[i][j]=2;
				}
				else if(i==1)
				{
					brickMapLife[i][j]=1;
				}
				else if(i==2)
				{
					brickMapLife[i][j]=2;
				}
				
			}
		}
	
		brickWidth=540/col;
		brickHeight=120/row;
	}
	
	public void draw(Graphics2D graph)
	{
		for(int i=0; i<brickMap.length; i++)
		{
			for(int j=0;j<brickMap[0].length;j++) 
			{
				if(brickMap[i][j]>0)
				{
					if(i==0)
					{
						graph.setColor(Color.red);
						graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					
					}
					else if(i==2)
					{
						graph.setColor(Color.red);
						graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					
					}
					else
					{
						graph.setColor(Color.white);
						graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					}

					
					graph.setStroke(new BasicStroke(10));
					graph.setColor(Color.black);
					graph.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					
				}
			}
		}
	}
	
	public void setBrick(int value,int row, int col)
	{
		brickMap[row][col]=value;
		
	}
	public void setBrickLife(int value,int row, int col)
	{
		brickMapLife[row][col]=value;
		
	}

	
}

