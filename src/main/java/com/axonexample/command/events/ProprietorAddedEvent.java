package com.axonexample.command.events;

import com.axonexample.command.aggregates.entities.ProprietorEntity;
import lombok.Value;
import org.axonframework.modelling.command.EntityId;

@Value
public class ProprietorAddedEvent {
  String titleId;
  String foreNames;
  String surname;
  String title;
  String decor;
}
