/*
 * Project Euler: Question 11
 * What is the greatest product of four adjacent numbers in the same direction 
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 */
package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class Question11 {

	public static void main(String[] args) {
		
		String input = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\r\n"
				+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\r\n"
				+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\r\n"
				+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\r\n"
				+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\r\n"
				+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\r\n"
				+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\r\n"
				+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\r\n"
				+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\r\n"
				+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\r\n"
				+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\r\n"
				+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\r\n"
				+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\r\n"
				+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\r\n"
				+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\r\n"
				+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\r\n"
				+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\r\n"
				+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\r\n"
				+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\r\n"
				+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		final int SEARCH_LENGTH = 4;
		int greatestProduct = 0;
		
		ArrayList<ArrayList<Integer>> grid = createGrid(input);
		
		/**
		 * Algorithm to systematically work through the grid and apply the four 
		 * directional checks and save the largest prodcut found. 
		 */
		for(int y = 0; y < grid.size() - 1; y++) {
			for(int x = 0; x < grid.get(y).size() - 1; x++) {
				int right = checkRight(x, y, grid, SEARCH_LENGTH);
				int down = checkDown(x, y, grid, SEARCH_LENGTH);
				int downRight = checkDownRight(x, y, grid, SEARCH_LENGTH);
				int downLeft = checkDownLeft(x, y, grid, SEARCH_LENGTH);
				
				if(right > greatestProduct) {
					greatestProduct = right;
				}
				if(down > greatestProduct) {
					greatestProduct = down;
				}
				if(downRight > greatestProduct) {
					greatestProduct = downRight;
				}
				if(downLeft > greatestProduct) {
					greatestProduct = downLeft;
				}
			}
		}
		System.out.println(greatestProduct);
	}
	
	/**
	 * Method to search in the horizontal direction starting at coordinate x, y and 
	 * moving rightward. 
	 * @param x The x array position on the grid.
	 * @param y The y array position on the grid. 
	 * @param grid The 2D grid of integers to search. 
	 * @param searchLength The number of consecutive elements to search. 
	 * @return The product of the elements in the search pattern. 
	 */
	private static int checkRight(int x, int y, ArrayList<ArrayList<Integer>> grid, int searchLength) {
		int product = 1;
		if(x < grid.get(0).size() -1 - searchLength) {
			for(int i = 0; i < searchLength; i++) {
				product *= grid.get(y).get(x+i);
			}
			return product;
		}
		return product = 0;
	}
	
	/**
	 * Method to search in the vertical direction starting at coordinate x, y and 
	 * moving downward. 
	 * @param x The x array position on the grid.
	 * @param y The y array position on the grid. 
	 * @param grid The 2D grid of integers to search. 
	 * @param searchLength The number of consecutive elements to search. 
	 * @return The product of the elements in the search pattern. 
	 */
	private static int checkDown(int x, int y, ArrayList<ArrayList<Integer>> grid, int searchLength) {
		int product = 1;
		if(y < grid.size() -1 - searchLength) {
			for(int i = 0; i < searchLength; i++) {
				product *= grid.get(y+i).get(x);
			}
			return product;
		}
		return product = 0;
	}
	
	/**
	 * Method to search in the south-east direction starting at coordinate x, y and 
	 * moving downward and to the right. 
	 * @param x The x array position on the grid.
	 * @param y The y array position on the grid. 
	 * @param grid The 2D grid of integers to search. 
	 * @param searchLength The number of consecutive elements to search. 
	 * @return The product of the elements in the search pattern. 
	 */
	private static int checkDownRight(int x, int y, ArrayList<ArrayList<Integer>> grid, int searchLength) {
		int product = 1;
		if(x < grid.get(0).size() - 1 - searchLength && y < grid.size() -1 - searchLength) {
			for(int i = 0; i < searchLength; i++) {
				product *= grid.get(y+i).get(x+i);
			}
			return product;
		}
		return product = 0;
	}
	
	/**
	 * Method to search in the south-west direction starting at coordinate x, y and 
	 * moving downward and to the left. 
	 * @param x The x array position on the grid.
	 * @param y The y array position on the grid. 
	 * @param grid The 2D grid of integers to search. 
	 * @param searchLength The number of consecutive elements to search. 
	 * @return The product of the elements in the search pattern. 
	 */
	private static int checkDownLeft(int x, int y, ArrayList<ArrayList<Integer>> grid, int searchLength) {
		int product = 1;
		if(x >= searchLength -1 && y < grid.size() -1 - searchLength) {
			for(int i = 0; i < searchLength; i++) {
				product *= grid.get(y+i).get(x-i);
			}
			return product;
		}
		return product = 0;
	}

	/**
	 * A method of taking a string of integers and converting it into a 2D array. 
	 * @param input The string of numbers to be converted. 
	 * @return A 2D ArrayList matrix of integers representing the original string. 
	 */
	private static ArrayList<ArrayList<Integer>> createGrid(String input) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for(String row : splitIntoRows(input)) {
			matrix.add(stringToInt(row));
		}
		return matrix;
	}

	/**
	 * A method to split a string into rows based on line-break characters.
	 * @param input A string representing multiple lines of text. 
	 * @return An ArrayList of integers. 
	 */
	private static ArrayList<String> splitIntoRows(String input){
		ArrayList<String> matrix = new ArrayList<>();
		String[] stringArray = input.split("\\r\\n");
		for(String row : stringArray) {
			matrix.add(row);
		}
		return matrix;
	}
	
	/**
	 * A method to convert a string of numbers separated by spaces into an ArrayString 
	 * of integers. 
	 * @param input A string of numbers separated by spaces. 
	 * @return An ArrayString of integers. 
	 */
	private static ArrayList<Integer> stringToInt(String input) {
		ArrayList<Integer> intArray = new ArrayList<>();
		String[] stringArray = input.split(" ");
		for(String number : stringArray) {
			intArray.add(Integer.parseInt(number));
		}
		return intArray;		
	}
}
