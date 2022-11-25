package day_2;

import java.sql.*;
import java.util.*;

public class  Day2_customer_search {

    static final String DB_url="jdbc:mysql://localhost:3306/day_2";
    static final String user="root";
    static final String pass="password";
    static final String Query="select * from customers";
    static final String sql="select * from customers where c_id=?";
    public static void main(String args[]){
        try(Connection conn= DriverManager.getConnection(DB_url,user,pass);
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery(Query)){

            while(rs.next()) {
                System.out.println("customer Id="+ rs.getInt("c_id"));
                System.out.println("customer First Name="+ rs.getString("c_fname"));
                System.out.println("customer Last Name="+ rs.getString("c_lname"));
                System.out.println("customer Age="+ rs.getInt("c_age"));
                System.out.println("customer Gender="+ rs.getString("c_gender"));
                System.out.println("customer Address="+ rs.getString("c_address"));
                System.out.println("customer Email="+ rs.getString("c_email"));
                System.out.println("customer Income="+ rs.getInt("c_income"));
            }

            System.out.println("------------search cutomer by id--------------------------");
            System.out.println("Enter customer Id");
            Scanner sc = new Scanner(System.in);
            int cid= sc.nextInt();

            ps.setInt(1, cid);
            ps.execute();
            System.out.println(ps);
            ResultSet rs1=ps.executeQuery();
            while(rs1.next()) {
                System.out.println("inside while loop");
                System.out.println("customer Id="+ rs1.getInt("c_id"));
                System.out.println("customer First Name="+ rs1.getString("c_fname"));
                System.out.println("customer Last Name="+ rs1.getString("c_lname"));
                System.out.println("customer Age="+ rs1.getInt("c_age"));
                System.out.println("customer Gender="+ rs1.getString("c_gender"));
                System.out.println("customer Address="+ rs1.getString("c_address"));
                System.out.println("customer Email="+ rs1.getString("c_email"));
                System.out.println("customer Income="+ rs1.getInt("c_income"));
                
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}