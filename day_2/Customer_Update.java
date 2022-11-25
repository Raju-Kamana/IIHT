package day_2;
import java.sql.*;
import java.util.Scanner;

public class Customer_Update {
	static final String DB_url="jdbc:mysql://localhost:3306/day_2";
    static final String user="root";
    static final String pass="password";
    static final String Query = "select * from customers";
    static final String sql = "update customers set c_fname=?,c_lname=?,c_age=?,c_gender=?,c_address=?,c_email=?,c_income=? where c_id=?";
    
    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(Query)) {

            while (rs.next()) {
                System.out.println("customer Id=" + rs.getInt("c_id"));
                System.out.println("customer First Name=" + rs.getString("c_fname"));
                System.out.println("customer Last Name=" + rs.getString("c_lname"));
                System.out.println("customer Age=" + rs.getInt("c_age"));
                System.out.println("customer Gender=" + rs.getString("c_gender"));
                System.out.println("customer Address=" + rs.getString("c_address"));
                System.out.println("customer Email=" + rs.getString("c_email"));
                System.out.println("customer Income=" + rs.getInt("c_income"));
            }
            System.out.println("--------------------------------------");
            System.out.println("Enter customer Id");
            Scanner sc = new Scanner(System.in);
            int cid = sc.nextInt();
            System.out.println("enter Customer First Name");
            String cfname = sc.next();
            System.out.println("enter Customer Last Name");
            String clname = sc.next();
            System.out.println("enter Customer Age");
            int cage = sc.nextInt();
            System.out.println("enter Customer Gender");
            String cgen = sc.next();
            System.out.println("enter Customer Address");
            String cadd = sc.next();
            System.out.println("enter Customer Email");
            String cemail = sc.next();
            System.out.println("enter Customer Income");
            int cincome = sc.nextInt();


            ps.setString(1, cfname);
            ps.setString(2, clname);
            ps.setInt(3,cage);
            ps.setString(4, cgen);
            ps.setString(5, cadd);
            ps.setString(6, cemail);
            ps.setInt(7, cincome);
            ps.setInt(8, cid);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}