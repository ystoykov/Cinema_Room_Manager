import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sizeArray = Integer.parseInt(scanner.nextLine());
        String numbers = scanner.nextLine();
        String findNumbers = scanner.nextLine();

        String[] strNumber = numbers.trim().split(" ");
        String[] strFindNumber = findNumbers.trim().split(" ");

        int[] number = Arrays.stream(strNumber).mapToInt(Integer::parseInt).toArray();
        boolean result = false;
        int n = Integer.parseInt(strFindNumber[0]);
        int m = Integer.parseInt(strFindNumber[1]);
        for (int i = 1; i < sizeArray; i++) {
            boolean first = number[i] == m && number[i - 1] == n;
            boolean second = number[i] == n && number[i - 1] == m;
            if (first || second) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}