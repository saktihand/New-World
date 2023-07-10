import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.text.Text;

public class DataBaseConnection {
    Connection databaseLink = null;

    public void accountLogin(String dBString) {
        try {
            String URL = "jdbc:sqlite:" + dBString;
            databaseLink = DriverManager.getConnection(URL);
            System.out.println("Connection Database");
        } catch (SQLException e) { 
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
        }
    }

    public boolean loginUser (String Username, String Password) {
        boolean AccessAllowed = false;
        String sql = "SELECT Username, Password FROM accountLogin";
        
        try ( Statement stmt = databaseLink.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                if (Password.equals(rs.getString("Password")) && Username.equals(rs.getString("Username"))) {
                    AccessAllowed = true;
                    break;
                }
            }
        } catch (SQLException e) {

        }
        return AccessAllowed;
    }

    public void createAccount(String username, String password, String email, String noHandphone) {
        String sql = "INSERT INTO accountLogin (username, email, password, noHandphone) VALUES (?, ?, ?,?)";
        
        try (PreparedStatement statement = databaseLink.prepareStatement(sql)){
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, noHandphone);
            statement.executeUpdate();
            System.out.println("Account created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    
        }
    
}
