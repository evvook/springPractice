package mrs.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		// TODO Auto-generated method stub
		return date == null ? null : Date.valueOf(date);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		// TODO Auto-generated method stub
		return value == null ? null : value.toLocalDate();
	}

}
