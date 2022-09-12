package com.ajayaw.message.stream;

import org.intellij.lang.annotations.JdkConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/*
During runtime Spring will create a Java proxy-based implementation of the MessageStreams interface
that can be injected as a Spring Bean anywhere in the code to access our two streams.
 */
public interface MessageStream {
    String INPUT = "message-in";
    String OUTPUT = "message-out";

    @Input(INPUT)
    SubscribableChannel inBoundMessages();

    @Output(OUTPUT)
    MessageChannel outboundMessages();
}
