package excelParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Vector;

public class Parser extends Worker {
	public static void main (String[] args){
		Parser obj = new Parser();
		obj.read();
	}
	
	public void read(){
		String csvFile = "/Users/Karven/Documents/WorkerAvailabilityCSV.csv";
		
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			boolean isInShop = false;
			
			while((line = br.readLine()) != null){
				String avail[] = line.split(csvSplitBy, -1);
				Availability availObj = new Availability();
				Worker inshop = null;
				if(avail[0].equals("In Shops")){
					isInShop = true;
					availObj.setMonday(avail[1]);
					availObj.setTuesday(avail[2]);
					availObj.setWednesday(avail[3]);
					availObj.setThursday(avail[4]);
					availObj.setFriday(avail[5]);
					availObj.setSaturday(avail[6]);
					availObj.setSunday(avail[7]);
				}
				if(avail[0].equals("Drivers")){
					isInShop = false;
					availObj.setMonday(avail[1]);
					availObj.setTuesday(avail[2]);
					availObj.setWednesday(avail[3]);
					availObj.setThursday(avail[4]);
					availObj.setFriday(avail[5]);
					availObj.setSaturday(avail[6]);
					availObj.setSunday(avail[7]);
				}
				
				if(isInShop = true){
					inshop = new Worker(avail[0], true, false, availObj);
				}
				if(isInShop = false){
					inshop = new Worker(avail[0], false, true, availObj);
				}
				
			}
		}
			
			catch (FileNotFoundException e){
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
			catch (Exception e){
				e.getMessage();
			}
			finally {
				if (br != null){
					try{
						br.close();
					}
					catch (IOException e){
						e.printStackTrace();
					}
					
					}
			}
				
		
	}
}
