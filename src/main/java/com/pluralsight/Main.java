package com.pluralsight;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Map maps Product ID (Integer) to Product Name (String)
        Map<Integer, String> inventoryMap = null;
        try {
            inventoryMap = loadInventory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a product ID to search for its name: ");

        if (inputScanner.hasNextInt()) {
            int searchId = inputScanner.nextInt();
            inputScanner.nextLine(); // Clear newline buffer

            if (inventoryMap.containsKey(searchId)) {
                String productName = inventoryMap.get(searchId);
                System.out.println("Product Name: " + productName);
            } else {
                System.out.println("We don't carry that product.");
            }
        } else {
            System.out.println("Please enter a valid numerical ID.");
        }

        inputScanner.close();
    }

    public static Map<Integer, String> loadInventory() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        File file = new File("src/main/resources/inventory.csv");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;

// Split line items by pipe character
            String[] tokens = line.split("\\|");

            if (tokens.length >= 2) {
                int id = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();

// Map ID key to Name value
                map.put(id, name);
            }
        }

        fileScanner.close();
        return map;

 }
}
