package com.devatlant.chatbot.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.model.Parameterized;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.api.objects.Message;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {
    private Game testSubject;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        testSubject = new Game(100, new Random());
    }

    @org.junit.jupiter.api.Test
    void should_respond_with_start() {
        Message start = buildMessage("/start");
        ResponseWithCounter res = testSubject.reactOnGamerMessage(start);
        assertEquals(RESPONSE.START, res.code);
    }

    public Message buildMessage(final String text){
        try {
            return objectMapper.readValue(String.format("{\"text\":\"%s\"}", text), Message.class);
        } catch (IOException e) {
           throw new RuntimeException("wrong json syntax for "+ text,e);
        }
    }

    @Test
    public void should_return_answer_with_counter(){
        //given
        testSubject = new Game(100, new Random());
        Message message = buildMessage("1");
        //run
        ResponseWithCounter res = testSubject.reactOnGamerMessage(message);

        // assert
        assertEquals(1, res.counter);
    }

    @Test
    public void should_return_true_when_input_data_is_integer(){
        //given
        testSubject = new Game(100, new Random());

        //run
        boolean res = testSubject.isInteger("1");

        // assert
        assertEquals(true, res);
    }
}
