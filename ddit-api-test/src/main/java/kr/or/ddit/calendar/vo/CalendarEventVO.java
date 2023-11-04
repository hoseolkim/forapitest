package kr.or.ddit.calendar.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CalendarEventVO {
	private String groupId;
	private String title;
	private String start;
	private String end;
	private Boolean allDay;
}