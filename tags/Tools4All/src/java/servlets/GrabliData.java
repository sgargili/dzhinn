/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pojo.ProductType;
import com.thoughtworks.xstream.XStream;
import csv.CsvReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.GrabliCsvData;

/**
 *
 * @author APopov
 */
public class GrabliData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        String requestEnc = request.getCharacterEncoding();
        if (requestEnc == null) {
            requestEnc = "ISO-8859-1";
        }
        String clientEnc = request.getParameter("charset");
        if (clientEnc == null) {
            clientEnc = "utf-8";
        }
        PrintWriter out = response.getWriter();

        CsvReader reader = null;


        XStream xstream = new XStream();
        xstream.alias("CsvData", List.class);
        xstream.alias("Csv", pojo.GrabliCsvData.class);
        List<GrabliCsvData> csvs = new ArrayList();
        String template = "";
        GrabliCsvData csv;
        File file;
        String xml;
        long id;
        ProductType pt;
        int i = 1;
        try {
            if (request.getParameter("fileId") == null) {
                id = 0;
            } else {
                id = Long.parseLong(request.getParameter("fileId"));
                if (id == 7777) {
                    id = 0;
                }
            }
            file = new File("/root/tempFolder/" + id + ".csv");
            try {
                reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            while (reader.readRecord()) {
                if (i++ == 8) {
                    break;
                }
                //String newString = new String(oldString.getBytes("UTF-8"), "Cp1251");
                csv = new GrabliCsvData();
                csv.setArticle(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"));
                csv.setDescription(new String(reader.get(1).getBytes("Cp1251"), "UTF-8"));
                csv.setPt(new String(reader.get(2).getBytes("Cp1251"), "UTF-8"));
                csv.setUrl(new String(reader.get(3).getBytes("Cp1251"), "UTF-8"));
                csvs.add(csv);
            }
            reader.close();

            xml = xstream.toXML(csvs);
            out.println(xml);
           // file.delete();
        } catch (Exception ex) {
            out.println("<CsvData>");
            out.println(ex);
            out.println("</CsvData>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
