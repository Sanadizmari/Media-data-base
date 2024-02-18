import java.util.ArrayList;

/**
 * A class that represents a media database.
 */
public class MyMediaDatabase implements MediaDatabase {

    private ArrayList<Media> mediaList; // an arraylist for storing 2 types of media

    /**
     * Creates a new instance of the MyMediaDatabase class.
     */
    public MyMediaDatabase() {
        mediaList = new ArrayList<>();
    }

    /**
     * Adds a new media entry to the database.
     * 
     * @param newMedia The new media entry to add.
     */
    @Override
    public void addEntry(Media newMedia) {
        String title = newMedia.getTitle();
        boolean titleIsInTheList = false;

        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            if (media.getTitle().equals(title) && media.getType().equals(newMedia.getType())) {
                titleIsInTheList = true;
                break;
            }
        }

        if (titleIsInTheList) {
            System.out.println(
                    "Error: A " + newMedia.getType() + "is already in the list");
        } else {
            mediaList.add(newMedia);
            System.out.println("The media object has been added to the database.");
        }
    }

    /**
     * Searches the database for a media entry with the specified title.
     * 
     * @param title The title to search for.
     * @return The media entry with the specified title, or null if not found.
     */
    @Override
    public Media lookupByTitle(String title) {
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;

    }

    /**
     * Lists all media objects in the database.
     */
    @Override
    public void listAllMedia() {
        System.out.println("List of all media objects in the database:");
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            System.out.println(media.getType() + ": " + media.getTitle());
        }
    }

    /**
     * Lists all media objects of a certain type in the database.
     * 
     * @param type The type of media objects to list.
     */
    @Override
    public void listMediaByType(String type) {
        System.out.println("List of " + type + " objects in the database:");
        boolean typeisInTheList = false;
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            if (media.getType().equals(type)) {
                System.out.println(media.getTitle());
                typeisInTheList = true;
            }
        }
        if (!typeisInTheList) {
            System.out.println("There is no  " + type + " found in database.");
        }
    }
}