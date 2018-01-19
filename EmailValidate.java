package app;

public class EmailValidate {
	
	public static void main(String[] args) {
		System.out.println(isGmail("youremail@gmail.com"));
	}
	
	public static Boolean checkEmail(String emajllat) {
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		boolean emailIsOk = true;
		String[] test = emajllat.split(",");
	    for (int i = 0; i < test.length; i++) {
	        if (!test[i].matches(emailPattern)) {
	            emailIsOk = false;
	            break;
	        }
	    }
	    return emailIsOk;
	    
	    
	}
	public static Boolean isGmail(String emaili) {
		String emailPattern = "^[A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "(?iu)(gmail.com)$";
		
		boolean emailIsGmail = true;
	
        if (!emaili.matches(emailPattern))
        	emailIsGmail = false;
            
	    return emailIsGmail;    
	}
}
