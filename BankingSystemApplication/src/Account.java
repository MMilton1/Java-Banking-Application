import java.util.Date;

public class Account implements  Comparable {

    static int nextAcctNumb = 359;
    int accNumb;
    String owner;
    City city;
    char gender;
    double balance;
    Date openDate;

    // Building the constructor

    public Account() {

    }

    public Account(String owner, City city, char gender) {
        accNumb = nextAcctNumb;
        nextAcctNumb += 359;
        this.owner = owner;
        this.city = city;
        this.gender = gender;

        balance = 0.0;
        openDate = null; // Passing the currentDate();
    }

    public Account(int accNumb, String owner, City city, char gender, double balance) {
        this.accNumb = accNumb;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        setBalance(balance);
    }

    public void setBalance(double bal) {
        balance = bal > 0.0 ? bal : 0.0;
    }

    @Override
    public String toString() {
        return accNumb +
                " " + owner + '\'' +
                " " + city.cityName +
                " " + gender +
                " " + balance +
                " " + openDate
                ;
    }


    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Account) o).owner);
    }

    // Deposit method created.
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
        }
    }

    // Withdrawal Method
    public double withdraw(double amount){
        if (amount > 0){
            if (amount < balance){
                setBalance(balance - amount);
            }
            else{
                amount = balance;
                setBalance(0.0);
            }
            return amount;
        }
        return 0.0;
    }


}

