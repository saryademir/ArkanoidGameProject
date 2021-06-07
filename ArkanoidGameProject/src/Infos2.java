import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Infos2 {
	
	ArrayList <Infos2> list = new ArrayList <Infos2>();
	public String name;
	public String date;
	public String time;
	public int score;
	
	public Infos2()
	{
		
	}
	
	public Infos2(String n, String d ,String t, int s)
	{
	
		this.name=n;
		this.date=d;
		this.time=t;
		this.score=s;
	}

	
}
