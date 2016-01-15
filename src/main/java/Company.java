import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Company{



    public Company(){
        this.productOwner = new ProductOwner(this);
        devMayEnter = new Semaphore(0);
        custWaiting = new Semaphore(0);
        devWaiting = new Semaphore(0);
        startCustConv = new Semaphore(0);
        endConv = new Semaphore(0);
        productOwner.start();



    }

    public final ProductOwner productOwner;
    public volatile int customersWaiting = 0;
    public volatile int developersWaiting = 0;

    public void incrCustWaiting(){
        customersWaiting ++;
    }
    public void incrDevWaiting(){
        developersWaiting ++;
    }
    public void decrCustWaiting(){
        customersWaiting --;
    }
    public void decrDevWaiting(){
        developersWaiting --;
    }

    public int getCustomersWaiting() {
        return customersWaiting;
    }

    public int getDevelopersWaiting() {
        return developersWaiting;
    }

    public Semaphore custWaiting, devWaiting, startCustConv, endConv, devMayEnter;



}
