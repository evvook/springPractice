package mrs.app.reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndTimeMustBeAfterStartTimeValidator implements ConstraintValidator<EndTimeMustBeAfterStartTime, ReservationForm>{

	private String message;
	
	@Override
	public void initialize(EndTimeMustBeAfterStartTime constrainAnnotation) {
		message = constrainAnnotation.message();
	}
	
	@Override
	public boolean isValid(ReservationForm value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value.getStartTime() == null || value.getEndTime() == null) {
			return true;
		}
		boolean isEndTimeMustBeAfterStartTime = value.getEndTime().isAfter(value.getStartTime());
		
		if(!isEndTimeMustBeAfterStartTime) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message).addPropertyNode("endTime").addConstraintViolation();
		}
		
		return isEndTimeMustBeAfterStartTime;
	}

}
