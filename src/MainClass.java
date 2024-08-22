import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size for list1: ");
        int size1 = sc.nextInt();
        System.out.print("Enter the size for list2: ");
        int size2 = sc.nextInt();
        Method.arrValue(list1, size1);
        Method.arrValue(list2, size2);
        ArrayList<Integer> list3 = Method.addition(list1, list2);
        ArrayList<Integer> list4 = Method.subtraction(list1, list2);
        ArrayList<Integer> list5 = Method.multiplication(list1, list2);

        StringBuilder result = new StringBuilder(); //used StringBuilder, easier and mutable for putting result
        result.append("list1: ").append(list1).append("\n");
        result.append("list2: ").append(list2).append("\n");
        result.append("Addition of lists: ").append(list3).append("\n");
        result.append("Subtraction of lists: ").append(list4).append("\n");
        result.append("Multiply of lists: ").append(list5).append("\n");
        Method.intersection(list1, list2, result); //did try to put words, inside other only this one worked

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File.FILE_PATH, true))) { //true for not overwriting
            bw.write(result.toString()); // turn result to string
            bw.newLine(); //newLine for each paragraph
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
