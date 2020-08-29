package com.marco.utils.enums;

/**
 * Enum used by the DateUtils class
 * 
 * @author marco
 *
 */
public enum DateFormats {
	EXIF_DATE_TIME("yyyy:MM:dd HH:mm:ss"),
	EXIF_DATE_TIME_WITH_ZONE("yyyy:MM:dd HH:mm:ssZZZZZ"),
	DB_TIME_STAMP("yyyy-MM-dd HH:mm:ss"),
	FOLDER_NAME("yyyyMMdd"),
	DB_DATE("yyyy-MM-dd"),
	FILE_NAME("yyyyMMdd_HHmmss"),
	FILE_NAME_SHORT("yyMMdd_HHmmss"),
	FILE_NAME_WITH_SPACE("yyyyMMdd HHmmss"),
	FILE_NAME_COMPACT("yyyyMMddHHmm"),
	FILE_NAME_HHMM("yyyyMMdd_HHmm"),
	FILE_NAME_JUST_DATE("yyyyMMdd"),
	EXIF_DATE_TIME_RUBBISH_01("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd&HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_02("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_03("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd/HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_04("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HH:mm.ss"),
	EXIF_DATE_TIME_RUBBISH_05("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HHmm"),
	EXIF_DATE_TIME_RUBBISH_06("yyyy/MM/dd HH:m"),
	EXIF_DATE_TIME_RUBBISH_07("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd\"HH:m"),
	EXIF_DATE_TIME_RUBBISH_08("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd+HH:m"),
	EXIF_DATE_TIME_RUBBISH_09("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HH:m"),
	EXIF_DATE_TIME_RUBBISH_10("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd+HH;m"),
	EXIF_DATE_TIME_RUBBISH_11("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd*HH:m"),
	EXIF_DATE_TIME_RUBBISH_12("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd.HHmm"),
	EXIF_DATE_TIME_RUBBISH_13("yyyy" + ((char)65533) + "MM" + ((char)65533) + "dd\"HHmm"),
	EXIF_DATE_TIME_RUBBISH_14("dd/MM/yyyy HH:m"),
	EXIF_DATE_TIME_RUBBISH_15("yyyy:MM:dd HH:m");
	
	
	private final String format;

	private DateFormats(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}
	
}
