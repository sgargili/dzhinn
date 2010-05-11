/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import service.ValueUsers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APopov
 */
public class Service extends HttpServlet {

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
        String requestEnc = request.getCharacterEncoding();
        if (requestEnc == null) {
            requestEnc = "ISO-8859-1";
        }
        String clientEnc = request.getParameter("charset");
        if (clientEnc == null) {
            clientEnc = "cp1251";
        }
        String reqParam;
        String[] reqParams;
        try {
            if (request.getParameter("request") == null) {
                out.println("<root>No</root>");
            }
            if (request.getParameter("request").contains("valueUsers")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("valueUsers/", "");
                reqParams = reqParam.split("/");
                String id = null;
                String namePattern = null;
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("id")) {
                        id = reqParams[i].replaceFirst("id=", "");
                    }
                    if (reqParams[i].contains("name")) {
                        namePattern = new String(reqParams[i].replaceFirst("name=", "").getBytes(requestEnc), clientEnc);
                        //namePattern = reqParams[i].replaceFirst("name=", "");
                    }
                }
                ValueUsers vUsers = new ValueUsers();
                if (id != null) {
                    out.println(vUsers.getValueUserById(Long.parseLong(id)));
                } else if (namePattern != null) {
                    out.println(vUsers.getValueUsersByName(namePattern));
                } else {
                    out.println(vUsers.getValueUsers());
                }
            }
            //out.println(xml);
        } catch (Exception ex) {
//            out.println("<Owners>");
//            out.println(ex);
//            out.println("</Owners>");
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
