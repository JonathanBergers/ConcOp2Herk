import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class ProductOwner extends CompanyMember {


    public final Semaphore developerJoined, customerJoined;


    protected ProductOwner(Company company) {
        super(company);
    }







    @Override
    public void run() {


        try {
            developerJoined.acquire();


            if(customerJoined.tryAcquire()){
                //customer available
                //start customerconv



            }else{
                //no customers available
                //start developer conv

            }

            //


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // member joined

        // try aquire customers

        // else try aquire developers





        // developers available ?



        
        super.run();
    }
}
