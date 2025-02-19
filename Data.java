//Boo!!

public class Data {
    private static final String[] START = new String[3];
    private static final String[] MENU = new String[5];
    private static final String[] SETTINGS = new String[2];
    private static boolean marginEdited = false;
    private static double margin = 1.;

    public static void init(){
        START[0] = "Main Menu";
        START[1] = "Settings";
        START[2] = "Exit";

        MENU[0] = "Average Projection";
        MENU[1] = "Monthly Savingsplan";
        MENU[2] = "Owned Shares";
        MENU[3] = "";
        MENU[4] = "Back to Start";

        SETTINGS[0] = "Edit Margin";
        SETTINGS[1] = "Back to Start";
    }

    public static String[] getSTART(){
        return START;
    }

    public static String[] getMENU(){
        return MENU;
    }

    public static String[] getSETTINGS(){
        return SETTINGS;
    }

    public static boolean getMarginEdited(){
        return marginEdited;
    }

    public static void setMarginEdited(boolean x){
        marginEdited = x;
    }

    public static double getMargin(){
        return margin;
    }

    public static void setMargin(double x){
        margin = x;
    }
}