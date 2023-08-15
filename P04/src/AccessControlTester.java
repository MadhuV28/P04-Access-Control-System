/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Access Control Tester
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
 * this class has AccessControl and the test methods
 * 
 * @author mvuyyuru
 *
 */

public class AccessControlTester {

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());

  }

  /**
   * 
   * @return
   */
  public static boolean runAllTests() {
    if (testUserConstructorAndMethods() && testAccessControlIsValidLoginNotValidUser()
        && !testAddUserWithNoAdminPowers() && testAddRemoveUserWithAdminPowers()) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Checks the correctness of the User constructors and methods
   * 
   * @return true if the User constructors and methods are correct and false otherwise
   */
  public static boolean testUserConstructorAndMethods() {
    User tUser = new User("Madhu", "9876", true);
    if (tUser.getUsername() != "Madhu") {
      return false;
    }
    if (tUser.getIsAdmin() != true) {
      return false;
    }
    tUser.setIsAdmin(false);
    if (tUser.getIsAdmin() != false) {
      return false;
    }
    if (tUser.isValidLogin("9876") != true) {
      return false;
    }
    tUser.setPassword("3456");
    if (tUser.isValidLogin("3456") != true) {
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of AccessControl.isValidLogin() method when called with incorrect
   * username or not matching (username, password) pair
   * 
   * @return true if AccessControl.isValidLogin() method is correct and false otherwise
   */
  public static boolean testAccessControlIsValidLoginNotValidUser() {
    boolean result = true;
    AccessControl a = new AccessControl();
    if (AccessControl.isValidLogin("notAdmin", "9876") != false) {
      result = false;
    }
    if (AccessControl.isValidLogin("admin", "root") != true) {
      result = false;
    }
    return result;
  }

  /**
   * Creates a new AccessControl object and does not log in an admin. This test must fail if
   * addUser(String username) does not return false or if a user was added to the list of user after
   * the method returns.
   * 
   * @return false if addUser does not return false or if a user was added to the list of user after
   *         the method returns and return true otherwise
   */
  public static boolean testAddUserWithNoAdminPowers() {
    AccessControl a = new AccessControl();
    if (a.addUser("Madhu") == false) {
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of addUser and removeUser methods when the current user has admin powers
   * 
   * @return true if addUser and removeUser methods when the current user has admin powers is
   *         correct and false otherwise
   */
  public static boolean testAddRemoveUserWithAdminPowers() {
    AccessControl a = new AccessControl();
    a.setCurrentUser("admin");
    if (a.addUser("Madhu") == false) {
      return false;
    }
    if (a.removeUser("Madhu") == false) {
      return false;
    }
    return true;
  }
}
