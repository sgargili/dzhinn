/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tor;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author APopov
 */
public class IpChange {

    public boolean setChange() {
        try {
            Socket socket = new Socket("127.0.0.1", 7751);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            os.write("authenticate\r\n".getBytes());
            os.flush();
            os.write("signal newnym\r\n".getBytes());
            os.flush();
            os.flush();
            is.close();
            os.close();
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
}