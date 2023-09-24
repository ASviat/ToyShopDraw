package ToyShop;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Toy
 */
public class Toy implements i_EditToy {

    private int toyID;
    private String toysName;
    private int toysQuantity;
    private double toysWeight;

    public Toy(String toysName, int toysQuantity, int toyID, double toysWeight) {

        this.toysName = toysName;
        this.toysQuantity = toysQuantity;
        this.toyID = toyID;
        this.toysWeight = toysWeight;

    }

    public Toy(int toyID) {
        try (Scanner input = new Scanner(System.in)) {

            this.toyID = toyID;
            System.out.println("Enter toys name: ");
            this.toysName = input.nextLine();
            System.out.println("Enter toys quantity you'd like to add: ");
            this.toysQuantity = input.nextInt();
            System.out.println("Enter toys weight in double:\n(Example: 3,250 means 3 kg and 250 grams)");
            this.toysWeight = input.nextDouble();

        } catch (Exception e) {
            System.err.println("Uncorrect data entered. Please, redo.");

        }
    }
    public Toy(){
        
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Enter toys name: ");
            this.toysName = input.nextLine();
            System.out.println("Enter toys quantity you'd like to add: ");
            this.toysQuantity = Integer.parseInt(input.nextLine());
            System.out.println("Enter toys weight in double:\n(Example: 3.250 means 3 kg and 250 grams)");
            this.toysWeight = Double.parseDouble(input.nextLine());
            
            // System.err.println("\nMistake found.");
            // Thread.sleep(3000);
            

        } catch (Exception e) {
            System.err.println("Uncorrect data entered. Please, redo.");

        }
    }

    @Override
    public void editWeight() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Change the weight: ");
            this.toysWeight = input.nextDouble();
        } catch (Exception e) {
            System.err.println("Not correct data for Weight Editing.\nPlease, just enter double or int:\n");
            editWeight();
        }
    }

    @Override
    public void editQuantity() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Change the Quantity: ");
            this.toysQuantity = input.nextInt();
        } catch (Exception e) {
            System.err.println("Not correct data for Weight Editing.\nPlease, just enter int:\n");
            editQuantity();
        }
    }

    @Override
    public void editName() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Change the Name: ");
            this.toysName = input.nextLine();

        } catch (Exception e) {
            System.err.println("Not correct data for Name Editing.\nPlease, just enter String:\n");
            editName();
        }
    }

    public String toyToString() {
        return String.format("ID: %d, Name: %s, Quantity: %d, Weight: %.3f\n", getToyID(), getToysName(),
                getToysQuantity(), getToysWeight());
    }

    public void getToy(PriorityQueue<Toy> mPriorityQueue) {
        System.out.println(mPriorityQueue.poll().toyToString());
    }

    //////
    public double getToysWeight() {
        return toysWeight;
    }

    public void setToysWeight(double toysWeight) {
        this.toysWeight = toysWeight;
    }

    public int getToyID() {
        return toyID;
    }
    

    public void setToyID(int toyID) {
        this.toyID = toyID;
    }
    // public void setToyID() {
    //     this.toyID = toyID;
    // }

    public String getToysName() {
        return toysName;
    }

    public void setToysName(String toysName) {
        this.toysName = toysName;
    }

    public int getToysQuantity() {
        return toysQuantity;
    }

    public void setToysQuantity(int toysQuantity) {
        this.toysQuantity = toysQuantity;
    }

}