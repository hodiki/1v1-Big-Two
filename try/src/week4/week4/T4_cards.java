package week4;

import java.util.ArrayList;

public class T4_cards {

	public static void main1() 
	{
	   ArrayList<String> color,number;
	   
	   String card_c,card_n;
	   
	    color=T4_color.colors();
	    number=T4_number.numbers();
	   	   
		ArrayList<String> cards = new ArrayList<String>();
		cards.addAll(color);
		cards.addAll(number);
		
		for(int i=0;i<4;i++){
			card_c= cards.get(i);
	    
			for(int j=4;j<17;j++) {
				card_n= cards.get(j);
				System.out.printf(card_n+" ");
			    System.out.printf(card_c+" \n");
			}
		}
	}
	
}
