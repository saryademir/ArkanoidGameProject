import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Map { //level 1 map

	public int brickMap[][];
	public int brickWidth;
	public int brickHeight;
	
	public Map(int row, int col)
	{
		brickMap = new int[row][col];
		for(int i=0; i<brickMap.length; i++)
		{
			for(int j=0;j<brickMap[0].length;j++) 
			{
				brickMap[i][j]=1;
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
					graph.setColor(Color.white);
					graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					graph.setColor(Color.black);
					graph.setStroke(new BasicStroke(10));//for brick borders
					
					graph.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					
				}
			}
		}
	}
	
	public void setBrick(int value,int row, int col)
	{
		brickMap[row][col]=value;
	}
}
