import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class Developer extends CompanyMember {


    protected Developer(Company company) {
        super(company);
    }



    private void work(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {



        //

        while (true){

            try {
                System.out.println(toString() + "now available");
                company.productOwner.memberJoined.release();

                if(company.productOwner.isInConversation()){
                    System.out.println(toString() + "PO in conversation");
                    continue;
                }else{

                    company.developersWaiting ++;
                    company.devWaiting.acquire();

                    if(company.devMayEnter.tryAcquire()){
                        company.developersWaiting --;
                        // in conversation
                        System.out.println(toString() + "in conversation");
                        company.endConv.acquire();
                        System.out.println(toString() + "left conversation");

                    }else{
                        company.developersWaiting --;
                        // may not enter , go back to work
                        continue;
                    }


                }



                // wait for message of product owner if

                //check for enough developers


                //check for customer try aquire

                //make decision

                //start conversation

            }catch (InterruptedException e){

            }


        }
    }


}
