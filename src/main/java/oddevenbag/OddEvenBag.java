// TODO implement this class and associated methods

package oddevenbag; // Same name of directory

import java.util.ArrayList;

public class OddEvenBag {
    private ArrayList<Integer> list;
    private int sum;
    private int countOdd;

    /**
     * Create an empty OddEvenBag
     */
    public OddEvenBag() {
        list = new ArrayList<>();
    }

    /**
     * Create an OddEvenBag using the contents of an array
     *
     * @param array is not null
     */
    public OddEvenBag(int[] array) {
        list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            sum += array[i];
            if (array[i] % 2 == 1) {
                countOdd++;
            }
        }
    }

    /**
     * Add a new entry to an OddEvenBag
     *
     * @param entry
     */
    public void add(int entry) {
        list.add(entry);
        sum += entry;
        if (entry % 2 == 1) {
            countOdd++;
        }
    }

    /**
     * Remove an occurrence of a value from OddEvenBag; if value DNE then OddEvenBag unchanged
     *
     * @param entry
     */
    public void remove(int entry) {
        boolean removal = list.remove(new Integer(entry));
        if (removal) {
            sum -= entry;
            if (entry % 2 == 1) {
                countOdd--;
            }
        }
    }

    /**
     * Increment the value of each entry by 1
     */
    public void increment() {
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            num++;
            list.set(i, num);
        }
        sum += list.size();
        countOdd =
            list.size() - countOdd; // All even entries become odd, and all odd entries become even
    }

    /**
     * Decrement the value of each entry by 1
     */
    public void decrement() {
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            num--;
            list.set(i, num);
        }

        sum -= list.size();
        countOdd = list.size() - countOdd;
    }

    /**
     * Check if OddEvenBag contains a value
     *
     * @param x the value to search for
     * @return true if x is in OddEvenBag, false otherwise
     */
    public boolean contains(int x) {
        return list.contains(x);
    }

    /**
     * Count the number of occurrences of a value in OddEvenBag
     *
     * @param x the value to find the number of occurrences for
     * @return the number of occurrences of x in OddEvenBag
     */
    public int getCount(int x) {
        int count = 0;
        for (int i : list) {
            if (x == i) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sum all elements in the OddEvenBag
     *
     * @return the sum of all elements in the OddEvenBag
     */
    public int sum() {
        return sum;
    }

    /**
     * Checks if an OddEvenBag is equal to another object.
     * Two OddEvenBags are equal if they have the same number of
     * odd and even elements.
     *
     * @param o object to compare with
     * @return true if this is equal to o
     */
    public boolean equals(Object o) {
        if (o instanceof OddEvenBag) {
            OddEvenBag other = (OddEvenBag) o; // Cast as OddEvenBag type

            // "this" for list in class
            if (this.countOdd == other.countOdd && this.list.size() == other.list.size()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Objects that are equal must return the same hash code.
     * It's not required for different objects to return different hash codes.
     * @return an integer value
     */
    public int hashCode(){
        // If two objects were equal, then countOdd would be the same;
        return this.countOdd;
    }
}