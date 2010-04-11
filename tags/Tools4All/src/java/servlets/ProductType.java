/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factories.FactoryDAO4Grabli;
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
public class ProductType extends HttpServlet {

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
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        XStream xstream = new XStream();
        xstream.alias("ProductTypes", List.class);
        xstream.alias("ProductType", pojo.ProductType.class);
        //xstream.addImplicitCollection(pojo.ProductType.class, "attributes");
        //xstream.omitField(PersistentBag.class, "initialized");
//        xstream.registerConverter(new XmlConvertor4PT());
        xstream.omitField(pojo.ProductType.class, "attributes");
        xstream.aliasField("Id", pojo.ProductType.class, "productTypeId");
        xstream.aliasField("Name", pojo.ProductType.class, "productTypeName");
        xstream.aliasField("AltName", pojo.ProductType.class, "productTypeAlternative");
        List ptList;
        String xml;
        int all;
        try {
            if (request.getParameter("all") == null) {
                all = 0;
            } else {
                all = Integer.parseInt(request.getParameter("all"));
            }
            ptList = fd.getProductTypeDAO().getAllProductTypesOnly();
            xml = xstream.toXML(ptList);
            if (all == 1) {
                xml = xml.replace("<ProductTypes>", "<ProductTypes>\n"
                        + "  <ProductType>\n"
                        + "    <Id>7777</Id>\n"
                        + "    <Name>All Product Types</Name>\n"
                        + "    <AltName></AltName>\n"
                        + "  </ProductType>");
            }
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
