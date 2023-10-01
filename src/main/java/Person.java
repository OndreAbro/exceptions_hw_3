public class Person {
    String surname;
    String name;
    String midname;
    String birthdate;
    String phone;
    String sex;

    public Person(String surname, String name, String midname, String birthdate, String phone, String sex) {
        this.surname = surname;
        this.name = name;
        this.midname = midname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", surname, name, midname, birthdate, phone, sex);
    }

}
