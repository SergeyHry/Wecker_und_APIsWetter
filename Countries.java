package TestFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
public abstract class Countries {
	private String city;
	public  Countries(String city) {
		this.city = city; 
	}

	public String time() {
	    String formattedStrings = "";
	    String[] parts;
	    Set<String> zoneIds = ZoneId.getAvailableZoneIds();
	    for (String zone : zoneIds) {
	        parts = zone.split("/");
	        if (parts.length > 1 && parts[1].equalsIgnoreCase(city)) {
	            ZoneId zoneId = ZoneId.of(zone);
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss ");
	            String formattedString = ZonedDateTime.now(zoneId).format(formatter);
	           
	            formattedStrings += formattedString + "\n";
	        }
	    }
	    return formattedStrings;
	}


public String getCity() {
	return city;
}
			}
				

			
	


