package java102;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{name='" + name + "', age=" + age + '}';
    }

    public static void main(String[] args)
    {
        Person person = new Person("John", 25);
        System.out.println(person.toString()); // Ruft automatisch toString() auf
    }
}
