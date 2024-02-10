package samuelfsd.com.br.myexpenses.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertData {
    public static String convertDateTime(Date date){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

        return formatDate.format(date);
    }
}
