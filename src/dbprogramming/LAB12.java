package dbprogramming;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB12 {

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
            String sql = "INSERT INTO student (studentID, firstName, lastName, email, deptID) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "65130500006");
            preparedStatement.setString(2, "Kantaphong");
            preparedStatement.setString(3, "Polmanee");
            preparedStatement.setString(4, "Kantaphong.polm@mail.kmutt.ac.th");
            preparedStatement.setString(5, "IT");
            preparedStatement.executeUpdate();
            ResultSet results = statement.executeQuery("SELECT * FROM student");
            while (results.next()) {
                System.out.println(results.getString(1)
                        + " " + results.getString(2)
                        + " " + results.getString(3)
                        + " " + results.getString(4)
                        + " " + results.getString(5));
            }
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
