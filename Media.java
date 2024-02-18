/**
 * This abstract class represents a media object with properties such as
 * type, title, location, year, and category.
 */
public abstract class Media {
    private String type, title, location, category;
    private int year;

    /**
     * Constructor to initialize the properties of the media object.x
     * 
     * @param type     The type of the media (music or movie).
     * @param title    The title of the media.
     * @param location The location (URL or path) of the media file.
     * @param year     The year the media was produced or released.
     * @param category The category of the media (e.g. action, comedy, rock, jazz).
     */
    public Media(String type, String title, String location, int year, String category) {
        this.type = type;
        this.title = title;
        this.location = location;
        this.year = year;
        this.category = category;
    }

    /**
     * Getter method for the media type.
     * 
     * @return The type of the media (music or movie).
     */
    public String getType() {
        return type;
    }

    /**
     * Getter method for the media title.
     * 
     * @return The title of the media.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the media location.
     * 
     * @return The location (URL or path) of the media file.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter method for the media year.
     * 
     * @return The year the media was produced or released.
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter method for the media category.
     * 
     * @return The category of the media (e.g. action, comedy, rock, jazz).
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter method for the media type.
     * 
     * @param t The new type of the media.
     */
    public void setType(String t) {
        type = t;
    }

    /**
     * Setter method for the media title.
     * 
     * @param ti The new title of the media.
     */
    public void setTitle(String ti) {
        title = ti;
    }

    /**
     * Setter method for the media location.
     * 
     * @param L The new location (URL or path) of the media file.
     */
    public void setLocation(String L) {
        location = L;
    }

    /**
     * Setter method for the media year.
     * 
     * @param y The new year the media was produced or released.
     */
    public void setYear(int y) {
        year = y;
    }

    /**
     * Setter method for the media category.
     * 
     * @param c The new category of the media (e.g. action, comedy, rock, jazz).
     */
    public void setCategory(String c) {
        category = c;
    }

    /**
     * Abstract method to play the media.
     */
    public abstract void playMedia();

    /**
     * Abstract method to return a string representation of the media.
     */
    public String toString() {
        return type + ": "
                + "Title: " + title + ", "
                + " Location: " + location + ", "
                + " year: " + year + ", "
                + " Category: " + category;
    }
}