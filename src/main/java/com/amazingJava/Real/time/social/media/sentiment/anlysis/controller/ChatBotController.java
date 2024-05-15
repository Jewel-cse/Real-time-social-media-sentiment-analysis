package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.dto.ChatGPTRequest;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class ChatBotController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate template;
    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model,prompt);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiUrl,request,ChatGPTResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
