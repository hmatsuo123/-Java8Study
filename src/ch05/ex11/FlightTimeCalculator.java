package ch05.ex11;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlightTimeCalculator {
	private static Map<String, String> aliasMap;

    static {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Los Angeles", "America/Los_Angeles");  // -8:00
        map.put("Frankfurt", "CET");                    // +1:00
        aliasMap = Collections.unmodifiableMap(map);
    }

	public static LocalDateTime calcArrivalTime(LocalDateTime departureTime, String departureZoneName, Duration flightTime, String arrivalZoneName) {
		LocalDateTime dateTime = null;
		try {
			ZoneId departureZone = ZoneId.of(departureZoneName, aliasMap);
			ZoneId arrivalZone = ZoneId.of(arrivalZoneName, aliasMap);
			dateTime = ZonedDateTime.of(departureTime, departureZone).plus(flightTime)
	                .withZoneSameInstant(arrivalZone).toLocalDateTime();
		} catch (DateTimeException e) {
			e.printStackTrace();
		}

        return dateTime;
    }

	public static Duration calcFlightTime(LocalDateTime departureTime, String departureZoneName, LocalDateTime arrivalTime, String arrivalZoneName) {
		Duration time = null;
		try {
			ZoneId departureZone = ZoneId.of(departureZoneName, aliasMap);
			ZoneId arrivalZone = ZoneId.of(arrivalZoneName, aliasMap);
			time = Duration.between(ZonedDateTime.of(departureTime, departureZone), ZonedDateTime.of(arrivalTime, arrivalZone));
		} catch (DateTimeException e) {
			e.printStackTrace();
		}

        return time;
    }

	public static void main(String[] args) {
		Duration time = FlightTimeCalculator.calcFlightTime(LocalDateTime.of(2017, 1, 1, 14, 5), "Frankfurt", LocalDateTime.of(2017, 1, 1, 16, 40), "Los Angeles");
		System.out.println(time);
	}
}
