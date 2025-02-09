package io.github.fvarrui.jeppetto.tests;

import io.github.fvarrui.jeppetto.Chat;
import io.github.fvarrui.jeppetto.Jeppetto;
import io.github.fvarrui.jeppetto.api.chat.completions.AssistantMessage;
import io.github.fvarrui.jeppetto.api.chat.completions.DeveloperMessage;
import io.github.fvarrui.jeppetto.api.chat.completions.RequestCompletion;
import io.github.fvarrui.jeppetto.api.chat.completions.UserMessage;

import java.util.ResourceBundle;

public class Main {

    private static final String API_KEY = ResourceBundle.getBundle("config").getString("openai.api.key");

    public static void main(String[] args) throws Exception {

//        Jeppetto jeppetto = new Jeppetto(API_KEY);

//        System.out.println(jeppetto.getModels());

//        RequestCompletion requestCompletion = new RequestCompletion();
//        requestCompletion.setModel("gpt-4o-mini");
//        requestCompletion.getMessages().add(new DeveloperMessage("You are a helpful assistant."));
//        requestCompletion.getMessages().add(new UserMessage("Hello!"));
//        System.out.println(jeppetto.chatCompletion(requestCompletion));

        Chat chat = new Chat(API_KEY, "gpt-4o-mini",
        "Actúa como un cuentacuentos interactivo, ofreciendo opciones." +
                "Irás ofreciendo pedacitos del cuento y en función de la opción elegida, te lo irás inventando." +
                "Dame cada pedacito en formato json."
        );
        System.out.println("Assistant: " + chat.send("Empieza el cuento").getContent());
        System.out.println("Assistant: " + chat.send("segunda opción").getContent());
        System.out.println("Assistant: " + chat.send("primera opción").getContent());

//        System.out.println(API_KEY);
//
//        Chat chat = new Chat(API_KEY, "gpt-4o-mini", "actúa como un experto crítico de cine y dame la información en formato CSV");
//        System.out.println("Assistant: " + chat.send("cuál es la mejor película de tarantino con kurt russell?").getContent());
//        System.out.println("Assistant: " + chat.send("dame la información en alemán").getContent());

    }

}
