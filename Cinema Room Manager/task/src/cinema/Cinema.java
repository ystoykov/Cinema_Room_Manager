package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int y = scanner.nextInt();
        String[][] cinema = newCinema(x, y);
        while (true) {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                printSeat(cinema);
            } else if (choice == 2) {
                while (true){
                    System.out.println("\nEnter a row number:");
                    int r = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int s = scanner.nextInt();
                    if ((r < 0 && s < 0) || r > cinema.length || s > cinema[0].length) {
                        System.out.println("\nWrong input!");
                    } else if ("B".equals(cinema[r - 1][s - 1])) {
                        System.out.println("\nThat ticket has already been purchased!");
                    } else {
                        System.out.println("Ticket price: $" + tiketPrice(cinema, r));
                        reserveSeat(cinema, r, s);
                        break;
                    }
                }
            } else if (choice == 3) {
                statistics(cinema);
            } else if (choice == 0) {
                break;
            }
        }

    }
    public static void printSeat(String[][] array) {
        String[][] newArray = array;
        int[] seats = new int[newArray[0].length];
        int count = 1;
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int x:seats) {
            x = count;
            System.out.print(" " + x);
            count++;
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < newArray[0].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    public static String[][] newCinema(int x, int y) {
        String[][] newCinema = new String[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newCinema[i][j] = "S";
            }
        }
        return newCinema;
    }
    public static void reserveSeat(String[][] cinema, int x, int y) {
        cinema[x - 1][y - 1] = "B";
    }
    public static int tiketPrice(String[][] cinema, int row) {
        int price = 10;
        int totalSeats = cinema.length * cinema[0].length;
        int frontHalf = cinema.length / 2;
        if (totalSeats > 60 && row > frontHalf) {
            price = 8;
        }
        return price;
    }
    public static void statistics(String[][] cinema) {
        int totalSeats = cinema.length * cinema[0].length;
        int numberOfPurchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (String[] str:cinema) {
            for (String s:str) {
                if ("B".equals(s)){
                    numberOfPurchasedTickets++;
                }
            }
        }
        if (totalSeats <= 60) {
            currentIncome = numberOfPurchasedTickets * 10;
            totalIncome = totalSeats * 10;
        } else {
            int count = 0;
            int firstHalfSeats = 0;
            int firstHalf = cinema.length / 2;
            for (int i = 0; i < firstHalf; i++) {
                for (int j = 0; j < cinema[0].length; j++) {
                    if ("B".equals(cinema[i][j])) {
                        count++;
                    }
                    firstHalfSeats++;
                }
            }
            currentIncome = count * 10 + (numberOfPurchasedTickets - count) * 8;
            totalIncome = firstHalfSeats * 10 + (totalSeats - firstHalfSeats) * 8;
        }
        double percentageOfPurchasedTickets = (double) numberOfPurchasedTickets / totalSeats * 100;
        System.out.printf("Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n", numberOfPurchasedTickets, percentageOfPurchasedTickets, currentIncome, totalIncome);
    }
}