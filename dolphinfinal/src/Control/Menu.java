package Control;
import UI.UI;
import FileHandler.Files;
import java.util.Scanner;

public class Menu {

    private final UI ui = new UI();

    public void run() {
        Files files = new Files();
        files.createFile();
        files.createCompetitiveFile();
        loginMenu(); }

    public void loginMenu() {
        ui.printLoginMenu();
        Scanner scan = new Scanner(System.in);
        int running = 0;
        String userInput = scan.nextLine();
        while (running!=1) {
            switch (userInput) {
                case "Delfin":
                    startupMenu();
                case "exit":
                    ui.getString("Lukker ned ...");
                    running = 1;
                    break;
                default:
                    ui.getString("Forkert password, prøv igen");
                    loginMenu(); } } }

    public void startupMenu() {
        Chairman chairman = new Chairman();
        Cashier cashier = new Cashier();
        Coach coach = new Coach();
        Scanner scan = new Scanner(System.in);
        ui.printStartUpMenu();
        int running = 0;
        int userInput = scan.nextInt();
        while (running!=1) {
            switch (userInput) {
                case 1:
                    try {
                        chairman.chairmanMenu();
                    } catch (Exception e) {
                        ui.errorMessage(); }
                    break;
                case 2:
                    try {
                        cashier.cashierMenu();
                    } catch (Exception e) {
                        ui.errorMessage(); }
                    break;
                case 3:
                    coach.coachMenu();
                    break;
                case 9:
                    loginMenu();
                case 0:
                    running = 1;
                default:
                    ui.errorMessage();
                    startupMenu();} } }
}