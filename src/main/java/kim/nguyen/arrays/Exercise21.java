/**
 * Create a class Person with 2 fields: int age and String name. In main, create
 * an array of 5 person, and sort the array with name ascending. If names are equal
 * sort in age descending order.
 * 
 * @version %I%, %G%
 * 
 * @author Kim Nguyen
 */

package kim.nguyen.arrays;

import java.util.Arrays;
import java.util.Collections;

public class Exercise21 {
    
    public static void main(String[] args) {
        final int SIZE = 5;

        Person[] person = new Person[SIZE];
        String[] names = { "doan", "kim", "doan", "Thy", "kim" };
        int[] ages = { 25, 18, 30, 32, 24 };

        /* Assigns values for the elements in the array */
        for (int index = 0; index < SIZE; ++index) {
            person[index] = new Person(names[index], ages[index]);
        }

        Arrays.sort(person);

        System.out.println(Arrays.toString(person));

        Arrays.sort(person, Collections.reverseOrder());

        System.out.println(Arrays.toString(person));
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person person) {
        if (name.compareTo(person.name) != 0) {
            return name.compareTo(person.name);
        } else {
            if (age >= person.age) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public String toString() {
        String result = "[name = " + name + ", age = " + age + "]";
        return result;
    }
}
