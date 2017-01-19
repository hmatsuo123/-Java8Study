package ch05.ex08;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class TimeZone {
	public static List<String> getTimeZoneOffsets(Instant instant) {
        return ZoneId.getAvailableZoneIds().stream()
                .map(z -> instant.atZone(ZoneId.of(z)))
                .map(z -> z.getOffset() + " " + z.getZone().toString())
                .collect(Collectors.toList());
    }

	public static void main(String[] args) {
		TimeZone.getTimeZoneOffsets(LocalDateTime.now().toInstant(ZoneOffset.UTC)).forEach(System.out::println);
	}
}
