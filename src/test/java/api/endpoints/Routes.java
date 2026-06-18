package api.endpoints;

public class Routes {
	
	public static String base_url= "https://petstore.swagger.io/v2";
	
	// User Module URLs
	
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String put_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	public static String get_login_url= base_url+"/user/login";
	public static String get_logout_url= base_url+"/user/logout";
	
	// Pet Module URLs
	
	public static String pet_post_url=base_url+"/pet";
	public static String pet_put_url= base_url+"/pet";
	public static String petByStatus_get_url= "/pet/findByStatus";
	

}
