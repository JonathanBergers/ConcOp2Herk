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


                System.out.println(toString() + " complain");


                company.incrCustWaiting();
                // mention product owner
                company.productOwner.memberJoined.release();

                // wait for product owner to let cust in
                company.custWaiting.acquire();

                System.out.println(toString() + "waiting to enter conv");

                //start conversation
                company.startCustConv.acquire();
                company.decrCustWaiting();

                System.out.println(toString() + "in conversation");

                // end conversation
                company.endConv.acquire();

                System.out.println(toString() + "left conversation");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }





}
