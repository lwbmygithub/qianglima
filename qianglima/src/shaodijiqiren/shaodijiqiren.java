package shaodijiqiren;

import java.util.ArrayList;
import java.util.List;

public class shaodijiqiren {
   
	static int x = 18;
	static int y = 20;
	static String map = "111000010000000100010010110000111100010100001100100110000001011000000100001111000000100001000000110011000011000000100000111100000000100000001110000010100001110000100000001001000000001000010001000001100000100001010011010001100010000111110001000000100000100000110001000001100011100101000101011100000001011101010000110000000001000000101000011011000000001000110000";
	static int[][] maps = new int[x][y];
	static int originalX = 0;
	static int originalY = 0;
	static String path;
	static List canUsePoint = new ArrayList<Integer>();
	
	
	public static void main(String[] args){
		createMap(map);
		//onePointGetSolve(0,0,maps);
		//printMap(maps);
		getSolve(maps);
		System.out.println("-----------originalX:" + originalX + "--------originalY:" + originalY);
		System.out.println(path);
	}
	
	public static void createMap(String map){
		String[] mapStrings = map.split("");
		int z = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				maps[i][j] = Integer.parseInt(mapStrings[z++]);
				if(maps[i][j] ==  0){
					canUsePoint.add(i);
					canUsePoint.add(j);
				}
			}
		}
	}
	
	public static void printMap(int[][] maps){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				System.out.print(maps[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------------");
		System.out.println();
	}
	
	public static void getSolve(int[][] maps){
		for(int i=0;i<canUsePoint.size();i++){
			Integer x1 = (Integer) canUsePoint.get(i++);
			Integer y1 = (Integer) canUsePoint.get(i);
			if(onePointGetSolve(new StringBuilder(), x1, y1, maps)){
				originalX = x1 + 1;
				originalY = y1 + 1;
				break;
			}
		}
	}
	
	public static void copyMap(int[][] inputMap, int[][] originalMap){
		for(int i = 0;i<x;i++){
			for(int j=0;j<y;j++){
				inputMap[i][j] = originalMap[i][j];
			}
		}
	}
	
	public static boolean onePointGetSolve(StringBuilder path, int x1, int y1, int[][] maps){
		int[][] nowMap = new int[x][y];
		copyMap(nowMap, maps);
		//printMap(nowMap);
		nowMap[x1][y1] = 0;
		int length = path.length();
		
		//向左走
		int changeY1 = left(x1, y1, nowMap);
		if(changeY1 != y1){
		  path.append('l');
		 Boolean isPass = onePointGetSolve(path, x1, changeY1, nowMap);
		 if(isPass){
			 shaodijiqiren.path = path.toString();
			 return isPass;
		 }
		}
		
		
		//向右走
		copyMap(nowMap, maps);
		nowMap[x1][y1] = 0;
		path.delete(length, path.length());
		
		int changeY2 = right(x1, y1, nowMap);
		if(changeY2 != y1){
			path.append('r');
			Boolean isPass = onePointGetSolve(path, x1, changeY2, nowMap);
			 if(isPass){
				 shaodijiqiren.path = path.toString();
				 return isPass;
			 }
		}
		
		//向上走
		copyMap(nowMap, maps);
		nowMap[x1][y1] = 0;
		path.delete(length, path.length());
		int changeX1 = up(x1, y1, nowMap);
		if(changeX1 != x1){
			path.append('u');
			Boolean isPass = onePointGetSolve(path, changeX1, y1, nowMap);
			 if(isPass){
				 shaodijiqiren.path = path.toString();
				 return isPass;
			 }
		}
		
		//向下走
		        copyMap(nowMap, maps);
		        nowMap[x1][y1] = 0;
		        path.delete(length, path.length());
				int changeX2 = down(x1, y1, nowMap);
				if(changeX2 != x1){
					path.append('d');
					Boolean isPass = onePointGetSolve(path, changeX2, y1, nowMap);
					 if(isPass){
						 shaodijiqiren.path = path.toString();
						 return isPass;
					 }
				}
				
				if(changeX1 == changeX2 && changeX2 == x1 && changeY1 == changeY2 && changeY2 == y1){
					if(checkIFSuccess(maps)){
						return true;
					}else{
						//path.deleteCharAt(path.length()-1);
						return false;
					}
				}
				
		return false;
}

	
	//向左走
	public static int left(int x1, int y1, int[][] maps){
		while(y1 >=0 && maps[x1][y1] != 1){
			maps[x1][y1] = 1;
			--y1;
		}
		return y1 + 1;
	}
  
  //向右走
	public static int right(int x1, int y1, int[][] maps){
		while(y1 < y && maps[x1][y1] != 1){
			maps[x1][y1] = 1;
			++y1;
		}
		return y1 - 1;
	}
	
	//向上走
	public static int up(int x1, int y1, int[][] maps){
		while(x1 >= 0 && maps[x1][y1] !=  1){
			maps[x1][y1] = 1;
			-- x1;
		}
		return x1 + 1;
	}
	
	//向下走
	public static int down(int x1, int y1, int[][] maps){
		while(x1 < x && maps[x1][y1] !=  1){
			maps[x1][y1] = 1;
			++ x1;
		}
		return x1 - 1;
	}
	
	public static boolean checkIFSuccess(int[][] maps){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(maps[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
