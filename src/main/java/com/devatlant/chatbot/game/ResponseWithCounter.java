package com.devatlant.chatbot.game;

import java.util.concurrent.atomic.AtomicLong;

public class ResponseWithCounter {
    public final RESPONSE code;
    public final long counter;

    public ResponseWithCounter(RESPONSE code, AtomicLong counter) {
        this.code = code;
        this.counter = counter.get();
    }
}
