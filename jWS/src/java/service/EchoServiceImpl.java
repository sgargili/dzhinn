package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EchoServiceImpl implements EchoService {

    public String echo(String name) {
        if (name == null || name.trim().length() == 0) {
            return "echo back: -please provide a name-";
        }
        SimpleDateFormat dtfmt = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
        return "echo back: name " + name + " received on " + dtfmt.format(Calendar.getInstance().getTime());
    }
}
