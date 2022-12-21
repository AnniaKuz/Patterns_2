package org.example;

import lombok.*;

import java.util.*;

import static org.example.Main.scan;


public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Broker broker = new Broker();
        Broker broker2 = new Broker();
        StockAnalyst analyst = new StockAnalyst("InvestAdvices");

        analyst.setHandler(() -> System.out.println("You've got message"));

        analyst.addObserver(broker);
        analyst.addMovement();
        analyst.addMovement();

        //broker2 included
        analyst.addObserver(broker2);
        analyst.addMovement();

        System.out.println("ANALYST");
        analyst.listAllMovements();
        System.out.println("BROKER N1");
        broker.listAllTheMovements();
        System.out.println("BROKER N2");
        broker2.listAllTheMovements();

    }

}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class StockAnalyst{

    private String name;

    public StockAnalyst(String name) {
        this.name = name;
    }

    List<Broker> observers;
    List<Movement> movements;

    {
        observers = new ArrayList<>();
        movements = new ArrayList<>();
    }
    MovementHandler handler;
    public void handlerMovement(){
        handler.handlerMovement();
    }

    public  void addObserver(Broker broker){
        observers.add(broker);
    }



    public Movement createMovement(){
        Movement movement = new Movement();
        boolean trendAssigned = false;
        do {
            String ans = "";
            System.out.println("What kind of trend is it? 'Up'/'Down'");
            ans = scan.next();
            if (ans.equalsIgnoreCase("up")) {
                movement.setTrend(Trend.UP);
                trendAssigned = true;
            } else if (ans.equalsIgnoreCase("down")) {
                movement.setTrend(Trend.DOWN);
                trendAssigned = true;
            } else {
                System.out.println("This option isn't valid");
            }
        }while(!trendAssigned);
        System.out.println("Text your massage");
        movement.setMessage(scan.next());

        return movement;
    }
    public void addMovement(){
        Movement movement = createMovement();
        movements.add(movement);
        observers.forEach(x->{x.getMovementList().add(movement);});
    }

    public void listAllMovements(){
        movements.forEach(x-> System.out.println(x));
    }

}

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Broker{
    private String name;
    MovementHandler handler;
    List<Movement> movementList;
    {
        movementList = new ArrayList<>();
    }

    public void listAllTheMovements(){
        movementList.forEach(x-> System.out.println(x));
    }
}

interface MovementHandler{
    void handlerMovement();
}

@ToString
@NoArgsConstructor
@Data
class Movement{
private Trend trend;
private String message;
private Date date;

    {
        date = new Date();
    }
}

enum Trend{
    UP, DOWN;
}

