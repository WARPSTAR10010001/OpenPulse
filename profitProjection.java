//Boo!!

import java.util.Scanner;

public class profitProjection {
    static Scanner scanner = new Scanner(System.in);            
    public static void main(){
        Main.headline("Profit Projection");

        System.out.print("Enter Initial Capital: ");
        double initialCapital = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Months: ");
        int months = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        scanner.nextLine();

        double monthlyInterestRate = Math.pow((1 + annualInterestRate), (1./12. - 1));
        double finalCapital = initialCapital * Math.pow((1 + monthlyInterestRate), months);
        double profit = finalCapital - initialCapital;

        System.out.println("\nFinal Capital: " + finalCapital);
        if(profit > 0){
            System.out.println("Profit: " + profit);
        } else if (profit < 0) {
            System.out.println("Loss: " + profit);
        } else {
            System.out.println("No Profits/Losses were made.");
        }

        System.out.print("\nContinue? [1/0]: ");
        int selection = scanner.nextInt();

        switch (selection){
            case 0 -> Main.exit(false, 0);
            case 1 -> Main.menu();
            default -> Main.exit(true, 1);
        }
    }
}