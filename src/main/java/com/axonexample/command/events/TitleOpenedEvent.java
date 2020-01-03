package com.axonexample.command.events;

import com.axonexample.command.aggregates.Status;
import lombok.Value;

@Value
public class TitleOpenedEvent {
    String id;
    Status status;
}
