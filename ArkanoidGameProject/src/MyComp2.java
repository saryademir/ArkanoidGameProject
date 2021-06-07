import java.util.Collections;
import java.util.Comparator;

public class MyComp2 {
	public class Sort implements Comparator<Infos2>
	{
		public int compare(Infos2 a, Infos2 b)
		{
			if(a.score==b.score)
			{
				return 0;
			}
			
			else if( a.score>b.score)
			{
				return -1;
			}
			
			else
			{
				return 1;
			}
			
	}

}}
