package Control;
import Competitive.CompetitiveControl;
import Competitive.CompetitiveDisplay;
import UI.UI;
import UI.UICashier;
import MemberControl.Display;
import java.util.Scanner;
import MemberControl.Control;

public class Cashier {

    private final UI ui = new UI();
    private final UICashier uiCashier = new UICashier();

    public void cashierMenu() {
        Display memberDisplay = new Display();
        CompetitiveDisplay competitiveDisplay = new CompetitiveDisplay();
        Control memberControl = new Control();
        CompetitiveControl competitiveControl = new CompetitiveControl();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        uiCashier.printCashierMenu();
        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    totalExpectedPayment();
                    returnToLast();
                    break;
                case 2:
                    totalArrears();
                    returnToLast();
                    break;
                case 3:
                    expectedMinusArreas();
                    returnToLast();
                case 4:
                    memberDisplay.printArrearsMembers();
                    returnToLast();
                case 5:
                    memberDisplay.printMembersWithoutArrears();
                    returnToLast();
                case 6:
                    competitiveDisplay.printArrearsMembers();
                    returnToLast();
                case 7:
                    competitiveDisplay.competitivesWithoutArrears();
                    returnToLast();
                case 8:
                    memberControl.editMember();
                    break;
                case 9:
                    competitiveControl.changeCompetitive();
                    break;
                case 0:
                    menu.startupMenu();
                    break;
                default:
                    ui.errorMessage();
                    cashierMenu();
            }
        }
    }

    public void expectedMinusArreas() {
        double expected = totalExpectedPayment();
        double arrears = totalArrears();
        double result = (expected - arrears);
        uiCashier.expectedMinusArrears();
        System.out.print(result + ",-"); }

    public double totalExpectedPayment() {
        CompetitiveDisplay competitiveDisplay = new CompetitiveDisplay();
        Display memberDisplay = new Display();
        double total;
        double regular = memberDisplay.expectedPayment();
        double competitive = competitiveDisplay.expectedPaymentCompetitive();
        total = regular + competitive;
        ui.getString("Den totale forventede årlige kontigentbetaling: ");
        System.out.println(total + ",-");
        return total; }

    public double totalArrears() {
        CompetitiveDisplay competitiveDisplay = new CompetitiveDisplay();
        Display memberDisplay = new Display();
        double total;
        double regular = memberDisplay.totalArreas();
        double competitive = competitiveDisplay.totalArreasCompetitive();
        total = regular + competitive;
        ui.getString("Den totale restance er: ");
        System.out.println(total+",-");
        return total;
    }

    public void returnToLast() {
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        ui.getString("tast x for at vende tilbage");
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            cashierMenu();
        } else {ui.errorMessage(); }
    }
}