# Simple Telegram based game

This project uses under the hood a popular java abstraction library for accessing Telegram Bot API - [org.telegram.telegrambots](https://github.com/rubenlagus/TelegramBots)

## How to

### Requirements
1. JDK/JRE 1.8
2. maven for dependency management and building stuff

### Step by step installation instruction
1. In your active Telegram account find a special bot [@BotFather](https://telegram.me/BotFather)
2. Then send command `/newbot`
3. Give a unique name to your new bot
4. Copy the telegram token to access the HTTP API
5. In your terminal/cmd run `mvn package`
6. In your terminal/cmd run `java -jar -Dtelegram.secret.key=MySecretKeyFromStep4 target/simpleBot-1.0-SNAPSHOT-jar-with-dependencies.jar`

### How to use

1. Open your Telegram app (mobile/Desktop)
2. Find your bot (which you have created in step 2 see previous section)
3. Start to send your guess to the chat and enjoy

![screenshot](https://raw.githubusercontent.com/devatlant/chat-bot-game/master/res/telegram_screenshot.jpg)

## Test from git and Vim
