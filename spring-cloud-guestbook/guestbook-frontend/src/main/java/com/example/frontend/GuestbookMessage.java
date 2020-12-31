package com.example.frontend;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class GuestbookMessage extends RepresentationModel<GuestbookMessage> {
  private String id;

  private String name;

  private String message;

  private String imageUri;

}
