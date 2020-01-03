package com.example.eventsourcing.events;

import com.example.eventsourcing.aggregates.Status;
import lombok.Value;

@Value
public class TitleOpenedEvent {
    String id;
    Status status;
}
