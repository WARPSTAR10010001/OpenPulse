//Boo!!

public class Data {
    private static final String[] startSelection = new String[3];
    private static final String[] menuSelection = new String[5];
    private static boolean marginEdited = false;
    private static double margin = 1.;

    public static void init(){
        startSelection[0] = "Start";
        startSelection[1] = "Settings";
        startSelection[2] = "Exit";

        menuSelection[0] = "Average Projection";
        menuSelection[1] = "Monthly Savingsplan";
        menuSelection[2] = "Owned Shares";
        menuSelection[3] = "Back to Start";
        menuSelection[4] = "Exit";
    }

    public static String[] getStartSelection(){
        return startSelection;
    }

    private static String[] getMenuSelection(){
        return menuSelection;
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