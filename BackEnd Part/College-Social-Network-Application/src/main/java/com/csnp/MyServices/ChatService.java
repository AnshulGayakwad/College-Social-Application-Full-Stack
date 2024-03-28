package com.csnp.MyServices;

import com.csnp.Models.Chat;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ChatService {
    List<Chat> getChatsByStudent(Long studentId);
    void sendChatMessage(Chat chat);
}