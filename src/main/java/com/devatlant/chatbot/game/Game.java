package com.devatlant.chatbot.game;

import org.telegram.telegrambots.api.objects.Message;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Game {
    private final int answer;
    public final int upperBound;
    public final AtomicLong guessCounter = new AtomicLong(0);
    public final Random random;

    public Game(final int upperBound, Random random) {
        this.random = random;
        answer = this.random.nextInt(upperBound);
        this.upperBound = upperBound;
    }

    public ResponseWithCounter reactOnGamerMessage(final Message message){
        if (message == null){
            throw new IllegalArgumentException("message can't be null!");
        }
        if (!message.hasText()){
            return new ResponseWithCounter(RESPONSE.WRONG_NUMBER_FORMAT, guessCounter);
        }
        final String gamerInput = message.getText();
        if (gamerInput.startsWith("/")){
            if (gamerInput.equals("/start")){
                return new ResponseWithCounter(RESPONSE.START, guessCounter);
            }
            if (gamerInput.equals("/help")){
                return new ResponseWithCounter(RESPONSE.HELP, guessCounter);
            }
        }
        if (!isInteger(gamerInput)){
            return new ResponseWithCounter(RESPONSE.WRONG_NUMBER_FORMAT, guessCounter);
        }
        int guess = Integer.parseInt(gamerInput);
        if (guess == answer){
            return new ResponseWithCounter(RESPONSE.FINISH, guessCounter);
        }
        else if (guess > answer){
            guessCounter.incrementAndGet();
            return new ResponseWithCounter(RESPONSE.LOWER, guessCounter);
        }else {
            guessCounter.incrementAndGet();
            return new ResponseWithCounter(RESPONSE.HIGHER, guessCounter);
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String str, int radix) {
        if(str== null || str.length() == 0) return false;
        for(int i = 0; i < str.length(); i++) {
            if(i == 0 && str.charAt(i) == '-') {
                if(str.length() == 1) return false;
                else continue;
            }
            if(Character.digit(str.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
