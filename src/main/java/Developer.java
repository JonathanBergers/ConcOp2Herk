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



        //

        while (true){

            try {
                work();
                System.out.println(toString() + "now available");
                company.productOwner.memberJoined.release();

                if(company.productOwner.isInConversation()){
                    System.out.println(toString() + "PO in conversation");
                }else{

                    company.incrDevWaiting();
                    company.devWaiting.acquire();
                    company.decrDevWaiting();
                    if(company.devMayEnter.tryAcquire()){
                        // in conversation
                        System.out.println(toString() + "in conversation");
                        company.endConv.acquire();
                        System.out.println(toString() + "left conversation");

                    }else{
                        System.out.println(toString() + "I may not enter");

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
