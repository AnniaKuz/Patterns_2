package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CurrencyConverter{
    private static CurrencyConverter instance;
    private Currency currency;


    public static CurrencyConverter getInstance(){
        if(instance==null){
            instance = new CurrencyConverter();
        }
        return instance;
    }

    public double convertPrice(Product product) {
        double changedPrice = Math.round(product.getProductPrice() * this.currency.getExchangeRate());
        return changedPrice;
    }
}
