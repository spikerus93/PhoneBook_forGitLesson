package myPhoneBook;

import java.util.*;

import static myPhoneBook.PhoneBook.addContact;
import static myPhoneBook.PhoneBook.printContacts;

public class App {
    public static void main (String[] args) {
        addContact("Иванов", "11-22-33");
        addContact("Сидоров", "11-23-34");
        addContact("Семенов", "12-23-43");
        addContact("Иванов", "13-24-33");
        addContact("Иванов", "12-23-48");
        addContact("Сидоров", "11-26-34");
        printContacts();

    }
}

class PhoneBook {
    private static HashMap<String, ArrayList> contacts = new HashMap<>();

//    Создание метода "добавить запись в телефонную книгу."
    public static void addContact (String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            ArrayList phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        } else {
            ArrayList phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
            }
        }
//    Создание метода для вывода списка контактов "по убыванию"
    public static void printContacts() {
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList<>(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> t1, Map.Entry<String, ArrayList> t2) {
                return t2.getValue().size() - t1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
