package Competitive;
import Control.Chairman;
import FileHandler.Files;
import Control.Coach;
import UI.UI;
import UI.UICashier;
import java.util.ArrayList;
import java.util.Collections;

public class CompetitiveDisplay {
    private final UI ui = new UI();
    private final UICashier uiCashier = new UICashier();
    ArrayList<CompetitiveMember> competitives = new ArrayList<>();
    ArrayList<CompetitiveMember> juniorCompetitives = new ArrayList<>();
    ArrayList<CompetitiveMember> seniorCompetitives = new ArrayList<>();
    ArrayList<CompetitiveMember> crawlJuniors = new ArrayList<>();
    ArrayList<CompetitiveMember> rygJuniors = new ArrayList<>();
    ArrayList<CompetitiveMember> brystJuniors = new ArrayList<>();
    ArrayList<CompetitiveMember> butterflyJuniors = new ArrayList<>();
    ArrayList<CompetitiveMember> actives = new ArrayList<>();
    ArrayList<CompetitiveMember> inactives = new ArrayList<>();
    ArrayList<CompetitiveMember> crawlSeniors = new ArrayList<>();
    ArrayList<CompetitiveMember> rygSeniors = new ArrayList<>();
    ArrayList<CompetitiveMember> brystSeniors = new ArrayList<>();
    ArrayList<CompetitiveMember> butterflySeniors = new ArrayList<>();
    ArrayList<CompetitiveMember> compArrears = new ArrayList<>();
    ArrayList<CompetitiveMember> compNoArrears = new ArrayList<>();


