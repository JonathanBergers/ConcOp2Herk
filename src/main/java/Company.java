import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Company extends Thread{


    public final ProductOwner productOwner;
    private List<Customer> customers;
    private List<Developer> developers;
    public Semaphore customerWaiting, customerConv, developerConv;

    public Company(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }





    public void onCustomerConversation(){

        // release all customers waiting
        // release 1 developer waiting
        // release all developers to go forward, only one may aquire the conversation

    }

    public void onDeveloperConv(){
        developerConv.release();

    }


    public void complainToCompany(){


        productOwner.onMemberJoined();


    }


    public void niks(){



    }




    public ProductOwner getProductOwner(){
        return productOwner;
    }







}
