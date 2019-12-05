//Authors:
//Disa Röed Sahlström
//Sebastian Åkerlund

package ntest;

public class Nqueen {

	
	private final int n = 8;
	private static int chessB[][] = new int [8][8];

	// Prints the chessboard
	public void printChessB(int chessB[][]) {
		System.out.print("  ");
		for(int col = 1; col <= n ; col++) {
			System.out.print(" " + col + " " );
		}
		System.out.println();

		for(int row = 0; row < n; row++) {
			System.out.print(row + 1 + "|");
			
			for (int coll = 0 ; coll < n ; coll++) {

				System.out.print( " "+ chessB[row][coll] + " " );
				
			}		
			System.out.println();
		}
	}
	
	
	// Checks if attacking other queens is possible
	public boolean attack(int chessB[][], int row , int coll) {	
		for(int i = 0 ; i < coll; i++) {
			if(chessB[row][i] == 1) {
				return false;
			}
		}
		
		
		for(int i = row, k = coll; k>=0 && i <n; i++, k--) {
			if(chessB[i][k] == 1) {
				return false;
			}
		}
		
		for(int i = row, k = coll; i >= 0 && k >= 0; i--, k-- ) {
			if(chessB[i][k]== 1) {
				return false;
			}
		}
		
		return true;
	}
	
	// Recursively checks for placement of queen
	public boolean placeQ(int chessB[][], int coll) {
		if(coll == n) {
			return true;
		}
		
		for(int i = 0; i < n; i++) {
			
			if(attack(chessB, i, coll)) {
				chessB[i][coll] = 1;
				
				if(placeQ(chessB, coll + 1) == true) {
					return true;
				}
				chessB[i][coll] = 0;
			}
		}
		return false;
	}
	//Draws chessboard if queens can be placed appropriately
	public boolean run() {	
		if(placeQ(chessB, 0) == true) {
			printChessB(chessB);
			return true;
		}
		return false;
	}
	
	
	public static void main(String args[]) {
		
		Nqueen nQueen = new Nqueen();
		nQueen.run();
				
	}
}
