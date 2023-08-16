package petsreg;

public abstract class Animal {

    private String name;
    private int age;
    private int id;

    public Animal(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


}
