/**
 * Created by jonathan on 8-1-16.
 */
public abstract class CompanyMember extends Thread{


    protected final Company company;


    protected CompanyMember(Company company) {
        this.company = company;
    }


    @Override
    public void run() {

        // complain

        company.
        // message product owner
        // wait
        // start conversation, after semaphore of product owner



        super.run();
    }
}
