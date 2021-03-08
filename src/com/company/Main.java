package com.company;
// Every import
import com.company.statements.Order;
import com.company.statements.Product;
import com.company.statements.User;
import java.util.Scanner;
import java.sql.*;

// Main
public class Main {
    public static void main(String[] args) throws SQLException {
        // Important fields
        Product product = new Product();
        User user = new User();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        // Contacting with user
        System.out.println("Welcome, to my little shop");
        System.out.println("We have 5 activity, choose one by writing letter from 1 to 5");
        // Infinite loop
        while (true) {
            System.out.println();
            System.out.println("1 - Create me as new user");
            System.out.println("2 - Open all available products");
            System.out.println("3 - See all users, that was here");
            System.out.println("4 - make order");
            System.out.println("5 - Exit from shop");
            System.out.println();
            // Depending on the selected number, the action will be performed
            try {
                int s = scanner.nextInt();
                if ( s == 1 ) {
                    System.out.println("Write down your credit card info:");
                    user.createUser();

                }
                if ( s == 2) {
                    product.Select();
                }
                if ( s == 3) {
                    user.seeAllUsers();
                }
                if ( s == 4) {
                    order.createOrder();
                }
                // Exit from program
                if ( s == 5) {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}