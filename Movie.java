/**
 * The Movie class represents a movie, which is a type of media. It
 * extends the
 * Media class
 * and adds additional properties such as director and playing time.
 */
public class Movie extends Media {
    private String director;
    private int playingTime;

    /**
     * Constructs a new Movie object with the specified title, location, year,
     * category,
     * director, and playing time.
     *
     * @param title       the title of the movie
     * @param location    the location of the movie
     * @param year        the year the movie was released
     * @param category    the category of the movie (e.g. drama, comedy, action,
     *                    etc.)
     * @param director    the director of the movie
     * @param playingTime the playing time of the movie in minutes
     */
    public Movie(String type, String title, String location, int year, String category, String director,
            int playingTime) {
        super(type, title, location, year, category);
        this.director = director;
        this.playingTime = playingTime;
    }

    /**
     * Plays the movie by printing "Now playing:" followed by the movie's title.
     */
    @Override
    public void playMedia() {
        System.out.println("Now playing: " + getTitle());
    }

    /**
     * Returns a string representation of the movie, including its title, director,
     * year, playing time, category, and location.
     *
     * @return a string representation of the movie
     */
    @Override
    public String toString() {
        return super.toString() + ", " + "Director: " + director + ", PlayingTime: " + playingTime + "mins";
    }
}
