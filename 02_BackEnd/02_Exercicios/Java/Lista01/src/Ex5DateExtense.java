import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex5DateExtense {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String date = "";
        boolean isDateValid = false;
        while(true){
            System.out.println("Type a date in the format dd/mm/aaaa");
            date = in.next();
            isDateValid = Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/\\d+", date);
            if(isDateValid){
                break;
            } else {
                System.out.println("Invalid date.");
            }
        }        
        String[] dateSplit = date.split("/");
        String dayNumber = dateSplit[0];
        String monthNumber = dateSplit[1];
        String yearNumber = dateSplit[2];
        String monthName;
        switch(monthNumber){
            case "01": {
                monthName = "janeiro";
                break;
            }
            case "02": {
                monthName = "fevereiro";
                break;
            }
            case "03": {
                monthName = "março";
                break;
            }
            case "04": {
                monthName = "abril";
                break;
            }
            case "05": {
                monthName = "maio";
                break;
            }
            case "06": {
                monthName = "junho";
                break;
            }
            case "07": {
                monthName = "julho";
                break;
            }
            case "08": {
                monthName = "agosto";
                break;
            }
            case "09": {
                monthName = "setembro";
                break;
            }
            case "10": {
                monthName = "outubro";
                break;
            }
            case "11": {
                monthName = "novembro";
                break;
            }
            case "12": {
                monthName = "dezembro";
                break;
            }
            default: monthName = "invalid";    
        }
        System.out.printf("%s de %s de %s", dayNumber, monthName, yearNumber);
        in.close();
    }
}
