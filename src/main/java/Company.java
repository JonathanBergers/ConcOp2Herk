import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Company{

    public Semaphore custWaiting, devWaiting, startCustConv, endConv, devMayEnter, beginCon;

    private Semaphore mutexCustomersWaiting, mutexDevelopersWaiting, joinConversationMutex;

    public Company(boolean withProductOwner){
        this.productOwner = new ProductOwner(this);
        devMayEnter = new Semaphore(0);
        custWaiting = new Semaphore(0);
        devWaiting = new Semaphore(0);
        startCustConv = new Semaphore(0);
        endConv = new Semaphore(0);
        beginCon = new Semaphore(0);

        joinConversationMutex = new Semaphore(1);

        mutexCustomersWaiting = new Semaphore(1);
        mutexDevelopersWaiting = new Semaphore(1);
        if(withProductOwner){
            productOwner.start();
        }




    }
    public Company(){
      this(true);

    }



    public final ProductOwner productOwner;
    private int customersWaiting = 0;
    private int developersWaiting = 0;
    private int peopleInConversationRoom = 0;

    public void incrCustWaiting(){
        try {
            mutexCustomersWaiting.acquire();
            customersWaiting ++;
            mutexCustomersWaiting.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void incrDevWaiting(){
        try {
            mutexDevelopersWaiting.acquire();
            developersWaiting ++;
            mutexDevelopersWaiting.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void decrCustWaiting(){
        try {
            mutexCustomersWaiting.acquire();
            customersWaiting --;
            mutexCustomersWaiting.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void decrDevWaiting(){
        try {
            mutexDevelopersWaiting.acquire();
            developersWaiting --;
            mutexDevelopersWaiting.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void incrPeopleInConRoom(){
        try {
            joinConversationMutex.acquire();
            peopleInConversationRoom ++;
            joinConversationMutex.release();
            if(productOwner.getConversationSize() == peopleInConversationRoom){
                beginCon.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decrPeopleInConRoom(){
        try {
            joinConversationMutex.acquire();
            peopleInConversationRoom --;
            joinConversationMutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCustomersWaiting() {
        return customersWaiting;
    }

    public int getDevelopersWaiting() {
        return developersWaiting;
    }

    public int getPeopleInConversationRoom() {
        return peopleInConversationRoom;
    }
}
