/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.user;

/**
 *
 * @author TRUNG NHAN
 */
public class userDAO extends DBContext {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<user> getAllUser() {
        List<user> list = new ArrayList<>();
        String sql = "SELECT * FROM [user]";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user us = new user(rs.getString("username"),
                        rs.getString("password"));
                
                list.add(us);
                /* String name = rs.getString("username");
                String pass = rs.getString("password");
                user users = new user(name, pass);*/
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        userDAO u = new userDAO();
        List<user> list = u.getAllUser();
        System.out.println(list.get(0).getUsername());
    }
    
    public void deleteUser(String user) {
        String sql = "DELETE FROM [user] WHERE username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.executeQuery();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public void insertUser(user us) {
        String sql = "INSERT INTO [dbo].[user] (username, password)\n"
                + "VALUES (?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, us.getUsername());
            ps.setString(1, us.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
