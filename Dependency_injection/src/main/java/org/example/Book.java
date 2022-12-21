package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Book implements Product{
    private String name;
    private double price;

    @Override
    public double getProductPrice() {
        return this.price;
    }

}
