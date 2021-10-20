package com.devatlant.chatbot.game;

import org.telegram.telegrambots.api.objects.Message;
import java.util.Random;

public class Game {
    private final int answer;
    public final int upperBound;

    public Game(final int upperBound) {
        final Random random = new Random();
        answer = random.nextInt(upperBound);
        this.upperBound = upperBound;
    }

    public RESPONSE reactOnGamerMessage(final Message message){
        if (message == null){
            throw new IllegalArgumentException("message can't be null!");
        }
        if (!message.hasText()){
            return RESPONSE.WRONG_NUMBER_FORMAT;
        }
        final String gamerInput = message.getText();
        if (gamerInput.startsWith("/")){
            if (gamerInput.equals("/start")){
                return RESPONSE.START;
            }
            if (gamerInput.equals("/help")){
                return RESPONSE.HELP;
            }
        }
        if (!isInteger(gamerInput)){
            return RESPONSE.WRONG_NUMBER_FORMAT;
        }
        int guess = Integer.parseInt(gamerInput);
        if (guess == answer){
            return RESPONSE.FINISH;
        }
        else if (guess > answer){
            return RESPONSE.LOWER;
        }else {
            return RESPONSE.HIGHER;
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
