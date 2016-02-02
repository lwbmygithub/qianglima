package mazhichu;

public class mazhichu {
	public static void main(String[] args){
		int i = 1;
		int count = 0;
    while(true){
    	i ++;
    	if(i % 2 == 0 ||  i % 3 == 0){
    		count ++;
    	}
    	if(count == 2333){
    		break;
    	}
    }
    System.out.println(i);
	}
}