    public void topJuniorCrawl() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Top 5 junior crawl svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(crawlJuniors);
            System.out.println(crawlJuniors.get(i).toString()); } }

    public void topSeniorCrawl() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Top 5 senior crawl svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(crawlSeniors);
            System.out.println(crawlSeniors.get(i).toString()); } }

    public void topJuniorBack() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Top 5 junior rygcrawl svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(rygJuniors);
            System.out.println(rygJuniors.get(i).toString()); } }

    public void topSeniorBack() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Top 5 senior rygcrawl svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(rygSeniors);
            System.out.println(rygSeniors.get(i).toString()); } }

    public void topJuniorButterfly () {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Top 5 junior butterfly svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(butterflyJuniors);
            System.out.println(butterflyJuniors.get(i).toString()); } }

    public void topSeniorButterfly () {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Top 5 senior butterfly svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(butterflySeniors);
            System.out.println(butterflySeniors.get(i).toString()); } }

    public void topJuniorBryst() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Top 5 brystsvømning junior svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(brystJuniors);
            System.out.println(brystJuniors.get(i).toString()); } }

    public void topSeniorBryst() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Top 5 brystsvømning senior svømmere: ");
        for (int i = 0; i < 5; i++) {
            Collections.sort(brystSeniors);
            System.out.println(brystSeniors.get(i).toString()); } }


    public void printJuniorCompetitives() {
        seperateByAge(competitives);
        ui.getString("Junior konkurrence svømmere: ");
        for (int i = 0; i < juniorCompetitives.size(); i++) {
            System.out.println(juniorCompetitives.get(i).toString()); } }

    public void printSeniorCompetitives() {
        seperateByAge(competitives);
        ui.getString("Senior konkurrence svømmere: ");
        for (int i = 0; i < seniorCompetitives.size(); i++) {
            System.out.println(seniorCompetitives.get(i).toString()); } }


    public double expectedPaymentCompetitive() {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        uiCashier.expectedpaymentMessageComp();
        double expextedPayment = 0;
        for (int i = 0; i < competitives.size(); i++) {
            double sum = competitives.get(i).getPrice();
            expextedPayment += sum; }
        System.out.print(expextedPayment + ",-");
        ui.getString(" ");
        return expextedPayment; }

    public double totalArreasCompetitive() {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        uiCashier.totalArrearsMessageComp();
        double totalArreas = 0;
        for (int i = 0; i < competitives.size(); i++) {
            double sum = competitives.get(i).getArrears();
            totalArreas += sum; }
        System.out.print(totalArreas + ",-");
        ui.getString(" ");
        return totalArreas; }

    public void printArrearsMembers() {
        seperateByArreas(competitives);
        ui.getString("Konkurrence medlemmer med restance: ");
        for (int i = 0; i < compArrears.size(); i++) {
            System.out.println(compArrears.get(i).toString());
        } }

    public void competitivesWithoutArrears() {
        seperateByArreas(competitives);
        ui.getString("Konkurrence medlemmer uden restance: ");
        for (int i = 0; i < compNoArrears.size(); i++) {
            System.out.println(compNoArrears.get(i).toString());
        } }

    public void seperateByArreas(ArrayList<CompetitiveMember> competitives) {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        for (int i = 0; i < this.competitives.size(); i++) {
            if (this.competitives.get(i).getArrears() >= competitives.get(i).getPrice()) {
                compArrears.add(this.competitives.get(i));
            } else if (this.competitives.get(i).getArrears() < competitives.get(i).getPrice()) {
                compNoArrears.add(this.competitives.get(i));
            } } }


    public void printJuniorCrawl() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Junior crawl konkurrence svømmere: ");
        for (int i = 0; i < crawlJuniors.size(); i++) {
            System.out.println(crawlJuniors.get(i).toString()); } }

    public void printJuniorRyg() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Junior rygcrawl konkurrence svømmere: ");
        for (int i = 0; i < rygJuniors.size(); i++) {
            System.out.println(rygJuniors.get(i).toString()); } }

    public void printJuniorButterfly() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Junior butterfly konkurrence svømmere: ");
        for (int i = 0; i < butterflyJuniors.size(); i++) {
            System.out.println(butterflyJuniors.get(i).toString()); } }

    public void printJuniorBryst() {
        seperateByDisciplineJuniors(juniorCompetitives);
        ui.getString("Junior brystsvømning konkurrence svømmere: ");
        for (int i = 0; i < brystJuniors.size(); i++) {
            System.out.println(brystJuniors.get(i).toString()); } }

    public void printSeniorBryst() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Senior brystsvømning konkurrence svømmere:");
        for (int i = 0; i < brystSeniors.size(); i++) {
            System.out.println(brystSeniors.get(i).toString()); } }

    public void printSeniorButterfly() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Senior butterfly konkurrence svømmere: ");
        for (int i = 0; i < butterflySeniors.size(); i++) {
            System.out.println(butterflySeniors.get(i).toString()); } }

    public void printSeniorCrawl() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Senior crawl konkurrence svømmere: ");
        for (int i = 0; i < crawlSeniors.size(); i++) {
            System.out.println(crawlSeniors.get(i).toString()); } }

    public void printSeniorRyg() {
        seperateByDisciplineSeniors(seniorCompetitives);
        ui.getString("Senior rygcrawl konkurrence svømmere: ");
        for (int i = 0; i < rygSeniors.size(); i++) {
            System.out.println(rygSeniors.get(i).toString()); } }

    public void printAllCompetitives() {
        Coach coach = new Coach();
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        if (competitives.size()==0) {
            ui.emptyList();
        } else {
            for (int i = 0; i < competitives.size(); i++) {
                System.out.println("Nummer: " +( i+1 ) + " " + competitives.get(i).toString());
            } }
        Chairman chairman = new Chairman();
        chairman.returnToStart(); }

    public void printInactives() {
        seperateByMembership(competitives);
        for (int i = 0; i < inactives.size(); i++) {
            ui.getString("Inaktive konkurrence svømmere");
            System.out.println(inactives.get(i).toString()); } }

    public void printActives() {
        seperateByMembership(competitives);
        for (int i = 0; i < actives.size(); i++) {
            ui.getString("Aktive konkurrence svømmere");
            System.out.println(actives.get(i).toString()); } }

    public void seperateByMembership(ArrayList<CompetitiveMember>competitives) {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        for (int i = 0; i < competitives.size(); i++) {
            if (this.competitives.get(i).getMembership()==true) {
                actives.add(this.competitives.get(i));
            } else if (this.competitives.get(i).getMembership()==false) {
                inactives.add(this.competitives.get(i));
            } else {ui.emptyList(); } } }

    public void seperateByDisciplineSeniors(ArrayList<CompetitiveMember>juniorCompetitives) {
        seperateByAge(competitives);
        for (int i = 0; i < seniorCompetitives.size(); i++) {
            if (this.seniorCompetitives.get(i).getDiscipline().equals("Butterfly")) {
                butterflySeniors.add(this.seniorCompetitives.get(i));
            } else if (this.seniorCompetitives.get(i).getDiscipline().equals("Crawl")) {
                crawlSeniors.add(this.seniorCompetitives.get(i));
            } else if (this.seniorCompetitives.get(i).getDiscipline().equals("Rygcrawl")) {
                rygSeniors.add(this.seniorCompetitives.get(i));
            } else if (this.seniorCompetitives.get(i).getDiscipline().equals("Brystsvømning")) {
                brystSeniors.add(this.seniorCompetitives.get(i));
            } else { ui.getString(" ");} } }

    public void seperateByDisciplineJuniors(ArrayList<CompetitiveMember>juniorCompetitives) {
        seperateByAge(competitives);
        for (int i = 0; i < juniorCompetitives.size(); i++) {
            if (this.juniorCompetitives.get(i).getDiscipline().equals("Butterfly")) {
                butterflyJuniors.add(this.juniorCompetitives.get(i));
            } else if (this.juniorCompetitives.get(i).getDiscipline().equals("Crawl")) {
                crawlJuniors.add(this.juniorCompetitives.get(i));
            } else if (this.juniorCompetitives.get(i).getDiscipline().equals("Rygcrawl")) {
                rygJuniors.add(this.juniorCompetitives.get(i));
            } else if (this.juniorCompetitives.get(i).getDiscipline().equals("Brystsvømning")) {
                brystJuniors.add(this.juniorCompetitives.get(i));
            } else { ui.getString(" ");} } }

    public void seperateByAge(ArrayList<CompetitiveMember> allCompetitives) {
        Files files = new Files();
        CompetitiveMember competitive = new CompetitiveMember();
        files.readCompetitiveFile(competitives,competitive);
        for (int i = 0; i < competitives.size(); i++) {
            if (this.competitives.get(i).getAge() < 18) {
                juniorCompetitives.add(this.competitives.get(i));
            } else if (this.competitives.get(i).getAge() > 18) {
                seniorCompetitives.add(this.competitives.get(i));
            } else {ui.getString(" ");} } }

}