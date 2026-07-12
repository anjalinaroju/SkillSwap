package com.skillswap.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillswap.backend.entity.Message;
import com.skillswap.backend.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Save Message
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    // Get All Messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Get Message By ID
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    // Get Messages Sent By User
    public List<Message> getMessagesBySender(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    // Get Messages Received By User
    public List<Message> getMessagesByReceiver(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    // Delete Message
    public String deleteMessage(Long id) {

        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return "Message Deleted Successfully!";
        }

        return "Message Not Found!";
    }
}