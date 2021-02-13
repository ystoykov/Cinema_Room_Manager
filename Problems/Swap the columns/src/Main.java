import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        for (int[] ex : arr) {
            int temp = ex[i];
            ex[i] = ex[j];
            ex[j] = temp;
        }
        for (int[] ex:arr) {
            for (int b: ex) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}