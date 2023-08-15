/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Access Control
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru
// Email: mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// no pair programming was used or allowed
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
/**
 * this class has AccessControl and methods and mutators that can be run
 * 
 * @author mvuyyuru
 *
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AccessControl {
  private static ArrayList<User> users; // An ArrayList of valid users
  private User currentUser;// Who is currently logged in, if anyone?
  private static final String DEFAULT_PASSWORD = "changeme"; // Default password given to new users
  // or when we reset a password of a specific user.

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    AccessControl control = new AccessControl();
  }

  /**
   * A no-argument constructor
   */
  public AccessControl() {
    if (users == null) {
      users = new ArrayList<>();
      users.add(new User("admin", "root", true));
    }
    currentUser = null;
  }

  /**
   * 
   * Report whether a given username/password pair is a valid login
   * 
   * @param username
   * @param password
   * @return true if the given username and password is valid and return false if it is not valid.
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      User currentUser = users.get(i);
      if (currentUser.getUsername().equals(username) && currentUser.isValidLogin(password)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Change the password of the current user
   * 
   * @param newPassword
   */
  public void changePassword(String newPassword) {
    if (currentUser != null) {
      currentUser.setPassword(newPassword);
    }
  }

  /**
   * Log out the current user
   */
  public void logout() {
    currentUser = null;
  }

  /**
   * A mutator that you can use to write tests without simulating user input. It sets the current
   * user to the user from the users list whose username matches the string provided as input to the
   * method (exact match case sensitive).
   * 
   * @param username that matches the string provided
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
      }
    }
  }

  /**
   * Create a new user With the default password and isAdmin==false and add it to the users
   * ArrayList throws an IllegalArgumentException with a descriptive error message if username is
   * null or if its length is less than 5 ( < 5), or if a user with the same username is already in
   * the list of users (usernames must be unique) Return true if the current user has Admin power
   * and the new user was successfully added. Return false if the the current user is null or does
   * not have Admin power
   * 
   * @param username of the user
   * @return false if currentUser is empty or if it is not given admin access and return true if the
   *         current user has Admin power and the new user was successfully added
   * @throws IllegalArgumentException with descriptive error message if the username that was
   *                                  entered was empty,the username that was entered is less than 5
   *                                  characters or if the username that was entered is already
   *                                  being used
   */
  public boolean addUser(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    if (username == null) {
      throw new IllegalArgumentException("the username that was entered was empty");
    }
    if (username.length() < 5) {
      throw new IllegalArgumentException("the username that was entered is less than 5 characters");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("the username that was entered is already being used");
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, false));
    return true;
  }

  /**
   * Create a new user, specify their admin status, and add it to the list of users. throws an
   * IllegalArgumentException with a descriptive error message if username is null or if its length
   * is less than 5 ( < 5), or if a user with the same username is already in the list of users
   * Return true if the current user has Admin power and the new user was successfully added. Return
   * false if the the current user is null or does not have Admin power
   * 
   * @param username
   * @param isAdmin
   * @return false if the the current user is null or does not have Admin power and true if the
   *         current user has Admin power and the new user was successfully added
   * @throws IllegalArgumentException with descriptive error message if the username that was
   *                                  entered was empty,the username that was entered is less than 5
   *                                  characters or if the username that was entered is already
   *                                  being used
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    if (username == null) {
      throw new IllegalArgumentException("the username that was entered was empty");
    }
    if (username.length() < 5) {
      throw new IllegalArgumentException("the username that was entered is less than 5 characters");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("the username that was entered is already being used");
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, isAdmin));
    return true;
  }

  /**
   * Remove a user given their unique username throws a NoSuchElementException with a descriptive
   * error message if no match with username is found in the list of users Return true if the
   * current user has Admin powers and the user whose username is passed as input was successfully
   * removed. Return false if the the current user is null or does not have Admin power
   * 
   * @param username that is given
   * @return false if the the current user is null or does not have Admin power and true if if the
   *         current user has Admin powers and the user whose username is passed as input was
   *         successfully removed
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean removeUser(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.remove(i);
        return true;
      }
    }
    throw new NoSuchElementException("A user with the entered username does not exist");

  }

  /**
   * Give a user admin power throws a NoSuchElementException with a descriptive error message if no
   * match with username is found in the list of users Return true if this operation terminates
   * successfully Return false if the current user is null or does not have admin powers
   * 
   * @param username
   * @return true if this operation terminates successfully and false if the current user is null or
   *         does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of user
   */
  public boolean giveAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(true);
        return true;
      }
    }
    throw new NoSuchElementException("A user with the entered username does not exist");
  }

  /**
   * Remove the admin power of a user given their username throws a NoSuchElementException with a
   * descriptive error message if no match with username is found in the list of users Return true
   * if this operation terminates successfully Return false if the current user is null or does not
   * have admin powers
   * 
   * @param username
   * @return true if this operation terminates successfully and false if the current user is null or
   *         does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean takeAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(false);
        return true;
      }
    }
    throw new NoSuchElementException("A user with the entered username does not exist");
  }

  /**
   * Reset the password of a user given their username throws a NoSuchElementException with a
   * descriptive error message if no match with username is found in the list of users Return true
   * if this operation terminates successfully Return false if the current user is null or does not
   * have admin powers
   * 
   * @param username
   * @return true if this operation terminates successfully and false if the current user is null or
   *         does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean resetPassword(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setPassword(DEFAULT_PASSWORD);
        return true;
      }
    }
    throw new NoSuchElementException("A user with the entered username does not exist");
  }

}
