package xishuashua;

import shujutuoming.Md5;

public class xishuashua {
	
	public static void main(String[] args){
		String a = "20160119HQ1001";
		Md5 m = new Md5();
		int b = 0;
		    while(true){
		    String c = a + b;
			String d = m.md5(c).substring(0, 6);
			if(d.equals("000000")){
				System.out.println(c);
				break;
			}
			b++;
		    }
	}
}
