import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String s = "";
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x) {
            case 1 : s = "You have chosen a square";
            break;
            case 2 : s = "You have chosen a circle";
            break;
            case 3 : s = "You have chosen a triangle";
            break;
            case 4 : s = "You have chosen a rhombus";
            break;
            default: s = "There is no such shape!";
            break;
        }
        System.out.println(s);
    }
}