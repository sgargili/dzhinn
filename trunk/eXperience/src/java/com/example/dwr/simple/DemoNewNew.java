
package com.example.dwr.simple;


import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;




public class DemoNewNew
{
  public static String NNN(String args) {
    Session session = null;
	boolean b=false;
	String str = args;
    try{
      // This step will read hibernate.cfg.xml and prepare hibernate for use
      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
       session =sessionFactory.openSession();
        //Create new instance of Contact and set values in it by reading them from form object
         //System.out.println("Inserting Record");
       Contact contact = new Contact();
      //  contact.setId(1007);
        contact.setFirstName(str);
        contact.setLastName(str+" PopovNew");
        contact.setEmail("andrey1602New@mail.ru");
	
		session.save(contact);
		
	session.beginTransaction().commit();
		  
		session.flush();
	b=true;

      //  System.out.println("Done");
    }catch(Exception e){
     // System.out.println(e.getMessage());
    }finally{
session.close();
      }
	  if (b)
	  {return "Done";
	  } else {
    return "Done-non";}
  }





    public String sayHello(String name) throws Exception
    {
        return NNN(name);
    }
    
    
}
