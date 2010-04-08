/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.FactoryDAO;
import pojo.ValueUser;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APopov
 */
public class ValueUsers extends HttpServlet {

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
        xstream.alias("Owners", List.class);
        xstream.alias("Owner", ValueUser.class);
        xstream.aliasField("Id", ValueUser.class, "id");
        xstream.aliasField("Name", ValueUser.class, "name");
        List vUsersList = new ArrayList();
        ValueUser vu;
        String xml;
        String id;
        try {
            if (request.getParameter("userId") == null) {
                id = "";
            } else {
                id = request.getParameter("userId");
            }
            if (!id.equals("")) {
                vu = fd.getValueUserDAO().getValueUserById(Long.parseLong(id));
                if (vu != null) {
                    vUsersList.add(vu);
                }
            } else {
                vUsersList = fd.getValueUserDAO().getAllValueUsers();
            }
            xml = xstream.toXML(vUsersList);
            out.println(xml);
        } catch (Exception ex) {
            out.println("<Owners>");
            out.println(ex);
            out.println("</Owners>");
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
