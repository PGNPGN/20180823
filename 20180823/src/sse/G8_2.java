package sse;

import java.util.Scanner;

public class G8_2 {
	Scanner scan = new Scanner(System.in);
	int dim;
	int[][] map;
	String dummy="";
	int[] dx= {-1, 1, 0, 0}, dy= {0, 0, -1, 1};
	int[][] check;
	int[][] sum;
	int min = Integer.MAX_VALUE;
	Node[] queue;
	Node data;
	int rp, wp;
	int nx, ny;
	
	public class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G8_2 obj = new G8_2();
		obj.getInput();
		obj.bfs();
		System.out.println(obj.min);
		
//		try {
//			for(Node N : obj.queue) {
//				if(N.x == obj.dim-1 && N.y == obj.dim-1)
//				System.out.println(N.x+" "+N.y+" "+obj.sum[N.x][N.y]);
//			}
//		}catch(NullPointerException e) {
//			
//		}
//	왜 안되는지 모르겠다.
//		System.out.println(obj.sum[obj.queue[obj.wp-1].x][obj.queue[obj.wp-1].y]);
		
	}
	
	
	public void bfs() {
		queue[0] = new Node(0,0);
		wp++;
		sum[0][0] = 0;
		
		while(rp<wp) {
			data = queue[rp];
			rp++;
			
			for(int i=0; i<4; i++) {
				nx = data.x + dx[i];
				ny = data.y + dy[i];
				
				if(nx>=0 && nx<dim && ny>=0 && ny<dim) {
					if(sum[data.x][data.y]+ map[nx][ny] < sum[nx][ny]) {
						queue[wp] = new Node(nx,ny);
						sum[nx][ny] = sum[data.x][data.y]+ map[nx][ny];
						
						if(queue[wp].x == dim-1 && queue[wp].y == dim-1) {
							if(sum[queue[wp].x][queue[wp].y] < min) {
								min = sum[queue[wp].x][queue[wp].y];
							}
						}
						wp++;
					}
				}
			}
		}
		
		
	}
	public void getInput() {
		dim = scan.nextInt();
		map = new int[dim][dim];
		check = new int[dim][dim];
		sum = new int[dim][dim];
		
		scan.nextLine();
		queue = new Node[10000000];
		
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
}
