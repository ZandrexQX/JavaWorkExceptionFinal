package FinalWorJava;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/* Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество дата рождения номер телефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m. */

public class FinalWork {
    public static void main(String[] args) {
        try {
            System.out.print("Введите данные: ");
            InputData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void InputData() throws Exception {
        Scanner sc = new Scanner(System.in);
        String [] strInput = sc.nextLine().split(" ");
        String file="";
        // Блок данных
        try {
            CheckArray(strInput);
        } catch (ArrInputError e) {
            e.printStackTrace();
        }

        // Блок Фамилии имени и отчества
        try {
            String family = CheckString(strInput[0]);
            String name = CheckString(strInput[1]);
            String familySecond = CheckString(strInput[2]);
            file = "E:/Разное/Java/FinalWorJava/"+family+".txt";
        } catch (StrInputError e) {
            e.printStackTrace();
        }
        
        // Блок даты
        try {
            Date date = CheckDate(strInput[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Блок телефона
        try {
            int phone = Integer.parseInt(CheckPhone(strInput[4]));
        } catch (PhoneInputError e) {
            e.printStackTrace();
        }

        // Блок пола
        try {
            String sex = CheckSex(strInput[5]);
        } catch (SexInputError e) {
            e.printStackTrace();
        }
        
        WriterInput(file,strInput);
    }

    public static void WriterInput(String file, String [] text) {
        try(FileWriter writer = new FileWriter(file)){
            for (String string : text) {
                writer.write("<"+string+">");
            }
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String CheckString(String str) throws StrInputError {
        if (str.matches("[0-9]+") && str.length() < 2) throw new StrInputError(str);
        return str;
    }

    public static Date CheckDate(String date) throws ParseException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
            Date dateOut = formatter.parse(date);
            return dateOut;
        }
        catch(DateInputError e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String [] CheckArray(String [] arr) throws ArrInputError {
        if (arr.length != 6) throw new ArrInputError();
        return arr;
    }

    public static String CheckPhone(String phone) throws PhoneInputError {
        if (!phone.matches("[0-9]+") || phone.length() < 4) throw new PhoneInputError(phone);
        return phone;
    }

    public static String CheckSex(String sex) throws SexInputError {
        if (sex.matches("[f,m]")) return sex;
        else throw new SexInputError(sex);
    }
}
