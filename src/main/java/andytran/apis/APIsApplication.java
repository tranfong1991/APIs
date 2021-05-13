package andytran.apis;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APIsApplication {

//	enum Direction{
//		HORIZONTAL, VERTICAL, RIGHT_DIAG, LEFT_DIAG
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(APIsApplication.class, args);
		
//		int[][] matrix = new int[3][3];
//		Scanner scanner = new Scanner(System.in);
//		
//		int count = 0;
//		int slotLeft = 9;
//		while(slotLeft > 0){
//			System.out.println("Player " + (count + 1));
//			
//			System.out.print("X = ");
//			int x = scanner.nextInt();
//			
//			System.out.print("Y = ");
//			int y = scanner.nextInt();
//			
//			if(x < 0 || x > 2 || y < 0 || y > 2){
//				System.out.println("Invalid coordinates!");
//				System.out.println();
//				continue;
//			}
//			
//			if(matrix[x][y] != 0){
//				System.out.println("Coordinates used!");
//				System.out.println();
//				continue;
//			}
//			
//			matrix[x][y] = count + 1;
//			slotLeft--;
//			printMatrix(matrix);
//			
//			if(hasWon(matrix, x, y, count + 1)){
//				System.out.println("Player " + (count + 1) + " has won!");
//				break;
//			}
//			
//			count = (count + 1) % 2;
//			System.out.println();		
//		}
//		scanner.close();
	}
	
//	private static void printMatrix(int[][] matrix){
//		System.out.println("Matrix:");
//		for(int i = 0; i < 3; i++){
//			for(int j = 0; j < 3; j++){
//				System.out.print(matrix[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//	}
//	
//	private static boolean hasWon(int[][] matrix, int x, int y, int symbol){		
//		int hcount = getCount(matrix, x, y, symbol, Direction.HORIZONTAL);
//		if(hcount == 3){
//			return true;
//		}
//		
//		int vcount = getCount(matrix, x, y, symbol, Direction.VERTICAL);
//		if(vcount == 3){
//			return true;
//		}
//		
//		int rdcount = getCount(matrix, x, y, symbol, Direction.RIGHT_DIAG);
//		if(rdcount == 3){
//			return true;
//		}
//		
//		int ldcount = getCount(matrix, x, y, symbol, Direction.LEFT_DIAG);
//		if(ldcount == 3){
//			return true;
//		}
//		
//		return false;
//	}
//	
//	private static int getCount(int[][] matrix, int x, int y, int symbol, Direction direction){
//		if(x < 0 || x > 2 || y < 0 || y > 2){
//			return 0;
//		}
//		
//		if(matrix[x][y] != symbol){
//			return 0;
//		}
//		
//		int count = 0;
//		
//		// -1 means visited
//		matrix[x][y] = -1;
//		
//		switch(direction){
//		case VERTICAL:
//			count = getCount(matrix, x - 1, y, symbol, direction);
//			count = count + getCount(matrix, x + 1, y, symbol, direction);
//			break;
//			
//		case HORIZONTAL:
//			count = getCount(matrix, x, y + 1, symbol, direction);
//			count = count + getCount(matrix, x, y - 1, symbol, direction);
//			break;
//		
//		case RIGHT_DIAG:
//			count = getCount(matrix, x - 1, y + 1, symbol, direction);
//			count = count + getCount(matrix, x + 1, y - 1, symbol, direction);
//			break;
//			
//		case LEFT_DIAG:
//			count = getCount(matrix, x - 1, y - 1, symbol, direction);
//			count = count + getCount(matrix, x + 1, y + 1, symbol, direction);
//			break;
//		}
//		
//		// unmark it as visited
//		matrix[x][y] = symbol;
//		
//		// +1 to include itself
//		return count + 1;
//	}
	
}
