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
		//Scanner mm = new Scanner(System.in);                      //�Զ�����ʾ������
		//m=mm.nextInt();
		
		String card_c,card_n,card_num;                                    //��������
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
	    System.out.println("��ӭ�����û������Ѻ��ͳ����С��Ϸ��Ŀǰ��֧��SOLO����SOLO���ָ���13���ƣ�");
	    System.out.println("�������һ���˿�����Ϸģʽ��ÿ�γ��Ƶ�����Ӧ����Ϸ����ʱ�ĳ�������pass���һ�γ��Ƶ�����Ϊ׼�����ߵ���˳���뻨�̶�ֻ��4�ţ�������һ�����š����ţ�������˳��������Դ����ơ�");
	    
	    //
	    //deal
	    //
	    
	    do {
	    	System.out.println("������1��ʼ��Ϸ��");
	    	y=yy.nextInt();
	    }while(y!=1);
	    
	    for(int i=1;i<=2;i++) {
	    	System.out.println("��"+i+"����ҷ���");
	    	hand_cards=Dealer.dealer(n,m,cards);
	    	if(i==1)
	    		p1_cards=hand_cards;
	    	else
	    		p2_cards=hand_cards;
	    	n=n-13;
	    	//clear();
		}
	    
	    h=random_number(2)+1;
	    System.out.println("\n���"+h+"����\n");
	    
	    //
	    //start game
	    //
	    
	    while(true) {                                         //�غ�****************************************************************
	    //
	    	
	    System.out.println("\n�������"+h+"������\n");
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
	    
	    System.out.println("\n�����"+h+"���ƣ�����0��ֹͣ���ƣ�\n");
	    
	    if(h==1) {                                   //���1����
	    do{                                         //����
	    y=yy.nextInt();
	    if(y==0 || p1n==0)
	    	break;
	    card=p1_cards.get(y-1);           //ȡ����������ŵ���
	    System.out.println(card);       //���������
	    cards_pool.add(card);           //�������Ʒ��뿨��
	    p1_cards.remove(y-1);             //������ɾ��������
	    p1n--;                          //���1���Ƽ�¼-1
	    pool++;                         //����+1
		    for(int i=0;i<p1n;i++) {
		    	System.out.print("("+(i+1)+"."+p1_cards.get(i)+") ");	    		    	
	    }
	    }while(y!=0);
	    System.out.println("Ŀǰ�Ŀ���Ϊ��");
	    for(f=0;f<pool;f++) {
	    	System.out.println(cards_pool.get(f));
	    }
	    }
	    
	    if(h==2) {                                   //���2����
		    do {                                         //����
		    y=yy.nextInt();
		    if(y==0 || p2n==0)
		    	break;
		    card=p2_cards.get(y-1);           //ȡ����������ŵ���
		    System.out.println(card);       //���������    
		    cards_pool.add(card);           //�������Ʒ��뿨��
		    p2_cards.remove(y-1);             //������ɾ��������
		    p2n--;                          //���2���Ƽ�¼-1
		    pool++;                         //����+1
			    for(int i=0;i<p2n;i++) {
			    	System.out.print("("+(i+1)+"."+p2_cards.get(i)+") ");	    		 
		    }
		    }while(y!=0);
		    System.out.println("Ŀǰ�Ŀ���Ϊ��");
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
	    }                                                   //�غ�****************************************************************
	    
	    
	       
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
    r.mousePress(InputEvent.BUTTON3_MASK);       // ��������Ҽ�
    r.mouseRelease(InputEvent.BUTTON3_MASK);    // �ͷ�����Ҽ�
    r.keyPress(KeyEvent.VK_CONTROL);             // ����Ctrl��
    r.keyPress(KeyEvent.VK_R);                    // ����R��
    r.keyRelease(KeyEvent.VK_R);                  // �ͷ�R��
    r.keyRelease(KeyEvent.VK_CONTROL);            // �ͷ�Ctrl��
    r.delay(100);       

}*/


