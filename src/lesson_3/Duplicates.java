package lesson_3;

/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.*/

import java.util.*;

public class Duplicates {

    public static void main(String[] args) {

        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        String [] array = new String[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = "Value" + ((int) (Math.random() * (20)));
        }

        findUniques(array);
        countDuplicates(array);

    }

    public static void findUniques(String[] array) {

        Set<String> set = new HashSet<String>();

        Collections.addAll(set, array);

        System.out.println("Уникальыне значения массива:");

        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void countDuplicates(String[] array) {

        HashMap<String, Integer> counter = new HashMap<>();

        for (String s : array) {

            if (counter.containsKey(s)) {
                Integer value = counter.get(s);
                counter.replace(s, value + 1);
            } else {
                counter.put(s, 1);
            }

        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println("Слово " + entry.getKey() + " повторяется " + entry.getValue() + " раз.");

        }
        System.out.println();
    }

}
