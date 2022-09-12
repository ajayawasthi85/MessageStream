package com.ajayaw.message.service;

import com.ajayaw.message.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.ajayaw.message.stream.MessageStream;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class MessageService {
    private final MessageStream msgStreams;

    public MessageService(MessageStream msgStreams) {
        this.msgStreams = msgStreams;
    }

    public void sendMessage(final Message msg){
        log.info("Sending message ", msg);
        MessageChannel msgChl = msgStreams.outboundMessages();
        msgChl.send(MessageBuilder
                .withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
