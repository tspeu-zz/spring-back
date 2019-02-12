import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCryp {

	public static void main(String[] args) {

		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		System.out.println("pass " + pe.encode("user"));
		
		
		
		
	}

}
