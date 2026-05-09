import CalculatorApp.*;
import org.omg.CORBA.*;

public class CalculatorImpl extends CalculatorPOA {
	private ORB orb;
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	public float add(float a, float b) {
		return a + b;
	}

	public float sub(float a, float b) {
        	return a - b;
    }

    	public float mul(float a, float b) {
        	return a * b;
    }

	public float div(float a, float b) {
		if (b == 0) {
			System.out.println("Division by 0 is not allowed");
			return 0;
		}

		return a / b;
	}
}