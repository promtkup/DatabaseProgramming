package dbprogramming;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB9 {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb1";
        String username = "root";
        String password = "mysql@sit";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection(URL, username, password);
            System.out.println("Database Connected");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO student (studentID, firstName, lastName, email, deptID) VALUES ('65130500006', 'Kantaphong', 'Polmanee', 'Kantaphong.polm@mail.kmutt.ac.th','IT')";
            statement.executeUpdate(sql);
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
