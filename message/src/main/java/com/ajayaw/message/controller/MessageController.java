package com.ajayaw.message.controller;

import com.ajayaw.message.model.Message;
import com.ajayaw.message.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final MessageService msgSrv;

    public MessageController(MessageService msgSrv) {
        this.msgSrv = msgSrv;
    }

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void messages(@RequestParam("message") String mesg){
        Message msg = Message.builder().content(mesg).timestamp(System.currentTimeMillis()).build();

        msgSrv.sendMessage(msg);
    }
}
