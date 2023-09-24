package ToyShop;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * GameMachine
 */
public class GameMachine {

    PriorityQueue<Toy> myPriorityQueue;

    // PriorityQueue<Toy> mPriorityQueue = new PriorityQueue<>(
    // (o1, o2) -> Double.compare(o1.getToysWeight(), o2.getToysWeight()));

    /**
     * Rolling a chance to pick selected toy in a game a give toy if its a win.
     * 
     * @throws InterruptedException
     */
    public void rollThePickedToy(String pickedToy, LinkedList<Toy> myList) {
        try {
            Random randomRoll = new Random();
            double pickedToysWeight = 0;
            for (Toy toy : myList) {
                if (pickedToy.equals(toy.getToysName())) {
                    pickedToysWeight = toy.getToysWeight();
                    break;
                }
            }
            double k = pickedToysWeight / 5; // We take 5 kg for max weight.
            double playersRoll = randomRoll.nextDouble(100) * (1 - k);
            System.out.print("You roll .");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".\n");
            System.out.printf("%.2f", playersRoll);

            System.out.print("\nKasino rolles .");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".\n");
            Thread.sleep(700);
            System.out.println("Pray to the Lord additional 2 seconds!");
            Thread.sleep(2000);
            double kasinoRoll = randomRoll.nextDouble(100);
            System.out.printf("%.2f", kasinoRoll);

            if (playersRoll > kasinoRoll) {
                System.out.println("\nCongratulation! You won!");
                for (int i = 0; i < myList.size(); i++) {
                    if (pickedToy.equals(myList.get(i).getToysName())) {
                        int quantity = myList.get(i).getToysQuantity();
                        myList.get(i).setToysQuantity(quantity - 1);
                        myPriorityQueue.add(myList.get(i));
                    }
                }
            } else {
                System.out.println("\nShame on you, looser!");
            }

        } catch (InterruptedException e) {
            System.err.println("\nDon't interrupt the waiting of rolling! Be patient!");
            rollThePickedToy(pickedToy, myList);
        }

    }

}