//package imf.backend;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserException;
//import org.xmlpull.v1.XmlPullParserFactory;
//
///**
// * Developed by: Andrey Popov
// * Date (time): 15.03.11 (11:05)
// */
//
//public class XmlParser {
//    public static void main(String args[]) throws XmlPullParserException, IOException {
//        Map<String, Entry> industry = new HashMap<String, Entry>();
//        Map<String, Entry> category = new HashMap<String, Entry>();
//        Map<String, Entry> pt = new HashMap<String, Entry>();
//        Map<String, Entry> vendor = new HashMap<String, Entry>();
//
//        Entry entry = new Entry();
//        String keyValue = "";
//        boolean isStart = false;
//        int key = 1;
//
//        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//        XmlPullParser xpp = factory.newPullParser();
//
//        InputStream is = new FileInputStream("C://industry.xml");
//        xpp.setInput(is, "utf-8");
//        int eventType = xpp.getEventType();
//
//        while (eventType != XmlPullParser.END_DOCUMENT) {
//            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
//                entry = new Entry();
//                entry.setOldKey(xpp.getAttributeValue(0));
//                entry.setNewKey(key + "");
//                entry.setParentNewKey("0");
//                isStart = true;
//            }
//            if (eventType == XmlPullParser.TEXT && isStart) {
//                entry.setValue(xpp.getText());
//                industry.put(key++ + "", entry);
//                isStart = false;
//            }
//
//            eventType = xpp.next();
//        }
//        System.out.println(industry.size());
//
//        key = 1;
//        is = new FileInputStream("C://category.xml");
//        xpp.setInput(is, "utf-8");
//        eventType = xpp.getEventType();
//
//        while (eventType != XmlPullParser.END_DOCUMENT) {
//            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
//                entry = new Entry();
//                entry.setOldKey(xpp.getAttributeValue(0));
//                entry.setNewKey(key + "");
//                entry.setParentNewKey("1");
//                isStart = true;
//            }
//            if (eventType == XmlPullParser.TEXT && isStart) {
//                entry.setValue(xpp.getText());
//                category.put(key++ + "", entry);
//                isStart = false;
//            }
//
//            eventType = xpp.next();
//        }
//        System.out.println(category.size());
//
//
//        key = 1;
//        is = new FileInputStream("C://pt.xml");
//        xpp.setInput(is, "utf-8");
//        eventType = xpp.getEventType();
//
//        while (eventType != XmlPullParser.END_DOCUMENT) {
//            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
//                entry = new Entry();
//                entry.setOldKey(xpp.getAttributeValue(0));
//                entry.setNewKey(key + "");
//                for (Map.Entry<String, Entry> entryMap : category.entrySet()) {
//                    if (entryMap.getValue().getOldKey().equals(xpp.getAttributeValue(2))) {
//                        entry.setParentNewKey(entryMap.getValue().getNewKey());
//                        break;
//                    }
//                }
//                isStart = true;
//            }
//            if (eventType == XmlPullParser.TEXT && isStart) {
//                entry.setValue(xpp.getText());
//                pt.put(key++ + "", entry);
//                isStart = false;
//            }
//
//            eventType = xpp.next();
//        }
//        System.out.println(pt.size());
//
//
//        key = 1;
//        is = new FileInputStream("C://vendor.xml");
//        xpp.setInput(is, "utf-8");
//        eventType = xpp.getEventType();
//
//        while (eventType != XmlPullParser.END_DOCUMENT) {
//            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
//                entry = new Entry();
//                entry.setOldKey(xpp.getAttributeValue(0));
//                entry.setNewKey(key + "");
//                for (Map.Entry<String, Entry> entryMap : industry.entrySet()) {
//                    if (entryMap.getValue().getOldKey().equals(xpp.getAttributeValue(2))) {
//                        entry.setParentNewKey(entryMap.getValue().getNewKey());
//                        break;
//                    }
//                }
//                isStart = true;
//            }
//            if (eventType == XmlPullParser.TEXT && isStart) {
//                entry.setValue(xpp.getText());
//                vendor.put(key++ + "", entry);
//                isStart = false;
//            }
//
//            eventType = xpp.next();
//        }
//        System.out.println();
//        System.out.println("Industry");
//        for (Map.Entry<String, Entry> entryMap : industry.entrySet()) {
//            System.out.println(
////                    entryMap.getValue().getOldKey() + " - " +
//                    entryMap.getValue().getNewKey() + "|" +
////                    entryMap.getValue().getParentNewKey() + " - " +
//                            entryMap.getValue().getValue()
//            );
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("Category");
//        for (Map.Entry<String, Entry> entryMap : category.entrySet()) {
//            System.out.println(
////                    entryMap.getValue().getOldKey() + " - " +
//                    entryMap.getValue().getNewKey() + "|" +
//                            entryMap.getValue().getParentNewKey()
////                            entryMap.getValue().getValue()
//            );
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("Pt");
//        for (Map.Entry<String, Entry> entryMap : pt.entrySet()) {
//            System.out.println(
////                    entryMap.getValue().getOldKey() + " - " +
//                    entryMap.getValue().getNewKey() + "|" +
//                            entryMap.getValue().getParentNewKey()
////                            entryMap.getValue().getValue()
//            );
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("Vendor");
//        for (Map.Entry<String, Entry> entryMap : vendor.entrySet()) {
//            System.out.println(
////                    entryMap.getValue().getOldKey() + " - " +
//                    entryMap.getValue().getNewKey() + "|" +
//                            entryMap.getValue().getParentNewKey()
////                            entryMap.getValue().getValue()
//            );
//        }
//
//
//    }
//}
