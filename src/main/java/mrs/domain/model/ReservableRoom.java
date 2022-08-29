package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.repository.Lock;

@Entity
public class ReservableRoom implements Serializable {

	@EmbeddedId
	private ReservableRoomId reservableRoomId;
	
	@ManyToOne
	@JoinColumn(name="room_id", insertable=false,updatable=false)
	@MapsId("roomId")
	public MeetingRoom meetingRoom;
	
	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}
	
	public ReservableRoom() {}

	public ReservableRoomId getReservableRoomId() {
		// TODO Auto-generated method stub
		return reservableRoomId;
	}
}
