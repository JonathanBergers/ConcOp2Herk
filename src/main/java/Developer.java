/**
 * Created by jonathan on 8-1-16.
 */
public class Developer extends CompanyMember {


    protected Developer(Company company) {
        super(company);
    }



    private void work(){

        try {
            System.out.println(toString() + "Working");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true){


                work();

                System.out.println(toString() + "now available");
                // mention product owner
                company.productOwner.memberJoined.release();

                if(company.productOwner.isInConversation()){
                    System.out.println(toString() + "PO in conversation");
                }else{

                    // increment developers waiting in company
                    company.incrDevWaiting();

                    company.devWaiting.acquire();
                    // decrement waiting
                    company.decrDevWaiting();
                    //try to enter the conversation, this is the point where the
                    // PO regulates the amount of devs allowed for a conversation
                    if(company.devMayEnter.tryAcquire()){

                        // in conversation
                        System.out.println(toString() + "in conversation");
                        company.endConv.acquire();
                        System.out.println(toString() + "left conversation");

                    }else{
                        System.out.println(toString() + "I may not enter");

                    }
                }

            }


        }catch (InterruptedException e){

        }
    }


}
