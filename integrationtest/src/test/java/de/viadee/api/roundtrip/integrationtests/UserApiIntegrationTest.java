package de.viadee.api.roundtrip.integrationtests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.viadee.api.roundtrip.client.api.ApiClient;
import de.viadee.api.roundtrip.client.api.ApiException;
import de.viadee.api.roundtrip.client.api.UserApiApi;
import de.viadee.api.roundtrip.client.api.model.User;

class UserApiIntegrationTest {

	private UserApiApi userApi;
	
	@BeforeEach
	public void init() {
		ApiClient apiClient = new ApiClient();
		apiClient.setHost("localhost");
		apiClient.setPort(8080);
		userApi = new UserApiApi(apiClient);
	}
	
	@Test
	void testSaveUser() throws ApiException {
		
		User user = new User();
		user.setName("testSaveUser");
		User savedUser = userApi.save(user);
		
		assertNotNull(savedUser);
		assertNotNull(savedUser.getId());
		assertNotEquals(savedUser.getId(), user.getId());
		assertEquals(savedUser.getName(), user.getName());
	}
	
	@Test
	void testGetUser() throws ApiException {
		
		User user = new User();
		user.setName("testGetUser");
		User savedUser = userApi.save(user);
		
		User findUser = userApi.findById(savedUser.getId());
		
		assertNotNull(findUser);
		assertEquals(findUser.getName(), user.getName());
	}
	
	@Test
	void testFindAllUser() throws ApiException {
		
		User user = new User();
		user.setName("findAllUser");
		User savedUser = userApi.save(user);
		
		List<User> users = userApi.findAll();
		
		Optional<User> foundUser = users.stream().filter(u -> savedUser.getId().equals(u.getId())).findAny();
		assertTrue(foundUser.isPresent());
	}

}
