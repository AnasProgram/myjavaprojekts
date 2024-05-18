package java102;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Erstellen eines HashMap-Objekts mit Schlüssel vom Typ String und Werten vom Typ Integer
        HashMap<String, Integer> studentGrades = new HashMap<>();

        // Hinzufügen von Schlüssel-Wert-Paaren
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 95);

        // Abrufen des Werts anhand des Schlüssels
        int aliceGrade = studentGrades.get("Alice");
        System.out.println("Alice's Note: " + aliceGrade);
    }
}

