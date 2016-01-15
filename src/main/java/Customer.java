import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Customer extends CompanyMember{


    public Semaphore mayEnterConv;
    public Semaphore mayLeaveConv;

    protected Customer(Company company) {
        super(company);
    }


    @Override
    public void run() {

        while(true){

            try {
                company.productOwner.memberJoined.release();
                // now wait for message of po

                System.out.println(toString() + " complain");
                company.customersWaiting ++;
                company.custWaiting.acquire();

                System.out.println(toString() + "waiting to enter conv");

                company.startCustConv.acquire();
                company.customersWaiting --;
                System.out.println(toString() + "in conversation");
                company.endConv.acquire();
                System.out.println(toString() + "left conversation");










            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }





}
