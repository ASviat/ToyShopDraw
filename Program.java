package ToyShop;

import java.util.Scanner;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) {

        int id = 1; // Counts addings and gives unique ID

        Storage storage = new Storage();
        storage.toysList.add(new Toy("Cat", 3, id++, 1.25));
        storage.toysList.add(new Toy("Dog", 1, id++, 4.0));
        storage.toysList.add(new Toy("Bug", 5, id++, 0.15));
        storage.toysList.add(new Toy("Fish", 2, id++, 0.25));

        String myAnswer = "";
        System.out.println(
                "Select the process:\nPress 1 to show storage.\nPress 2 to add to storage.\nPress 3 to play the game.\nPress q to exit.\n");

        while (!myAnswer.equals("q")) {
            try (Scanner input = new Scanner(System.in)) {

                
                myAnswer = input.nextLine();
                if (myAnswer.equals("1")) {
                    storage.showStorage();
                    System.out.println(
                            "Select the process:\nPress 1 to show storage.\nPress 2 to add to storage.\nPress 3 to play the game.\nPress q to exit.\n");

                    myAnswer = input.nextLine();

                }
                if (myAnswer.equals("2")) {
                    storage.addToStorage();

                    storage.toysList.getLast().setToyID(id++);

                    System.out.println("Toy added.");
                    
                    System.out.println(
                            "Select the process:\nPress 1 to show storage.\nPress 2 to add to storage.\nPress 3 to play the game.\nPress q to exit.\n");

                    myAnswer = input.nextLine();
                }
                if (myAnswer.equals("3")) {
                    System.out.println("The game begins!");
                    storage.pickToy();
                    GameMachine game = new GameMachine();
                    game.rollThePickedToy(storage.pickedToyForGame, storage.toysList);
                }
                

            } catch (RuntimeException e) {
                System.err.println(e.getClass().getSimpleName());
                System.err.println("Pls, redo.");
            }

        }

    }

}