package com.aero.o2o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testjdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try{
//			   Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			   System.out.print("ddddd1");
////			   Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://182.92.71.49:1433/EFB_DB","sa","AeroTQSQL2014");
//			   Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/o2o","sa","aero");
//			   System.out.print("ddddd2");
//			   Statement stmt = con.createStatement();
//			   String sql="select * from test;";
//			   ResultSet rs = stmt.executeQuery(sql);
//			   if(rs.next())
//			   {
//			    System.out.print(rs.getString(1));
//			   }
//			  }catch(Exception ex){
//			       ex.printStackTrace();}
		A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C(); 
        D d = new D(); 
        System.out.println(a1.show(b));  
        System.out.println(a1.show(c));  
        System.out.println(a1.show(d));  
        System.out.println(a2.show(b));  
        System.out.println(a2.show(c));  
        System.out.println(a2.show(d));  
        System.out.println(b.show(b));    
        System.out.println(b.show(c));    
        System.out.println(b.show(d));     
	}

}
class A {
    public String show(D obj){
           return ("A and D");
    } 
    public String show(A obj){
           return ("A and A");
    } 
} 
class B extends A{
    public String show(B obj){
           return ("B and B");
    }
    public String show(A obj){
           return ("B and A");
    } 
}
class C extends B{
	
} 
class D extends B{
	
} 