package com.marco.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.marco.utils.enums.DateFormats;

/**
 * It provides some utils method to manipulate dates and time stamps
 * @author Marco
 *
 */
public class DateUtils {
	
	private DateUtils() {}

	/**
	 * It parse the string into a LocalDate object
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static LocalDate fromStringToLocalDate(String value, DateFormats format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
		return LocalDate.parse(value, formatter);
	}

	/**
	 * It converts the LocalDate into a String
	 * 
	 * @param localDate
	 * @param format
	 * @return
	 */
	public static String fromLocalDateToString(LocalDate localDate, DateFormats format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
		return localDate.format(formatter);
	}

	/**
	 * It parses a string into a local date time
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static LocalDateTime fromStringToLocalDateTime(String value, DateFormats format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
		return LocalDateTime.parse(value, formatter);
	}

	/**
	 * It parses a string into a Zoned Date Time
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static ZonedDateTime fromStringToZonedDateTime(String value, DateFormats format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
		return ZonedDateTime.parse(value, formatter);
	}

	/**
	 * It converts a local date time into a string
	 * 
	 * @param localDateTime
	 * @param format
	 * @return
	 */
	public static String fromLocalDateTimeToString(LocalDateTime localDateTime, DateFormats format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat());
		return localDateTime.format(formatter);
	}
}
