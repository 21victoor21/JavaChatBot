package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "RootCodeGym_bot";
    public static final String TOKEN = "7144252994:AAHHynJc2Wc0zZ-nRuzPC1gbHdquTZZjO1E";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Hola, _futuro_ *programador* Victor");
        }

        if (getMessageText().contains("hola")){
            sendTextMessageAsync("Hola, cual es tu nombre?");
        }

        if (getMessageText().contains("me llamo")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
        }
    }
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}