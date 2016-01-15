/**
 * Created by jonathan on 8-1-16.
 */
public abstract class CompanyMember extends Thread{


    private static int idCounter = 0;
    private final int id;

    protected final Company company;


    protected CompanyMember(Company company) {
        this.company = company;
        id = idCounter;
        idCounter++;
    }



    protected void conversate(){


        try {
            System.out.println(toString() + " I am having a conversation");
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return id + " " + getClass().getCanonicalName() + " ";
    }
}
