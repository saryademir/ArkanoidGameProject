import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class MouseAdapt extends MouseAdapter{
	
	int panelX=310;
	Rectangle rect=new Rectangle(panelX, 550,100,8);
	boolean press;
	int preX;
	int preY;
    Point prePoint;
    MouseAdapt()
    {
    	
    }
    public void paint(Graphics g)
	  {
	    		g.setColor(Color.green);
	    		g.fillRect(panelX, 550,100,8);
	  }
	@Override
	public void mousePressed(MouseEvent e) {
		 	
			prePoint = e.getPoint();
	 }

  
     public void mouseDragged(MouseEvent e) {
        
    	/* Point currentPt=e.getPoint();
    	 rect.translate((int)(currentPt.getX()-prePoint.getX()),(int)(currentPt.getY()-prePoint.getY()));
    	 prePoint=currentPt;*/
    	 
     }
	@Override
     public void mouseReleased(MouseEvent e) {
         
     }

     public void updateLocation(MouseEvent e) {
        
       

     }
}
 


