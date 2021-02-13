package de.viadee.api.roundtrip.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.RestController;
import de.viadee.api.roundtrip.api.model.User;

@RestController
public class UserApiController implements UserApi {

	private static final String MESSAGE_NULL_ID = "null is not a valid id";
	private static final String MESSAGE_NULL_USER = "null is not a valid user object";
	private Map<String, User> users = new HashMap<>();
	
	public UserApiController() {
        Stream.of("Bob", "Mary").map(name -> save(new User(name)));
	}
	
	@Override
	public List<User> findAll() {
		return new ArrayList<>(users.values());
	}

	@Override
	public User findById(String id) {
		return users.get(id);
	}

	@Override
	public User save(User user) {
		
		if(user == null) {
			throw new IllegalArgumentException(MESSAGE_NULL_USER);
		}
		
		user.setId(UUID.randomUUID().toString());
		users.put(user.getId(), user);

		return user;
	}

	@Override
	public User update(String id, User user) {
		
		if(id == null) {
			throw new IllegalArgumentException(MESSAGE_NULL_ID);
		}
		if(user == null) {
			throw new IllegalArgumentException(MESSAGE_NULL_USER);
		}
		
		users.put(id, user);
		
		return user;
	}

	@Override
	public void delete(String id) {
		
		if(id == null) {
			throw new IllegalArgumentException(MESSAGE_NULL_ID);
		}
		
		users.remove(id);
	}

}
