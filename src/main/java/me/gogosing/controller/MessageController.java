package me.gogosing.controller;

import me.gogosing.model.Salt;
import me.gogosing.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by JinBum Jeong on 2020/03/02.
 */
@RestController
@RequestMapping("/v1")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message")
    public Map<String, String> getMessage(@RequestBody Salt salt) {
        return Map.of(
            "external", messageService.getExternalMessage(salt.getContents())
        );
    }
}
