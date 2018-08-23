package sse;

import java.util.Scanner;

public class G7 {
	Scanner scan = new Scanner(System.in);
	int num;
	int[][] map;
	int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	int count;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G7 obj = new G7();
		obj.getInput();
		obj.map[0][0] = 1;
		obj.process(0, 0, 1);
		System.out.println(obj.count);
	}
	
	public void process(int x, int y, int cnt) {
		int nx, ny;
//		print();
//		System.out.println("I'm in "+x+", "+y);
//		System.out.println("------------------------");
		if(x==4 && y==4) {
			if(cnt == 25-num) {
//				System.out.println("count is pulsed");
				count++;
				return;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx>=0&&nx<5&&ny>=0&&ny<5) {
				if(map[nx][ny]!=2 && map[nx][ny]!=1) {
					map[nx][ny] = 1;
					process(nx, ny, cnt+1);
					map[nx][ny] = 0;
				}
			}
		}

	}
	
	
	public void getInput() {
		num = scan.nextInt();
		map = new int[5][5];
		
		for(int i=0; i<num; i++) {
			map[scan.nextInt()-1][scan.nextInt()-1] = 2;
		}
		
		
		
	}
	public void print() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}
