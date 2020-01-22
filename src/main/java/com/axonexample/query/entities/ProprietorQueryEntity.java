package com.axonexample.query.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProprietorQueryEntity {

  @Id
  String proprietorId;
  String foreNames;
  String surname;
  String title;
  String decor;

}
