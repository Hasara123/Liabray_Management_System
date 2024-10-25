package controller;

import javafx.scene.control.Alert;
import model.Book;
import model.Member;
import model.Signup;

import java.sql.*;
import java.util.ArrayList;

public class SignupController {
    public static boolean add(Signup signup) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("insert into Staff values(?,?,?)");

            stm.setObject(1, signup.getUserName());
            stm.setObject(2, signup.getPassword());
            stm.setObject(3, signup.getEmail());

            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    public static ArrayList<Signup> staffViewAll() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from staff");

            ResultSet result = stm.executeQuery();

            ArrayList<Signup> signups = new ArrayList<>();

            while (result.next()) {
                Signup signup=new Signup();

                signup.setUserName(result.getString(1));
               signup.setEmail(result.getString(2));

              signups.add(signup);

            }
            return signups;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
