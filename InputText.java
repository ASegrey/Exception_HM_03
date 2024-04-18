package Seminar_03.HM_03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/* 
Приложение должно проверить введенные данные по количеству.
Если количество не совпадает, вернуть код ошибки, обработать его 
и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется. 

Приложение должно распарсить полученную строку и выделить из них требуемые значения. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, 
что именно неверно.
*/
public class InputText {

    public InputText() {}
    
    // Метод для получения данных от пользователя
    public DataModel getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String data;
        System.out.println("Введите данные разделенные пробелами:");
        System.out.println("(Фамилия) (Имя) (Отчество) (дата рождения dd-MM-yyyy) (номер телефона - 11 цифр) (пол М/Ж) ");
        System.out.print("-> ");
        data = scanner.nextLine();
        String[] parseData = data.split(" "); //Распарсиваем строку в массив строк (разделитель пробел)
        List<String> errorsCache = new ArrayList<>();
        if (parseData.length < 6){
            errorsCache.add("Введены не все данные ");
        }

        if (!isCharInString(parseData[0])){
            errorsCache.add("Неверный формат данных-> Фамилия ");
        }

        if (!isCharInString(parseData[1])){
            errorsCache.add("Неверный формат данных-> Имя ");
        }

        if (!isCharInString(parseData[2])){
            errorsCache.add("Неверный формат данных-> Отчество ");
        }

        if (!isDataFormat(parseData[3])){
            errorsCache.add("Неверный формат данных-> Даты рождения ");
        }

        if (!isNumber(parseData[4])){
            errorsCache.add("Неверный формат данных-> Номер телефона ");
        }
        if (parseData[4].length() < 11){
            errorsCache.add("Номер телефона меньше 11 цифр");
        }
        if (parseData[4].length() > 11){
            errorsCache.add("Номер телефона больше 11 цифр");
        }
        if (!isGenderString(parseData[5]) || (parseData[5].length() > 1)){
            errorsCache.add("Неверный формат данных-> Пол ");
        }
        if (errorsCache.size() != 0){
            throw new DataException(errorsCache.toString());
        }
        return new DataModel(parseData[0], parseData[1], parseData[2], parseData[3], parseData[4], parseData[5]);
    }

    public boolean isCharInString(String dataIn){
        String badChars = ".*[1234567890`*+-/=?!].*";
        if (dataIn.matches(badChars)){
            return false;
        }
        return true;
    } 

    public boolean isDataFormat(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
        dateFormat.setLenient(false); 
        try { 
            Date parsedDate = dateFormat.parse(date); 
            return true;
        } 
        catch (ParseException e) { 
//            System.out.println("Invalid date format dd-MM-yyyy."); 
            return false;
        } 
    }

    public boolean isNumber(String str) {
        try {
            Long.parseLong(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isGenderString(String gender){
        String Chars = "[MFmfМЖмж]+";
        if (gender.matches(Chars)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public int selectMenu(){
        Scanner scanner = new Scanner(System.in);
        int data = 0;
        System.out.println("Меню программы, введите номер для выбора:");
        System.out.println("-> 1 : Ввод данных");
        System.out.println("-> 2 : Вывод всех данных");
        System.out.println("-> 3 и более : Выход");
        try
        {
            data = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.err.println("Указанно не число");

        }
        switch (data) {
            case 0:
                break;

            case 1:
                FileSave fs = new FileSave();
                fs.LoadInFile(getUserInput());
                break;
            case 2:
                System.out.println("Все сохраненные данные -> ");
                FileLoad fl = new FileLoad();
                System.out.println(fl.VeiewAllData());
                break;

            default:
                data = -1;
                System.out.println("Выход из программы");
                break;
        }
        return data;
    }

}
