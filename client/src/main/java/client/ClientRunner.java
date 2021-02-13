package client;

import de.viadee.api.roundtrip.client.api.ApiClient;
import de.viadee.api.roundtrip.client.api.ApiException;
import de.viadee.api.roundtrip.client.api.UserApiApi;
import de.viadee.api.roundtrip.client.api.model.User;

public class ClientRunner {
	
	public static void main(String[] args) throws ApiException {
		
		ApiClient apiClient = new ApiClient();
		apiClient.setHost("localhost");
		apiClient.setPort(8080);
		UserApiApi userAPI = new UserApiApi(apiClient);
		
		User user = new User();
		user.setName("Bob");
		User savedUser = userAPI.save(user);
		
		System.out.println(savedUser);
	}

}
