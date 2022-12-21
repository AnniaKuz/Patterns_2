package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Euro implements Currency{
    private static Euro instance;
    private String code;
    private double exchangeRate;



    public static Euro getInstance(){
        if(instance==null){
            instance = new Euro();
        }
        return instance;
    }


    @Override
    public double getExchangeRate() {
        return this.exchangeRate;
    }
}
