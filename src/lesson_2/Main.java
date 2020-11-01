package lesson_2;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод,
обработать возможные исключения MySizeArrayException и MyArrayDataException,
и вывести результат расчета.
*/

import lesson_2.exceptions.MyArrayDataException;
import lesson_2.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {

        // Нужный массив
        String [][] array = new String [4][4];

        // Наполняем случайными значениями
        // Первый элемент можно указать буквенным и проверить эксепшн
        fillArray(array, 3, 1, "1");

        try {stringToInt(array); }
        catch (MyArraySizeException e) { e.printStackTrace();}
        catch (MyArrayDataException e){ e.printStackTrace(); }

    }

    public static void stringToInt (String [][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        int i = 0;
        int j = 0;

        // Первая проверка дял исключения укладывается в if-else
        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Массив выходит за рамки 4х4!");
        }
        else {

            // Вторая проверка идёт черз поулчение друго исключения NumberFormatException
            try {
                for (; i < array.length; i++) {
                    for (; j < array.length; j++) {
                       sum += Integer.parseInt(array[i][j]);
                    }
                    j = 0;
                }

                System.out.println("Сумма массива = " + sum);
            }catch (NumberFormatException e){
                throw new MyArrayDataException("В массиве есть нечисловое значение! Оно находится в ячейке ["+ i + "][" + j + "]");
            }

        }

    }

    public static void fillArray (String [][] array, int xCoordinate, int yCoordinate, String value){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString((int) (Math.random() * (10 - 1) + 1));
            }
        }

        array[yCoordinate][xCoordinate] = value;

    }


}
