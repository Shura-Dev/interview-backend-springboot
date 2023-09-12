package com.industriascin.interview.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;

@Data
@Table(name = "tasks")
@Entity
public class TaskEntity {

  @Id
  @GeneratedValue
  private UUID uuid;

  private String title;

  private String description;

  private boolean completed;
}
