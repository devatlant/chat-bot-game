package com.devatlant.chatbot.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.BotSession;

/**
 * Created by yev on 2/10/17.
 */
public class Start {
    private static final Logger LOGGER = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new BotEngine());
        } catch (TelegramApiException e) {
            LOGGER.error("error occurred while starting the bot server-code", e);
        }
    }
}
