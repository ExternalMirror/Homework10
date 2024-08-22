import java.util.ArrayList;
import java.util.Random;
public class Method {
    public static void arrValue(ArrayList<Integer> list, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size cannot be negative or zero");
        }
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100) + 1);
        }
    }
    public static ArrayList<Integer> addition(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<>();
        //list3 for adding addition results

        int maxSize = Math.max(list1.size(), list2.size());
        //for comparing with max size to put values

        for (int i = 0; i < maxSize; i++) {
            int value1 = (i < list1.size()) ? list1.get(i) : 0;
            int value2 = (i < list2.size()) ? list2.get(i) : 0;
            //first used separate for adding "0" but it is said, need to calculate 0's as well in calculations
            //instead of that I used get and misc operator, looks way cleaner, I think at least
            //though, take a lot of time for some reason
            list3.add(value1 + value2);
        }
        return list3;
    }
    public static ArrayList<Integer> subtraction(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list4 = new ArrayList<>();

        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            int value1 = (i < list1.size()) ? list1.get(i) : 0;
            int value2 = (i < list2.size()) ? list2.get(i) : 0;
            list4.add(value1 - value2);
        }
        //same here
        return list4;
    }
    public static ArrayList<Integer> multiplication(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list5 = new ArrayList<>();

        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            int value1 = (i < list1.size()) ? list1.get(i) : 0;
            int value2 = (i < list2.size()) ? list2.get(i) : 0;
            list5.add(value1 * value2);
        }
        //same here
        return list5;
    }
    public static void intersection(ArrayList<Integer> list1, ArrayList<Integer> list2, StringBuilder result) {
        ArrayList<Integer> intersection = new ArrayList<>();
        //empty intersection list here for storing
        for (int num : list1) {
            if (list2.contains(num) && !intersection.contains(num)) {
                intersection.add(num); //put num's in list
                // for each list 1 num checks list 2 contains that num
                // did put !intersection.contains(num) for not adding same numbers
            }
        }

        if (!intersection.isEmpty()) { //overall check if there was any value that was added in above in list
            int max = Integer.MIN_VALUE; // used to ensure that it gets value from intersection for comparing
            int maxIndex = -1; //invalid index, can use for validation
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < intersection.size(); i++) { //check all the values in list
                int currentNumber =  intersection.get(i);
                if (intersection.get(i) > max) { //simple finding max value and index then replacing previous one
                    max = currentNumber; // first used =intersection.get(i); but didn't work
                    maxIndex = i;
                }
                if (intersection.get(i) < min) { // did write separate at first but then merged them
                    min = intersection.get(i);  // for some reason, was giving wrong numbers
                    minIndex = i;
                }
            }

            result.append("Intersection of list1 and list2: ").append(intersection).append("\n");
            result.append("Maximum value: ").append(max).append(", index: ").append(maxIndex).append("\n");
            result.append("Minimum value: ").append(min).append(", index: ").append(minIndex).append("\n"); // same with StringBuilder
        } else {
            System.out.println("There is no intersected values");
        }
    }
}
