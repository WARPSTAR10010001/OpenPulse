//Boo!!

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String NAME = "OpenPulse";
    static final String BUILD = "0005";
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

        for(int i = 0; i < Data.getSTART().length; i++){
            System.out.println("[" + (i + 1) + "]: " + Data.getSTART()[i]);
        }
        System.out.print("\nSelection [Range: 1-" + Data.getSTART().length + "]: ");
        int selection = (scanner.nextInt() - 1);
        scanner.nextLine();
        if(selection > (Data.getSTART().length - 1) || selection < 0){
            exit(true, 3);
        }
        switch (selection){
            case 0 -> menu();
            case 1 -> settings();
            case 2 -> exit(false, 0);
            default -> exit(true, 3);
        }
    }

    public static void menu(){
        headline("Main Menu");

        for(int i = 0; i < Data.getMENU().length; i++){
            System.out.println("[" + (i + 1) + "]: " + Data.getMENU()[i]);
        }
        System.out.print("\nSelection [Range: 1-" + Data.getMENU().length + "]: ");
        int selection = (scanner.nextInt() - 1);
        scanner.nextLine();
        if(selection > (Data.getMENU().length - 1) || selection < 0){
            exit(true, 3);
        }
        switch (selection){
            case 0 -> profitProjection.main();
            case 1 -> {}
            case 2 -> {}
            case 3 -> {}
            case 4 -> start();
            default -> exit(true, 3);
        }
    }

    public static void settings(){
        headline("Settings");

        for(int i = 0; i < Data.getSETTINGS().length; i++){
            System.out.println("[" + (i + 1) + "]: " + Data.getSETTINGS()[i]);
        }
        System.out.print("\nSelection [Range: 1-" + Data.getSETTINGS().length + "]: ");
        int selection = (scanner.nextInt() - 1);
        scanner.nextLine();
        if(selection > (Data.getSETTINGS().length - 1) || selection < 0){
            exit(true, 3);
        }
        switch (selection){
            case 0 -> {
                System.out.print("\nEnter Margin [Current: ±" + Data.getMargin() + "% / Range: ±[1-15]%]: ");
                double margin = Math.abs(scanner.nextDouble());
                if(margin > 15 || margin < 1){
                    exit(true, 3);
                }
                Data.setMargin(margin);
                Data.setMarginEdited(true);
                settings();
            }
            case 1 -> start();
            default -> exit(true, 3);
        }
    }

    public static String centered(String item, char sym) {
        if(LENGTH - 4 < item.length()){
            exit(true, 0);
        }
        int totalPadding = LENGTH - item.length() - 2;
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
        System.out.println("\n" + centered(item, CHARACTER) + "\n");
    }

    public static void exit(boolean isError, int exitCode){
        if(isError){
            String msg = "\nERROR: ";
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
            headline("End");
            System.exit(0);
        }
    }
}