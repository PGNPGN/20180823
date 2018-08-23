package sse;

import java.util.Scanner;

public class G9 {

	Scanner scan = new Scanner(System.in);
	int row, col;
	int[][] map;
	int start_x, start_y, start_dir, goal_x, goal_y, goal_dir;
	Node[] queue;
	Node data;
	int[][][] check;
	int[][] check_turn;
	int rp, wp;
	int nx, ny;
	int[][] direction = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}};
	int[][] turn_array = {{0,0}, {4,3}, {3,4}, {1,2}, {2,1}};
	boolean flag = true;
	
	public class Node{
		int x, y, dir, cnt;

		public Node(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G9 obj = new G9();
		obj.getInput();
		obj.bfs();

	}
	public void bfs() {
		queue[0] = new Node(start_x, start_y, start_dir, 0);
		check[start_dir][start_x][start_y] = 1;
		wp++;

		while(rp<wp) {
			data = queue[rp];
			rp++;
			flag = true;
			
			for(int i=1; i<=5; i++) {
				if(i<=3 && flag == true) { // 이전단계에서 장애물 만났는지 flag로 검사
					nx = data.x + i*direction[data.dir][0];
					ny = data.y + i*direction[data.dir][1];


					if(nx>=0 && nx<col && ny>=0 && ny<row) {
						if(check[data.dir][nx][ny]==0) {
							if(map[nx][ny]==0) {
								check[data.dir][nx][ny]=1;
//								System.out.println("go, nx= "+nx+" ny= "+ny+" dir= "+data.dir+" cnt= "+(data.cnt+1));
								queue[wp] = new Node(nx,ny,data.dir,data.cnt+1);
								wp++;
							}else {
								flag = false;
							}
						}
					}
					
					if(queue[wp-1].x == goal_x && queue[wp-1].y == goal_y && queue[wp-1].dir == goal_dir) {
						System.out.println(queue[wp-1].cnt);
						return;
					}
				}
				if(i>3 && i<=5) {
//					System.out.println("turn, x= "+data.x+" y= "+data.y+" dir= "+turn(i, data.dir)+" cnt= "+(data.cnt+1));
					int ndir= turn_array[data.dir][i-4];
					if(check[ndir][data.x][data.y]==0) {
						queue[wp] = new Node(data.x, data.y, turn(i, data.dir), data.cnt+1);	
						wp++;
						check[ndir][data.x][data.y]=1;
					}
					

					if(queue[wp-1].x == goal_x && queue[wp-1].y == goal_y && queue[wp-1].dir == goal_dir) {
						System.out.println(queue[wp-1].cnt);
						return;
					}
				
				}
			}
		}

	}
	private int turn(int i, int dir) {

		return turn_array[dir][i-4];
	}
//	private int go(char c, int i, int dir) {
//		if(c == 'x') {
//			return i*direction[data.dir][0];
//		}
//		if(c == 'y') {
//			return i*direction[data.dir][1];
//		}
//		return 100;
//	}
	
	public void getInput() {
		col = scan.nextInt();
		row = scan.nextInt();
		map = new int[col][row];
		queue = new Node[col*row*10];
		check = new int[5][col][row];
		check_turn = new int[col][row];

		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		start_x = scan.nextInt()-1;
		start_y = scan.nextInt()-1;
		start_dir = scan.nextInt();
		goal_x = scan.nextInt()-1;
		goal_y = scan.nextInt()-1;
		goal_dir = scan.nextInt();

		//		for(int i=0; i<col+1; i++) {
		//			for(int j=0; j<row+1; j++) {
		//				System.out.print(map[i][j]);
		//			}
		//			System.out.println();
		//		}
	}

	public void print(int[][] some) {
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				System.out.print(some[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

}
