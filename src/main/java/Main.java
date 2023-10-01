import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите фамилию, имя, отчество, дату рождения, телефон и пол человека: ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();


        String[] parseData = data.split(" ");
        validateSize(parseData);

        String surname = parseData[0];
        String name = parseData[1];
        String midname = parseData[2];

        String birthdate = validateDate(parseData[3]);
        String phone = validatePhone(parseData[4]);
        String sex = validateSex(parseData[5]);

        Person person = new Person(surname, name, midname, birthdate, phone, sex);
        String filename = person.surname + ".txt";

        File file = new File(filename);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(person.toString());
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void validateSize(String[] parseData) {
        if (parseData.length < 6) throw new DataSizeException("мало");
        if (parseData.length > 6) throw new DataSizeException("много");
    }

    public static String validateDate(String date) {
        boolean isMatch = Pattern.compile("(0[0-9]|[12][0-9]|[01])\\.(0[0-9]|1[012])\\.((19|20)\\d\\d)")
                .matcher(date)
                .find();
        if (!isMatch) throw new DateFormatException("Введена некорректная дата рождения!");
        return date;
    }

    public static String validatePhone(String phone) {
        boolean isMatch = Pattern.compile("[1-9]([0-9]{6}|[0-9]{10})")
                .matcher(phone)
                .find();
        if (!isMatch) throw new PhoneNumberFormatException("Введен некорректный номер телефона!");
        return phone;
    }

    public static String validateSex(String sex) {
        boolean isMatch = Pattern.compile("[mf]")
                .matcher(sex)
                .find();
        if (!isMatch) throw new SexFormatException("Введен некорректный пол!");
        return sex;
    }
}

