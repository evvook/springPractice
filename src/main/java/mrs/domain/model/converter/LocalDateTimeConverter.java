package mrs.domain.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		// TODO Auto-generated method stub
		return dateTime == null ? null : Timestamp.valueOf(dateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		// TODO Auto-generated method stub
		return value == null ? null : value.toLocalDateTime();
	}

}
