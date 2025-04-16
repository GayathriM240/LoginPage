package com.login.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.model.User;
import com.login.util.DBConnection;

public class UserDao {

	// Method to create a new user in the database
    public boolean addUser(User user) throws Exception {
        String sql = "INSERT INTO users (username, password, email, phone_number) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());

            int result = preparedStatement.executeUpdate();

            return result > 0;  // If rows are affected, user is successfully added
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Error occurred during insertion
        }
    }

    // Method to get a user by ID
    public User getUserById(int id) throws Exception {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

        	preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;  // Return user or null if not found
    }

    // Method to get all users from the database
    public List<User> getAllUsers() throws Exception {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;  // Return the list of users
    }

    // Method to update user information
    public boolean updateUser(User user) throws Exception {
        String sql = "UPDATE users SET username = ?, password = ?, email = ?, phone_number = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setInt(5, user.getUserId());

            int result = preparedStatement.executeUpdate();
            return result > 0;  // If rows are affected, the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Error occurred during update
        }
    }

    // Method to delete a user by ID
    public boolean deleteUser(int id) throws Exception {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            return result > 0;  // If rows are affected, the user was successfully deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Error occurred during deletion
        }
    }

        }

