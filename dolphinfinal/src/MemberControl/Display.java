package MemberControl;
import UI.UI;
import UI.UIChairman;
import FileHandler.Files;
import java.util.ArrayList;
import UI.UICashier;
import Control.Chairman;

public class Display {
    private final UI ui = new UI();
    private final UICashier uiCashier = new UICashier();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Member> juniors = new ArrayList<>();
    ArrayList<Member> seniors = new ArrayList<>();
    ArrayList<Member> motionists = new ArrayList<>();
    ArrayList<Member> actives = new ArrayList<>();
    ArrayList<Member> inactives = new ArrayList<>();
    ArrayList<Member>membersInArreas = new ArrayList<>();
    ArrayList<Member>membersWithoutArrears = new ArrayList<>();

    public void printMembersFromFile() {
        Files files = new Files();
        Member member = new Member();
        Chairman chairman = new Chairman();
        files.readFile(members,member);
        if (members.size() == 0) { ui.emptyList();
        } else {
            for (int i = 0; i < members.size(); i++) {
                System.out.println("Medlem nummer: "+(i+1)+" "+members.get(i).toString());
            } }
        chairman.returnToLast();
    }

    public void printJuniors() {
        seperateByAge(members);
        ui.getString("Junior medlemmer: ");
        for (int i = 0; i < juniors.size(); i++) {
            System.out.println(juniors.get(i).toString());
        }
    }

    public void printSeniors() {
        seperateByAge(members);
        ui.getString("Senior medlemmer: ");
        for (int i = 0; i < seniors.size(); i++) {
            System.out.println(seniors.get(i).toString());
        }
    }

    public void printMotionists() {
        seperateByAge(members);
        ui.getString("Motionist medlemmer: ");
        for (int i = 0; i < motionists.size(); i++) {
            System.out.println(motionists.get(i).toString());
        }
    }

    public void printActives() {
        seperateByMembership(members);
        ui.getString("Aktive medlemmer: ");
        for (int i = 0; i < actives.size(); i++) {
            System.out.println(actives.get(i).toString());
        }
    }

    public void printInactives() {
        seperateByMembership(members);
        ui.getString("Passive medlemmer: ");
        for (int i = 0; i < inactives.size(); i++) {
            System.out.println(inactives.get(i).toString());
        }
    }

    public double expectedPayment() {
        Files files = new Files();
        Member member = new Member();
        files.readFile(members,member);
        uiCashier.expectedpaymentMessage();
        double expextedPayment = 0;
        for (int i = 0; i < members.size(); i++) {
            double sum = members.get(i).getPrice();
            expextedPayment += sum; }
        System.out.print(expextedPayment + ",-");
        ui.getString(" ");
        return expextedPayment; }

    public double totalArreas() {
        Files files = new Files();
        Member member = new Member();
        files.readFile(members,member);
        uiCashier.totalArrearsMessage();
        double totalArreas = 0;
        for (int i = 0; i < members.size(); i++) {
            double sum = members.get(i).getArrears();
            totalArreas += sum; }
        System.out.print(totalArreas + ",-");
        ui.getString(" ");
        return totalArreas; }


    public void printArrearsMembers() {
        seperateByArreas(members);
        uiCashier.membersInArreasMessage();
        for (int i = 0; i < membersInArreas.size(); i++) {
            System.out.println(membersInArreas.get(i).toString());
        } }

    public void printMembersWithoutArrears() {
        seperateByArreas(members);
        uiCashier.membersWithoutArrearsMessage();
        for (int i = 0; i < membersWithoutArrears.size(); i++) {
            System.out.println(membersWithoutArrears.get(i).toString());
        } }

    public void seperateByAge(ArrayList<Member> members) {
        Files files = new Files();
        Member member = new Member();
        files.readFile(members,member);
        for (int i = 0; i < members.size(); i++) {
            if (this.members.get(i).getAge() < 18) {
                juniors.add(this.members.get(i));
            } else if ((this.members.get(i).getAge()>18)&&(this.members.get(i).getAge()<60)) {
                seniors.add(this.members.get(i));
            } else if (this.members.get(i).getAge()>=60) {
                motionists.add(this.members.get(i));
            } else {ui.errorMessage();}
        } }

    public void seperateByMembership (ArrayList<Member> members) {
        Files files = new Files();
        Member member = new Member();
        files.readFile(members,member);
        for (int i = 0; i < members.size(); i++) {
            if (this.members.get(i).getMembership()==true) {
                actives.add(this.members.get(i));
            } else if (this.members.get(i).getMembership()==false) {
                inactives.add(this.members.get(i));
            } else {ui.errorMessage(); } } }

    public void seperateByArreas(ArrayList<Member> members) {
        Files files = new Files();
        Member member = new Member();
        files.readFile(members,member);
        for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getArrears() >= members.get(i).getPrice()) {
                membersInArreas.add(this.members.get(i));
            } else if (this.members.get(i).getArrears() < members.get(i).getPrice()) {
                membersWithoutArrears.add(this.members.get(i));
            } } }


}