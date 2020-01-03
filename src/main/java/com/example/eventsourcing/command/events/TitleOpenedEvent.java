package com.example.eventsourcing.command.events;

import com.example.eventsourcing.command.aggregates.Status;
import lombok.Value;

@Value
public class TitleOpenedEvent {
    String id;
    Status status;
}
