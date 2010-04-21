/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factories.FactoryDAO4Grabli;
import pojo.ProductType;
import com.thoughtworks.xstream.XStream;
import csv.CsvReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.GrabliCsvData;

/**
 *
 * @author APopov
 */
public class GrabliCsvColumnData extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        XStream xstream = new XStream();
        xstream.alias("CsvData", List.class);
        xstream.alias("Csv", pojo.GrabliCsvData.class);
        Map map = new HashMap();
        map.put(1, "Article");
        map.put(2, "Description");
        map.put(3, "Product Type");
        map.put(4, "Url");
        String xml;

        try {
            xml = xstream.toXML(map);
            out.println(xml);
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
