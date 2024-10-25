package controller;

import model.BookReturn;
import model.Issue;
import model.BookReturn;

import java.sql.*;
import java.util.ArrayList;

public class ReturnController {
    public static Issue searchIssue(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from issuebook where IssueId=?");

            stm.setObject(1, id);

            ResultSet result = stm.executeQuery();
            Issue issue = new Issue();

            if (result.next()) {
                issue.setIssueId(result.getString(1));
                issue.setBorrowerId(result.getString(2));
                issue.setBookcode(result.getString(3));
                issue.setIssueDate(result.getString(4));
                issue.setDueDate(result.getString(5));

                return issue;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ArrayList<String> loadissueIds(){
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system?autoReconnect=true&useSSL=false",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select IssueId from issuebook");

            ResultSet result = stm.executeQuery();

            ArrayList<String> issueIds = new ArrayList<>();

            while (result.next()) {
                issueIds.add(result.getString(1));
            }

            return issueIds;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean returnBook(BookReturn bookReturn) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "1234");


            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("insert into returnbook values(?,?,?,?)");
            stm.setObject(1, bookReturn.getReturnId());
            stm.setObject(2, bookReturn.getBorrowerId());
            stm.setObject(3, bookReturn.getBookCode());
            stm.setObject(4, bookReturn.getReturnDate());

            int returnAdded = stm.executeUpdate();

            System.out.println(returnAdded);

  

            if (returnAdded > 0) {
                PreparedStatement stm2 = connection.prepareStatement("UPDATE book SET Quantity = Quantity+? WHERE ISBN = ?");
                stm2.setObject(1, 1);
                stm2.setObject(2,bookReturn.getISBN());


                int returnUpdated = stm2.executeUpdate();

                if (returnUpdated> 0) {
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
            System.out.println(e);;
        }

        return false;
    }
}
