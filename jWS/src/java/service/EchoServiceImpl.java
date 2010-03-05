package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String name) {
        if (name == null || name.trim().length() == 0) {
            return "echo back: -please provide a name-";
        }
        SimpleDateFormat dtfmt = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
        return "Привет, " + name + "! Ты послал сообщение в " + dtfmt.format(Calendar.getInstance().getTime());
    }
}
