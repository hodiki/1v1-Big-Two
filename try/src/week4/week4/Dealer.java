package week4;

import java.util.ArrayList;

public class Dealer {
	public static ArrayList<String> dealer(int i,int x,ArrayList<String> cards) {
		
	    /*for(int i=0;i<52;i++) {                   //cards test
	    	card_num=cards.get(i);
	    	System.out.println(""+card_num);
	    }*/
		int m=x;
		int n=i;
		ArrayList<String> hand_cards = new ArrayList<String>();
	    while(x!=0) {            //Transfer value into card, unit card output
	    	m=random_number(n);	
	    	hand_cards.add(the_game.card(m,cards));   //输出并储存收到的手牌
	    	
	    	cards.remove(m);     //delete card
	    	n--;x--;
	    }
	    System.out.print("\n");     //调整位置
	    return hand_cards;               //返回储存的手牌
	}

	/*public static ArrayList<String> colors(ArrayList<String> colors) {     //Put into the function and pass it to card
		//ArrayList<String> colors = new ArrayList<String>()                 //error
		return colors;
	}

	public static ArrayList<String> numbers(ArrayList<String> numbers) {
		//ArrayList<String> numbers= new ArrayList<String>();
		return numbers;
	}*/
	
	
	//
	//card:////////////////////////////////////////////////////////////////////////////////////////
	//
	
	/*public static void card(int n,ArrayList<String> cards) {
		String card;
		card=cards.get(n);
		System.out.print(" ("+card+") ");
	}
	*/
	
    //
    //other:////////////////////////////////////////////////////////////////////////////////////////
	//
	

	public static int random_number(int n){
		int a= (int)(Math.random()*n);
		//System.out.printf(""+a);
		return a;
	}

}
