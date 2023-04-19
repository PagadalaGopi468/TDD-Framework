package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;


public class Data_Utility {

	public String getdatafromProperties(String getData) throws Exception {
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\Credentials.properties");
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(getData);
	}
}
