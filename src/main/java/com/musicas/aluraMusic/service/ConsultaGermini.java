package com.musicas.aluraMusic.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGermini {

    public static String obterInformacao(String texto) {
        String prompt = "Me forneça um resumo curto sobre o artista '" + texto +
                "', estruturado com quebras de linha para exibição no terminal.";
        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("API_KEY_GEMINI"))
                .modelName("gemini-1.5-flash")
                .maxOutputTokens(1000)
                .build();
        return gemini.generate(prompt);
    }
}
