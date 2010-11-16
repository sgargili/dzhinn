/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factories.FactoryDAO4Grabli;
import pojo.ProductType;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APopov
 */
public class Attribute extends HttpServlet {

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
        xstream.alias("Attributes", List.class);
        xstream.alias("Attribute", pojo.Attribute.class);
        xstream.aliasField("Id", pojo.Attribute.class, "attributeId");
        xstream.aliasField("Name", pojo.Attribute.class, "attributeName");
        xstream.aliasField("AltName", pojo.Attribute.class, "attributeAlternative");
        //xstream.addImplicitCollection(pojo.ProductType.class, "attributes");
        xstream.omitField(pojo.Attribute.class, "values");
        xstream.omitField(pojo.Attribute.class, "attributeAlternativeNames");
        xstream.omitField(pojo.Attribute.class, "productTypes");
        //xstream.registerConverter(new XmlConvertor4Attributes());
        List atrList;
        String template = "";
        String xml;
        int id;
        ProductType pt;
        try {
            if (request.getParameter("ptId") == null) {
                id = 0;
            } else {
                id = Integer.parseInt(request.getParameter("ptId"));
                if (id == 7777) {
                    id = 0;
                }
            }
            if (request.getParameter("template") != null) {
                template = new String(request.getParameter("template").getBytes(requestEnc), clientEnc);
                System.out.println(template);
            }
            if (!template.equals("")) {
                atrList = fd.getAttributeDAO().getAttributesOnlyByTemplate(template);
            } else {
                if (id != 0) {
                    pt = new ProductType();
                    pt.setProductTypeId(id);
                    atrList = fd.getAttributeDAO().getAttributesOnlyByProductType(pt);
                } else {
                    atrList = fd.getAttributeDAO().getAllAttributesOnly();
                }
            }
            xml = xstream.toXML(atrList);
            out.println(xml);
        } catch (Exception ex) {
            out.println("<Attributes>");
            out.println(ex);
            out.println("</Attributes>");
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
