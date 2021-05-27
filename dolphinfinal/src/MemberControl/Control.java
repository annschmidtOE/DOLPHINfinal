package MemberControl;
import UI.UI;
import UI.UIChairman;
import Control.Chairman;
import java.util.ArrayList;
import java.util.Scanner;
import Control.Menu;
import FileHandler.Files;

public class Control {

    private final UI ui = new UI();
    private final UIChairman uiChairman = new UIChairman();
    ArrayList<Member> members = new ArrayList<>();

    public void createMember() {
        Files files = new Files();
        Member member = new Member();
        Scanner scan = new Scanner(System.in);
        uiChairman.memberName();
        member.setName(scan.nextLine());
        uiChairman.memberLastName();
        member.setLastName(scan.nextLine());
        uiChairman.memberAge();
        member.setAge(scan.nextInt());
        ui.getString("");
        member.setID(member.getID());
        member.setMemberShip(setMembership());
        member.setPrice(member.getPrice());
        member.setMembershipDate(member.getMembershipDate());
        uiChairman.memberArrears();
        member.setArrears(scan.nextDouble());

        members.add(new Member(member.getName(),member.getLastName(),member.getID(),member.getAge(),
                member.getMembership(),member.getPrice(),member.getArrears(),member.getMembershipDate()));
        uiChairman.memberCreatedMessage();
        files.saveMember(members,member);
    }

    public boolean setMembership () {
        uiChairman.membershipStatus();
        Scanner scan = new Scanner(System.in);
        int userinput = scan.nextInt();
        if (userinput==1) {
            return true;
        } else if (userinput==2) {
            return false;
        } else { return true; }
    }

    public void deleteMember() {
        Member member = new Member();
        Files files = new Files();
        Chairman chairman = new Chairman();
        Scanner scan = new Scanner(System.in);
        try {
            files.readFile(members, member);
            if (members.size() == 0) { ui.emptyList();
            } else {
                for (int i = 0; i < members.size(); i++) {
                    System.out.println("Medlem nummer: "+(i+1)+" "+members.get(i).toString());
                } }
            uiChairman.deleteMemberMessage();
            int userinput = scan.nextInt();
            userinput = userinput - 1; //index correction
            members.remove(userinput);
            uiChairman.memberDeletedMessage();
            files.saveMemberAfterChange(members,member);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        chairman.chairmanMenu();
    }

    public void editMember() {
        Member member = new Member();
        Files files = new Files();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        try {
            files.readFile(members,member);
            int choosenMember = 0;

            if (members.size() == 0) {
                ui.emptyList();
            } else {
                for (int i = 0; i < members.size(); i++) {
                    System.out.println("Medlem nummer: " + (i + 1) + " " + members.get(i).toString());
                }
            }
            uiChairman.memberChangeMessage();
            choosenMember = scan.nextInt();
            ui.getString("Ændre medlem: ");
            System.out.println(members.get(choosenMember-1));
            uiChairman.whatToChangeMessage();
            int userinput;
            userinput = scan.nextInt();
            if (userinput==1) {
                editMembership(members.get(choosenMember-1));
            } else if (userinput==2) {
                editMemberArrears(members.get(choosenMember-1));
            } else {ui.errorMessage();
                menu.startupMenu(); }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void editMembership(Member member) {
        Menu menu = new Menu();
        Files files = new Files();
        Scanner scan = new Scanner(System.in);
        uiChairman.changeMembership();
        int userinput;
        userinput = scan.nextInt();
        if (userinput==1) {
            member.setMemberShip(true);
            files.saveMemberAfterChange(members,member);
            menu.startupMenu();
        } else if (userinput==2) {
            member.setMemberShip(false);
            files.saveMemberAfterChange(members,member);
            menu.startupMenu();
        } else {ui.errorMessage();
            menu.startupMenu();  } }

    public void editMemberArrears(Member member) {
        Menu menu = new Menu();
        Files files = new Files();
        Scanner scan = new Scanner(System.in);
        uiChairman.changeArrearsMessage();
        if (scan.hasNextDouble()) {
            member.setArrears(scan.nextDouble());
            files.saveMemberAfterChange(members,member);
            menu.startupMenu();
        } else {ui.errorMessage(); menu.startupMenu();} }




}
