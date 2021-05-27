package Control;
import UI.UI;
import UI.UIChairman;
import MemberControl.Control;
import MemberControl.Display;
import Competitive.CompetitiveControl;
import java.util.Scanner;
import Competitive.CompetitiveDisplay;

public class Chairman {

    private final UI ui = new UI();
    private final UIChairman uiChairman = new UIChairman();

    public void chairmanMenu() {
        uiChairman.printChairmanMenu();
        Menu menu = new Menu();
        Control memberControl = new Control();
        CompetitiveControl competitiveControl = new CompetitiveControl();
        Scanner scan = new Scanner(System.in);

        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    try {
                        memberControl.createMember();
                        chairmanMenu();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        competitiveControl.createMember();
                        chairmanMenu();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    printMembersMenu();
                    break;
                case 4:
                    memberControl.deleteMember();
                    chairmanMenu();
                    break;
                case 5:
                    competitiveControl.deleteCmpetitive();
                    chairmanMenu();
                    break;
                case 6:
                    memberControl.editMember();
                    break;
                case 7:
                    competitiveControl.changeCompetitive();
                    chairmanMenu();
                    break;
                case 8:
                    menu.startupMenu();
                    break;
                case 9:
                    menu.loginMenu();
                case 0:
                    running = 1;
                    break;
                default:
                    ui.errorMessage();
                    chairmanMenu(); } } }

    public void printMembersMenu() {
        Display memberDisplay = new Display();
        CompetitiveDisplay competitiveDisplay = new CompetitiveDisplay();
        Scanner scan = new Scanner(System.in);
        uiChairman.printMemberMenu();
        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    memberDisplay.printMembersFromFile();
                    break;
                case 2:
                    competitiveDisplay.printAllCompetitives();
                    break;
                case 3:
                    memberDisplay.printJuniors();
                    returnToLast();
                    break;
                case 4:
                    memberDisplay.printSeniors();
                    returnToLast();
                    break;
                case 5:
                    memberDisplay.printMotionists();
                    returnToLast();
                    break;
                case 6:
                    memberDisplay.printMembersWithoutArrears();
                    returnToLast();
                    break;
                case 7:
                    memberDisplay.printArrearsMembers();
                    returnToLast();
                    break;
                case 8:
                    memberDisplay.printActives();
                    returnToLast();
                    break;
                case 9:
                    memberDisplay.printInactives();
                    returnToLast();
                    break;
                case 0:
                    chairmanMenu();
                    break;
                default:
                    ui.errorMessage();
                    chairmanMenu(); } } }

    public void returnToLast() {
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        uiChairman.printReturnMessage();
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            chairmanMenu();
        } else {ui.errorMessage(); } }

    public void returnToStart() {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        uiChairman.printReturnMessage();
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            menu.startupMenu();
        } else {ui.errorMessage(); }
    }

}
