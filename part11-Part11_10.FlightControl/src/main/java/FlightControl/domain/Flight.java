package FlightControl.domain;

/**
 *
 * @author Jere
 */
public class Flight {
    private final Airplane airplane;
    private final Airport departureAirport;
    private final Airport destinationAirport;
    private final String code; 

    public Flight(Airplane airplane, Airport departureAirport, Airport destinationAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.code = airplane.getID() + departureAirport.getCode() + departureAirport.getCode();
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }
    
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public String getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return airplane.toString() + " (" + departureAirport.getCode() + "-" + destinationAirport.getCode() + ")";
    }
}
