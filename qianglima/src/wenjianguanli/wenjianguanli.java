package wenjianguanli;

import java.io.File;

public class wenjianguanli {
	
	   static Long maxLength = (long) 0;
	   static String maxFilePath;

		public static void main(String[] args){
			File file  = new File("D:\\BaiduYunDownload\\root\\root");
			getMaxFile(file);
			System.out.println(maxFilePath);
		}
		
		public static void getMaxFile(File file){
			if(file.isDirectory()){
				File[] subFiles = file.listFiles();
				for(File subFile : subFiles){
					getMaxFile(subFile);
				}
			}else if(file.isFile()){
				Long fileLength = file.length();
				if(fileLength > maxLength){
					maxLength = fileLength;
					maxFilePath = file.getAbsolutePath();
				}
			}
		}
}
