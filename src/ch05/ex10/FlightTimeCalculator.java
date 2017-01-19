package ch05.ex10;

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

	public static void main(String[] args) {
		LocalDateTime time = FlightTimeCalculator.calcArrivalTime(LocalDateTime.of(2017, 1, 1, 3, 5), "Los Angeles", Duration.ofMinutes(10 * 60 + 50), "Frankfurt");
		System.out.println(time.getHour() + ":" + time.getMinute());
	}
}
