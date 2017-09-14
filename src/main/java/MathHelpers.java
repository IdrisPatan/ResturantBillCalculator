import java.text.DecimalFormat;

public final class MathHelpers {

    public static double getFormattedValue(double value){
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(value));
    }

}
