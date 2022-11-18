package testcases.DataReadFromExternalSources;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import reusableComponents.PropertiesOperations;

public class FilloDataReader {

	public static void main(String[] args) throws Exception {
		Fillo fillo = new Fillo();
		String filePath = System.getProperty("user.dir")
				+ PropertiesOperations.getPropertyValueByKey("testDataLocation2");
		Connection connection = fillo.getConnection(filePath);
		String s="TaskCreationData";
		//String strQuery = null;
		if(s.equalsIgnoreCase("TaskCreationData")) {
			String strQuery ="Select * from TaskCreationData";
			Recordset recordset = connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			System.out.println(recordset.getFieldNames().size());
			recordset.close();
			connection.close();
		}
		
//		recordset.next();
//		System.out.println(recordset);
		//System.out.println(recordset.getCount());//row count
		//System.out.println(recordset.getFieldNames().size());
		//System.out.println(fillo.getConnection(strQuery));
		
		//int columnCount=recordset.getFieldNames().size();//8
//		recordset.next();
//		recordset.next();
//		String columnName=recordset.getField(6).name();
//		String columnValue=recordset.getField(6).value();
//		
//		System.out.println(columnName+"-->"+columnValue);
		
//		while(recordset.next()) { //5
//			for (int i = 0; i < columnCount; i++) { //8
//				System.out.print(recordset.getField(i).name() + "-->" + recordset.getField(i).value() + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
		//int columnCount = recordset.getFieldNames().size();

//		Map<String, String> dataMap = new HashMap<>();
//
//		while (recordset.next()) {
//			for (int i = 0; i < columnCount; i++) {
//				// dataMap.put(recordset.getField(i).name(), recordset.getField(i).value());
//				System.out.println(recordset.getField(i).name() + "-->" + recordset.getField(i).value() + " ");
//			}

			// System.out.println("-----------------");
		//}
//		System.out.println(dataMap);
//		System.out.println(dataMap.get("CAMPAIGNID"));
//		for (String key : dataMap.keySet()) {
//			if (key.equals("CampaignID")) {
//				System.out.println(dataMap.get("CampaignID"));
//			}
//		}
		
	}
}
