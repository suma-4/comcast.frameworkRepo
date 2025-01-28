package Runner;

import org.testng.annotations.Test;

import Generic.Facebook;
import POM.LoginFB;

public class RunFacebook extends Facebook {
@Test
public void execute()
{
	LoginFB login=new LoginFB(driver);
	login.userName("suma@gmail.com");
	login.password("suma@123");
	login.button();
}
}