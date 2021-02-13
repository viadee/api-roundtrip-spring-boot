package de.viadee.api.roundtrip.api.controller;

/**
 * Exception indicating that a user was requested, that does not exist.
 */
public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -6082761705337370376L;
  
  public UserNotFoundException(String id) {
    super("Could not find user " + id);
  }

}
