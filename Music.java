import java.util.Scanner;

/**
 * Represents a music media.
 * Inherits common media fields from the Media class.
 */
public class Music extends Media {

    private String artist; // the artist of the music
    private int numberOfSongs; // the number of songs in the music

    /**
     * Constructor for the Musbic class.
     * 
     * @param title         The title of the music.
     * @param location      The location of the music.
     * @param year          The year of the music.
     * @param category      The category of the music.
     * @param artist        The artist of the music.
     * @param numberOfSongs The number of songs in the music.
     */
    public Music(String type, String title, String location, int year, String category, String artist,
            int numberOfSongs) {
        // Call the superclass constructor to set the common media fields
        super(type, title, location, year, category);
        // Set the unique music fields
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
    }

    /**
     * Implements the abstract method declared in the Media class.
     * Prompts the user to enter a track number to play and then prints a message
     * indicating the track number and title of the music being played.
     */
    @Override
    public void playMedia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which track do you want to play (Tracks 1-" + numberOfSongs + ")? ");
        int trackNumber = sc.nextInt();
        System.out.println("Now playing: Track " + trackNumber + " of " + getTitle());
        sc.close();
    }

    /*
     * Override the toString method to return a string representation of a Music
     * object
     */
    @Override
    public String toString() {
        return super.toString() + " artist: " + artist + ", " + numberOfSongs + " tracks";
        // return "Music: " + getTitle() + " (" + getYear() + ") by " + artist + " (" +
        // numberOfSongs + " songs)";
    }
}
