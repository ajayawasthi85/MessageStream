package com.ajayaw.message.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import com.ajayaw.message.stream.MessageStream;

@EnableBinding(MessageStream.class)
public class StreamConfig {
}
