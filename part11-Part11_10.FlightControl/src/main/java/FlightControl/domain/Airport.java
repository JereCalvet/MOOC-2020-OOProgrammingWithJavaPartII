package FlightControl.domain;

/**
 *
 * @author Jere
 */
public class Airport {
    private final String code;
    private final String location;

    public Airport(String code, String location) {
        this.code = code;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return code + " (" + location + ")";
    } 
}
