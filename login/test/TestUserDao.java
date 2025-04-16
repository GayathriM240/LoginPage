package com.login.test;
import com.login.dao.UserDao;
import com.login.model.User;


public class TestUserDao {
	public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();

        // Test adding a user
        User user = new User(5 ,"xyz", "gayi@2002", "gayigayathrim998@gmail.com", "8867624616");
        boolean isAdded = userDao.addUser(user);
        System.out.println("User added: " + isAdded);

        // Test fetching all users
        System.out.println("Fetching all users:");

        userDao.getAllUsers().forEach(u -> System.out.println(u.getUsername()));

//        // Test updating a user
//        user.setUsername("john_doe_updated");
//        boolean isUpdated = userDao.updateUser(user);
//        System.out.println("User updated: " + isUpdated);

        // Test deleting a user

//        // Test deleting a user
//        boolean isDeleted = userDao.deleteUser(user.get());
//        System.out.println("User deleted: " + isDeleted);
    }

}
