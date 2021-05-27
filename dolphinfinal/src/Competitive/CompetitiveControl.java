package Competitive;
import Control.Chairman;
import Control.Menu;
import FileHandler.Files;
import UI.UI;
import UI.UIChairman;
import UI.UICoach;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveControl {

    private final UI ui = new UI();
    private final UIChairman uiChairman = new UIChairman();
    private final UICoach uiCoach = new UICoach();
    ArrayList<CompetitiveMember> competitives = new ArrayList<>();

    public void createMember() {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        Scanner scan = new Scanner(System.in);
        uiChairman.memberName();
        competitive.setName(scan.nextLine());
        uiChairman.memberLastName();
        competitive.setLastName(scan.nextLine());
        uiChairman.memberAge();
        competitive.setAge(scan.nextInt());
        competitive.setID(competitive.getID());
        competitive.setMemberShip(setMembership());
        competitive.setPrice(competitive.getPrice());
        competitive.setArrears(0.0);
        competitive.setTime(00);
        competitive.setTimeDate("00-00-000");
        competitive.setDiscipline(setDiscipline());

        competitive.setMembershipDate(competitive.getMembershipDate());
        competitives.add(new CompetitiveMember(competitive.getName(),competitive.getLastName(),competitive.getID(),
                competitive.getAge(),competitive.getMembership(),competitive.getDiscipline(),competitive.getTime(),
                competitive.getTimeDate(),competitive.getPrice(),competitive.getArrears(),competitive.getMembershipDate()));
        uiChairman.memberCreatedMessage();
        files.saveCompetitive(competitives,competitive);
    }

    public boolean setMembership () {
        uiChairman.membershipStatus();
        Scanner scan = new Scanner(System.in);
        int userinput = scan.nextInt();
        if (userinput==1) {
            return true;
        } else if (userinput==2) {
            return false;
        } else { return true; } }

    public String setDiscipline() {
    Scanner scan = new Scanner(System.in);
    uiChairman.printSetDiscipline();
    int userinput = scan.nextInt();
    String discipline = null;
    switch (userinput) {
        case 1: discipline="Butterfly"; break;
        case 2: discipline="Crawl"; break;
        case 3: discipline="Rygcrawl"; break;
        case 4: discipline="Brystsvømning"; break;
        default: ui.errorMessage();
    } return discipline; }


    public void deleteCmpetitive() {
        Chairman chairman = new Chairman();
        Files files = new Files();
        Scanner scan = new Scanner(System.in);
        CompetitiveMember competitive = new CompetitiveMember();
        try {
            files.readCompetitiveFile(competitives,competitive);
            if (competitives.size() == 0) { ui.emptyList();
            } else {
                for (int i = 0; i < competitives.size(); i++) {
                    System.out.println("Medlem nummer: "+(i+1)+" "+competitives.get(i).toString());
                } }
            uiChairman.deleteMemberMessage();
            int userinput = scan.nextInt();
            userinput = userinput - 1; //index correction
            competitives.remove(userinput);
            uiChairman.memberDeletedMessage();
            files.saveCompetitiveChanges(competitives,competitive);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        chairman.chairmanMenu();
    }

    public void changeCompetitiveCoach() {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();

        try {
            files.readCompetitiveFile(competitives,competitive);
            int choosenMember = 0;
            if (competitives.size() == 0) {
                ui.emptyList();
            } else {
                for (int i = 0; i < competitives.size(); i++) {
                    System.out.println("Medlem nummer: " + (i + 1) + " " + competitives.get(i).toString());
                }
            }
            uiChairman.memberChangeMessage();
            choosenMember = scan.nextInt();
            ui.getString("Ændre medlem: ");
            System.out.println(competitives.get(choosenMember - 1));
            uiCoach.changeCompetitive();
            int userinput;
            userinput = scan.nextInt();
            if (userinput == 1) {
                editCompetitiveTime(competitives.get(choosenMember - 1)); //index correction
            } else if (userinput == 2) {
                editCompetitiveDisciplin(competitives.get(choosenMember - 1));
            } else {
                ui.errorMessage();
                menu.startupMenu();
            }   } catch (Exception exception) {
            exception.printStackTrace(); } }

    public void changeCompetitive() {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        try {
            files.readCompetitiveFile(competitives,competitive);
            int choosenMember = 0;
            if (competitives.size() == 0) {
                ui.emptyList();
            } else {
                for (int i = 0; i < competitives.size(); i++) {
                    System.out.println("Medlem nummer: " + (i + 1) + " " + competitives.get(i).toString());
                }
            }
            uiChairman.memberChangeMessage();
            choosenMember = scan.nextInt();
            ui.getString("Ændre medlem: ");
            System.out.println(competitives.get(choosenMember - 1));
            uiChairman.whatToChangeMessage();
            int userinput;
            userinput = scan.nextInt();
            if (userinput == 1) {
                editCompetitiveMembership(competitives.get(choosenMember - 1)); //index correction
            } else if (userinput == 2) {
                editCompetitiveArrears(competitives.get(choosenMember - 1));
            } else {
                ui.errorMessage();
                menu.startupMenu();
            }   } catch (Exception exception) {
            exception.printStackTrace(); } }

    public void editCompetitiveDisciplin(CompetitiveMember competitiveMember) {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        Scanner scan = new Scanner(System.in);
        int userinput1;
        userinput1 = scan.nextInt();
        switch (userinput1) {
            case 1: competitiveMember.setDiscipline("Butterfly"); files.saveCompetitiveChanges(competitives,competitive); break;
            case 2: competitiveMember.setDiscipline("Crawl"); files.saveCompetitiveChanges(competitives,competitive); break;
            case 3: competitiveMember.setDiscipline("Rygcrawl"); files.saveCompetitiveChanges(competitives,competitive); break;
            case 4: competitiveMember.setDiscipline("Brystsvømning"); files.saveCompetitiveChanges(competitives,competitive); break;
            default: ui.errorMessage(); } }

    public void editCompetitiveTime(CompetitiveMember competitiveMember) {
        Menu menu = new Menu();
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        Scanner scan = new Scanner(System.in);
        String userinput;
        uiCoach.changeTimeMessage();
        if (scan.hasNextDouble()) {
            competitiveMember.setTime(scan.nextInt());
            ui.getString("Indtast datoen for tiden dd-mm-ååå");
            userinput=scan.nextLine();
            competitiveMember.setTimeDate(userinput);
            files.saveCompetitiveChanges(competitives,competitive);
            menu.startupMenu();
        } else {ui.errorMessage(); menu.startupMenu();} }

    public void editCompetitiveMembership(CompetitiveMember competitiveMember) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        uiChairman.changeMembership();
        int userinput;
        userinput = scan.nextInt();
        if (userinput==1) {
            competitiveMember.setMemberShip(true);
            files.saveCompetitiveChanges(competitives,competitive);
            menu.startupMenu();
        } else if (userinput==2) {
            competitiveMember.setMemberShip(false);
            files.saveCompetitive(competitives,competitive);
            menu.startupMenu();
        } else {ui.errorMessage();
            menu.startupMenu();  } }

    public void editCompetitiveArrears(CompetitiveMember competitiveMember) {
        Menu menu = new Menu();
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        Scanner scan = new Scanner(System.in);
        uiChairman.changeArrearsMessage();
        if (scan.hasNextDouble()) {
            competitiveMember.setArrears(scan.nextDouble());
            files.saveCompetitiveChanges(competitives,competitive);
            menu.startupMenu();
        } else {ui.errorMessage(); menu.startupMenu();} }


}