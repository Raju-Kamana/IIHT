package day_2;
import java.sql.*;
import java.util.Scanner;

public class day2_Customer_delete {
	 	static final String DB_url="jdbc:mysql://localhost:3306/day_2";
	    static final String user="root";
	    static final String pass="password";
    static final String Query = "select * from customers";
    static final String sql = "Delete from customers where c_id=?";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(Query)) {

            while (rs.next()) {
                System.out.println("customer Id="+ rs.getInt("c_id"));
                System.out.println("customer First Name="+ rs.getString("c_fname"));
                System.out.println("customer Last Name="+ rs.getString("c_lname"));
                System.out.println("customer Age="+ rs.getInt("c_age"));
                System.out.println("customer Gender="+ rs.getString("c_gender"));
                System.out.println("customer Address="+ rs.getString("c_address"));
                System.out.println("customer Email="+ rs.getString("c_email"));
                System.out.println("customer Income="+ rs.getInt("c_income"));
            }
            System.out.println("--------------------------------------");
            System.out.println("Enter customer Id");
            Scanner sc = new Scanner(System.in);
            int cid = sc.nextInt();

            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}