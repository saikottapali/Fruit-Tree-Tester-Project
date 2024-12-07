import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FruitTreeTester {
    public static void main(String[] args) {
        LinkedBST<Fruit> fruitTree = new LinkedBST<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the fruit tree!");
        System.out.print("Please enter a Fruit File Name: ");
        String fileName = scanner.nextLine();

        System.out.println("\nPopulating tree from file...");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 2) {
                    String type = data[0].trim();
                    double weight;
                    try {
                        weight = Double.parseDouble(data[1].trim());
                        if (weight > 0) {
                            fruitTree.add(new Fruit(type, weight));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid weight in file: " + data[1]);
                    }
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or could not be read.");
            return;
        }

        System.out.println("\nPrinting In-Order Traversal:");
        fruitTree.printInOrder();

        System.out.println("\nPrinting Pre-Order Traversal:");
        fruitTree.printPreOrder();

        System.out.println("\nPrinting Post-Order Traversal:");
        fruitTree.printPostOrder();

        // Deletion example
        Fruit fruitToDelete = new Fruit("apple", 0.4859853412170728);
        System.out.println("\nDeleting " + fruitToDelete);
        fruitTree.remove(fruitToDelete);

        System.out.println("\nPrinting In-Order Traversal after deletion:");
        fruitTree.printInOrder();
    }
}