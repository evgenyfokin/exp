package Exception.hw3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mydata = "";
        try (Scanner scanner = new Scanner(System.in, "cp866");) {
            System.out.println("Enter your data separated by space "+
                    "(Full name, date of birth in format dd.mm.yyyy, phone number, gender: m or f): ");
            mydata = scanner.nextLine();
        }
        CheckList ch = new CheckList(mydata);
        if (ch.getCorrect()) {
            File file = new File(ch.getSurname());
            try (FileWriter writer = new FileWriter(file, true);) {
                String data = ch.getSurname() + " " + ch.getName() + " " + ch.getSecondName() + " " + ch.getDate() + " "
                        + ch.getTelephone() + " " + ch.getGender() + " \n";
                writer.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}