package Control;

import Competitive.CompetitiveDisplay;
import Competitive.CompetitiveControl;
import UI.UI;
import UI.UICoach;

import java.util.Scanner;

public class Coach {

    private final UI ui = new UI();
    private final UICoach uiCoach = new UICoach();

    public void coachMenu() {
        CompetitiveDisplay display = new CompetitiveDisplay();
        CompetitiveControl control = new CompetitiveControl();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        uiCoach.coachMenu();
        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    showTeams();
                    break;
                case 2:
                    topSwimmers();
                    break;
                case 3:
                    control.changeCompetitiveCoach();
                    coachMenu();
                    break;
                case 4:
                    display.printAllCompetitives();
                    break;
                case 5:
                    display.printActives();
                    returnToLast();
                    break;
                case 6:
                    display.printInactives();
                    returnToLast();
                    break;
                case 0:
                    menu.startupMenu();
                    break;
                default:
                    ui.errorMessage();
                    coachMenu();
            }
        }
    }

    public void showTeams() {
        CompetitiveDisplay display = new CompetitiveDisplay();
        CompetitiveControl control = new CompetitiveControl();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        uiCoach.printCompetitivesMenu();
        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    display.printJuniorCompetitives();
                    returnToLastShow();
                    break;
                case 2:
                    display.printSeniorCompetitives();
                    returnToLastShow();
                    break;
                case 3:
                    display.printJuniorCrawl();
                    returnToLastShow();
                    break;
                case 4:
                    display.printJuniorRyg();
                    returnToLastShow();
                    break;
                case 5:
                    display.printJuniorBryst();
                    returnToLastShow();
                    break;
                case 6:
                    display.printJuniorButterfly();
                    returnToLastShow();
                    break;
                case 7:
                    display.printSeniorCrawl();
                    returnToLastShow();
                    break;
                case 8:
                    display.printSeniorRyg();
                    returnToLastShow();
                    break;
                case 9:
                    display.printSeniorBryst();
                    returnToLastShow();
                    break;
                case 0:
                    display.printSeniorButterfly();
                    returnToLastShow();
                    break;
                case 99:
                    coachMenu();
                default:
                    ui.errorMessage();
                    coachMenu();
            }
        }
    }

    public void topSwimmers() {
        Scanner scan = new Scanner(System.in);
        CompetitiveDisplay competitiveDisplay = new CompetitiveDisplay();
        uiCoach.topSwimmers();
        int running = 0;
        int userInput = scan.nextInt();
        while (running != 1) {
            switch (userInput) {
                case 1:
                    competitiveDisplay.topJuniorCrawl();
                    returnToLastTop();
                    break;
                case 2:
                    competitiveDisplay.topJuniorBack();
                    returnToLastTop();
                    break;
                case 3:
                    competitiveDisplay.topJuniorBryst();
                    returnToLastTop();
                    break;
                case 4:
                    competitiveDisplay.topJuniorButterfly();
                    returnToLastTop();
                    break;
                case 5:
                    competitiveDisplay.topSeniorCrawl();
                    returnToLastTop();
                    break;
                case 6:
                    competitiveDisplay.topSeniorBack();
                    returnToLastTop();
                    break;
                case 7:
                    competitiveDisplay.topSeniorBryst();
                    returnToLastTop();
                    break;
                case 8:
                    competitiveDisplay.topSeniorButterfly();
                    returnToLastTop();
                    break;
                case 9:
                    coachMenu();
                    break;
                default:
                    ui.errorMessage();
                    coachMenu(); } } }

    public void returnToLast() {
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        ui.getString("tryk x for at vende tilbage");
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            coachMenu();
        } else {ui.errorMessage(); }
    }

    public void returnToLastShow() {
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        ui.getString("tryk x for at vende tilbage");
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            showTeams();
        } else {ui.errorMessage(); }
    }

    public void returnToLastTop() {
        Scanner scan = new Scanner(System.in);
        ui.getString(" ");
        ui.getString("tryk x for at vende tilbage");
        String userinput;
        userinput = scan.nextLine();
        if (userinput.equals("x")){
            topSwimmers();
        } else {ui.errorMessage(); }
    }
}
