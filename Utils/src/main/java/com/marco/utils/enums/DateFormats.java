package com.marco.utils.enums;

/**
 * Enum used by the DateUtils class
 * 
 * @author marco
 *
 */
public enum DateFormats {
	/**
	 * yyyy:MM:dd HH:mm:ss
	 */
	EXIF_DATE_TIME("yyyy:MM:dd HH:mm:ss"),
	/**
	 * yyyy:MM:dd HH:mm:ssZZZZZ
	 */
	EXIF_DATE_TIME_WITH_ZONE("yyyy:MM:dd HH:mm:ssZZZZZ"),
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	DB_TIME_STAMP("yyyy-MM-dd HH:mm:ss"),
	/**
	 * yyyyMMdd
	 */
	FOLDER_NAME("yyyyMMdd"),
	/**
	 * yyyy-MM-dd
	 */
	DB_DATE("yyyy-MM-dd"),
	/**
	 * yyyyMMdd_HHmmss
	 */
	FILE_NAME("yyyyMMdd_HHmmss"),
	/**
	 * yyMMdd_HHmmss
	 */
	FILE_NAME_SHORT("yyMMdd_HHmmss"),
	/**
	 * yyyyMMdd HHmmss
	 */
	FILE_NAME_WITH_SPACE("yyyyMMdd HHmmss"),
	/**
	 * yyyMMddHHmm
	 */
	FILE_NAME_COMPACT("yyyyMMddHHmm"),
	/**
	 * yyyyMMdd_HHmm
	 */
	FILE_NAME_HHMM("yyyyMMdd_HHmm"),
	/**
	 * yyyyMMdd
	 */
	FILE_NAME_JUST_DATE("yyyyMMdd"),
	EXIF_DATE_TIME_RUBBISH_01("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd&HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_02("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_03("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd/HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_04("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_05("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HHmm"),
	/**
	 * yyyy/MM/dd HH:m
	 */
	EXIF_DATE_TIME_RUBBISH_06("yyyy/MM/dd HH:m"),
	EXIF_DATE_TIME_RUBBISH_07("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd\"HH:m"),
	EXIF_DATE_TIME_RUBBISH_08("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd+HH:m"),
	EXIF_DATE_TIME_RUBBISH_09("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HH:m"),
	EXIF_DATE_TIME_RUBBISH_10("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd+HH;m"),
	EXIF_DATE_TIME_RUBBISH_11("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HH:m"),
	EXIF_DATE_TIME_RUBBISH_12("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HHmm"),
	EXIF_DATE_TIME_RUBBISH_13("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd\"HHmm"),
	/**
	 * dd/MM/yyyy HH:m
	 */
	EXIF_DATE_TIME_RUBBISH_14("dd/MM/yyyy HH:m"),
	/**
	 * yyyy:MM:dd HH:m
	 */
	EXIF_DATE_TIME_RUBBISH_15("yyyy:MM:dd HH:m");
	
	
	private final String format;

	private DateFormats(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}
	
}
