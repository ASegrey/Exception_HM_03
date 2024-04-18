package Seminar_03.HM_03;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoad {
    public FileLoad() {
    }
    public StringBuilder VeiewAllData() {
        String pathBase = "Base.txt";
        StringBuilder allPerson = new StringBuilder();
        /*Попробуем прочитать базу*/
        try (BufferedReader br = new BufferedReader(new FileReader(pathBase))){
            String readString;
            while((readString = br.readLine()) != null){
                /*Читаем из файла из базы данных и добавляем в вывод */
                readString = readString.replaceAll("\\n", "");
                try (BufferedReader base = new BufferedReader(new FileReader(readString))){
                    while((readString = base.readLine()) != null){
                        readString = readString.replaceAll("\\n", "");
                        String[] parseData = readString.split(" ");
                        DataModel personData = new DataModel(parseData[0], parseData[1], parseData[2], parseData[3], parseData[4], parseData[5]);
                        allPerson.append(personData.toString()); 
                    }
                }
                catch (Exception e) {
                    allPerson.append("Файл" + readString + " не найден!!!");
                }
            }
        }
        catch (Exception e) {
            allPerson.append("Нет данных в базе");
        }
        return allPerson;
    }
}
