package service;

import dao.MessageDao;
import entity.Message;

public class MessageService {
    private MessageDao messageDao = new MessageDao();

    // 添加消息服务方法
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    // 根据messageId查找消息服务方法
    public Message findMessageById(int messageId) {
        return messageDao.findMessageById(messageId);
    }

    // 更新消息信息服务方法
    public void updateMessage(Message message) {
        messageDao.updateMessage(message);
    }

    // 删除消息服务方法
    public void deleteMessage(int messageId) {
        messageDao.deleteMessage(messageId);
    }
}