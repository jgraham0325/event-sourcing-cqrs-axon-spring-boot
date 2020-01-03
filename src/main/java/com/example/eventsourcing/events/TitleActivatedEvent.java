package com.example.eventsourcing.events;

import com.example.eventsourcing.aggregates.Status;

public class TitleActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public TitleActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
