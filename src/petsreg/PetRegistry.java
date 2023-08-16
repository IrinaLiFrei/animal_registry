package petsreg;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class PetRegistry {

    private final List<Animal> pets = new ArrayList<>();
    private final Map<Integer,String> commands = new HashMap<>();

    private final Counter count = new Counter();

    public List<Animal> getPets(){
        return pets;
    }

    public List<Animal> showPets(List<Animal> pets) {
        System.out.println("\nPets: ");
        for (Animal pet : pets) {
            System.out.printf("%d. %s => name: %s, age: %d\n",
                    pet.getId(), pet.getClass().getSimpleName().toUpperCase(),
                    pet.getName(), pet.getAge());
        }
        return pets;
    }

    public int getSize() {
        return pets.size();
    }

    public void addDog(int id, String name, int age){
        id = pets.size() + 1;
        Animal dog = new Dog (id, name, age);
        pets.add(dog);
        commands.put(id, null);
    }

    public void addCat(int id, String name, int age){
        id = pets.size() + 1;
        Animal cat = new Cat (id, name, age);
        pets.add(cat);
        commands.put(id, null);
    }

    public int getId(){
        int id = pets.size() + 1;
        return id;
    }

    public void addCommand(int id, String command) {
        if (commands.get(id) == null) {
            commands.replace(id, command);
        } else {
            String string = commands.get(id) + "; " + command;
            commands.replace(id, string);
        }
    }

    public void showCommands() {
        for (Map.Entry<Integer,String> entry : commands.entrySet()) {
            Integer key = entry.getKey();
            System.out.print(key + ". ");
            System.out.print(getPets().get(key - 1).getName());
            System.out.print(" => ");
            String value = entry.getValue();
            System.out.print(value);
            System.out.println();

        }
    }

    public void add() {
        try (FileWriter writer = new FileWriter("counter.txt", false)) {
            count.add();
            String string = String.valueOf(count.getCount());
            writer.write(string);
            System.out.println("Counter: " + count.getCount());
            writer.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
