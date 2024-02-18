import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MDConsolelO is a command-line interface for a media database.
 * It provides various operations to add, view, and play media entries.
 */
public class MDConsoleIO {

  private static Scanner scanner = new Scanner(System.in); // Scanner object
  // A MyMediaDatabase object to store and retrieve media entries
  private static MyMediaDatabase database = new MyMediaDatabase();

  /**
   * This is the main method of the program. It calls the 'processCommand'
   * method to start the process.
   */
  public static void main(String[] args) {
    menu(); // Calls the menu method to start the process.
  }

  /**
   * This method prompts the user to add a new entry to the media database.
   * The user is prompted to enter the type of media (music or movie),
   * and then is prompted to enter information specific to that media type.
   * A new Music or Movie object is created based on the user input,
   * and added to the media database.
   * 
   * @throws InputMismatchException if the user enters invalid input
   * 
   * @throws Exception              if an error occurs during the creation of the
   *                                Music/Movie object
   */
  public static void doAddEntry() {
    try {
      // prompt user to enter the type of the media
      System.out.println("Enter media type (music/movie):");
      String type = scanner.nextLine().toLowerCase();

      if (type.equals("music")) {

        // prompt user to enter title
        String title;
        do {
          System.out.println("Enter title:");
          title = scanner.nextLine().toLowerCase();

        } while (title.isEmpty());

        // prompt user to enter location
        String location;
        do {
          System.out.println("Enter location:");
          location = scanner.nextLine();
        } while (location.isEmpty());

        // prompt user to enter year;
        int year = 0;
        while (true) {
          System.out.println("Enter year:");
          String yearStr = scanner.nextLine();
          try {
            year = Integer.parseInt(yearStr);
            break;
          } catch (NumberFormatException e) {
            System.out.println("Invalid year. Please enter a valid year.");
          }
        }

        // promot user to enter category
        String category;
        do {
          System.out.println("Enter category:");
          category = scanner.nextLine();
        } while (category.isEmpty());

        // propmt user to enter artist
        String artist;
        do {
          System.out.println("Enter artist:");
          artist = scanner.nextLine();
        } while (artist.isEmpty());

        // propmt user to enter number of songs
        int numberOfSongs = 0;
        while (true) {
          System.out.println("Enter number of songs:");
          String numberOfSongsStr = scanner.nextLine();
          try {
            numberOfSongs = Integer.parseInt(numberOfSongsStr);
            break;
            // Catches the possible exception if user attentd to enter a string instead of
            // int.
          } catch (NumberFormatException e) {
            System.out.println("Invalid number of songs. Please enter a valid number.");
          }
        }
        // create new Music object and add it to the media database
        Music music = new Music(type, title, location, year, category, artist, numberOfSongs);
        database.addEntry(music);

        // Movie Type of media database
      } else if (type.equals("movie")) {
        // prompt user to enter title
        String title;
        do {
          System.out.println("Enter title:");
          title = scanner.nextLine().toLowerCase();

        } while (title.isEmpty());

        // prompt user to enter location
        String location;
        do {
          System.out.println("Enter location:");
          location = scanner.nextLine();
        } while (location.isEmpty());

        // prompt user to enter the year.
        int year = 0;
        while (true) {
          System.out.println("Enter year:");
          String yearStr = scanner.nextLine();
          try {
            year = Integer.parseInt(yearStr);
            break;

            // Catches the possible exception if user attentd to enter a string instead of
            // int.
          } catch (NumberFormatException e) {
            System.out.println("Invalid year. Please enter a valid year.");
          }
        }

        // prompt user to enter category
        String category;
        do {
          System.out.println("Enter category:");
          category = scanner.nextLine();
        } while (category.isEmpty());

        // propmt user to enter the directory
        String director;
        do {
          System.out.println("Enter director:");
          director = scanner.nextLine();
        } while (director.isEmpty());

        // propmt user to enter the playing time
        int playingTime = 0;
        while (true) {
          System.out.println("Enter playing time (in minutes):");
          String playingTimeStr = scanner.nextLine();
          try {
            playingTime = Integer.parseInt(playingTimeStr);
            break;
          } catch (NumberFormatException e) {
            System.out.println("Invalid playing time. Please enter a valid number.");
          }
        }

        // create new Movie object and add it to the media database
        Movie movie = new Movie(type, title, location, year, category, director, playingTime);
        database.addEntry(movie);
      } else {
        System.out.println("Invalid media type. Please try again.");
      }

    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please try again.");
      scanner.next(); // clear the input buffer
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }

  /**
   * This method prompts the user to enter a title of a media item,
   * and then looks up the details of that item in the media database.
   * If the item is found, its details are printed to the console.
   * If the item is not found, a message indicating so is printed.
   */
  public static void doGetDetails() {
    // propmt user to enter the title.
    System.out.println("Enter title:");
    String title = scanner.nextLine().toLowerCase();

    // lookup the media by title in the media database
    Media media = database.lookupByTitle(title);
    if (media == null) {
      System.out.println(title + " not found in the database");
    } else {
      // print the details of the media item
      System.out.println(media);
    }
  }

  /**
   * This method calls the "listAllMedia" method of the media database,
   * which prints the details of all the media items in the database to the
   * console.
   */
  public static void doListAllMedia() {
    database.listAllMedia();
  }

  /**
   * This method prompts the user to enter a media type (music or movie),
   * and then calls the "listMediaByType" method of the media database,
   * which prints the details of all the media items of the specified type to the
   * console.
   */
  public static void doListMediaByType() {
    System.out.println("Enter media type (music/movie):");
    String type = scanner.nextLine().toLowerCase();
    if (type.equals("movie") || type.equals("music")) {
      database.listMediaByType(type);
    } else {
      System.out.println("\nThe " + type + " Type does not exist!\n");
    }
  }

  /**
   * This method prompts the user to enter a title of a media item,
   * and then looks up the media item in the media database.
   * If the item is found, its "playMedia" method is called to play the media.
   * If the item is not found, a message indicating so is printed.
   */
  public static void doPlayMedia() {
    System.out.println("Enter title:");
    String title = scanner.nextLine().toLowerCase();
    // lookup the media by title in the media database
    Media media = database.lookupByTitle(title);
    if (media == null) {
      System.out.println(title + " not found in the database");
    } else {
      // call the "playMedia" method of the media item to play the media
      media.playMedia();
    }
  }

  /**
   * Displays a menu of options to the user and processes the user's choice.
   */
  public static void menu() {
    // display the welcome message
    System.out.println("\n---------------------------------");
    System.out.println("    Welcome to Media Database");
    System.out.println("----------------------------------\n");

    // loop indefinitely to display the menu and process user's choice
    while (true) {
      // display the menu options to the user
      System.out.println("-------------MENU-------------");
      String[] options = {
          "Add Entry",
          "Get details of media",
          "Play Media",
          "List all media",
          "List media by type",
          "Exit\n"
      };
      for (int i = 0; i < options.length; i++) {
        System.out.println("Enter " + (i + 1) + ": "
            + options[i]);
      }
      System.out.println("Please choose an option:");

      // read the user's choice from the console
      String choice = scanner.nextLine();

      // call the corresponding method based on the user's choice
      switch (choice) {
        case "1" -> doAddEntry();
        case "2" -> doGetDetails();
        case "3" -> doPlayMedia();
        case "4" -> doListAllMedia();
        case "5" -> doListMediaByType();
        case "6" -> {
          System.out.println("Goodbye!");
          System.exit(0);
        }
        default -> System.out.println("*** Invalid option - "
            + "Enter an integer between 1 and "
            + (options.length));
      }
    }
  }
}