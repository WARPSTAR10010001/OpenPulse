//Boo!!

public class Settings {
    private static boolean marginEdited = false;
    private static double margin = 1.;

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