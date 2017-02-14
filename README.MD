#Simple Telegram based game

This project uses under the hood a popular java abstraction library for accessing Telegram Bot API - [org.telegram.telegrambots](https://github.com/rubenlagus/TelegramBots)

## How to

#### Requirements
1. JDK/JRE 1.8
2. maven for dependency management and building stuff

#### Step by step installation instruction
3. In your active Telegram account find a special bot [@BotFather](https://telegram.me/BotFather)
4. Then send command `/newbot`
5. Give a unique name to your new bot
6. Copy the telegram token to access the HTTP API
7. In your terminal/cmd run `mvn package`
8. In your terminal/cmd run `java -jar -Dtelegram.secret.key=MySecretKeyFromStep6 target/simpleBot-1.0-SNAPSHOT-jar-with-dependencies.jar`
