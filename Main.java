//Boo!!

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String NAME = "OpenPulse";
    static final String BUILD = "0001";
    static final String DIVIDER = "\n--------------------------------------------\n";

    public static void main(String[] args) {
        System.out.print("+++++++++++++ " + NAME + " [" + BUILD + "]" + " +++++++++++++");
        System.out.println(DIVIDER);
        start();
    }

    public static void start(){
        System.out.print("Edit settings? [1/0]: ");
        switch (scanner.nextInt()){
            case 0 -> {}
            case 1 -> settings();
            default -> exit(true, 1);
        }
        //...
    }

    public static void settings(){
        //...
    }

    public static void exit(boolean isError, int exitCode){
        if(isError){
            String msg = "\nError: ";
            switch (exitCode){
                case 0 -> msg += "Forced session termination";
                case 1 -> msg += "Invalid selection";
                case 2 -> msg += "Input mismatch";
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