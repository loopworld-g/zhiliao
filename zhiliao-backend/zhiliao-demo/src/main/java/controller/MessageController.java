package controller;

import entity.Message;
import org.springframework.web.bind.annotation.*;
import service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    private MessageService messageService = new MessageService();

    @PostMapping
    public void addMessageController(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    // 处理根据messageId查找消息的请求
    @GetMapping("/{messageId}")
    public Message findMessageByIdController(@PathVariable int messageId) {
        return messageService.findMessageById(messageId);
    }

    // 处理更新消息的请求
    @PutMapping
    public void updateMessageController(@RequestBody Message message) {
        messageService.updateMessage(message);
    }

    // 处理删除消息的请求
    @DeleteMapping("/{messageId}")
    public void deleteMessageController(@PathVariable int messageId) {
        messageService.deleteMessage(messageId);
    }
}
