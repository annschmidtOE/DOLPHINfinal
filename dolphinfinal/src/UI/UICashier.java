package UI;

public class UICashier {

    private final UI ui = new UI();

    public void printCashierMenu() {
        ui.getString("Velkommen kasser!");
        ui.getString("1. Forventet årlig kontigentbetalinger i alt");
        ui.getString("2. Restance i alt");
        ui.getString("3. Forventet årlig betalinger minus nuværende restance");
        ui.getString("4. Se medlemmer i restance");
        ui.getString("5. Medlemmer uden restance");
        ui.getString("6. Se konkurrence svømmere i restance ");
        ui.getString("7. Se konkurrence svømmere uden restance ");
        ui.getString("8. Rediger medlemmer");
        ui.getString("9. Rediger konkurrence svømmere");
        ui.getString("0. Tilbage"); }

    public void expectedpaymentMessage() {ui.getString("Svømmeklubben Delfinen totale kontigentbetaling for " +
            "almindelige medlemmer: "); }

    public void expectedpaymentMessageComp() {ui.getString("Svømmeklubben Delfinen totale kontigentbetaling for " +
            "konkurrence svømmere: "); }

    public void totalArrearsMessage() {ui.getString("Svømmeklubbens almindelige medlemmers totale restance: "); }
    public void totalArrearsMessageComp() {ui.getString("Svømmeklubbens konkurrence svømmeres totale restance: "); }


    public void expectedMinusArrears() {ui.getString("Årlige kontigenter i alt minus restance: "); }

    public void membersInArreasMessage() {ui.getString("Medlemmer i restance: " ); }

    public void membersWithoutArrearsMessage() {ui.getString("Medlemmer uden restance: "); }
}