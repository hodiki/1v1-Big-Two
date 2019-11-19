package week4;

import java.util.ArrayList;

public class T4_number {
	
	/*public static void main(String[] args)
	{
		
	}*/
	
	public static ArrayList<String> numbers()
	{
		ArrayList<String> number = new ArrayList<String>();
		number.add("A");
		for(int i=2;i<11;i++)
		{
			number.add(""+i);
		}
		number.add("J");
		number.add("Q");
		number.add("K");
		
		return number;
	}
	 
}
