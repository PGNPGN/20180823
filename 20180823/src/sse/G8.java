package sse;

import java.util.Scanner;

public class G8 {
	Scanner scan = new Scanner(System.in);
	int dim;
	int[][] map;
	String dummy="";
	int[] dx= {-1, 1, 0, 0}, dy= {0, 0, -1, 1};
	int[][] sum;
	int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G8 obj = new G8();
		obj.getInput();
		obj.sum[0][0] = 0;
		obj.dfs(0, 0);
		System.out.println(obj.min);
	}
	
	public void dfs(int x, int y) {
		int nx, ny;
//		print();
//		System.out.println("I'm in "+x+","+y);
		
		if(sum[x][y]>=min) {
			return;
		}
		
		if(x==dim-1 && y==dim-1) {
			if(sum[x][y]<min) {
				min = sum[x][y];
				return;
			}
			return;
		}
		

		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx>=0 && nx<dim && ny>=0 && ny<dim) {
				if(sum[x][y] + map[nx][ny] < sum[nx][ny]) {
					sum[nx][ny]	= sum[x][y] + map[nx][ny] ;
					
//					System.out.println("nx = "+nx+" ny = "+ny);
//					System.out.println("-----------------");
//					
					dfs(nx, ny);
				}

			}
		}
		
		
		
		
	}
	
	
	public void getInput() {
		dim = scan.nextInt();
		map = new int[dim][dim];
		sum = new int[dim][dim];
		scan.nextLine();
		
		for(int i=0; i<dim; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<dim; j++) {
				map[i][j] = (int)(dummy.charAt(j)-'0');
			}
		}
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				sum[i][j] = Integer.MAX_VALUE;
			}
		}
//		for(int i=0; i<dim; i++) {
//			for(int j=0; j<dim; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	public void print() {
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				System.out.print(sum[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
}
