package presenter;

import petsreg.Animal;

import petsreg.PetRegistry;

import java.util.List;

public class PetPresenter {

    private final PetRegistry petRegistry;

    public PetPresenter() {
        this.petRegistry = new PetRegistry();
    }

    public List<Animal> getPets() {
        return petRegistry.getPets();
    }

    public void addDog(int id, String name, int age) {
        petRegistry.addDog(petRegistry.getId(), name, age);
    }

    public void addCat(int id, String name, int age) {
        petRegistry.addCat(petRegistry.getId(), name, age);
    }

    public int getId(){
        return petRegistry.getId();
    }

    public void showPets() {
        petRegistry.showPets(getPets());
    }

    public int getSize() {
        return petRegistry.getSize();
    }

    public void addCommand(int id, String command) {
        petRegistry.addCommand(id, command);
    }

    public void showCommands() {
        petRegistry.showCommands();
    }

    public void add() {
        petRegistry.add();
    }
}


