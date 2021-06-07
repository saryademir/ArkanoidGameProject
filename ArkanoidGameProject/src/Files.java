
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
	
	static String path;

	public Files() {

		try {
			path = new java.io.File(".").getCanonicalPath(); 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeScore2(String name, String date,String time, int score) {

		FileWriter write_f;						
		try {
			write_f = new FileWriter("scores.txt", true);
			write_f.write(String.format("%s %s %s %d \n", name, date,time,score));
			write_f.write("\r\n");
			write_f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String readScore() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("scores.txt"));
		try {
			StringBuilder sb = new StringBuilder();	
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}

	}
}
