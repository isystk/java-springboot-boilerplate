package com.isystk.sample.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 日付ユーティリティ
 */
@Slf4j
public class DateUtils {

	/**
	 * Date型の値を指定されたDateTimeFormatterフォーマットした値を返します。
	 *
	 * @param fromDate
	 * @param formatter
	 * @return
	 */
	public static String format(final Date fromDate, final DateTimeFormatter formatter) {
		val zoneId = getZoneId();
		val localDateTime = fromDate.toInstant().atZone(zoneId).toLocalDateTime();
		val result = formatter.format(localDateTime);
		return result;
	}

	/**
	 * LocalDateTime型の値を指定されたDateTimeFormatterフォーマットした値を返します。
	 *
	 * @param fromLocalDateTime
	 * @param formatter
	 * @return
	 */
	public static String format(final LocalDateTime fromLocalDateTime, final DateTimeFormatter formatter) {
		val result = formatter.format(fromLocalDateTime);
		return result;
	}

	/**
	 * Date型の値をLocalDateTime型に変換して返します。
	 *
	 * @param fromDate
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(final Date fromDate) {
		val zoneId = getZoneId();
		return fromDate.toInstant().atZone(zoneId).toLocalDateTime();
	}

	/**
	 * LocalDateTime型の値をDate型に変換して返します。
	 *
	 * @param fromLocalDateTime
	 * @return
	 */
	public static Date toDate(final LocalDateTime fromLocalDateTime) {
		val zoneId = getZoneId();
		val zoneDateTime = ZonedDateTime.of(fromLocalDateTime, zoneId);
		return Date.from(zoneDateTime.toInstant());
	}

	/**
	 * LocalDate型の値をDate型に変換して返します。
	 *
	 * @param localDate
	 * @return
	 */
	public static Date toDate(final LocalDate localDate) {
		val zoneId = getZoneId();
		val zoneDateTime = localDate.atStartOfDay(zoneId).toInstant();
		return Date.from(zoneDateTime);
	}

	protected static ZoneId getZoneId() {
		return ZoneId.systemDefault();
	}

	/**
	 * システムで利用する現在日時を取得します。。
	 *
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime getNow() {
		return LocalDateTime.now();
	}

    /**
     * 指定した日付に、指定した年数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param year 加算する年数
     * @return Date 日付+加算する年数の日付
     */
    public static LocalDateTime addYear(final LocalDateTime date, final int year) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.YEAR, year);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した月数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param month 加算する月数
     * @return Date 日付+加算する月数した日付
     */
    public static LocalDateTime addMonth(final LocalDateTime date, final int month) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.MONTH, month);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した週数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param addDays 加算する週数
     * @return Date 日付+加算する週数の日付
     */
    public static LocalDateTime addWeek(final LocalDateTime date, final int addWeeks) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.DATE, addWeeks * 7);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した日数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param addDays 加算する日数
     * @return Date 日付+加算する日数の日付
     */
    public static LocalDateTime addDate(final LocalDateTime date, final int addDays) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.DATE, addDays);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した時間を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param addHours 加算する時間
     * @return Date 日付+加算する時間の日付
     */
    public static LocalDateTime addHour(final LocalDateTime date, final int addHours) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.HOUR_OF_DAY, addHours);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した分数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param minute 加算する分数
     * @return Date 日付+加算する分数の日付
     */
    public static LocalDateTime addMinute(final LocalDateTime date, final int minute) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.MINUTE, minute);
	return toLocalDateTime(cal.getTime());
    }

    /**
     * 指定した日付に、指定した秒数を加算した日付を返します。<br>
     *
     * @param date 日付
     * @param second 加算する秒数
     * @return Date 日付+加算する秒数の日付
     */
    public static LocalDateTime addSecond(final LocalDateTime date, final int second) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(toDate(date));
	cal.add(Calendar.SECOND, second);
	return toLocalDateTime(cal.getTime());
    }

}
