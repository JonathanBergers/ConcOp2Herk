import org.junit.Test;

/**
 * Created by jonathan on 15-1-16.
 */
public class CompanyTest {


    public static void main(String[] args) {

        // only po
//        onePo();

        // only customers
//        onlyCust();

        // only devs
//        onlyDevs();

        //only custs and devs
//        onlyCustAndDevs();

        //1 dev and customers
//        testCustomers1Dev();

        // 1 po and customers
//        onlyCustAndPo();

        // 1 po and developers
//        onlyDevsAndPo();

        // 1 po and devs and customers
        all();

    }



    public static void onePo(){

        new Company();

    }
    public static void onlyCust(){
        Company c = new Company(false);

        for (int i = 0; i < 10; i++) {
            new Customer(c).start();
        }
    }

    public static void onlyCustAndPo(){
        Company c = new Company();

        for (int i = 0; i < 10; i++) {
            new Customer(c).start();
        }

    }


    public static void onlyDevs(){
        Company c = new Company(false);

        for (int i = 0; i < 10; i++) {
            new Developer(c).start();
        }
    }

    public static void onlyDevsAndPo(){
        Company c = new Company();

        for (int i = 0; i < 10; i++) {
            new Developer(c).start();
        }
    }


    public static void onlyCustAndDevs(){
        Company c = new Company(false);

        for (int i = 0; i < 10; i++) {
            new Developer(c).start();
            new Customer(c).start();
        }
    }


    public static void all(){
        Company c = new Company();

        for (int i = 0; i < 10; i++) {
            new Developer(c).start();
            new Customer(c).start();
        }
    }


    public static void testCustomers1Dev(){

        Company c = new Company();

        for (int i = 0; i < 10; i++) {
            new Customer(c).start();
        }
        new Developer(c).start();

    }


}
