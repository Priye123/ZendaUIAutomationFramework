package testcases.DataReadFromExternalSources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import pages.LoginAndDashboardPage2;
import testBase.TestBase;

public class LoginTestFromYamlFile extends TestBase {

	static final Logger log = LogManager.getLogger(LoginTestFromYamlFile.class);

	private static final String YAML_DATA = "username: testing_10dlc\n" + "password: fWVkHEOvTAij6K8APlJq\n";
	private static final String YAML_FILE = "src/test/resources/login-ui.yml";
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();

	@DataProvider(name = "dp")
	public Object[][] parseYaml() {
		Yaml yaml = new Yaml();
		Map<String, String> map = new HashMap<String, String>();
		map = (Map<String, String>) yaml.load(YAML_DATA);

		return new Object[][] { map.values().toArray() };
	}

	@DataProvider(name = "dp2")
	public Object[][] parseYamlFile() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream iStream = new FileInputStream(new File(YAML_FILE));
		Collection<Map<String, String>> usersCollection = (Collection<Map<String, String>>) yaml.load(iStream);

		// declare 2D Array to return
		String[][] users2DArray = new String[usersCollection.size()][2];

		// parse logic into 2D Array
		int i = 0;
		for (Map<String, String> usersMap : usersCollection) { // Iterate over collection of users
			Collection userValuesCollection = usersMap.values();
			for (Object userValue : userValuesCollection) { // Iterate over collection of user values
				Map<String, String> userMap = (Map<String, String>) userValue;
				for (Map.Entry<String, String> credentials : userMap.entrySet()) { // Iterate over map of each value
					if (credentials.getKey().equals("username"))
						users2DArray[i][0] = credentials.getValue();
					if (credentials.getKey().equals("password"))
						users2DArray[i][1] = credentials.getValue();
				}
			}
			i++;
		}

		return users2DArray;
	}

	@Test(dataProvider = "dp")
	public void loginTest(String user, String pwd) {
		log.info("username: " + user + "\t password: " + pwd);
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
	}

}
