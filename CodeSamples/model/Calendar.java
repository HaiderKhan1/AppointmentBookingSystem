package sk.fsk.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

//https://howtodoinjava.com/spring-boot2/spring-boot-crud-hibernate/

@Entity
@Table(name = "CALENDAR")
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "calendar_name", unique = true, nullable = false )
	private String calendarName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "full_name")
	private String name;

	@Column(name = "email", nullable = false, length = 200)
	private String email;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "password", nullable = false, length = 500)
	private String password;

	@ColumnDefault("0")
	@Column(name = "status", nullable = false, length = 5)
	private int status;

	// https://www.baeldung.com/hibernate-one-to-many
	@OneToMany(mappedBy = "calendar")
	@JsonIgnore
	private Set<Booking> bookings;

	@OneToOne(mappedBy = "calendar", cascade = CascadeType.ALL)
	@JsonIgnore
	private Settings settings;

	@OneToMany(mappedBy = "calendar")
	@JsonIgnore
	private Set<Guest> guests;

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCalendarName() {
		return calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

//	public Set<Guest> getGuests() {
//		return guests;
//	}
//
//	public void setGuests(Set<Guest> guests) {
//		this.guests = guests;
//	}
}