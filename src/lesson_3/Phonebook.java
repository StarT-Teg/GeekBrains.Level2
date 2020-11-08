package lesson_3;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
*/

import java.util.HashMap;

public class Phonebook {
    
    private static HashMap <String, String> phonebook = new HashMap<>();

    public void add (String surname, String telephoneNumber){

        surname = surname.toLowerCase();

        if (phonebook.containsKey(surname)){
            System.out.println("Такая фамилия уже существует! Номер добавлен в список номеров контакта");
            phonebook.replace(surname, (phonebook.get(surname) +", " + telephoneNumber));
            System.out.println();
        }
        else {
            phonebook.put(surname, telephoneNumber);
            System.out.println("Контакт успешно добавлен!");
            System.out.println();
        }
    }

    public void get (String surname){

        if (phonebook.containsKey(surname.toLowerCase())){
            System.out.println("Номера телефонов для фамилии " + surname + ":");
            System.out.println(phonebook.get(surname.toLowerCase()));
            System.out.println();
        }
        else {
            System.out.println("Такого контакта не существует!");
        }


    }

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();
        phonebook.add("Путин", "+7903434634");
        phonebook.add("Путин", "+54884567345");
        phonebook.add("РЕпин", "+56954673433");
        phonebook.get("Путин");
        phonebook.get("репин");
        phonebook.get("Репин");
        phonebook.get("Пепин");

    }
}
