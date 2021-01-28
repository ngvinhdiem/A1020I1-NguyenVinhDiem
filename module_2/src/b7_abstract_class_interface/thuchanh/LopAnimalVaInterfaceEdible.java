package b7_abstract_class_interface.thuchanh;
abstract class Animal {
    public abstract String makeSound();
}

interface Edible {
    String howToEat();
}

abstract class Fruits implements Edible{
}

class Tigers extends Animal {
    @Override
    public String makeSound() {
        return "Gru Gru";
    }

}

class Chickens extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Cluck";
    }

    @Override
    public String howToEat() {
        return "fried, steam";
    }
}

class Apple extends Fruits {

    @Override
    public String howToEat() {
        return "sliced";
    }
}

class Orange extends Fruits {

    @Override
    public String howToEat() {
        return "juiced";
    }
}
public class LopAnimalVaInterfaceEdible {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tigers();
        animals[1] = new Chickens();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chickens) {
                Edible edibler = (Chickens) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruits[] fruits = new Fruits[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruits fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}