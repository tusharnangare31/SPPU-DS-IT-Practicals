import OddEvenApp.*;
import org.omg.CORBA.*;

public class OddEvenImpl extends OddEvenPOA{
    private ORB orb;

    public void setORB(ORB orb_val){
        orb = orb_val;
    }
    
    public String check(int num){
        if(num % 2 == 0)
            return "Even";
        else
            return "Odd";
    }
}