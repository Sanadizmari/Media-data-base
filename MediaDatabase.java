/**
 * Interface for a media database, which can add new media entries,
 * look up entries by title, and list all media in the database.
 */
public interface MediaDatabase {

    /**
     * Adds a new media entry to the database.
     *
     * @param newMedia the new media entry to add
     */
    public void addEntry(Media newMedia);

    /**
     * Looks up a media entry in the database by its title.
     *
     * @param title the title of the media entry to look up
     * @return the media entry with the given title, or null if not found
     */
    public Media lookupByTitle(String title);

    /**
     * Lists all media entries in the database.
     */
    public void listAllMedia();

    /**
     * Lists all media entries of a specific type in the database.
     *
     * @param type the type of media to list (e.g. "music" or "movie")
     */
    public void listMediaByType(String type);

}
