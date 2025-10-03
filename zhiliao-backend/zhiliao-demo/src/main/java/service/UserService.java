package service;

import dao.UserDao;
import entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    // 添加用户服务方法
    public void addUser(User user) {
        userDao.addUser(user);
    }

    // 根据userId查找用户服务方法
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }

    // 更新用户信息服务方法
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    // 删除用户服务方法
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }
}