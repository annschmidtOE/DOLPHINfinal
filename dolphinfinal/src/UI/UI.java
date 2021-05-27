package UI;
import java.util.Scanner;

public class UI {

    private final Scanner scan = new Scanner(System.in);

    //----------------------------------MENU----------------------------------
    public void printLoginMenu() {
        getString("VELKOMMEN TIL SVØMMEKLUBBEN DELFINEN!");
        getString("Indtast password for at komme til adminstrator menuen,");
        getString("for at afslutte programmet, skriv: exit "); }

    public void printStartUpMenu() {
        getString("Velkommen!");
        getString("1. Formand");
        getString("2. Kasser");
        getString("3. Træner");
        getString("9. Log af");
        getString("0. Luk ned"); }

    public void returnMenu() {
        getString("8. Tilbage");
        getString("9. Log af");
        getString("0. Afslut"); }

    public void errorMessage() {
        getString(colorText("red","Fejl, prøv igen")); }

    public void emptyList() {getString("Listen er tom");}
    //-------------------------------STRING GETTER----------------------------
    public String getString(String message){
        System.out.println(colorText("blue",message));
        return message; }
    //------------------------------INTEGER GETTER----------------------------
    public int getInt(String message) {
        System.out.println(colorText("cyan",message));
        return intValidate(); }
    //---------------------------INT VALIDATION-------------------------------
    public int intValidate() {
        while (!(scan.hasNextInt())) {
            System.out.println(colorText("red","Invalid input"));
        }
        int nextInput = scan.nextInt();
        scan.nextLine();
        return nextInput; }
    //---------------------------COLOR CODING---------------------------------
    public String colorText(String colorIndex, String text) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";
        String color = switch (colorIndex.toLowerCase()) {
            case "red" -> ANSI_RED;
            case "blue" -> ANSI_BLUE;
            case "cyan" -> ANSI_CYAN;
            default -> ANSI_RESET; };
        return color + text + ANSI_RESET; }
}
