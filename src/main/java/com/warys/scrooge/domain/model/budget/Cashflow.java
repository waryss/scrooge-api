package com.warys.scrooge.domain.model.budget;

import com.warys.scrooge.domain.model.GenericModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Cashflow extends GenericModel {

    private String ownerId;
    private String category;
    private String label;
    private double amount;
    private String frequency;

}