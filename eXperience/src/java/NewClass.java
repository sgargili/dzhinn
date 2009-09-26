
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] aaa) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(true);
        Date date = new java.util.Date();
        String formattedDate = df.format(date);
        System.out.println(formattedDate);
    }
}
