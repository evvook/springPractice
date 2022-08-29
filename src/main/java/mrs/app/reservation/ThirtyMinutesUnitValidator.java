package mrs.app.reservation;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ThirtyMinutesUnitValidator implements ConstraintValidator<ThirtyMinnutesUnit, LocalTime>{

	@Override
	public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null) {
			return true;
		}
		return value.getMinute() % 30 == 0;
	}

}
