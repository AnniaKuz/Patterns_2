package org.example;
/*
Сделайте симулятор платежной оплаты который будет принимать инкапсулированный объект как способ оплаты:
credit,  PayPal, debit
Код вызывает оплату не зная его спов и возвращает контроль в оригинальный класс (класс начала)
Класс который вызывает оплату это магазин обуви
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        PaymentSystem paymentSystem = new PaymentSystem();
        Shop shop = new Shop(paymentSystem);
        shop.getPaymentSystem().setPayment(new PaymentCredit());
        shop.doPay();
        shop.getPaymentSystem().setPayment(new PaymentPayPal());
        shop.doPay();


    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Shop{
    PaymentSystem paymentSystem;
    public void doPay(){
        paymentSystem.getPayment().pay();
    }

}
@AllArgsConstructor
@NoArgsConstructor
@Data
class PaymentSystem{
    private Payment payment;
}

interface Payment{
    public void pay();
}

class PaymentCredit implements  Payment{
    @Override
    public void pay() {
        System.out.println("Pay credit");
    }
}

class PaymentPayPal implements  Payment{
    @Override
    public void pay() {
        System.out.println("Pay PayPal");
    }
}