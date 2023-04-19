package GenericUtilities;


import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	InstanceUtility i=new InstanceUtility();
	public String ReaddataFromProperty(String Key) throws Exception
	{
		FileInputStream f=new FileInputStream(i.PropertyFilePath());
		Properties p=new Properties();
		p.load(f);
		String value = p.getProperty(Key);
		return value;
		
	}
}

