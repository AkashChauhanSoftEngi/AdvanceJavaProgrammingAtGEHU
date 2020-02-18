package JDBCBasedExamples;

import java.sql.*;

public class MysqlConnectionUsingJDBC {

    public static void main(String args[]) throws SQLException, ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "root", "root");
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from emp");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        }
        con.close();
    }
}
