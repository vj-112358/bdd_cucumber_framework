package Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.Utility;

public class RequestBody extends Environment {
	public static String req_post_tc(String TestCaseName) throws IOException {
		ArrayList<String> Data = Utility.readExcelData("Post_API", TestCaseName);
		String key_1 = Data.get(1);
		String value_1 = Data.get(2);
		String key_2 = Data.get(3);
		String value_2 = Data.get(4);
		String req_body = "{\r\n" + "    \"" + key_1 + "\": \"" + value_1 + "\",\r\n" + "    \"" + key_2 + "\": \""
				+ value_2 + "\"\r\n" + "}";
		return req_body;
	}

	public static String req_put_tc(String TestCaseName) throws IOException {
		ArrayList<String> Data = Utility.readExcelData("Put_API", TestCaseName);
		String key_1 = Data.get(1);
		String value_1 = Data.get(2);
		String key_2 = Data.get(3);
		String value_2 = Data.get(4);
		String req_body = "{\r\n" + "    \"" + key_1 + "\": \"" + value_1 + "\",\r\n" + "    \"" + key_2 + "\": \""
				+ value_2 + "\"\r\n" + "}";
		return req_body;
	}

	public static String req_delete_tc(String TestCaseName) throws IOException {
		ArrayList<String> Data = Utility.readExcelData("Delete_API", TestCaseName);
		String key_1 = Data.get(1);
		String delete_resource = key_1;
		return delete_resource;
	}

	public static String req_patch_tc(String TestCaseName) throws IOException {
		ArrayList<String> Data = Utility.readExcelData("Patch_API", TestCaseName);
		String key_1 = Data.get(1);
		String value_1 = Data.get(2);
		String key_2 = Data.get(3);
		String value_2 = Data.get(4);
		String req_body = "{\r\n" + "    \"" + key_1 + "\": \"" + value_1 + "\",\r\n" + "    \"" + key_2 + "\": \""
				+ value_2 + "\"\r\n" + "}";
		return req_body;
	}

	public static String req_get_tc(String TestCaseName) throws IOException {
		ArrayList<String> Data = Utility.readExcelData("Get_API", TestCaseName);
		String get_resource = "";
		if (Data.get(2).equals(Data.get(3))){
			get_resource = Data.get(1);

		} else {
			get_resource = Data.get(1) + "?" + Data.get(2);
		}
		return get_resource;

	}
}
