package fangketongji;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class fangketongji {

	public static  void main(String[] args) throws Exception{
		FileInputStream a = new FileInputStream("D:\\BaiduYunDownload\\uv.txt");
		InputStreamReader  b = new InputStreamReader(a);
		BufferedReader c = new BufferedReader(b);
	    String read;
	    List userList = new ArrayList<String>();
	    while((read = c.readLine()) != null){
	    	String[] reads = read.split(" ");
	    	if(!userList.contains(reads[1])){
	    		userList.add(reads[1]);
	    	}
	    }
	    System.out.println(userList.size());
	}
}
