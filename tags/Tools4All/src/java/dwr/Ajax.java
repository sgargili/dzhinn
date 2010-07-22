/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dwr;

/**
 *
 * @author APopov
 */
import factories.FactoryDAO;
import factories.FactoryDAO4Grabli;
import grabli.GrabliPro;
import xml.XmlPro;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import org.directwebremoting.Browser;
import pojo.ChatLogs;
import pojo.IpCount;
import pojo.Users;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.ui.dwr.Util;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.io.FileTransfer;
import pojo.Attribute;
import pojo.AttributeAlternativeName;
import pojo.Groupe;
import pojo.OutputData;
import pojo.ProductType;
import pojo.Regexp;
import pojo.Unit;
import pojo.UnitAlternativeName;
import processing.MergingProcessing;
import value4it.MatchingData;
import value4it.ValuePro;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Ajax {

    /**
     * @param text The new message text to add
     */
    XmlPro xmlp = new XmlPro();
    ChatLogs chLog;
    String[] strMas;
    Users user;
    int j;
    private static Map<String, IpCount> ipMap = new HashMap();
    IpCount ipCount = new IpCount();
    int count;

    public void test() {
        //ipCount.setCountAll(10);
        ScriptSession ss;
        ScriptBuffer script;
        for (int t = 0; t < 10; t++) {
            //count = t;
            //ipCount.setCount(count);
            //ipMap.put(WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), ipCount);
            ss = WebContextFactory.get().getScriptSession();
            script = new ScriptBuffer();
            try {
                script.appendScript("update(");
                script.appendData(9);
                script.appendScript(",");
                script.appendData(t);
                script.appendScript(");");
                ss.addScript(script);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
        // ipCount.setCount(0);
        //ipCount.setCountAll(0);
        //ipMap.put(WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), ipCount);
    }

    public void addMessage(String text) {
        String ip = WebContextFactory.get().getHttpServletRequest().getRemoteAddr();
        if (!text.equals("Введите ник...: ")) {
            // Make sure we have a list of the list 30 messages
            try {
                strMas = text.split(":\\s");
                chLog = new ChatLogs(ip, strMas[0], strMas[1]);
                FactoryDAO.getInstance().getChatLogsDAO().addChatLogs(chLog);
                user = FactoryDAO.getInstance().getUsersDAO().getUserByIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                if (user != null) {
                    if (!user.getNick().equals(strMas[0])) {
                        user.setNick(strMas[0]);
                        FactoryDAO.getInstance().getUsersDAO().addUser(user);
                    }
                } else {
                    user = new Users();
                    user.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    user.setNick(strMas[0]);
                    FactoryDAO.getInstance().getUsersDAO().addUser(user);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (text != null && text.trim().length() > 0) {
                messages.addLast(new Message(text));
                while (messages.size() > 37) {
                    messages.removeFirst();
                }
            }

            // Clear the input box in the browser that kicked off this page only
            //Util.setValue("text", "");

            // For all the browsers on the current page:
            Browser.withCurrentPage(new Runnable() {

                public void run() {
                    // Clear the list and add in the new set of messages
                    Util.removeAllOptions("chat_id_ul");
                    Util.addOptions("chat_id_ul", messages, "text");
                    // ScriptSessions.addFunctionCall("updateMessage");
                }
            });
        }
    }

    public void updateMessage() {
        Browser.withCurrentPage(new Runnable() {

            public void run() {
                // Clear the list and add in the new set of messages
                Util.removeAllOptions("chat_id_ul");
                Util.addOptions("chat_id_ul", messages, "text");
            }
        });
    }

    public String updateNick() {
        Users userName = null;
        String output = "Введите ник...";
        try {
            userName = new Users();
            userName = FactoryDAO.getInstance().getUsersDAO().getUserByIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
            output = userName.getNick();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        userName = null;
        return output;
    }

    public void setCount(int l) {
        j = l;
    }

    public int getCount() {
        j = ipMap.get(WebContextFactory.get().getHttpServletRequest().getRemoteAddr()).getCount();
        return j;
    }

    public int getCountAll() {
        return ipMap.get(WebContextFactory.get().getHttpServletRequest().getRemoteAddr()).getCountAll();
    }
    /**
     * The current set of messages
     */
    private final LinkedList<Message> messages = new LinkedList<Message>();

    public void ImportTree() {
        xmlp.xmlCategoriesExport();
    }

    public void ImportAllProducts(boolean autoname, boolean description) {
        xmlp.xmlPcSyncProducts(autoname, description);
    }

    public void ImportProductsByArticles(String articles, boolean autoname, boolean description) {
    }

    public boolean checkTreeStatus() {
        return xmlp.checkTreeStatus();
    }

    public boolean checkProductsStatus() {
        return xmlp.checkProductsStatus();
    }

    public String exportByProducts(String products, String langs) {
        ValuePro vp = new ValuePro();
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        return vp.exportByProducts(products, WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), langs);
    }

    public String exportMarketing(String products) {
        ValuePro vp = new ValuePro();
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        return vp.exportMarketing(products);
    }

    public String clearCache() {
        ValuePro vp = new ValuePro();
        return vp.clearCache();
    }

    public String changeStatus(String products, String status) {
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.changeStatus(products, status);
    }

    public String changeOwner(String products, String owner) {
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.changeOwner(products, owner);
    }

    public String addLink(String links) {
        links = links.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.addLink(links);
    }

    public String clearSession() {
        ValuePro vp = new ValuePro();
        return vp.clearSession();
    }

    public FileTransfer matchData(InputStream uploadFile, String fileName, String separator) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)|(\\.xlsx)|(\\.xls)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return null;
        }
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".temp");
        FileUtils.writeStringToFile(file, convertStreamToString(uploadFile));
        MatchingData match = new MatchingData();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        p = Pattern.compile("\\.csv");
        m = p.matcher(fileName);
        if (m.find()) {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.csv", "$2");
            buffer.write(FileUtils.readFileToByteArray(match.matchData(uploadFile, file, fileName, separator, MatchingData.CSV)));
        } else {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.xlsx", "$2");
            buffer.write(FileUtils.readFileToByteArray(match.matchData(uploadFile, file, fileName, separator, MatchingData.EXCEL)));
        }

        return new FileTransfer(fileName, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    private String convertStreamToString(InputStream is) throws UnsupportedEncodingException, IOException {
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "WINDOWS-1251"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String addProductType(String productTypeName) {
        if (productTypeName.replaceAll("\\s+|\\d+", "").equals("")) {
            return "Empty";
        }
        if (FactoryDAO4Grabli.getInstance().getProductTypeDAO().isProductTypePresent(productTypeName.trim())) {
            return "Already Exist";
        }
        GrabliPro gp = new GrabliPro();
        return gp.addProductType(productTypeName);
    }

    public String getProductTypeAltName(String productTypeId) {
        String altName = "";
        GrabliPro gp = new GrabliPro();
        try {
            altName = gp.getProductTypeAltName(Integer.parseInt(productTypeId));
        } catch (NumberFormatException ex) {
            return "MultiSelectInRequest";
        }
        return altName;
    }

    public String updateProductTypeAltName(String productTypeId, String newAltName) {
        ProductType pt = new ProductType();
        try {
            pt.setProductTypeId(Integer.parseInt(productTypeId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            pt = null;
            return "MultiSelectInRequest";
        }
        pt.setProductTypeAlternative(newAltName);
        GrabliPro gp = new GrabliPro();
        gp.updateProductTypeAltName(pt);
        return "Done";
    }

    public FileTransfer downloadPTData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadPTData(file)));
        file.delete();
        return new FileTransfer("PT.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public String deleteProductType(String productTypeId) {
        ProductType pt = new ProductType();
        try {
            pt.setProductTypeId(Integer.parseInt(productTypeId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            pt = null;
            return "MultiSelectInRequest";
        }
        GrabliPro gp = new GrabliPro();
        gp.deleteProductType(pt);
        return "Done";
    }

    public String updatePtByFile(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return "!csv";
        }
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".temp");
        FileUtils.writeStringToFile(file, convertStreamToString(uploadFile));
        GrabliPro gp = new GrabliPro();
        gp.updateProductTypeByFile(file);
        return "Done";
    }

    public String getAttributeAltName(String attributeId) {
        String altName = "";
        GrabliPro gp = new GrabliPro();
        try {
            altName = gp.getAttributeAltName(Integer.parseInt(attributeId));
        } catch (NumberFormatException ex) {
            return "MultiSelectInRequest";
        }
        return altName;
    }

    public String updateAttributeAltName(String attributeId, String newAltName) {
        Attribute at = new Attribute();
        try {
            at.setAttributeId(Integer.parseInt(attributeId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            at = null;
            return "MultiSelectInRequest";
        }
        at.setAttributeAlternative(newAltName);
        GrabliPro gp = new GrabliPro();
        gp.updateAttributeAltName(at);
        return "Done";
    }

    public FileTransfer downloadAtrData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadAttributeData(file)));
        file.delete();
        return new FileTransfer("Atr.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public FileTransfer downloadUnitsData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadUnitsData(file)));
        file.delete();
        return new FileTransfer("Units.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public FileTransfer downloadGroupesData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadGroupesData(file)));
        file.delete();
        return new FileTransfer("Groupes.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public String deleteAttribute(String attributeId) {
        Attribute at = new Attribute();
        try {
            at.setAttributeId(Integer.parseInt(attributeId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            at = null;
            return "MultiSelectInRequest";
        }
        GrabliPro gp = new GrabliPro();
        gp.deleteAttribute(at);
        return "Done";
    }

    public String deleteUnit(String unitId) {
        Unit unit = new Unit();
        try {
            unit.setUnitId(Integer.parseInt(unitId));
        } catch (NumberFormatException ex) {
            unit = null;
            return "MultiSelectInRequest";
        }
        GrabliPro gp = new GrabliPro();
        gp.deleteUnit(unit);
        return "Done";
    }

    public String deleteGroupe(String groupeId) {
        Groupe grp = new Groupe();
        try {
            grp.setGroupeId(Integer.parseInt(groupeId));
        } catch (NumberFormatException ex) {
            grp = null;
            return "MultiSelectInRequest";
        }
        GrabliPro gp = new GrabliPro();
        gp.deleteGroupe(grp);
        return "Done";
    }

    public String deleteRegexp(String regexpId) {
        Regexp reg = new Regexp();
        try {
            reg.setRegexpId(Integer.parseInt(regexpId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            reg = null;
            return "MultiSelectInRequest";
        }
        GrabliPro gp = new GrabliPro();
        gp.deleteRegexp(reg);
        return "Done";
    }

    public String updateAtrByFile(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return "!csv";
        }
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".temp");
        FileUtils.writeStringToFile(file, convertStreamToString(uploadFile));
        GrabliPro gp = new GrabliPro();
        gp.updateAttributeByFile(file);
        return "Done";
    }

    public String updateUnitsByFile(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return "!csv";
        }
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".temp");
        FileUtils.writeStringToFile(file, convertStreamToString(uploadFile));
        GrabliPro gp = new GrabliPro();
        gp.updateUnitByFile(file);
        return "Done";
    }

    public String updateGroupesByFile(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return "!csv";
        }
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".temp");
        FileUtils.writeStringToFile(file, convertStreamToString(uploadFile));
        GrabliPro gp = new GrabliPro();
        gp.updateGroupeByFile(file);
        return "Done";
    }

    public String addAttribute(String attributeName) {
        if (attributeName.replaceAll("\\s+|\\d+", "").equals("")) {
            return "Empty";
        }
        if (FactoryDAO4Grabli.getInstance().getAttributeDAO().isAttributePresent(attributeName.trim())) {
            return "Already Exist";
        }
        GrabliPro gp = new GrabliPro();
        return gp.addAttribute(attributeName);
    }

    public String addUnit(String unitName) {
        if (unitName.replaceAll("\\s+|\\d+", "").equals("")) {
            return "Empty";
        }
        if (FactoryDAO4Grabli.getInstance().getUnitDAO().isUnitPresent(unitName.trim())) {
            return "Already Exist";
        }
        GrabliPro gp = new GrabliPro();
        return gp.addUnit(unitName);
    }

    public String addGroupe(String groupeName) {
        if (groupeName.replaceAll("\\s+|\\d+", "").equals("")) {
            return "Empty";
        }
        if (FactoryDAO4Grabli.getInstance().getGroupeDAO().isGroupePresent(groupeName.trim())) {
            return "Already Exist";
        }
        GrabliPro gp = new GrabliPro();
        return gp.addGroupe(groupeName);
    }

    public String addRegexp(int attributeId, int groupeId, String regexpType, String regexpPattern, String regexpReplacement, String novelty) {
//        if (regexpPattern.replaceAll("\\s+", "").equals("")
//                || regexpType.replaceAll("\\s++", "").equals("")
//                || regexpReplacement.replaceAll("\\s+", "").equals("")) {
//            return "Empty";
//        }
//        if (FactoryDAO4Grabli.getInstance().getRegexpDAO().isRegexpPresent(regexpPattern.trim())) {
//            return "Already Exist";
//        }
        GrabliPro gp = new GrabliPro();
        return gp.addRegexp(attributeId, groupeId, regexpType, regexpPattern, regexpReplacement, novelty);
    }

    public String addGroupe2Attr(String groupeId, String atrIds) {
        String[] attributesIds = atrIds.split(",");
        List<Integer> atrList = new ArrayList();
        try {
            for (int i = 0; i < attributesIds.length; i++) {
                atrList.add(Integer.parseInt(attributesIds[i]));
            }
        } catch (NumberFormatException ex) {
        }
        int groupeIdd = Integer.parseInt(groupeId);
        GrabliPro gp = new GrabliPro();
        gp.addGroupe2Attr(groupeIdd, atrList);
        return "Done";
    }

    public String addPt2Groupe(String ptId, String grpIds) {
        String[] groupeIds = grpIds.split(",");
        List<Integer> grpList = new ArrayList();
        try {
            for (int i = 0; i < groupeIds.length; i++) {
                grpList.add(Integer.parseInt(groupeIds[i]));
            }
        } catch (NumberFormatException ex) {
        }
        int ptIdd = Integer.parseInt(ptId);
        GrabliPro gp = new GrabliPro();
        gp.addPt2Groupe(ptIdd, grpList);
        return "Done";
    }

    public FileTransfer downloadGroupe2AttrData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadGroupe2AttrData(file)));
        file.delete();
        return new FileTransfer("Atr2Pt.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public FileTransfer downloadPt2GroupeData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadPt2GroupeData(file)));
        file.delete();
        return new FileTransfer("Pt2Groupe.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public FileTransfer downloadPt2Groupe2AttributeData() throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".xlsx");
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.downloadPt2Groupe2AttributeData(file)));
        file.delete();
        return new FileTransfer("Pt2Groupe2Attribute.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    public String addAttributeAltName(String attributeId, String newAltName) {
        AttributeAlternativeName atrAlt = new AttributeAlternativeName();
        Attribute atr = new Attribute();
//        System.out.println(attributeId + "|||" + newAltName);
        try {
            atr.setAttributeId(Integer.parseInt(attributeId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            atrAlt = null;
            return "MultiSelectInRequest";
        }
        atrAlt.setAttributeAlernativeNameValue(newAltName);
        atrAlt.setAttribute(atr);
//        System.out.println(atrAlt.getAttribute().getAttributeId()+"|||"+atrAlt.getAttributeAlernativeNameValue());
        GrabliPro gp = new GrabliPro();
        gp.addAttributeAltName(atrAlt);
        return "Done";

    }

    public String addAttributeAltNameByName(String attributeName, String newAltName) {
        AttributeAlternativeName atrAlt = new AttributeAlternativeName();
        Attribute atr = FactoryDAO4Grabli.getInstance().getAttributeDAO().getAttributeByName(attributeName);
        atrAlt.setAttributeAlernativeNameValue(newAltName);
        atrAlt.setAttribute(atr);
        GrabliPro gp = new GrabliPro();
        gp.addAttributeAltName(atrAlt);
        return "Done";

    }

    public String updateOutputData(String outputDataRecord) {
        String[] data = outputDataRecord.split("\\|\\|\\|");
        OutputData od = new OutputData();
        od.setOutputDataId(Integer.parseInt(data[0]));
        od.setSessionId(Long.parseLong(data[1]));
        od.setArticle(data[2]);
        od.setProductType(data[3]);
        od.setGroupe(data[4]);
        od.setAttribute(data[5]);
        od.setValue(data[6]);
        od.setUnit(data[7]);
//        od.setAvailable(Byte.parseByte(data[8]));
        if (data[8].equals("true")) {
            od.setAvailable((byte) 1);
        } else {
            od.setAvailable((byte) 0);
        }
        FactoryDAO4Grabli.getInstance().getOutputDataDAO().addOutputData(od);
        return "Done";
    }

    public String addUnitAltName(String unitId, String newAltName) {
        UnitAlternativeName unitAlt = new UnitAlternativeName();
        Unit unit = new Unit();
        try {
            unit.setUnitId(Integer.parseInt(unitId));
        } catch (NumberFormatException ex) {
            unitAlt = null;
            return "MultiSelectInRequest";
        }
        unitAlt.setUnitAlternativeNameValue(newAltName);
        unitAlt.setUnit(unit);
        GrabliPro gp = new GrabliPro();
        gp.addUnitAltName(unitAlt);
        return "Done";

    }

    public String deleteAttributeAltName(String attributeId, String altNameId) {
        AttributeAlternativeName atrAlt = new AttributeAlternativeName();
        Attribute atr = new Attribute();
        try {
            atr.setAttributeId(Integer.parseInt(attributeId));
        } catch (NumberFormatException ex) {
            atrAlt = null;
            return "MultiSelectInRequest";
        }
        String[] mass = altNameId.split(",");
        for (int i = 0; i < mass.length; i++) {
            try {
                atrAlt.setAttributeAlernativeNameId(Integer.parseInt(mass[i]));
                atrAlt.setAttribute(atr);
            } catch (NumberFormatException ex) {
                atrAlt = null;
            }
            GrabliPro gp = new GrabliPro();
            gp.deleteAttributeAltName(atrAlt);
        }
        return "Done";

    }

    public String deleteUnitAltName(String unitId, String altNameId) {
        UnitAlternativeName unitAlt = new UnitAlternativeName();
        Unit unit = new Unit();
        try {
            unit.setUnitId(Integer.parseInt(unitId));
        } catch (NumberFormatException ex) {
            unitAlt = null;
            return "MultiSelectInRequest";
        }
        String[] mass = altNameId.split(",");
        for (int i = 0; i < mass.length; i++) {
            try {
                unitAlt.setUnitAlternativeNameId(Integer.parseInt(mass[i]));
                unitAlt.setUnit(unit);
            } catch (NumberFormatException ex) {
                unitAlt = null;
            }
            GrabliPro gp = new GrabliPro();
            gp.deleteUnitAltName(unitAlt);
        }
        return "Done";

    }

    public String uploadGrabliFile(InputStream uploadFile, String fileName, String proxyBool, String proxyIP) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return "!csv";
        }
        long outId = System.nanoTime();
        GrabliPro gp = new GrabliPro();
        gp.fillInputData(uploadFile, outId, proxyBool, proxyIP);
        return outId + "";
    }

    public String processGrabli(long sessionId) {
        FactoryDAO4Grabli.getInstance().getOutputDataDAO().deleteOutputDataBySessionId(sessionId);
        try {
            MergingProcessing mp = MergingProcessing.getInstance();
            mp.merge(sessionId);
            return "Done";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public FileTransfer updateDownloadData(long sessionId, String inputData) throws Exception {
        File file = new File("/root/TempFolder/" + System.nanoTime() + ".csv");
        System.out.println(file.getAbsolutePath());
        GrabliPro gp = new GrabliPro();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        buffer.write(FileUtils.readFileToByteArray(gp.updateParseData(file, sessionId, inputData)));
        file.delete();
        return new FileTransfer("uploadData.csv", "text/csv", buffer.toByteArray());
    }

    public String getSessionId() {
        return System.nanoTime() + "";
    }

    public String deleteAllSessionId() {
        FactoryDAO4Grabli.getInstance().getOutputDataDAO().deleteAllOutputDataAndInputDataByNativeSQL();
        return "Done";
    }

    public String[] updateRegexp(String regexpId) {
        String[] mass = new String[3];
        GrabliPro gp = new GrabliPro();
        Regexp reg = gp.updateRegexp(Integer.parseInt(regexpId));
        mass[0] = reg.getRegexpType();
        mass[1] = reg.getRegexpPattern();
        mass[2] = reg.getRegexpReplacement();
        return mass;
    }
}
