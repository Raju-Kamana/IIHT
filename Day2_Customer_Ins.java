package day_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Day2_Customer_Ins {
	static final String DB_url="jdbc:mysql://localhost:3306/day_2";
    static final String user="root";
    static final String pass="password";
    static final String Query = "insert into customers(c_id,c_fname,c_lname,c_age,c_gender,c_address,c_email,c_income) values(?,?,?,?,?,?,?,?)";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(Query)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter Customer Id");
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

            ps.setInt(1, cid);
            ps.setString(2, cfname);
            ps.setString(3, clname);
            ps.setInt(4,cage);
            ps.setString(5, cgen);
            ps.setString(6, cadd);
            ps.setString(7, cemail);
            ps.setInt(8, cincome);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}