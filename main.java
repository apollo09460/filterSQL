/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dms;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

/**
 *
 * @author von
 */
public class main {
    
    connection a = new connection();
  
      public static void main(String[] args) {
        // 
        
        
        //stored procedure
        
         String url = "jdbc:mysql://localhost:3306/employees";
        String username = "root";
        String password = "";
        String store = """
                       DELIMITER //
                       CREATE PROCEDURE GetAllEmployees()
                       BEGIN
                           -- Select all records from the employees table
                           SELECT * FROM employees;
                       END //
                       DELIMITER ;""";
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("Select employees.first_name , salaries.salary FROM employees join salaries ON employees.emp_no = salaries.emp_no Limit 10");
       
        
        }
        
        catch(Exception e){
        
        
        }
        
        
        
        System.out.println("choose:");
         System.out.println("1.join:");
          System.out.println("2.Left join");
           System.out.println("3.Right Join");
            System.out.println("4.Subquery");
             System.out.println("5.Stored Procedure");
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
              
//inner joiin
if(num == 1){
              url = "jdbc:mysql://localhost:3306/employees";
         username = "root";
        password = "";
        
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("Select employees.first_name , salaries.salary FROM employees join salaries ON employees.emp_no = salaries.emp_no Limit 10");
        while(resultset.next()){
        
       System.out.println(resultset.getString(1)+" " +resultset.getString("salary"));
        
        }
        
        }
        
        catch(Exception e){
        
        
        }
        
}
//left join
    if(num == 2){
        
      url = "jdbc:mysql://localhost:3306/employees";
   username = "root";
     password = "";
        
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("Select employees.first_name , salaries.salary FROM employees left join salaries ON employees.emp_no = salaries.emp_no Limit 10");
        while(resultset.next()){
        
       System.out.println(resultset.getString("first_name")+" " +resultset.getString("salary"));
        
        }
        
        }
        
        catch(Exception e){
        
        
        }
    
    
    
    
    
    
    
    }
    //right join
    if(num == 3){
    
      url = "jdbc:mysql://localhost:3306/employees";
       username = "root";
     password = "";
        
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("Select employees.first_name , salaries.salary FROM employees right join salaries ON employees.emp_no = salaries.emp_no Limit 10");
        while(resultset.next()){
        
       System.out.println(resultset.getString("first_name")+" " +resultset.getString("salary"));
        
        }
        
        }
        
        catch(Exception e){
        
        
        }
        
     
    
    
    
    }

   //subquery 
   
   if(num == 4 ){
   
 url = "jdbc:mysql://localhost:3306/employees";
        username = "root";
        password = "";
        
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("Select* From employees WHERE emp_no > 80000 Limit 10");
        while(resultset.next()){
        
       System.out.println(resultset.getString("first_name")+" " +resultset.getString("last_name"));
        
        }
        
        }
        
        catch(Exception e){
        
        
        }   
   
   
   
   
   
   
   
   
   
   
   }

   //call procedure 
   
   if(num == 5 ){
       
       
       
     url = "jdbc:mysql://localhost:3306/employees";
    username = "root";
     password = "";
        
        
        try{
            java.sql.Connection conn = DriverManager.getConnection(url,username,password);
       
        //PreparedStatement  p = conn.prepareStatement(sql);
       // p.execute();
        
        Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("CALL GetAllEmployees()");
        while(resultset.next()){
        
       System.out.println(resultset.getString("first_name")+" " +resultset.getString("last_name"));
        
        }
        
        
        
        
        }
        
        catch(Exception e){
        
        
        }   
       
   
   
   }
        
        
        
    }
    
}
