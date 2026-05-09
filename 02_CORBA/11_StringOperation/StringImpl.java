import StringApp.*;
import org.omg.CORBA.*;

public class StringImpl extends StringOperationPOA{
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	@Override
	public int length(String str) {
		return str.length();
	}

	public String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public String toUpper(String str) {
		return str.toUpperCase();
	}

	public String toLower(String str) {
		return str.toLowerCase();
	}
}