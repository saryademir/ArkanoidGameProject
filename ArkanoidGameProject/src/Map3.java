
	import java.awt.BasicStroke;
	import java.awt.Color;
	import java.awt.Graphics2D;

	public class Map3 extends Map {//for level 3
		
		public int brickMapLife[][];//for colorful bricks hit count
		
		public Map3(int row, int col)
		{
			super(row,col);
			
			brickMapLife = new int[row][col];
			for(int i=0; i<brickMap.length; i++)
			{
				for(int j=0;j<brickMap[0].length;j++)
				{
					
					if(i==0)
					{
						brickMapLife[i][j]=3; //top row bricks should be broken when the ball hits them 3 times
					}
					else if(i==1)
					{
						brickMapLife[i][j]=2; //second row bricks should be broken when the ball hits them twice
					}
					else if(i==2)
					{
						brickMapLife[i][j]=1; //third row bricks should be broken when the ball hits them once
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
							graph.setColor(Color.blue);
							graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);	
							
						}
						else if(i==1)
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



