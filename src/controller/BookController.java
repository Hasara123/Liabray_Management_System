package controller;

import model.Book;
import model.Member;

import java.sql.*;
import java.util.ArrayList;

public class BookController {
    public static boolean addBook(Book book) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("insert into Book values(?,?,?,?)");

            stm.setObject(1, book.getISBN());
            stm.setObject(2, book.getTitle());
            stm.setObject(3, book.getAuthor());
            stm.setObject(4, book.getQuantity());

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

    public static boolean deleteBook(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("delete from Book where ISBN=?");
            stm.setObject(1, id);

            int result = stm.executeUpdate();
            if (result == 1) {
                return true;
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return false;
    }

    public static Book searchBook(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from book where ISBN=?");

            stm.setObject(1, id);

            ResultSet result = stm.executeQuery();
            Book book = new Book();

            if (result.next()) {
                book.setISBN(result.getString(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setQuantity(Integer.parseInt(result.getString(4)));

                return book;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean updateBook(Book book) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("update book set Title=?,Author=?,Quantity=? where ISBN=?");

            stm.setObject(1, book.getTitle());
            stm.setObject(2, book.getAuthor());
            stm.setObject(3, book.getQuantity());
            stm.setObject(4, book.getISBN());

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

    public static ArrayList<Book> viewAllBook() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from book");

            ResultSet result = stm.executeQuery();

            ArrayList<Book> books = new ArrayList<>();

            while (result.next()) {
                Book book = new Book();

                book.setISBN(result.getString(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setQuantity(Integer.parseInt(result.getString(4)));

                books.add(book);

            }
            return books;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> loadBookIds() {
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select ISBN from book");

            ResultSet result = stm.executeQuery();

            ArrayList<String> bookIds = new ArrayList<>();

            while (result.next()) {
                bookIds.add(result.getString(1));
            }

            return bookIds;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
