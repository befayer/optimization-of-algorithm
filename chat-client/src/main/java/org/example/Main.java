package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        Client client = new Client(username);
    }
}