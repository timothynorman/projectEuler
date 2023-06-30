/*
    Strategy is to create a 2D array showing the number of pathways into each node.
    The number of pathways into each node is a sum of the nodes that can enter it.
    Therefore, in this example where you can only enter a node from above or the left, the number of paths
    into a node is the sum of the node above and to the left of the node in question.
    Refer to: https://www.robertdickau.com/lattices.html for details on approach.
 */
package ca.timnorman.projectEuler;

public class Question15 {
    public static void main(String[] args) {

        final int ROW_LENGTH = 20;
        final int COLUMN_LENGTH = 20;

        long[][] latticeArray = new long[ROW_LENGTH + 1][COLUMN_LENGTH + 1];

        // Populating the array
        for (int i = 0; i <= ROW_LENGTH; i++){
            for (int j = 0; j <= COLUMN_LENGTH; j++){
                // Top row MUST have only one path into each node.
                if (j < 1){
                    latticeArray[i][j] = 1;
                }
                // Left column MUST have only one path into each node.
                else if (i < 1) {
                    latticeArray[i][j] = 1;
                }
                // Paths into node is sum of nodes above and left of the node.
                else {
                    latticeArray[i][j] = latticeArray[i-1][j] + latticeArray[i][j-1];
                }
            }
        }

        System.out.printf("The total ways to navigate a %d by %d lattice path is: %,15d %n%n", ROW_LENGTH, COLUMN_LENGTH, latticeArray[ROW_LENGTH][COLUMN_LENGTH]);

        // Print a formatted table of each node in the lattice pathway showing the number of paths into that node (demonstration purposes only).
        for (long[] row : latticeArray){
            for (long column : row){
                System.out.printf("%,15d ", column);
            }
            System.out.println();
        }
    }
}
