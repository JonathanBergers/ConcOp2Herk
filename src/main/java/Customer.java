import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Customer extends Thread{


    private final Semaphore conversationStart;
    final Company company;

    public Customer(Company company) {
        this.company = company;
    }

    @Override
    public void run() {

        // join line for conversation
        // release product owner 1


        // wait for product owner
        //


        try {
            company.productOwner.customerJoined.release();
            // now wait for message of po
            conversationStart.acquire();

            // have a cnv







        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        super.run();
    }





}
