package com.axonexample.command.aggregates.entities;

import lombok.Value;
import org.axonframework.modelling.command.EntityId;

@Value
public class ProprietorEntity {
  @EntityId
  String proprietorId;
  String foreNames;
  String surname;
  String title;
  String decor;
}
