import java.util.Arrays;
import java.util.Scanner;

public class KnightsTour {
    private static int N; // Size of the chessboard

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the chessboard: ");
        N = scanner.nextInt();

        System.out.print("Enter the starting row for the knight: ");
        int startX = scanner.nextInt();

        System.out.print("Enter the starting column for the knight: ");
        int startY = scanner.nextInt();

        solveKnightsTour(startX, startY);
    }

    public static void solveKnightsTour(int startX, int startY) {
        int[][] chessboard = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(chessboard[i], -1);
        }

        int moveNumber = 0;

        if (solve(chessboard, startX, startY, moveNumber)) {
            printSolution(chessboard);
        } else {
            System.out.println("No solution exists");
        }
    }
    

    public static boolean solve(int[][] chessboard, int row, int col, int moveNumber) {
        if (moveNumber == N * N) {
            return true; // All squares visited
        }

        if (isSafe(chessboard, row, col)) {
            chessboard[row][col] = moveNumber;

            int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
            int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

            for (int i = 0; i < 8; i++) {
                int newRow = row + rowMoves[i];
                int newCol = col + colMoves[i];

                if (solve(chessboard, newRow, newCol, moveNumber + 1)) {
                    return true;
                }
            }

            // Backtrack
            chessboard[row][col] = -1;
        }

        return false;
    }

    public static boolean isSafe(int[][] chessboard, int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < N && chessboard[row][col] == -1);
    }

    public static void printSolution(int[][] chessboard) {
        System.out.println("Knight's Tour Solution:");
        for (int[] row : chessboard) {
            for (int move : row) {
                System.out.printf("%2d ", move);
            }
            System.out.println();
        }
    }
}
