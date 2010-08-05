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
import service.GroupesXML;
import service.OutputDataXML;
import service.RegExpXML;
import service.SessionsXML;
import service.UnitsAltXML;
import service.UnitsXML;

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
                String attrAltId = null;
                String id = null;
                String article = null;
                String attributeValue = null;
                String attributeId = null;
                String groupeId = null;
                String groupeValue = null;
                String regexpPreview = null;
                String regexpLimit = null;
                String sessionId = null;
                String productTypeId = null;
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("attrAltId")) {
                        attrAltId = reqParams[i].replaceFirst("attrAltId=", "");
                    }
                    if (reqParams[i].contains("sessionId")) {
                        id = reqParams[i].replaceFirst("sessionId=", "");
                    }
                    if (reqParams[i].contains("article")) {
                        article = new String(reqParams[i].replaceFirst("article=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("attributeId")) {
                        attributeId = new String(reqParams[i].replaceFirst("attributeId=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("attributeValue")) {
                        attributeValue = new String(reqParams[i].replaceFirst("attributeValue=", "").getBytes(requestEnc), clientEnc).replaceFirst("\\|\\|\\|", "/");
                    }

                    if (reqParams[i].contains("regexpPreview")) {
                        regexpPreview = new String(reqParams[i].replaceFirst("regexpPreview=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("groupeId")) {
                        groupeId = new String(reqParams[i].replaceFirst("groupeId=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("groupeValue")) {
                        groupeValue = new String(reqParams[i].replaceFirst("groupeValue=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("regexpLimit")) {
                        regexpLimit = new String(reqParams[i].replaceFirst("regexpLimit=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("session")) {
                        sessionId = new String(reqParams[i].replaceFirst("session=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("productTypeId")) {
                        productTypeId = new String(reqParams[i].replaceFirst("productTypeId=", "").getBytes(requestEnc), clientEnc);
                    }
                }
                //System.out.println("Before: --->>> " + attributeId + " ||| " + attributeValue);
                OutputDataXML odXML = new OutputDataXML();
                if (attrAltId != null) {
                    out.println(odXML.getOutputDataByAttributeAltIdAfter(productTypeId, attrAltId, groupeId, attributeId, regexpLimit));
                } else if (id != null) {
                    out.println(odXML.getOutputDataBySessionId(Long.parseLong(id)));
                } else if (article != null) {
                    out.println(odXML.getOutputDataByArticle(article));
                } else if (regexpPreview.equals("before")) {
                    if (attributeValue != null) {
                        out.println(odXML.getOutputDataByGroupeByAttributeBySessionId(groupeValue, attributeValue, sessionId, regexpLimit));
                    }
                } else if (regexpPreview.equals("after")) {
                    if (attributeValue != null) {
                        out.println(odXML.getOutputDataByAttributeAfter(groupeId, groupeValue, attributeId, attributeValue, regexpLimit));
                    }
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
                } else if (pt != null) {
                    out.println(attXML.getAttributesByPtName(pt));
                } else {
                    out.println(attXML.getAllAttributes());
                }
            } else if (request.getParameter("request").contains("units")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("units/", "");
                reqParams = reqParam.split("/");
                //String id = null;
                String unitName = null;
                for (int i = 0; i < reqParams.length; i++) {
//                    if (reqParams[i].contains("unitId")) {
//                        id = reqParams[i].replaceFirst("unitId=", "");
//                    }
                    if (reqParams[i].contains("unitName")) {
                        unitName = new String(reqParams[i].replaceFirst("unitName=", "").getBytes(requestEnc), clientEnc);
                    }

                }
                UnitsXML unitXML = new UnitsXML();
                if (unitName != null && !unitName.equals("")) {
                    out.println(unitXML.getUnitsPtName(unitName));
                } else {
                    out.println(unitXML.getAllUnits());
                }
            } else if (request.getParameter("request").contains("unitAlt")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("unitsAlt/", "");
                reqParams = reqParam.split("/");
                //String id = null;
                String unitId = null;
                for (int i = 0; i < reqParams.length; i++) {
//                    if (reqParams[i].contains("unitId")) {
//                        id = reqParams[i].replaceFirst("unitId=", "");
//                    }
                    if (reqParams[i].contains("unitId")) {
                        unitId = new String(reqParams[i].replaceFirst("unitId=", "").getBytes(requestEnc), clientEnc);
                    }

                }
                UnitsAltXML unitAltXML = new UnitsAltXML();
                if (unitId != null && !unitId.equals("")) {
                    out.println(unitAltXML.getUnitAlternativeNamesByUnitId(Integer.parseInt(unitId)));
                } else {
                    out.println(unitAltXML.getAllUnitAlternativeNames());
                }
            } else if (request.getParameter("request").contains("groupes")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("groupes/", "");
                //System.out.println(reqParam);
                reqParams = reqParam.split("/");
                String id = "";
                String pt = "";
                String template = "";
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("ptId")) {
                        id = reqParams[i].replaceFirst("ptId=", "");
                        if (id.equals("7777")) {
                            id = "0";
                        }
//                        System.out.println(id);
                    }
                    if (reqParams[i].contains("productType")) {
                        pt = new String(reqParams[i].replaceFirst("productType=", "").getBytes(requestEnc), clientEnc);
                    }
                    if (reqParams[i].contains("template")) {
//                        template = new String(reqParams[i].replaceFirst("template=", "").getBytes(requestEnc), clientEnc);
                        template = reqParams[i].replaceFirst("template=", "");
                    }

                }
                GroupesXML gpXML = new GroupesXML();
//                System.out.println(id+" ---------------->>>>>> ID");
                if (!template.equals("")) {
//                    System.out.println(template + "--->>> Template");
                    out.println(gpXML.getGroupesByTemplate(template));
                } else if (id != null && !id.equals("0")) {
//                    System.out.println(id + "--->>> ID");
                    out.println(gpXML.getGroupesByPtId(Integer.parseInt(id)));
                } else if (pt != null) {
//                    System.out.println("PTNAME--->>> ID");
                    out.println(gpXML.getGroupesByPtName(pt));
                } else {
//                    System.out.println("All--->>> ID");
                    out.println(gpXML.getAllGroupes());
                }
            } else if (request.getParameter("request").contains("attrs")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("attrs/", "");
                reqParams = reqParam.split("/");
                String id = null;
                String grp = null;
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("grpId")) {
                        id = reqParams[i].replaceFirst("grpId=", "");
                    }
                    if (reqParams[i].contains("groupe")) {
                        grp = new String(reqParams[i].replaceFirst("groupe=", "").getBytes(requestEnc), clientEnc);
                    }

                }
                AttributesXML attXML = new AttributesXML();
                if (id != null) {
                    out.println(attXML.getAttributesWithCompositeByGroupeId(Integer.parseInt(id)));
                } else if (grp != null) {
                    out.println(attXML.getAttributesByGroupeName(grp));
                } else {
                    out.println(attXML.getAllAttributes());
                }
            } else if (request.getParameter("request").contains("regexp")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("regexp/", "");
                reqParams = reqParam.split("/");
//                String regexpPattern = null;
//                String regexpType = null;
//                String regexpValue = "";
//                String prefix = "";
//                String suffix = "";
//                String replacement = "";
                String attrAltId = "";
                String attributeId = "";
                String groupeId = "";
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("attributeId")) {
                        attributeId = reqParams[i].replaceFirst("attributeId=", "");
                    }
                    if (reqParams[i].contains("groupeId")) {
                        groupeId = reqParams[i].replaceFirst("groupeId=", "");
                    }
                    if (reqParams[i].contains("attrAltId")) {
                        attrAltId = reqParams[i].replaceFirst("attrAltId=", "");
                    }
//                    if (reqParams[i].contains("regexpType")) {
//                        regexpType = new String(reqParams[i].replaceFirst("regexpType=", "").getBytes(requestEnc), clientEnc);
//                    }
//                    if (reqParams[i].contains("regexpValue")) {
//                        regexpValue = new String(reqParams[i].replaceFirst("regexpValue=", "").getBytes(requestEnc), clientEnc);
//                    }
////                    if (reqParams[i].contains("prefix")) {
////                        prefix = new String(reqParams[i].replaceFirst("prefix=", "").getBytes(requestEnc), clientEnc);
////                    }
////                    if (reqParams[i].contains("suffix")) {
////                        suffix = new String(reqParams[i].replaceFirst("suffix=", "").getBytes(requestEnc), clientEnc);
////                    }
//                    if (reqParams[i].contains("replacement")) {
//                        replacement = new String(reqParams[i].replaceFirst("replacement=", "").getBytes(requestEnc), clientEnc);
//                    }

                }
                RegExpXML regXML = new RegExpXML();
//                response.setContentType("text/html;charset=UTF-8");
                if (attributeId != null
                        && !attributeId.equals("")
                        && groupeId != null
                        && !groupeId.equals("")) {

                    out.println(regXML.getRegexpsByAttributeIdByGroupeId(Integer.parseInt(attributeId), Integer.parseInt(groupeId)));

                } else {
                    out.println(regXML.getRegexpsByAttrAltId(Integer.parseInt(attrAltId)));
                }
            } else if (request.getParameter("request").contains("sessions")) {
                reqParam = request.getParameter("request");
                reqParam = reqParam.replaceFirst("sessions/", "");
                reqParams = reqParam.split("/");
                String article = "";
//                String regexpType = null;
//                String regexpValue = "";
//                String prefix = "";
//                String suffix = "";
//                String replacement = "";
                for (int i = 0; i < reqParams.length; i++) {
                    if (reqParams[i].contains("article")) {
                        article = reqParams[i].replaceFirst("article=", "");
                    }
                }
                SessionsXML sesXML = new SessionsXML();
//                response.setContentType("text/html;charset=UTF-8");
                out.println(sesXML.getSessionsXML(article));
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
