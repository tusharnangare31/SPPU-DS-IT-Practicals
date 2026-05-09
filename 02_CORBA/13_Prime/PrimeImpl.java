import PrimeApp.*;
import org.omg.CORBA.*;

public class PrimeImpl extends PrimePOA{
    private ORB orb;

    public void setORB(ORB orb_val){
        orb = orb_val;
    }

    public String checkPrime(int num){
        if(num <= 1)
            return "Not Prime";

        for(int i = 2; i <= num/2; i++){
            if(num % i == 0)
                return "Not Prime";
        }

        return "Prime";
    }
}