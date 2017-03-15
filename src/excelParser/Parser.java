package excelParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser{
	public static void main (String[] args){
		Parser obj = new Parser();
		obj.read();
	}
	
	public void read(){
		String csvFile = "WorkerAvailabilityCSV.csv";
		
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
				}else if(avail[0].equals("Drivers") ){
					isInShop = false;
				}else if(!avail[0].equals("") && !avail[0].equals("Availability")){
					
					availObj.setMonday(avail[1]);
					availObj.setTuesday(avail[2]);
					availObj.setWednesday(avail[3]);
					availObj.setThursday(avail[4]);
					availObj.setFriday(avail[5]);
					availObj.setSaturday(avail[6]);
					availObj.setSunday(avail[7]);
					if(isInShop == true){
						inshop = new Worker(avail[0], true, false, availObj);
					}
					else if(isInShop == false){
						inshop = new Worker(avail[0], false, true, availObj);
					}
					
				}
				
				
				
			}
		}
			
			catch (FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			catch (IOException e){
				System.out.println(e.getMessage());
			}
			catch (Exception e){
				System.out.println(e.getMessage());
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
