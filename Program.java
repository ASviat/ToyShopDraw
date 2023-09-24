package ToyShop;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * Program
 */
public class Program {

    String toyPicked;

    /**
     * Queue to send toys to the winners.
     */
    PriorityQueue<Toy> mPriorityQueue = new PriorityQueue<>(
            (o1, o2) -> Double.compare(o1.getToysWeight(), o2.getToysWeight()));

    /**
     * Shows all toys in storage
     * 
     * @param myList
     */
    public static void showStorage(LinkedList<Toy> myList) {
        System.out.println("Which toy would u like to try to pick? ");
        for (Toy toy : myList) {
            System.out.printf("ID: %d - Name: '%s' - Weight: '%.3f' - Quantity: %d\n", toy.getToyID(),
                    toy.getToysName(),
                    toy.getToysWeight(),
                    toy.getToysQuantity());
        }
    }

    /**
     * Shows toy storage and asks to select a toy.
     * 
     * @param myList
     */
    public static String pickToy(LinkedList<Toy> myList) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Remember, higher the weight -- more risk -- better the price!");
            System.out.println("Write toy's name to pick: ");
            int counter = 0;
            String myAnswer = input.nextLine().toUpperCase();
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getToysName().toUpperCase().equals(myAnswer.toUpperCase())) {

                    counter = 0;
                    int quantity = myList.get(i).getToysQuantity();
                    myList.get(i).setToysQuantity(quantity - 1);
                    if (myList.get(i).getToysQuantity() == 0) {
                        System.out.printf("Last toy '%s' picked\n", myList.get(i).getToysName());
                        myList.remove(i);
                        return myAnswer;
                    } else {
                        System.out.printf("Toy '%s' picked.\n", myList.get(i).getToysName());
                        return myAnswer;
                    }

                }
                if (!myList.get(i).getToysName().toUpperCase().equals(myAnswer.toUpperCase())) {
                    counter++;

                }
                if (counter == myList.size()) {
                    System.err.println("Thx for money, bye.\n(Insert additional coin to start again)\n");
                }

            }

        } catch (RuntimeException e) {
            System.err.println("Pick the toy that exists!");

        }
        return "-1";

    }

    /**
     * Rolling a chance to pick selected toy in a game a give toy if its a win.
     */
    public static void rollThePickedToy(String pickedToy, LinkedList<Toy> myList,PriorityQueue<Toy> myPriorityQueue) {
        Random randomRoll = new Random();
        double pickedToysWeight = 0;
        for (Toy toy : myList) {
            if (pickedToy.equals(toy.getToysName())) {
                pickedToysWeight = toy.getToysWeight();
                break;
            }
        }
        double playersRoll = randomRoll.nextDouble(101) * (1 - pickedToysWeight);
        System.out.println(playersRoll);
        double kasinoRoll = randomRoll.nextDouble(101);
        System.out.println(kasinoRoll);

        if (playersRoll > kasinoRoll) {
            System.out.println("Congratulation! You won!");
            for (int i = 0; i < myList.size(); i++) {
                if (pickedToy.equals(myList.get(i).getToysName())) {
                    int quantity = myList.get(i).getToysQuantity();
                    myList.get(i).setToysQuantity(quantity - 1);
                    myPriorityQueue.add(myList.get(i))
                }
            }
        } else {
            System.out.println("Shame on you, looser!");
        }

    }

    /**
     * Counts all toys in storage
     * 
     * @param myList
     * @return int quantity
     */
    public static int allToysQuantity(LinkedList<Toy> myList) {
        int quantity = 0;
        for (Toy toy : myList) {
            quantity += toy.getToysQuantity();
        }
        return quantity;
    }

    public static void main(String[] args) {

        LinkedList<Toy> toysList = new LinkedList<>();

        int id = 1; // Counts addings and gives unique ID

        toysList.add(new Toy("Cat", 3, id++, 1.25));
        toysList.add(new Toy("Dog", 1, id++, 4.0));
        toysList.add(new Toy("Bug", 5, id++, 0.15));
        toysList.add(new Toy("Fish", 2, id++, 0.25));

        System.out.println("The game begins!");
        // System.out.println(allToysQuantity(toysList));
        showStorage(toysList);
        pickToy(toysList);
        // System.out.println(allToysQuantity(toysList));

    }

}