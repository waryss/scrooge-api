package com.warys.scrooge.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class Flow extends GenericModel {

    private String ownerId;
    private String category;
    private String label;
    private double amount;
    private String frequency;

}