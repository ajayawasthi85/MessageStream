package com.ajayaw.message.service;

import com.ajayaw.message.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.StreamRetryTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.ajayaw.message.stream.MessageStream;

@Component
@Slf4j
public class MessageListener {

    @StreamListener(MessageStream.INPUT)
    public void handleMessage(@Payload Message msg){
        log.info("Received Message: {} ", msg);
    }
}
