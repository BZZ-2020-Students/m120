package aufgabe3;

/**********************************************************
*
*  This class contains the main() method
*  for the JavaPhone application.
*
* @author  H. Diethelm, HTA Luzern
* @version 1.0  12-06-2000
* 
**********************************************************/

class JavaPhoneMain {
  
  // Starts free-standing Java-Program
  public static void main(String[] args) {
      // Create a new object of class aufgabe3.JavaPhoneGUI
    JavaPhoneGUI gui = new JavaPhoneGUI();
    gui.setSize(300, 300);
  }

}