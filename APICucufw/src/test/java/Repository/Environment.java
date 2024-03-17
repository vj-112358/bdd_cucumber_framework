package Repository;

public class Environment {

	public static String Hostname() {
		String hostname = "https://reqres.in/";
		return hostname;
	}

	public static String Resource_create() {
		String resource = "api/users";
		return resource;
	}
	public static String Resource_login() {
		String resource = "api/login";
		return resource;
	}

	public static String Resource_Put() {
		String resource = "api/users/2";
		return resource;
	}
	public static String Resource_register() {
		String resource = "api/register";
		return resource;
	}
	public static String Resource_Delete() {
		String resource = "api/users";
		return resource;
	}
	public static String Resource_Patch() {
		String resource = "api/users/2";
		return resource;
	}

	public static String HeaderName() {

		String headername = "Content-Type";
		return headername;
	}

	public static String HeaderValue() {

		String headervalue = "application/json";
		return headervalue;
	}

	public static String Resource_get() {
		String resource = "api";
		return resource;
	}

}