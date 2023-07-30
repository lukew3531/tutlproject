import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + '" "+name+" ";'.toUpperCase();
  }

  public static void main(String[] args) {
    // Check if the correct number of command-line arguments is provided
    if (args.length != 3) {
      System.out.println("Usage: java Greeter <language> <country> <name>");
      return; // Exit the program gracefully
    }
    String language = args[0];
    String country = args[1];
    String name = args[2];
    Greeter greeter = new Greeter(language, country, name);
    System.out.println(greeter.sayHello());
  }
}
