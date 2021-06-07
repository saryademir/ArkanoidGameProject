import java.applet.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line.Info;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Audio {
	

	public Clip clip; 
	
	public Audio(String s)
	{
		try {
			AudioInputStream st= AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s)); 
			AudioFormat baseFormat=st.getFormat(); 
			AudioFormat decodeFormat=new AudioFormat(AudioFormat.Encoding.PCM_UNSIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),baseFormat.getChannels()*2,baseFormat.getSampleRate(),false);
			AudioInputStream ts = AudioSystem.getAudioInputStream(decodeFormat,st);
			clip=AudioSystem.getClip();
			clip.open(ts);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	public void play()
	{
		if(clip==null)
		{
			return;
		}
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop()
	{
		if(clip.isRunning()) clip.stop();
	}
	
	public void close()
	{
		stop();
		clip.close();
		
	}

}
