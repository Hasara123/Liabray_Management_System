package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Issue;

public class IssueController {

    public static boolean issueBook(Issue issue) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "1234");

            System.out.println(issue);

            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("insert into issuebook values(?,?,?,?,?)");
            stm.setObject(1, issue.getIssueId());
            stm.setObject(2, issue.getBorrowerId());
            stm.setObject(3, issue.getBookcode());
            stm.setObject(4, issue.getIssueDate());
            stm.setObject(5, issue.getDueDate());


            int issueAdded = stm.executeUpdate();
            System.out.println(issueAdded);
            System.out.println(issue.getBookcode());

            if (issueAdded > 0) {
                PreparedStatement stm2 = connection.prepareStatement("UPDATE book SET Quantity = Quantity - ? WHERE ISBN = ?");
                stm2.setObject(1, 1);
                stm2.setObject(2, issue.getBookcode());


                int bookUpdated = stm2.executeUpdate();

                if (bookUpdated > 0) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
                connection.rollback();
                connection.setAutoCommit(true);
            }

            connection.rollback();
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}


