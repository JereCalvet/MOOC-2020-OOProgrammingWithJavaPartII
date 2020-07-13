
/**
 *
 * @author Jere
 */
public class CD implements Packable {
    
    private final String artist;
    private final String name;
    private final int publicationYear;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
    return artist + ": " + name + " (" + publicationYear + ")";
    }
    
    @Override
    public double weight() {
        return 0.1;
    }
}
