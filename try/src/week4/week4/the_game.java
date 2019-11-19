package week4;


import java.awt.AWTException;
import java.util.*;

//import java.awt.Robot;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;

public class the_game {
	public static void main(String[] args) throws AWTException {
		int m=13,n=52,h,p1n=m,p2n=m,y,pool=0,f;
		String card;
		Scanner yy = new Scanner(System.in);
		//Scanner mm = new Scanner(System.in);                      //自定义启示卡牌数
		//m=mm.nextInt();
		
		String card_c,card_n,card_num;                                    //构筑卡组
		ArrayList<String> colors = new ArrayList<String>();
		ArrayList<String> numbers= new ArrayList<String>();
		ArrayList<String> cards= new ArrayList<String>();
		ArrayList<String> p1_cards= new ArrayList<String>();
		ArrayList<String> p2_cards= new ArrayList<String>();
		ArrayList<String> cards_pool= new ArrayList<String>();
		ArrayList<String> hand_cards= new ArrayList<String>();
		
		
		
		colors=T4_color.colors();
	    numbers=T4_number.numbers();
	    
	    for(int i=0;i<4;i++){
			card_c= colors.get(i);
	    
			for(int j=0;j<13;j++) {
				card_n= numbers.get(j);
				card_num=card_c+" "+card_n;
				cards.add(card_num);
			}
		}
	    System.out.println("欢迎来玩用户极不友好型锄大地小游戏（目前仅支持SOLO）（SOLO开局各发13张牌）");
	    System.out.println("锄大地是一种扑克牌游戏模式，每次出牌的数量应与游戏开局时的出牌数或pass后第一次出牌的数量为准，可走单，顺子与花固定只能4张，可三带一、三张、四张，花大于顺，后面的以此类推。");
	    
	    //
	    //deal
	    //
	    
	    do {
	    	System.out.println("请输入1开始游戏：");
	    	y=yy.nextInt();
	    }while(y!=1);
	    
	    for(int i=1;i<=2;i++) {
	    	System.out.println("给"+i+"号玩家发牌");
	    	hand_cards=Dealer.dealer(n,m,cards);
	    	if(i==1)
	    		p1_cards=hand_cards;
	    	else
	    		p2_cards=hand_cards;
	    	n=n-13;
	    	//clear();
		}
	    
	    h=random_number(2)+1;
	    System.out.println("\n玩家"+h+"先手\n");
	    
	    //
	    //start game
	    //
	    
	    while(true) {                                         //回合****************************************************************
	    //
	    	
	    System.out.println("\n这是玩家"+h+"的手牌\n");
	    if(h==1) {
		    for(int i=0;i<p1n;i++) {
		    	System.out.print("("+(i+1)+"."+p1_cards.get(i)+") ");	    		    	
	    }
	    }
	    else {
	    	for(int i=0;i<p2n;i++) {
		    	System.out.print("("+(i+1)+"."+p2_cards.get(i)+") ");	    		 
	    }
	    }
	    
	    System.out.println("\n请玩家"+h+"出牌（输入0则停止出牌）\n");
	    
	    if(h==1) {                                   //玩家1出牌
	    do{                                         //出牌
	    y=yy.nextInt();
	    if(y==0 || p1n==0)
	    	break;
	    card=p1_cards.get(y-1);           //取出对于牌序号的牌
	    System.out.println(card);       //输出出的牌
	    cards_pool.add(card);           //将出的牌放入卡池
	    p1_cards.remove(y-1);             //从手牌删除出的牌
	    p1n--;                          //玩家1手牌记录-1
	    pool++;                         //卡池+1
		    for(int i=0;i<p1n;i++) {
		    	System.out.print("("+(i+1)+"."+p1_cards.get(i)+") ");	    		    	
	    }
	    }while(y!=0);
	    System.out.println("目前的卡池为：");
	    for(f=0;f<pool;f++) {
	    	System.out.println(cards_pool.get(f));
	    }
	    }
	    
	    if(h==2) {                                   //玩家2出牌
		    do {                                         //出牌
		    y=yy.nextInt();
		    if(y==0 || p2n==0)
		    	break;
		    card=p2_cards.get(y-1);           //取出对于牌序号的牌
		    System.out.println(card);       //输出出的牌    
		    cards_pool.add(card);           //将出的牌放入卡池
		    p2_cards.remove(y-1);             //从手牌删除出的牌
		    p2n--;                          //玩家2手牌记录-1
		    pool++;                         //卡池+1
			    for(int i=0;i<p2n;i++) {
			    	System.out.print("("+(i+1)+"."+p2_cards.get(i)+") ");	    		 
		    }
		    }while(y!=0);
		    System.out.println("目前的卡池为：");
		    for(f=0;f<pool;f++) {
		    	System.out.println(cards_pool.get(f));
		    }
		    }
	    
	    if(h==2) {
	    	h=1;
	    }
	    else {
	    	h=2;
	    }
	    
	    if(p1n==0 || p2n==0) {
	    	if(p1n==0)
	    		System.out.println("\n\ngamer1 win");
	    	else
	    		System.out.println("\n\ngamer2 win");
	    	System.out.print("game over\n");
		    yy.close();
	    	break;
	    }
	    
	    //
	    }                                                   //回合****************************************************************
	    
	    
	       
	    //mm.close();
	}
	
	public static String card(int n,ArrayList<String> cards) {
		String card;
		card=cards.get(n);
		System.out.print(" ("+card+") ");
		return card;
	}
	
	public static int random_number(int n){
		int a= (int)(Math.random()*n);
		//System.out.printf(""+a);
		return a;
	}
		
}

/*public static void clear() throws AWTException
{
    Robot r = new Robot();
    r.mousePress(InputEvent.BUTTON3_MASK);       // 按下鼠标右键
    r.mouseRelease(InputEvent.BUTTON3_MASK);    // 释放鼠标右键
    r.keyPress(KeyEvent.VK_CONTROL);             // 按下Ctrl键
    r.keyPress(KeyEvent.VK_R);                    // 按下R键
    r.keyRelease(KeyEvent.VK_R);                  // 释放R键
    r.keyRelease(KeyEvent.VK_CONTROL);            // 释放Ctrl键
    r.delay(100);       

}*/


