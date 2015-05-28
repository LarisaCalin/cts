package ro.ase.csie.cts.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Utils {

    public static  String formatDate(Date date){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            StringBuilder sb = new StringBuilder();
            sb.append(calendar.get(Calendar.DAY_OF_MONTH)+" "+(calendar.get(Calendar.MONTH)+1)+" "+calendar.get(Calendar.YEAR));
            return sb.toString();
    }

    public static Date convertStringToDate(String stringDate){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = df.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public  static String convertDateToString(Date date){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = df.format(date);
        return dateString;
    }

    public static BigDecimal truncateDecimal(double x,int numberofDecimals)
    {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }
}
