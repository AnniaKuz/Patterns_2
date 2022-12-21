package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Sterling implements Currency{
    private static Sterling instance;
    private String code;
    private double exchangeRate;


    public static Sterling getInstance(){
        if(instance==null){
            instance = new Sterling();
        }
        return instance;
    }

    @Override
    public double getExchangeRate() {
        return this.exchangeRate;
    }
}
