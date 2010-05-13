/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import service.ValueUsersXML;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AttributesXML;
import service.OutputDataXML;

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
                ValueUsersXML vUsers = new ValueUsersXML();
                if (id != null) {
                    out.println(vUsers.getValueUserById(Long.parseLong(id)));
                } else if (namePattern != null) {
                    out.println(vUsers.getValueUsersByName(namePattern));
                } else {
                    out.println(vUsers.getValueUsers());
                }
            } else if (request.getParameter("request").contains("outputData")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("outputData/", "");
                reqParams = reqParam.split("/");
                String id = null;
                String article = null;
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("sessionId")) {
                        id = reqParams[i].replaceFirst("sessionId=", "");
                    }
                    if (reqParams[i].contains("article")) {
                        article = new String(reqParams[i].replaceFirst("article=", "").getBytes(requestEnc), clientEnc);
                    }
                }
                OutputDataXML odXML = new OutputDataXML();
                if (id != null) {
                    out.println(odXML.getOutputDataBySessionId(Long.parseLong(id)));
                } else if (article != null) {
                    out.println(odXML.getOutputDataByArticle(article));
                } else {

                    out.println(odXML.getAllOutputData());
                }
            } else if (request.getParameter("request").contains("attributes")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("attributes/", "");
                reqParams = reqParam.split("/");
                String id = null;
                String pt = null;
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("ptId")) {
                        id = reqParams[i].replaceFirst("ptId=", "");
                    }
                    if (reqParams[i].contains("productType")) {
                        pt = new String(reqParams[i].replaceFirst("productType=", "").getBytes(requestEnc), clientEnc);
                    }

                }
                AttributesXML attXML = new AttributesXML();
                if (id != null) {
                    out.println(attXML.getAttributesByPtId(Integer.parseInt(id)));
                }else if (pt != null) {
                    out.println(attXML.getAttributesByPtName(pt));
                } else {
                    out.println(attXML.getAllAttributes());
                }
            }
            //out.println(xml);
        } catch (Exception ex) {
            out.println(ex);
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
