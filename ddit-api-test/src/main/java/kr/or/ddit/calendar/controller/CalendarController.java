package kr.or.ddit.calendar.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.calendar.vo.CalendarEventVO;

@Controller
public class CalendarController {
	
	@GetMapping("/calendarUI")
	public String getCalendarUI() {
		return "calendar/calendarUI";
	}
	
	@GetMapping("/getEventList")
	public String getEventList(
			Model model
		){
		
		List<CalendarEventVO> list = new ArrayList<>();
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dayAfterNow = now.plusDays(1);
		
		CalendarEventVO e1 = new CalendarEventVO();
		e1.setAllDay(false);
		e1.setTitle("24시간짜리 이벤트");
		e1.setStart(now.toString());
		e1.setEnd(dayAfterNow.toString());

		
		LocalDate day = LocalDate.now();
		LocalDateTime ldt1 = now.plusDays(1);
		int y1 = ldt1.getYear();
		Month m1 = ldt1.getMonth();
		int d1 = ldt1.getDayOfMonth();
		LocalDate tommorow = LocalDate.of(y1, m1, d1);
		
		CalendarEventVO e2 = new CalendarEventVO();
		e2.setAllDay(true);
		e2.setTitle("하루종일 이벤트");
		e2.setStart(day.toString());
		e2.setEnd(tommorow.toString());
		
		list.add(e1);
		list.add(e2);
		
		model.addAttribute("list", list);
		
		return "jsonView";
	}
	@GetMapping("/ajax/getEventList")
	public List<CalendarEventVO> getEventListAjax(
			){
		
		List<CalendarEventVO> list = new ArrayList<>();
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dayAfterNow = now.plusDays(1);
		
		CalendarEventVO e1 = new CalendarEventVO();
		e1.setAllDay(false);
		e1.setTitle("24시간짜리 이벤트");
		e1.setStart(now.toString());
		e1.setEnd(dayAfterNow.toString());
		
		
		LocalDate day = LocalDate.now();
		LocalDateTime ldt1 = now.plusDays(1);
		int y1 = ldt1.getYear();
		Month m1 = ldt1.getMonth();
		int d1 = ldt1.getDayOfMonth();
		LocalDate tommorow = LocalDate.of(y1, m1, d1);
		
		CalendarEventVO e2 = new CalendarEventVO();
		e2.setAllDay(true);
		e2.setTitle("하루종일 이벤트");
		e2.setStart(day.toString());
		e2.setEnd(tommorow.toString());
		
		list.add(e1);
		list.add(e2);
		
		return list;
	}
	
	
	@GetMapping("/calendarUInojs")
	public String getCalendarUINoJS() {
		return "calendarUI";
	}
}
