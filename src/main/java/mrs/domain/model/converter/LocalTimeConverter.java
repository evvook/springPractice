package mrs.domain.model.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime time) {
		// TODO Auto-generated method stub
		return time == null ? null : Time.valueOf(time);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time value) {
		// TODO Auto-generated method stub
		return value == null ? null : value.toLocalTime();
	}

}
