import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String temp = "";
        String finalString = "";
        int dim = -1;

        while (!temp.equals("end")) {
            finalString = finalString + temp + " ";
            temp = scanner.nextLine();
            dim++;
        }

        scanner.close();
        scanner = new Scanner(finalString);
        int count = 0;

        while (scanner.hasNextInt()) {
            scanner.nextInt();
            count++;
        }

        scanner.close();
        int column = count / dim;
        int[][] inArray = new int[dim][column];
        scanner = new Scanner(finalString);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                inArray[i][j] = scanner.nextInt();
            }
        }

        int[][] outArray = new int[dim][column];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                int left = j - 1;
                int top = i - 1;
                int right = j + 1;
                int bot = i + 1;
                if (i == 0) {
                    top = dim - 1;
                }
                if (i == dim - 1) {
                    bot = 0;
                }
                if (j == 0) {
                    left = column - 1;
                }
                if (j == column - 1) {
                    right = 0;
                }
                outArray[i][j] =
                        inArray[i][left] + inArray[i][right] + inArray[top][j] + inArray[bot][j];
            }
        }
        scanner.close();

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(outArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
