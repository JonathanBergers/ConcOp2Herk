import org.junit.Test;

/**
 * Created by jonathan on 15-1-16.
 */
public class CompanyTest {


    public static void main(String[] args) {
//        testOnlyCustomers();
        testOnlyDevs();
//        testCustomers1Dev();
    }


    /**The expected result is that the only thing you see is that the product owner is fixing his room
     *
     */
    public static void testOnlyProductOwner(){

        new Company();

    }

    public static void testOnlyCustomers(){

        Company c = new Company();

        for (int i = 0; i < 10; i++) {
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

    public static void testOnlyDevs(){

        Company c = new Company();

        for (int i = 0; i < 5; i++) {
            new Developer(c).start();
        }

    }

}
