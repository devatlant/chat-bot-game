package com.devatlant.chatbot.game;

import org.apache.commons.codec.binary.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by yev on 2/10/17.
 */
public class HelloWorldBot extends TelegramLongPollingBot {

	private int answer = 50;
	private final String secretKey;

	public HelloWorldBot() {
		super();
		secretKey = System.getProperty("telegram.secret.key");
		if (secretKey==null){
			throw new IllegalArgumentException("Please, specify the system property with -Dtelegram.secret.key");
		}
	}

	public void onUpdateReceived(Update update) {
		if (!update.hasMessage()){
			return;
		}
		processMessage(update.getMessage());
	}

	public String getBotUsername() {
		return "perros_2107_bot";
	}

	public String getBotToken() {
		return secretKey;
	}

	private void processMessage(Message message){
		final Long chatId =  message.getChatId();
		if (!message.hasText()){
			sendMsg(chatId, "Error: no text provided");
			return;
		}
		if (!isInteger(message.getText())){
			sendMsg(chatId, "Error: not integer");
			return;
		}
		int guess = Integer.parseInt(message.getText());
		if (guess == answer){
			sendMsg(chatId, "You win! Congratulations!");
			return;
		}
		else if (guess > answer){
			sendMsg(chatId, "try lower");
			return;
		}else {
			sendMsg(chatId,"try higher");
		}

	}
	private void sendMsg(final Long chatId , final String text){
		SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
						.setChatId(chatId)
						.setText(text);
		try {
			sendMessage(message); // Call method to send the message
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public static boolean isInteger(String s) {
		return isInteger(s,10);
	}

	public static boolean isInteger(String str, int radix) {
		if(str.isEmpty()) return false;
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
