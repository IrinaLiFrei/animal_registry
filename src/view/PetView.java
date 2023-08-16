package view;

import presenter.PetPresenter;

import java.io.IOException;
import java.util.Scanner;

public class PetView {
    final Scanner scanner = new Scanner(System.in);
    private final PetPresenter petPresenter;

    public PetView() {
        this.petPresenter = new PetPresenter();
    }

    public void showError(String message) {
        System.err.println(message);
    }

    public void start() throws IOException {
        System.out.println("Welcome to our Pet Registry!");
        boolean loop = true;
        while (loop) {
            System.out.println("Select option:");
            System.out.println("1. Add a pet");
            System.out.println("2. Add a command");
            System.out.println("3. Show all pets");
            System.out.println("4. Show all commands");
            System.out.println("0. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> addCommand();
                case 3 -> showPets();
                case 4 -> showCommands();
                case 0 -> loop = false;
                default -> showError("Unacceptable command.");
            }

            System.out.println();
        }
    }

    private void addPet() {
        System.out.print("""
                Choose the type of pet:
                1. Dog
                2. Cat
                """);
        int petType;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Try again. Choose a number of pet type ");
                scanner.next();
            }
            petType = scanner.nextInt();
            scanner.nextLine();
        } while (petType < 1 || petType > 2);

        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();

        System.out.print("Enter pet age: ");
        int age;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age <= 0);
        if (petType == 1) {
            petPresenter.addDog(petPresenter.getId(), name, age);
        } else {
            petPresenter.addCat(petPresenter.getId(), name, age);
        }
        if (name != "") {
            petPresenter.add();
        }
    }

    private void addCommand() {
        System.out.print("Choose a pet to teach it a command: ");
        showPets();
        int id;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Choose pet id");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id <= 0 || id > petPresenter.getSize());
        System.out.print("Enter a command: ");
        String command = scanner.nextLine();
        petPresenter.addCommand(id, command);
    }

    private void showPets() {
        petPresenter.showPets();
    }

    private void showCommands() {
        petPresenter.showCommands();
    }
}

