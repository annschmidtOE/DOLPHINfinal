package Competitive;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Random;

public class CompetitiveMember implements Comparable<CompetitiveMember>{
    // TODO: 26-05-2021 SAMMENLIGT METODE, COLLECTIONSSORT(TOP 5 FOR HVER DISCIPLIN JUNIOR OG SENIOR)
    private String name;
    private String lastName;
    private int age;
    private int time;
    private String discipline;
    private String timeDate;
    private String membershipDate;
    private boolean membership;
    private double price = 0.0;
    private int ID;
    private double arrears;
    //---------------------------------CONSTRUCTOR---------------------------------
    public CompetitiveMember(String name, String lastName, int ID, int age, boolean membership,
                             String discipline, int time, String timeDate, double price, double arrears, String membershipDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.time = time;
        this.discipline = discipline;
        this.timeDate = timeDate;
        this.membershipDate = membershipDate;
        this.membership = membership;
        this.price = price;
        this.ID = ID;
        this.arrears = arrears; }
    //-------------------------------OVERRIDE CONTRUCTOR-------------------------------
    public CompetitiveMember() { }
    //------------------------------------SETTERS--------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMemberShip(boolean membership) {
        this.membership = membership;
    }

    public void setID(int ID) {
        Random random = new Random();
        this.ID = random.nextInt(999); }

    public void setMembershipDate(String membershipDate) {
        this.membershipDate = String.valueOf(LocalDate.now());
    }

    public void setTime(int time) { this.time = time; }

    public void setDiscipline(String discipline) { this.discipline = discipline; }

    public void setTimeDate(String timeDate) { this.timeDate = timeDate; }

    public void setPrice(double price) {
        if ((getAge() < 18)&&getMembership()==true) {
            this.price = 1000.0;
        } else if ((getAge() >= 18) && (getAge() < 60) && (getMembership() == true)) {
            this.price = 1600.0;
        } else if ((getAge() >= 60)&&(getMembership()==true)) {
            this.price = 1200.0;
        } else if (getMembership()==false) {
            this.price = 500.0;
        } else {this.price=0.0;} }

    public void setArrears(double arrears) { this.arrears = arrears; }
    //-------------------------------GETTERS------------------------------------
    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public int getID() { return ID; }

    public int getTime() { return time; }

    public String getDiscipline() { return discipline; }

    public String getTimeDate() { return timeDate; }

    public double getPrice() { return price; }

    public String getMembershipDate() { return membershipDate; }

    public boolean getMembership() { return membership; }

    public double getArrears() { return arrears; }



//-------------------------------TO-STRING--------------------------------------

    public String toString() {
        if (membership == true) {
            return "Konkurrence svømmer: " + name + " " + lastName + ", Alder: " + age + ", ID: " + ID + "\n" +
                    "Medleksskab : Aktiv, Disciplin: " + discipline + ", Bedste tid: " + time + ", Dato for bedste tid: "
                    + timeDate + ", Pris: " + price + ",- Restance: " + arrears + ",- Medlem siden: " + membershipDate;
        } else if (membership == false) {
            return "Konkurrence svømmer: " + name + " " + lastName + ", Alder: " + age + ", ID: " + ID + "\n" +
                    "Medleksskab : Passiv, Disciplin: " + discipline + ", Bedste tid: " + time + ", Dato for bedste tid: "
                    + timeDate + ", Pris: " + price + ",- Restance: " + arrears + ",- Medlem siden: " + membershipDate;
        } else {
            return null;
        } }

    @Override
    public int compareTo(CompetitiveMember other) {
        return this.time - other.time;
    }
}