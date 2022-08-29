package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reservationId;
	
	public LocalTime startTime;
	
	public LocalTime endTime;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "reserved_date"), @JoinColumn(name = "room_id")})
	private ReservableRoom reservableRoom;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public ReservableRoom getReservableRoom() {
		// TODO Auto-generated method stub
		return reservableRoom;
	}

	public boolean overlap(Reservation target) {
		// TODO Auto-generated method stub
		if(!Objects.equals(reservableRoom.getReservableRoomId(), target.getReservableRoom().getReservableRoomId())) {
			return false;
		}
		
		if(startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
			return true;
		}
		
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	public void setStartTime(LocalTime startTime) {
		// TODO Auto-generated method stub
		this.startTime = startTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		// TODO Auto-generated method stub
		this.endTime = endTime;
	}

	public void setReservableRoom(ReservableRoom reservableRoom) {
		// TODO Auto-generated method stub
		this.reservableRoom = reservableRoom;
	}

	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user = user;
	}
}
