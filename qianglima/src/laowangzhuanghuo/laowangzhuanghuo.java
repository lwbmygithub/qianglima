package laowangzhuanghuo;

import java.util.Arrays;

public class laowangzhuanghuo {
	
	static int[][] _01BagSolves = new int [15][5000];
	static int[] goods = {509,838,924,650,604,793,564,651,697,649,747,787,701,605,644};
   
	public static void main(String[] args){
		createSolveMap();
		System.out.println("--------finalResult:" + _01BagSolves[14][4999] + "---------");
	}
	
	public static void createSolveMap(){
		for(int i=0;i<15;i++){
			for(int j=1;j<5000;j++){
				int maxNoThisVal = 0;
				int maxHasThisVal = 0;
				int w = j - goods[i];
				if(w >= 0){
					if(i >= 1){
					maxHasThisVal = _01BagSolves[i-1][w] + goods[i];
					}else{
						maxHasThisVal = _01BagSolves[0][j] + goods[i];
					}
				}
				if(i >= 1){
			   maxNoThisVal = _01BagSolves[i-1][j];
				}else{
					maxNoThisVal = _01BagSolves[0][j];
				}
				int thisVal = maxNoThisVal > maxHasThisVal ? maxNoThisVal : maxHasThisVal;
				/*调出哪个装了哪个没装
				if(i == 4 && j == 838){
					System.out.println("----NO:" + maxNoThisVal + "Yes:"  +  maxHasThisVal +"-----");
				}*/
				_01BagSolves[i][j] = thisVal;
			}
		}
	}
	
}
