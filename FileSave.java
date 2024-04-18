package Seminar_03.HM_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileSave {

    public FileSave() {
    }

    /**
     * @param str
     */
    public void LoadInFile(DataModel data) {
        String pathBase = "Base.txt";
        String path = data.getLastName() + ".txt";
        Boolean save = true;
        /*Попробуем прочитать базу*/
        try (BufferedReader br = new BufferedReader(new FileReader(pathBase))){
            String readString;
            while((readString = br.readLine()) != null){
                readString = readString.replaceAll("\\n", "");
                if (readString.equals(path)){
                    save = false;
                    break;
                }
            }
            if (save){
                try(FileWriter fwb = new FileWriter(pathBase, true)){
                    fwb.write(path);
                    fwb.write("\n");
                }
                catch (Exception eb) {
                    System.out.println("Файл занят, попробуйте позже");
                }
            }
        }
        catch (Exception e) {
            /*Создаем базу */
            try(FileWriter fw = new FileWriter(pathBase)){
                fw.write(path);
                fw.write("\n");
            }
            catch (Exception er) {
                System.out.println("Файл занят, попробуйте позже");
            }
        }
        save = false;
        /*Поробуем прочитать файл, если нет, то точно добавляем запись */
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            /*Файл есть, нужно прочитать и сравнить*/
            //чтение построчно
            String s;
            String[] wordArr = new String[5];
            while((s = br.readLine()) != null){
                s = s.replaceAll("\\n", "");
                wordArr = s.split(" ");
                for (int i = 0; i < wordArr.length; i++) {
                    if (wordArr[i] != data.getDataModel(i)){
                        save = true;
                    }  
                }
                if (save){break;}
            }
        } catch (Exception e) {
            save = true;
        }
        if(save){
        try(FileWriter fw = new FileWriter(path, true)){
            for (int i = 0; i < data.getLength(); i++) {
                fw.write(data.getDataModel(i) + " ");
            }
            fw.write("\n");
            System.out.println("Запись добавлена в " + path);
        }
        catch (Exception e) {
            System.out.println("Файл занят, попробуйте позже");
        }
        }
        else {
            System.out.println("Запись в файле уже есть!");
        }
    }
}
