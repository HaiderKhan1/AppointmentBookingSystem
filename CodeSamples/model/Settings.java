package sk.fsk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SETTINGS")
public class Settings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String logoText;
	
	@Column
	private String  startTimeOfDay;
	
	@Column
	private String  endTimeOfDay;
	
	@Column
	private String workingDays;

	@Column
	private Integer  slotMaxSizeAllowed;

	@Column
	private Integer  maxSlotsAllowedPerDayPerUser;

	@Column
	private Integer  gapBetweenTwoSlots;

	@Column
	private Integer  openUpTo;
	
	@Column
	private Boolean disableEmailNotifications;
	
	@OneToOne	
	@JoinColumn(name = "calendar_id", nullable = false, unique = true)
	private Calendar calendar;

	@Column
	private Boolean preDefinedSlotsEnabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSlotMaxSizeAllowed() {
		return slotMaxSizeAllowed;
	}

	public void setSlotMaxSizeAllowed(Integer slotMaxSizeAllowed) {
		this.slotMaxSizeAllowed = slotMaxSizeAllowed;
	}

	public Integer getMaxSlotAllowedPerDayPerUser() {
		return maxSlotsAllowedPerDayPerUser;
	}

	public void setMaxSlotAllowedPerDayPerUser(Integer maxSlotsAllowedPerDayPerUser) {
		this.maxSlotsAllowedPerDayPerUser = maxSlotsAllowedPerDayPerUser;
	}

	public Integer getGapBetweenTwoSlots() {
		return gapBetweenTwoSlots;
	}

	public void setGapBetweenTwoSlots(Integer gapBetweenTwoSlots) {
		this.gapBetweenTwoSlots = gapBetweenTwoSlots;
	}

	public Boolean isDisableEmailNotifications() {
		return disableEmailNotifications;
	}

	public void setDisableEmailNotifications(Boolean disableEmailNotifications) {
		this.disableEmailNotifications = disableEmailNotifications;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getLogoText() {
		return logoText;
	}

	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}

	public Integer getOpenUpTo() {
		return openUpTo;
	}

	public void setOpenUpTo(Integer openUpTo) {
		this.openUpTo = openUpTo;
	}

	public Boolean preDefinedSlotsEnabled() {
		return this.getPreDefinedSlotsEnabled();
	}

	public Boolean getPreDefinedSlotsEnabled() {
		return preDefinedSlotsEnabled;
	}

	public void setPreDefinedSlotsEnabled(Boolean preDefinedSlotsEnabled) {
		this.preDefinedSlotsEnabled = preDefinedSlotsEnabled;
	}

	public String getStartTimeOfDay() {
		return startTimeOfDay;
	}

	public void setStartTimeOfDay(String startTimeOfDay) {
		this.startTimeOfDay = startTimeOfDay;
	}

	public String getEndTimeOfDay() {
		return endTimeOfDay;
	}

	public void setEndTimeOfDay(String endTimeOfDay) {
		this.endTimeOfDay = endTimeOfDay;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

}
