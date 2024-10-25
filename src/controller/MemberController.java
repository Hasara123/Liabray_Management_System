package controller;

import model.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberController {
    public static boolean addMember(Member member) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("insert into Member values(?,?,?,?)");

            stm.setObject(1, member.getId());
            stm.setObject(2, member.getName());
            stm.setObject(3, member.getAddress());
            stm.setObject(4, member.getMobile());

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


    public static boolean deleteMember(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("delete from Member where Id=?");
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


    public static Member searchMember(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from member where Id=?");

            stm.setObject(1, id);

            ResultSet result = stm.executeQuery();
            Member member = new Member();

            if (result.next()) {
                member.setId(result.getString(1));
                member.setName(result.getString(2));
                member.setAddress(result.getString(3));
                member.setMobile(result.getString(4));

                return member;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean updateMember(Member member) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("update Member set name=?,address=?,mobile=? where Id=?");

            stm.setObject(1, member.getName());
            stm.setObject(2, member.getAddress());
            stm.setObject(3, member.getMobile());
            stm.setObject(4, member.getId());

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

    public static ArrayList<Member> viewAllMember() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from member");

            ResultSet result = stm.executeQuery();

            ArrayList<Member> members = new ArrayList<>();

            while (result.next()) {
                Member member = new Member();

                member.setId(result.getString(1));
                member.setName(result.getString(2));
                member.setAddress(result.getString(3));
                member.setMobile(result.getString(4));

                members.add(member);

            }
            return members;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> loadMemberIds() {
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select Id from member");

            ResultSet result = stm.executeQuery();

            ArrayList<String>  memberIds = new ArrayList<>();

            while (result.next()) {
                memberIds.add(result.getString(1));
            }

            return memberIds;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

