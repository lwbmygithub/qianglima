package shujutuoming;

public class findMingWen {
    
	static String encodeString = "7E38890B870934B126F66857ED6B57B9";
	
	public static void main(String[] args){
		
		Md5 m = new Md5();
		 int a = 19000000;
		
		 while(true){
			 String aString = "" + a;
			 if(m.md5(aString).toUpperCase().equals(encodeString)){
				 System.out.println(aString);
				 break;
			 }
			 a++;
		 }
	}
}
