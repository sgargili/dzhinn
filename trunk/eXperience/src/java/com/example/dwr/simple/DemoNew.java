package com.example.dwr.simple;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import java.util.*;

public class DemoNew {

    public static String GETARTID(String art) throws Exception {
        Connection connection = getConnection();
        String id = "";
        try {
            String query = "SELECT Articleid FROM Test WHERE ARTICLE='" + art + "'";
            PreparedStatement ps = connection.prepareStatement(query);
            //Statement ps1 = connection.createStatement();
            //long eee=1234567890;
            //int result = ps1.executeUpdate("UPDATE Test SET Article='" + eee + "' WHERE Article='1234567890'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } finally {
            closeConnection(connection);
        }
        return id;
    }

    private static Connection getConnection() throws Exception {
        Connection connection = null;
        //Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
        //try
        //{
        //	DriverManager.registerDriver(new COM.ibm.db2.jdbc.app.DB2Driver());
        //}
        //catch (SQLException e)
        //{
        //}
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        return connection;
    }

    private static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static String NNN(String args) {
        Session session = null;
        String ew = "";
        String ew1 = "";
        String ew2 = "";
        String ew3 = "";
        String str = args;
        try {
            // This step will read hibernate.cfg.xml and prepare hibernate for use
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Create new instance of Contact and set values in it by reading them from form object
            //System.out.println("Inserting Record");
            // Contact contact = new Contact();
            //contact.setId(1007);
            // contact.setFirstName(str);
            // contact.setLastName("PopovNew");
            // contact.setEmail("andrey1602New@mail.ru");

            //session.save(contact);

            //session.beginTransaction().commit();

            //session.flush();
            //Contact account2 = (Contact)session.load(Contact.class, Contact.getId());
            //System.out.println(account2.getFirstName());

            String SQL_QUERY = "Select contact.firstName, contact.lastName, contact.email, contact.id from Contact contact where contact.id='" + str + "'";
            Query query = session.createQuery(SQL_QUERY);
            for (Iterator it = query.iterate(); it.hasNext();) {
                Object[] row = (Object[]) it.next();
                ew = "Name ->" + row[0].toString().trim();
                ew1 = " Sname ->" + row[1].toString().trim();
                ew2 = " Email ->" + row[2].toString().trim();
                ew3 = " ID ->" + row[3].toString().trim();
            }





            session.close();

            //  System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Actual contact insertion will happen at this step
        }
        return ew + ew1 + ew2 + ew3;
    }

    public String sayHello(String name) throws Exception {
        return NNN(name);
    }
//"Article - " + name + "ArticleID - " + GETARTID(name) +
}
