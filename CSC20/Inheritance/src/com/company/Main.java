package com.company;
/**
 * The abstract class that is intended to be extended
 * The shared properties of furnitures should all go here
 */
abstract class Furniture {
    // Every furniture has a certain number of legs.
    // We use the abstract keyword so that the
    // extended (child) class is forced to extend this method.
    // Every object that is a furniture has an identity
    abstract void id();
    // The legCount will also be available to the child classes
    // It does not need to be reimplemented like methods do
    int legCount = 4;

    // Other methods can also be included that do not have to be overridden by the child class
    void legs() {
        System.out.printf("I have %d legs!%n", legCount);
    }

}

/*
 * A chair is a type of furniture.
 * It inherits all furniture properties except the furniture object constructor
 */
class Chair extends Furniture {
    void id() {
        System.out.println("Im a chair");
    }
}

/*
 * A recliner is a type of furniture
 */
class Recliner extends Furniture {
    // The legCount, defined in the Furniture class, is assigned to here.
    // The legCount differs from furniture to furniture
    //int legCount = 4;
    void id() {
        System.out.println("I'm a recliner");
    }
}

class LaZBoy extends Recliner {
    // A laZboy is a type of recliner, so the id method doesn't necessary need to be extended
    // Still, it can be extended if needed, like so

    void id() {
        System.out.println("I'm a laZboy");
    }

    // For demonstration, the legs method is overridden here,
    // to show that legCount from the abstract method can be used in a child class
    @Override
    void legs() {
        System.out.printf("This laZboy has %d legs!%n", legCount);
        // Parent variables can also be modified, like so
        legCount--;
        System.out.printf("Lost a leg! Now, %d legs remain!%n", legCount);
    }
}

class furnitureTest {
    public static void main(String[] args) {
        // The furniture set array
        Furniture[] set = {
            new Chair(),
            new Recliner(),
            new LaZBoy()
        };

        // For each furniture in the set
        for(Furniture f : set) {
            // Call the id and legs methods of each furniture, represented as f
            f.id();
            f.legs();
            System.out.println();
        }
    }
}

class A { int x = 1; }              // Parent
class B extends A { }               // Has A's properties
class C extends B { int x = 2;}     // Has B's properties which are modified
class classTest{
    public static void main(String[] args) {
        A w = new A(); System.out.println(w.x); // 1
        B u = new B(); System.out.println(u.x); // 1
        C v = new C(); System.out.println(v.x); // 2
        // A objects casted as A, B, C: A, which has an x value of 1,
        // goes through a widening conversion to both B and C
        A[] a = {
            new A(),    // A in A, x = 1
            new B(),    // A in B, x = 1
            new C()     // A in C, x = 1
        };
        for (int i=0; i<3; ++i) System.out.println(a[i].x); // 1 1 1
    }
}