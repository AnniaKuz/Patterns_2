package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Dollar implements Currency{
    private  static  Dollar instance;
    private String code;
    private double exchangeRate;




    public static Dollar getInstance(){
        if(instance==null){
            instance = new Dollar();
        }
        return instance;
    }

    @Override
    public double getExchangeRate() {
        return this.exchangeRate;
    }

}
