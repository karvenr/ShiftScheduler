package excelParser;

public class Availability {
	private boolean [][] aval; //Monday 0 Tuesday 1 Wednesday 2 Thursday 3 Friday 4 Saturday 5 Sunday 6
	
	public Availability(){
		aval = new boolean[7][24];
	}
	
	private void setTimes(String time, int index) throws Exception{
		String [] times = time.split("-");
		
		//Indexes in aval that the workers is available to work between
		int indexval1, indexval2;
		
		//Time available starting
		if(times[0].contains("am")){
			int valAm = Integer.valueOf(times[0].substring(0, times[0].indexOf("am"))); //Value if its am
			if(times[0].equals("12am")){
				indexval1 = 0;
			}else if(valAm < 12 && valAm > 0){
				indexval1 = valAm;
			}else{ //If the first time is invalid
				throw new Exception("Invalid time 1 " + times[0]);
			}
		}else if(times[0].contains("pm")){
			int valPm = Integer.valueOf(times[0].substring(0, times[0].indexOf("pm"))); //Value if its pm
			if(valPm < 12 && valPm > 0){
				indexval1 = valPm + 12;
			}else{ //if the first time is invalid
				throw new Exception("Invalid time 2 " + times[0]);
			}
		}else{
			throw new Exception("Invalid time 3 " + times[0]);
		}
		
		//Time available until
		if(times[1].contains("am")){
			int valAm = Integer.valueOf(times[1].substring(0, times[1].indexOf("am"))); //Value if its am
			if(times[1].equals("12am")){
				indexval2 = 0;
			}else if(valAm < 12 && valAm > 0){
				indexval2 = valAm;
			}else{
				throw new Exception("Invalid time 4 " + times[1]);
			}
		}else if(times[1].contains("pm")){
			int valPm = Integer.valueOf(times[1].substring(0, times[1].indexOf("pm"))); //Value if its pm
			if(valPm < 12 && valPm > 0){
				indexval2 = valPm + 12;
			}else{
				throw new Exception("Invalid time 5" + times[1]);
			}
		}else{
			throw new Exception("Invalid time 6 " + times[1]);
		}
		
		//If the interval for available hours is negative 
		if(indexval1 > indexval2){
			throw new Exception("Invalid format " + time);
		}
		
		//Sets the times in the interval for 
		for(int i = indexval1; i < indexval2; i++){
			aval[index][i] = true;
		}
	}

	//Getters
	public boolean[] getMonday(){
		return aval[0];
	}
	
	public boolean[] getTuesday(){
		return aval[1];
	}
	
	public boolean[] getWednesday(){
		return aval[2];
	}
	
	public boolean[] getThursday(){
		return aval[3];
	}
	
	public boolean[] getFriday(){
		return aval[4];
	}
	
	public boolean[] getSaturday(){
		return aval[5];
	}
	
	public boolean[] getSunday(){
		return aval[6];
	}
	
	//Setters
	public void setMonday(String time) throws Exception{	
		if(!time.equals("X")){
			setTimes(time, 0);
		}
	}
	
	public void setTuesday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 1);
		}
	}
	
	public void setWednesday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 2);
		}
	}
	 
	public void setThursday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 3);
		}
	}
	
	public void setFriday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 4);
		}
	}
	
	public void setSaturday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 5);
		}
	}
	
	public void setSunday(String time) throws Exception{
		if(!time.equals("X")){
			setTimes(time, 6);
		}
	}
	
}
