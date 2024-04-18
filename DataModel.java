package Seminar_03.HM_03;

public class DataModel {
    private String lastName;   // Фамилия
    private String firstName;  // Имя
    private String fatherName; // Отчество
    private String birthDate;  // Дата рождения    
    private String foneNumber; // Телефон число 89265770938 (11 знаков)
    private String gender;     // Пол F или M
    private int length; 
      
    public int getLength() {
        return length;
    }

    public DataModel(String lastName, String firstName, String fatherName, String birthDate, String foneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.foneNumber = foneNumber;
        this.gender = gender;
        length = 6;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFoneNumber() {
        return foneNumber;
    }

    public void setFoneNumber(String foneNumber) {
        this.foneNumber = foneNumber;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDataModel(int index){
        String answer = "";
        switch (index) {
            case 0:
                answer = getLastName();
                break;
            case 1:
                answer = getFirstName();
                break;
            case 2:
                answer = getFatherName();
                break; 
            case 3:
                answer = getBirthDate();
                break;
            case 4:
                answer = getFoneNumber();
                break; 
            case 5:
                answer = getGender();
            break; 
            default:
                break;
        }
        return answer;
    }
    @Override
    public String toString() {
        return  "<" + getLastName() + ">"+
        "<" + getFirstName()+ ">" +
        "<" + getFatherName()+ ">" +
        "<" + getBirthDate()+ ">" + 
        "<" + getFoneNumber()+ ">" +
        "<" + getGender()+ ">" + "\n"
                ;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
