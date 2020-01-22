package com.axonexample.command;

import lombok.Value;

@Value
public class ProprietorWithoutId {
  Integer entrySequence;
  String foreNames;
  String surname;
  String title;
  String decor;
}
