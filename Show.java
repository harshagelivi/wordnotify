import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Show{
	public static void main(String[] args){
		try{
			File wordFile = new File("words.txt");
			FileReader fileReader = new FileReader(wordFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			List<String> wordList = new ArrayList<String>();

			String[] cmdarray= new String[4];			

			Runtime runtime = Runtime.getRuntime();
			Process proc = null;
			Random random = new Random();
			String line=null;
			while((line=bufferedReader.readLine()) != null){
				wordList.add(line);
			}	
			bufferedReader.close();
			int wordListSize = wordList.size();
			int i=0;
			while(true){
				i = (random.nextInt())%wordListSize;
				if(i<0){ 
					i = i * (-1);
				}
				String[] splits = wordList.get(i).split("=");
	
				cmdarray[0] = "notify-send";
						
				//cmdarray[1] = "-t";
				//cmdarray[2] = "15000";
				cmdarray[1] = splits[0].trim();
				cmdarray[2] = splits[1].trim();
				cmdarray[3] = "--icon=earth.png";				
						
				proc = runtime.exec(cmdarray);
				try {
				    TimeUnit.MINUTES.sleep(5);
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}

			}
	
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
