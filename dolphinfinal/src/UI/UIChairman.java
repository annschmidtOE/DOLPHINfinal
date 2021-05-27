package UI;

public class UIChairman {
    private final UI ui = new UI();


    public void printChairmanMenu() {
        ui.getString("Velkommen formand!");
        ui.getString("1. Opret medlem");
        ui.getString("2. Opret konkurrence svømmer");
        ui.getString("3. Se medlemmer");
        ui.getString("4. Slet medlem");
        ui.getString("5. Slet konkurrence svømmer");
        ui.getString("6. Rediger medlem");
        ui.getString("7. Rediger konkurrence svømmer");
        ui.returnMenu(); }

    public void printMemberMenu() {
        ui.getString("Se medlemmer");
        ui.getString("1. Se alle medlemmer");
        ui.getString("2. Se alle konkurrence svømmere");
        ui.getString("3. Se junior medlemmer");
        ui.getString("4. Se senior medlemmer");
        ui.getString("5. Se motionist medlemmer");
        ui.getString("6. Se medlemmer med betalt kontigent");
        ui.getString("7. Se medlemmer i restance");
        ui.getString("8. Se aktive medlemmer");
        ui.getString("9. Se passive medlemmer");
        ui.getString("0. Tilbage"); }

    public void printSetDiscipline() {
        ui.getString("Vælg svømmers disciplin: ");
        ui.getString("1. Butterfly");
        ui.getString("2. Crawl");
        ui.getString("3. Rygcrawl");
        ui.getString("4. Brystsvømning"); }

    public void printReturnMessage() { ui.getString("For at vende tilbage tast \"x\" "); }

    public void memberCreatedMessage() {
        ui.getString("Medlem oprettet ..");
    }

    public void membershipStatus() {ui.getString("Medlemstype: for aktiv tast 1, for passiv tast 2"); }

    public void changeMembership() {ui.getString("For at ændre medlemsskabet til aktiv tast 1, for at ændre" +
            "medlemsskabet til passiv tast 2 "); }

    public void changeArrearsMessage() {ui.getString("Indtast medlemmets nye restance, hvis medlemmet har betalt hele restancen tast 0"); }

    public void memberSavedMessage() { ui.getString("Gemmer .. \n Gemt "); }

    public void memberName() { ui.getString("Medlemmets fornavn:"); }

    public void memberLastName() {ui.getString("Medlemmets efternavn: "); }

    public void memberAge() { ui.getString("Medlemmets alder:"); }

    public void memberArrears() {ui.getString("Har medlemmet betalt det årlige kontigent med indmeldelse? " +
            "for ja tast 0, ellers skriv det beløb medlemmet har i restance: ");}

    public void deleteMemberMessage() {
        ui.getString("Indtast venligt nummeret på det medlem du ønsker at slette: "); }

    public void memberDeletedMessage() {
        ui.getString("Medlem slettet .. ");
    }

    public void memberChangeMessage() {ui.getString("Indtast nummeret på det medlem du ønsker at ændre"); }

    public void whatToChangeMessage() {
        ui.getString("Hvad ønsker du at ændre: ");
        ui.getString("1. Medlemsskab");
        ui.getString("2. Restance"); }

}
