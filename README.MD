# Simple Telegram based game

[![CI](https://github.com/stasya05/chat-bot-game/actions/workflows/ci.yml/badge.svg)](https://github.com/stasya05/chat-bot-game/actions/workflows/ci.yml)

This project uses under the hood a popular java abstraction library for accessing Telegram Bot API - [org.telegram.telegrambots](https://github.com/rubenlagus/TelegramBots)

---
### Author (fork)
#### Anastasia
JE ME PRÉSENTE

Étudiante du programme franco-ukrainien de double diplôme avec de l'Université Lumière Lyon 2 et l'Université Nationale d'Économie de Kharkiv Simon Kuznets. Je suis à la recherche d'un stage comme chef de projet dans le domaine l'informatique
ÉDUCATION ET FORMATION
10/2020 – EN COURS – Kharkiv, Ukraine
Master 2 en Statistique et Data Science pour le Management
**Université Lumière Lyon 2**
10/2020 – EN COURS – Kharkiv, Ukraine

Master 2 en Systèmes et Technologies d'Information
l'Université Nationale d'Économie de Kharkiv Simon Kuznets
09/2015 – 06/2020 – Kharkiv, Ukraine
Licence en Publicité et Relations Publiques
l'Université Nationale d'Économie de Kharkiv Simon Kuznets
*EXPÉRIENCE PROFESSIONNELLE*

05/2021 – 09/2021 – Kharkiv, Ukraine Chef de projet
IM - digital
* Communication avec les clients
* Planification budgétaire
* Organisation du travail de l'équipe autour de la tâche demandée ◦ Fournir au client des rapports sur l'avancement des tâches
* Présentation des tâches terminées au client

09/2021  – Kharkiv, Ukraine
CHEF DE PROJET – SWEETSOFT
* Élaboration d'un plan de projet
* Présentation de travaux
* Motivation de l'équipe
* Organisation du travail de l'équipe autour de la tâche demandée

---

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
