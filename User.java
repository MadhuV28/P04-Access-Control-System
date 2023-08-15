/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: User
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
 * this class has User and methods and mutators and accessors that can be run on AccessControl.
 * 
 * @author mvuyyuru
 *
 */
public class User {
  private final String USERNAME;// The name of the user
  private String password;// The password of the user
  private boolean isAdmin;// Whether or not the user has Admin powers

  /**
   * 
   * @param username for the User
   * @param password for user
   * @param isAdmin  status of admin for user
   */
  public User(String username, String password, boolean isAdmin) {
    this.USERNAME = username;
    this.isAdmin = isAdmin;

  }

  /**
   * Report whether the password is correct
   * 
   * @param password the password that was set by the user
   * @return false if the password entered does not equal the correct password and true if they are
   *         equal
   */
  public boolean isValidLogin(String password) {
    if (this.password.equals(password)) {
      return true;
    }
    return false;
  }

  /**
   * Return the name of the user
   * 
   * @return USERNAME
   */
  public String getUsername() {
    return USERNAME;
  }

  /**
   * Report whether the user is an admin
   * 
   * @return isAdmin
   */
  public boolean getIsAdmin() {
    return isAdmin;
  }

  /**
   * Set the new password
   * 
   * @param password that was set by user
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Set the new admin status
   * 
   * @param isAdmin whether or not admin access is allowed
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}


