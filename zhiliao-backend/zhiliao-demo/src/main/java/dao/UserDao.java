package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 模拟存储用户数据的列表
    private List<User> userList = new ArrayList<>();

    // 添加用户方法
    public void addUser(User user) {
        userList.add(user);
    }

    // 根据userId查找用户方法
    public User findUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    // 更新用户信息方法
    public void updateUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId() == user.getUserId()) {
                userList.set(i, user);
                break;
            }
        }
    }

    // 删除用户方法
    public void deleteUser(int userId) {
        userList.removeIf(user -> user.getUserId() == userId);
    }
}