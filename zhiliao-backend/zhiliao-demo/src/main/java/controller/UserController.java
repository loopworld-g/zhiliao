package controller;

import entity.User;
import service.UserService;

public class UserController {
    private UserService userService = new UserService();

    // 处理添加用户的请求
    public void addUserController(User user) {
        userService.addUser(user);
    }

    // 处理根据userId查找用户的请求
    public User findUserByIdController(int userId) {
        return userService.findUserById(userId);
    }

    // 处理更新用户信息的请求
    public void updateUserController(User user) {
        userService.updateUser(user);
    }

    // 处理删除用户的请求
    public void deleteUserController(int userId) {
        userService.deleteUser(userId);
    }
}