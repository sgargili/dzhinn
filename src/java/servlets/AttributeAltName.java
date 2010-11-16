/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factories.FactoryDAO4Grabli;
import pojo.Attribute;
import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4AtrAlt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public class AttributeAltName extends HttpServlet {

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
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        XStream xstream = new XStream();
        xstream.alias("Attribute", Attribute.class);
        // xstream.alias("Name", String.class);
        //xstream.addImplicitCollection(AttributeAlternativeName.class, "attributeAltName");
        //xstream.aliasField("Id", AttributeAlternativeName.class, "attributeId");
        xstream.registerConverter(new XmlConvertor4AtrAlt());

        Attribute atr;
        String xml;
        List data;
        //AttributeAlternativeName atrAlt;
        int atrId, gpId;
        try {
            if (request.getParameter("attribute") == null) {
                out.println("<AltNames>");
                out.println("</AltNames>");
            } else {
                atrId = Integer.parseInt(request.getParameter("attribute"));
                gpId = Integer.parseInt(request.getParameter("groupe"));
                data = fd.getAttributeAlternativeNameDAO().getAttributeAlternativeNameByAttributeByGroupe(atrId, gpId);
//                atr = fd.getAttributeDAO().getAttributeById(atrId);
                xml = xstream.toXML(data);
                out.println(xml);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            out.println("<AltNames>");
            out.println(ex);
            out.println("</AltNames>");
        } finally {
            out.close();
        }
//        try {
//            ptList = fd.getAttributeDAO().getAllAttributesOnly();
//            xml = xstream.toXML(ptList);
//            out.println(xml);
//        } catch (Exception ex) {
//        } finally {
//            out.close();
//        }
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
