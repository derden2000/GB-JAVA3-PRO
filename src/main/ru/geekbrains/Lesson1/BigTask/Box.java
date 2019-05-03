package main.ru.geekbrains.Lesson1.BigTask;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    public ArrayList<T> boxContent;

    public Box() {
        this.boxContent = new ArrayList<>();
    }

    public static void main(String[] args) {
        Box<Apple> firstBox = new Box<>();
        firstBox.addToBox(new Apple());
        firstBox.addToBox(new Apple());
        firstBox.addToBox(new Apple());

        System.out.println(firstBox.getBoxContent());
        System.out.println(firstBox.getBoxWeight());

        Box<Orange> secondBox = new Box<>();
        secondBox.addToBox(new Orange());
        secondBox.addToBox(new Orange());

        Box<Apple> thirdBox = new Box<>();
        thirdBox.addToBox(new Apple());
        thirdBox.addToBox(new Apple());

        System.out.println(thirdBox.getBoxContent());
        
        Box<Apple> forthBox = new Box<>();
        thirdBox.replace(forthBox);

        System.out.println(firstBox.compare(secondBox));
        System.out.println(firstBox.compare(thirdBox));
        System.out.println(thirdBox.getBoxContent());
        System.out.println(forthBox.getBoxContent());
    }

    public ArrayList<T> getBoxContent() {
        return boxContent;
    }

    private float getBoxWeight() {
        float boxWeight = 0;
        for (T obj : boxContent) {
            boxWeight += obj.getWeight();
        }
        return boxWeight;
    }

    private Box<T> replace(Box<T> fruitBox) {
        for (T obj: this.boxContent) {
            fruitBox.addToBox(obj);
        }
        this.boxContent.removeAll(boxContent);
        return fruitBox;
    }

    private boolean compare(Box secondBox) {
        if (this.getBoxWeight() == secondBox.getBoxWeight())
        return true;
        else
            return false;
    }

    private void addToBox(T fruit) {
        boxContent.add(fruit);
    }

}