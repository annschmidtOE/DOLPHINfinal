package FileHandler;
import Competitive.CompetitiveMember;
import MemberControl.Member;
import UI.UI;
import UI.UIChairman;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    private String MEMBERFILE = "Medlem.txt";
    private String COMPFILE = "Konkurrence.txt";
    private final UIChairman uiChairman = new UIChairman();
    private final UI ui = new UI();

    public void createFile() {
        try {
            File allMembers = new File("Medlem.txt");
        } catch (Exception exception) {
            exception.printStackTrace(); } }

    public void createCompetitiveFile() {
        try {
            File competitiveMembers = new File("KonkurrenceSvømmer.txt");
        } catch (Exception exception) {
            exception.printStackTrace(); } }

    public void readFile(ArrayList<Member> members, Member member) {
        try {
            File allMembers = new File("Medlem.txt");
            Scanner inFile = new Scanner(allMembers);

            while (inFile.hasNext()) {
                member.setName(inFile.next());
                member.setLastName(inFile.next());
                member.setID(inFile.nextInt());
                member.setAge(inFile.nextInt());
                member.setMemberShip(Boolean.parseBoolean(inFile.next()));
                member.setPrice(Double.parseDouble(inFile.next()));
                member.setArrears(Double.parseDouble(inFile.next()));
                member.setMembershipDate(inFile.next());
                members.add(new Member(member.getName(),member.getLastName(),member.getID(),member.getAge(),
                        member.getMembership(),member.getPrice(),member.getArrears(),member.getMembershipDate()));
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); } }

    public void readCompetitiveFile(ArrayList<CompetitiveMember> competitives, CompetitiveMember competitive) {
        try {
            File allCompetitives = new File("Konkurrence.txt");
            Scanner inFile = new Scanner(allCompetitives);

            while (inFile.hasNext()) {
                competitive.setName(inFile.next());
                competitive.setLastName(inFile.next());
                competitive.setID(inFile.nextInt());
                competitive.setAge(inFile.nextInt());
                competitive.setMemberShip(inFile.nextBoolean());
                competitive.setDiscipline(inFile.next());
                competitive.setTime(inFile.nextInt());
                competitive.setTimeDate(String.valueOf(inFile.next()));
                competitive.setPrice(Double.parseDouble(inFile.next()));
                competitive.setArrears(Double.parseDouble(inFile.next()));
                competitive.setMembershipDate(inFile.next());
                competitives.add(new CompetitiveMember(competitive.getName(),competitive.getLastName(),competitive.getID(),
                        competitive.getAge(),competitive.getMembership(),competitive.getDiscipline(),competitive.getTime(),
                        competitive.getTimeDate(),competitive.getPrice(),competitive.getArrears(),competitive.getMembershipDate()));
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); } }

    public void saveMember(ArrayList<Member> members,Member member) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(MEMBERFILE),true); //overskriver hver gang den kaldes
            for (int i = 0; i < members.size(); i++) {
                member = members.get(i);
                fileWriter.write(member.getName()+ " ");
                fileWriter.write(member.getLastName()+ " ");
                fileWriter.write(member.getID()+ " ");
                fileWriter.write(member.getAge()+ " ");
                fileWriter.write(String.valueOf(member.getMembership())+ " ");
                fileWriter.write(String.valueOf(member.getPrice())+ " ");
                fileWriter.write(String.valueOf(member.getArrears())+ " ");
                fileWriter.write(String.valueOf(member.getMembershipDate())+ " ");
                fileWriter.write("\n");
            } } catch (IOException e) {
            e.printStackTrace();
        } try {
            fileWriter.close(); } catch (IOException e) {
            ui.errorMessage();
        } uiChairman.memberSavedMessage(); }

    public void saveMemberAfterChange(ArrayList<Member> members,Member member) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(MEMBERFILE)); //overskriver ikke
            for (int i = 0; i < members.size(); i++) {
                member = members.get(i);
                fileWriter.write(member.getName()+ " ");
                fileWriter.write(member.getLastName()+ " ");
                fileWriter.write(member.getID()+ " ");
                fileWriter.write(member.getAge()+ " ");
                fileWriter.write(String.valueOf(member.getMembership())+ " ");
                fileWriter.write(String.valueOf(member.getPrice())+ " ");
                fileWriter.write(String.valueOf(member.getArrears())+ " ");
                fileWriter.write(String.valueOf(member.getMembershipDate())+ " ");
                fileWriter.write("\n");
            } } catch (IOException e) {
            e.printStackTrace();
        } try {
            fileWriter.close(); } catch (IOException e) {
            ui.errorMessage();
        } uiChairman.memberSavedMessage(); }

    public void saveCompetitive(ArrayList<CompetitiveMember> competitives, CompetitiveMember competitive) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(COMPFILE),true); //overrides when called
            for (int i = 0; i < competitives.size(); i++) {
                competitive = competitives.get(i);
                fileWriter.write(competitive.getName()+ " ");
                fileWriter.write(competitive.getLastName()+ " ");
                fileWriter.write(competitive.getID()+ " ");
                fileWriter.write(competitive.getAge()+ " ");
                fileWriter.write(String.valueOf(competitive.getMembership())+ " ");
                fileWriter.write(competitive.getDiscipline()+ " ");
                fileWriter.write((competitive.getTime()+ " "));
                fileWriter.write(competitive.getTimeDate()+ " ");
                fileWriter.write(String.valueOf(competitive.getPrice())+ " ");
                fileWriter.write(String.valueOf(competitive.getArrears())+ " ");
                fileWriter.write(String.valueOf(competitive.getMembershipDate())+ " ");
                fileWriter.write("\n");
            } } catch (IOException e) {
            e.printStackTrace();
        } try {
            fileWriter.close(); } catch (IOException e) {
            ui.errorMessage();
        } uiChairman.memberSavedMessage(); }

    public void saveCompetitiveChanges(ArrayList<CompetitiveMember> competitives, CompetitiveMember competitive) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File(COMPFILE)); //does not override
            for (int i = 0; i < competitives.size(); i++) {
                competitive = competitives.get(i);
                fileWriter.write(competitive.getName()+ " ");
                fileWriter.write(competitive.getLastName()+ " ");
                fileWriter.write(competitive.getID()+ " ");
                fileWriter.write(competitive.getAge()+ " ");
                fileWriter.write(String.valueOf(competitive.getMembership())+ " ");
                fileWriter.write(competitive.getDiscipline()+ " ");
                fileWriter.write((competitive.getTime()+ " "));
                fileWriter.write(competitive.getTimeDate()+ " ");
                fileWriter.write(String.valueOf(competitive.getPrice())+ " ");
                fileWriter.write(String.valueOf(competitive.getArrears())+ " ");
                fileWriter.write(String.valueOf(competitive.getMembershipDate())+ " ");
                fileWriter.write("\n");
            } } catch (IOException e) {
            e.printStackTrace();
        } try {
            fileWriter.close(); } catch (IOException e) {
            ui.errorMessage();
        } uiChairman.memberSavedMessage(); }

}