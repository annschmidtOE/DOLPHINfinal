package UI;

public class UICoach {

    private final UI ui = new UI();

    public void coachMenu() {
        ui.getString("Velkommen kasser!");
        ui.getString("1. Se hold");
        ui.getString("2. Se top 5 svømmere");
        ui.getString("3. Rediger konkurrence svømmer");
        ui.getString("4. Se alle konkurrence svømmere");
        ui.getString("5. Se alle aktive konkurrence svømmere");
        ui.getString("6. Se inaktive konkurrence svømmere");
        ui.getString("0. Tilbage"); }

    public void printCompetitivesMenu() {
        ui.getString("1. Se alle junior konkurrence svømmere");
        ui.getString("2. Se alle senior konkurrence svømmere");
        ui.getString("3. Se junior konkurrence svømmere i crawl");
        ui.getString("4. Se junior konkurrence svømmere i rygcrawl");
        ui.getString("5. Se junior konkurrence svømmere i brystsvømning");
        ui.getString("6. Se junior konkurrence svømmere i butterfly");
        ui.getString("7. Se senior konkurrence svømmere i crawl");
        ui.getString("8. Se senior konkurrence svømmere i rygcrawl");
        ui.getString("9. Se senior konkurrence svømmere i brystsvømning");
        ui.getString("0. Se senior konkurrence svømmere i butterfly");
        ui.getString("99. Tilbage"); }

    public void topSwimmers() {
        ui.getString("Top 5 svømmere inden for hver disciplin: ");
        ui.getString("1. Junior Crawl");
        ui.getString("2. Junior Rygcrawl");
        ui.getString("3. Junior Brystsvømning");
        ui.getString("4. Junior Butterfly");
        ui.getString("5. Senior Crawl");
        ui.getString("6. Senior Rygcrawl");
        ui.getString("7. Senior Brystsvømning");
        ui.getString("8. Senior Butterfly");
        ui.getString("9. Tilbage");
    }

    public void changeCompetitive() {
        ui.getString("1. Rediger bedste tid");
        ui.getString("3. Rediger disciplin"); }

    public void changeTimeMessage() {
        ui.getString("Tast svømmerens bedste tid i sekunder: ");}

}