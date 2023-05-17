package dbprogramming;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB13 {

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
            String sql = "UPDATE student SET email = ? WHERE studentID = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "Kantaphong@gmail.com");
            prepareStatement.setString(2,"65130500006");
            prepareStatement.executeUpdate();
            ResultSet results = statement.executeQuery("SELECT * FROM student");
            ResultSetMetaData resultsMetaData = results.getMetaData();
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
