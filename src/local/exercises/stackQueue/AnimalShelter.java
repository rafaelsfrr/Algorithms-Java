package local.exercises.stackQueue;

import java.util.GregorianCalendar;
import java.util.LinkedList;


// Here we have a space/time tradeoff - if we want an O(1) time bound, we need to implement two separate queues
// resulting in a O(A + B) space bound
public class AnimalShelter {

    private enum AnimalType {
        DOG,
        CAT
    }

    private static class Animal {
        private String name;
        private AnimalType type;
        private GregorianCalendar arrivalDate;

        public Animal(String name, AnimalType type, GregorianCalendar arrivalDate) {
            this.name = name;
            this.type = type;
            this.arrivalDate = arrivalDate;
        }

        @Override
        public String toString() {
            return this.name + " " + this.type + " " + this.arrivalDate.getTime();
        }
    }

    // O(A + B) space
    private LinkedList<Animal> queueDog = new LinkedList<>();
    private LinkedList<Animal> queueCat = new LinkedList<>();

    // O(1)
    public void enqueue(String name, AnimalType type, GregorianCalendar arrivalDate) {
        Animal nAnimal = new Animal(name, type, arrivalDate);
        if(nAnimal.type == AnimalType.DOG)
            queueDog.add(nAnimal);
        else queueCat.add(nAnimal);
    }

    // O(1)
    public Animal dequeueAny() throws Exception {
        if(!queueDog.isEmpty() && !queueCat.isEmpty()) {
            if(queueDog.getFirst().arrivalDate.after(queueCat.getFirst().arrivalDate)) {
                return queueCat.poll();
            } else {
                return queueDog.poll();
            }
        } else if(!queueCat.isEmpty()) {
            return queueCat.poll();
        } else if(!queueDog.isEmpty()) {
            return queueDog.poll();
        }
        throw new Exception("Not found any animal on the queue");
    }

    // O(1)
    public Animal dequeueDog() throws Exception {
        if(!queueDog.isEmpty()) {
            return queueDog.poll();
        }
        throw new Exception("Not found any dog on the queue");
    }

    // O(1)
    public Animal dequeueCat() throws Exception {
        if(!queueCat.isEmpty()) {
            return queueCat.poll();
        }

        throw new Exception("Not found any cat on the queue");
    }
}
