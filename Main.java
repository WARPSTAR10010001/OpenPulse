//Boo!!

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String NAME = "OpenPulse";
    static final String BUILD = "0003";
    static final String DIVIDER = "\n----------------------------------------------------------------------\n";
    static final int LENGTH = 70;
    static final char CHARACTER = '+';

    public static void main(String[] args) {
        System.out.print("++++++++++++++++++++++++++ " + NAME + " [" + BUILD + "]" + " ++++++++++++++++++++++++++");
        System.out.print(DIVIDER);
        Data.init();
        start();
    }

    public static void start(){
        headline("Start");

        for(int i = 0; i < Data.getStartSelection().length; i++){
            System.out.println("[" + (i + 1) + "]: " + Data.getStartSelection()[i]);
        }
        int selection = (scanner.nextInt() - 1);
        scanner.nextLine();
        if(selection > 3 || selection < 1){
            exit(true, 2);
        }
        
    }

    public static void menu(){
        headline("Menu");

    }

    public static void settings(){
        headline("Settings");

        System.out.print("Edit Margin? [1/0]: ");
        int selection = scanner.nextInt();
        switch (selection){
            case 0 -> {}
            case 1 -> {
                System.out.print("     Enter Margin [Current: ±" + Data.getMargin() + "% / Range: 1-15]: ");
                double margin = scanner.nextDouble();
                scanner.nextLine();
                if(margin > 15 || margin < 1){
                    exit(true, 3);
                }
                Data.setMargin(margin);
                Data.setMarginEdited(true);
            }
            default -> exit(true, 1);
        }
        //...
    }

    public static String centered(String item, char sym) {
        if(LENGTH - 4 < item.length()){
            exit(true, 0);
        }
        int totalPadding = LENGTH - item.length() - 2;
    
        if (totalPadding <= 0) {
            return " " + item + " ";
        }
        int firstHalf = totalPadding / 2;
        int secondHalf = totalPadding - firstHalf;
        String output = "";
        for (int i = 0; i < firstHalf; i++) {
            output += sym;
        }
        output += " " + item + " ";
        for (int i = 0; i < secondHalf; i++) {
            output += sym;
        }
        return output;
    }

    public static void headline(String item){
        System.out.println("\n" + centered(item, CHARACTER));
    }

    public static void exit(boolean isError, int exitCode){
        if(isError){
            String msg = "\nError: ";
            switch (exitCode){
                case 0 -> msg += "Forced session termination";
                case 1 -> msg += "Invalid selection";
                case 2 -> msg += "Input mismatch";
                case 3 -> msg += "Input out of range";
                default -> msg += "Internal Conflict";
            }
            msg += ".";
            System.out.println(msg);
            System.exit(exitCode);
        } else {
            System.out.println("\nSession terminated.");
            System.exit(0);
        }
    }
}