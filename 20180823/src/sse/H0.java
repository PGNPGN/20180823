package sse;

import java.util.Scanner;

public class H0 {
	Scanner scan = new Scanner(System.in);
	int R, C;
	int[][] map;
	int[][][] check;
	int start_x, start_y, goal_x, goal_y;
	int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	int rp, wp;
	int nx, ny;
	Node[] queue;
	Node data;

	public class Node{
		int x, y, cnt, bomb;

		public Node(int x, int y, int cnt, int bomb) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.bomb = bomb;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H0 obj = new H0();
		obj.getInput();
		obj.find_start_end_point();
		if(obj.bfs()>0) {
			System.out.println(obj.bfs());
		}else
			System.out.println(-1);
//		obj.bfs();
	}

	public int bfs() {
		queue[0] = new Node(start_x, start_y, 0, 3);
		wp++;

		while(rp<wp) {
			System.out.println("rp= "+rp+" wp= "+wp);
			data = queue[rp];
			rp++;
			
			
			for(int i=0; i<4; i++) {
				nx = data.x + dx[i];
				ny = data.y + dy[i];

				if(nx>=1 && nx<R-1 && ny>=1 && ny<C-1) {
					if(map[nx][ny] == 1) continue;
					if(map[nx][ny] == 3) continue;
					if(check[data.bomb][nx][ny] == 1) continue;
					if(data.bomb == 0) continue;

					
					if(map[nx][ny] == 2) {
						System.out.println("Meet 2, nx ="+nx+" ny= "+ny+" cnt=" + (data.cnt+1)+" bomb= "+(data.bomb-1));
						check[data.bomb-1][nx][ny] = 1;
						queue[wp++] = new Node(nx,ny,data.cnt+1, data.bomb-1);
					}
					if(map[nx][ny] == 0) {
						System.out.println("Meet 0, nx ="+nx+" ny= "+ny+" cnt=" + (data.cnt+1)+" bomb= "+(data.bomb));
						check[data.bomb][nx][ny] = 1;
						queue[wp++] = new Node(nx,ny,data.cnt+1, data.bomb);
					}
					if(map[nx][ny] == 4) {
						System.out.println("Finish!!"+nx+" "+ny);
//						return queue[wp-1].cnt;
						return (data.cnt+1);
					}
				}
			}
		}
		return -100;
	}

	public void find_start_end_point() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==3) {
					start_x = i;
					start_y = j;
				}
				if(map[i][j] == 4) {
					goal_x = i;
					goal_y = j;
				}
			}
		}
	}

	public void getInput() {
		R = scan.nextInt();
		C = scan.nextInt();
		map = new int[R][C];
		check = new int[4][R][C];
		queue = new Node[R*C*10];

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = scan.nextInt();
			}
		}
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

	}
}
