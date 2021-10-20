package com.devatlant.chatbot.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import static com.devatlant.chatbot.game.RESPONSE.START;
import static com.devatlant.chatbot.game.RESPONSE.WRONG_COMMAND;

/**
 * Created by yev on 2/10/17.
 */
public class BotEngine extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(BotEngine.class);
    private final String secretKey;
    private final Game game;

    public BotEngine() {
        super();
        secretKey = System.getProperty("telegram.secret.key");
        if (secretKey == null) {
            throw new IllegalArgumentException("Please, specify the system property with -Dtelegram.secret.key");
        }
        game = new Game(100);
        LOGGER.info("bot started");
    }


    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) {
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

    private void processMessage(Message message) {
        LOGGER.info(String.format("process message [%s] from client [%s %s]",
            message.getText(), message.getFrom().getFirstName(), message.getFrom().getLastName()));
        final RESPONSE response = game.reactOnGamerMessage(message);
        sendMsg(message, response);
    }

    private void sendMsg(final Message message, final RESPONSE response) {
        final String text;
        switch (response) {
            case START:
                text = "Available commands : /start /help";
                break;
            case HELP:
                text = String.format("\uD83D\uDC81\uD83C\uDFFB you need to guess a number from 0 to %s. Send me a number...", game.upperBound);
                break;
            case WRONG_COMMAND:
                text = String.format("seems you started taping command {%s}, but this command is not supported", message.getText());
                break;
            case WRONG_NUMBER_FORMAT:
                text = String.format("\uD83D\uDE1E it's not a number - %s", message.getText());
                break;
            case FINISH:
                text = String.format("\uD83C\uDFC6 %s, you win! Congratulations!", message.getFrom().getFirstName());
                break;
            case HIGHER:
                text = "\uD83D\uDE1E nope, try higer";
                break;
            case LOWER:
                text = "\uD83D\uDE1E nope, try lower";
                break;
            default:
                throw new IllegalArgumentException(String.format("this input [%s] is not implemented yet!", message.getText()));
        }
        SendMessage messageToBeSend = new SendMessage() // Create a SendMessage object with mandatory fields
            .setChatId(message.getChatId())
            .setReplyToMessageId(message.getMessageId())
            .setText(text);
        try {
            sendMessage(messageToBeSend); // Call method to send the message
        } catch (TelegramApiException e) {
            LOGGER.error("error occurred while sending message {}", message, e);
        }
    }


}
