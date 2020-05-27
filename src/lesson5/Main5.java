package lesson5;

public class Main5 {

    public static void main(String[] args) {

        Person[] persArray  = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Worker", "petrovptr@mailbox.com", "892375486", 30000, 25);
        persArray[2] = new Person("Sinyavina Marina", "Accountant", "sinyavina_marina@mailbox.com", "892324851", 30000, 42);
        persArray[3] = new Person("Kolotov Alexey", "Director", "alex_kol@mailbox.com", "892341545", 30000, 55);
        persArray[4] = new Person("Semenova Veronika", "Master", "semenova_veronika@mailbox.com", "89234651", 30000, 47);

        for (Person person : persArray) {
            if (person.getAge() > 40) {
                System.out.println(person);
            }
        }

    }
}
