package com.company;

import com.company.statements.product;
import com.company.statements.user;

import java.util.Scanner;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        product a = new product();
        user b = new user();
        Scanner scanner = new Scanner(System.in);
        Scanner scaner = new Scanner(System.in);
        Scanner addresss = new Scanner(System.in);

        System.out.println("Welcome, to my little shop");
        System.out.println("We have 4 activity, choose one by writing letter from 1 to 4");
        while (true) {
            System.out.println();
            System.out.println("1 - Create me as new user");
            System.out.println("2 - Open all available products");
            System.out.println("3 - ");
            System.out.println("4 - Exit from shop");
            System.out.println();
            try {
                int s = scanner.nextInt();
                if ( s== 1 ) {
                    System.out.println("Write down your credit card info:");
                    b.seeAllUsers();

                }
                if ( s == 2) {
                    a.Select();
                }
                if ( s == 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}