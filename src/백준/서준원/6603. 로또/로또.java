package 백준

import java.util.Scanner;

public class Main {
   private static int n;
   private static int[] array;
   private static int[] result = new int[6];
   
   public static void main(String[] args) {
	   
	   Scanner s = new Scanner(System.in);
	   
	   while (true) {
		   n = s.nextInt();
		   
		   if (n == 0) {
			   break;
		   }
		   
		   array = new int[n];
		   for (int i=0; i<n; i++) {
			   array[i] = s.nextInt();
		   }
		   
		   dfs(0,0);
		   System.out.println();
	   }
	   
   }

	public static void dfs(int a, int b) {
		
		if (a == 6) {
			for (int i=0; i<6; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		} else {
			for (int i=b; i<n; i++) {
				result[a] = array[i]; 
				dfs(a+1, i+1); 
			}
		}	
	}
}