package com.skillswap.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillswap.backend.entity.Message;
import com.skillswap.backend.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Save Message
    @PostMapping
    public Message saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    // Get All Messages
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // Get Message By ID
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    // Get Messages Sent By User
    @GetMapping("/sender/{senderId}")
    public List<Message> getMessagesBySender(@PathVariable Long senderId) {
        return messageService.getMessagesBySender(senderId);
    }

    // Get Messages Received By User
    @GetMapping("/receiver/{receiverId}")
    public List<Message> getMessagesByReceiver(@PathVariable Long receiverId) {
        return messageService.getMessagesByReceiver(receiverId);
    }

    // Delete Message
    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable Long id) {
        return messageService.deleteMessage(id);
    }
}