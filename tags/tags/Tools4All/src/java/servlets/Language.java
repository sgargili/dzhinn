/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factories.FactoryDAO4Grabli;
import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4PT;
import factories.FactoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.ValueLanguage;

/**
 *
 * @author APopov
 */
public class Language extends HttpServlet {

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
        FactoryDAO fd = FactoryDAO.getInstance();
        XStream xstream = new XStream();
        xstream.alias("Languages", List.class);
        xstream.alias("Language", ValueLanguage.class);
        //xstream.addImplicitCollection(pojo.ProductType.class, "attributes");
        xstream.omitField(ValueLanguage.class, "id");
        xstream.aliasField("Name", ValueLanguage.class, "name");
        xstream.aliasField("Description", ValueLanguage.class, "description");
        //xstream.registerConverter(new XmlConvertor4PT());
        List lgList;
        String xml;
        try {
            lgList = fd.getValueLanguageDAO().getAllValueLanguages();
            xml = xstream.toXML(lgList);
            out.println(xml);
        } catch (Exception ex) {
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
