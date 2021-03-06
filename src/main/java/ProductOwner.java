import java.util.concurrent.Semaphore;

/**
 * Created by jonathan on 8-1-16.
 */
public class ProductOwner extends CompanyMember {


    public final Semaphore memberJoined;

    private int conversationSize = 0;

    protected ProductOwner(Company company) {
        super(company);
        memberJoined = new Semaphore(0);


    }

    public int getConversationSize(){
        return conversationSize;
    }



    private boolean inConversation = false;

    public boolean isInConversation(){
        return inConversation;
    }




    @Override
    public void run() {



        while(true){



            if(inConversation){

                try {
                    company.beginCon.acquire();
                    conversate();
                    // end conv
                    company.endConv.release(conversationSize);
                    conversationSize = 0;
                    inConversation = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }







            } else {

                try {

                    System.out.println(toString() + "I am fixing my room");
                    memberJoined.acquire();
                    System.out.println(toString() + "Member joined");
                    final int cWaiting = company.getCustomersWaiting();
                    final int dWaiting = company.getDevelopersWaiting();

                    System.out.println("--------------\n devs:" + dWaiting + " \n custs: " + cWaiting + "\n --------------");



                    if(dWaiting > 0){
                        // start a customer conv
                        if(cWaiting >0){

                            System.out.println(toString() + "There are now " + company.getCustomersWaiting() + " customers waiting in company");
                            // set the flag for the developer, so when he may stop waiting, he will know if he may enter the conversation.

                            conversationSize = 1 + cWaiting;

                            // see tryaquire developer
                            company.devMayEnter.release(1);
                            // now mention the developers and customers that they may stop waiting
                            company.devWaiting.release(dWaiting);
                            company.custWaiting.release(cWaiting);
                            // 1 developer is in the conversation, let the customers enter
                            company.startCustConv.release(cWaiting);
                            inConversation = true;

                            //wacht totdat iedereen is aangeschoven.








                            ///
                        }


                        if(dWaiting >3){
                            //start dev conv
                            System.out.println(toString() + "There are " + dWaiting + " developers waiting");
                            // start a developer conversation
                            // set the flag for 4 dev, so when he may stop waiting, he will know if he may enter the conversation.
                            // see tryaquire developer
                            company.devMayEnter.release(4);

                            company.devWaiting.release(dWaiting);
                            conversationSize = 4;

                            inConversation = true;




                        }
                    }


                    //


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }






        }

    }


}
