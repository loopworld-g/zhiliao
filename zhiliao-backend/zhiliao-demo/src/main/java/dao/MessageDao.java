package dao;

import entity.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    // 模拟存储消息数据的列表
    private List<Message> messageList = new ArrayList<>();

    // 添加消息方法
    public void addMessage(Message message) {
        messageList.add(message);
    }

    // 根据messageId查找消息方法
    public Message findMessageById(int messageId) {
        for (Message msg : messageList) {
            if (msg.getMessageId() == messageId) {
                return msg;
            }
        }
        return null;
    }

    // 更新消息信息方法
    public void updateMessage(Message message) {
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getMessageId() == message.getMessageId()) {
                messageList.set(i, message);
                break;
            }
        }
    }

    // 删除消息方法
    public void deleteMessage(int messageId) {
        messageList.removeIf(msg -> msg.getMessageId() == messageId);
    }
}