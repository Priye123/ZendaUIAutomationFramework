package reusableComponents;

import java.util.HashMap;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloOperations {

	public HashMap<String, String> getTestData(String tcID, String sheetName) throws Exception {
		Fillo fillo = new Fillo();
		String filePath = System.getProperty("user.dir")
				+ PropertiesOperations.getPropertyValueByKey("testDataLocation");
		Connection connection = fillo.getConnection(filePath);
		String strQuery = null;
		if (sheetName.equalsIgnoreCase("StaffData"))
			strQuery = "Select * from StaffData where TC_ID='" + tcID + "'";

		Recordset recordset = connection.executeQuery(strQuery);
		int columnCount = recordset.getFieldNames().size();

		HashMap<String, String> dataMap = new HashMap<>();

		while (recordset.next()) {
			for (int i = 0; i < columnCount; i++) {
				dataMap.put(recordset.getField(i).name(), recordset.getField(i).value());
			}
		}
		return dataMap;
	}

}
