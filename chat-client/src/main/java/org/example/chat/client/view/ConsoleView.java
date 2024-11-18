package org.example.chat.client.view;

import java.util.Scanner;

public class ConsoleView implements View{
    Scanner scanner = new Scanner(System.in);

    public String get() {
        return scanner.nextLine();
    }

    @Override
    public void set(String value) {
        System.out.println(value);
    }


}
