package com.devatlant.chatbot.game;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by yev on 2/10/17.
 */
public class Start {
		public static void main(String[] args) {

			ApiContextInitializer.init();

			TelegramBotsApi botsApi = new TelegramBotsApi();

			try {
				botsApi.registerBot(new HelloWorldBot());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

}
