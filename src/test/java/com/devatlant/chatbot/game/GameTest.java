package com.devatlant.chatbot.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.api.objects.Message;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {
    private Game testSubject;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        testSubject = new Game(100);
    }

    @org.junit.jupiter.api.Test
    void should_respond_with_start() {
        Message start = buildMessage("/start");
        RESPONSE res = testSubject.reactOnGamerMessage(start);
        assertEquals(RESPONSE.START, res);
    }

    public Message buildMessage(final String text){
        try {
            return objectMapper.readValue(String.format("{\"text\":\"%s\"}", text), Message.class);
        } catch (IOException e) {
           throw new RuntimeException("wrong json syntax for "+ text,e);
        }
    }
}
