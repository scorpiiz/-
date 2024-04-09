package com.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 
 * @author Administrator
 *
 */
public class DateUtils {
//	private static final String SIGN = "/";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private static final ThreadLocal<DateFormat> FORMAT_DATE_TIME = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	/**
	 * yyyy年MM月dd日 HH时mm分
	 */
	private static final ThreadLocal<DateFormat> FORMAT_DATE_TIME_TEXT = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		}
	};
	/**
	 * yyyy-MM-dd HH:mm
	 */
	private static final ThreadLocal<DateFormat> FORMAT_DATE_HOUR_MINUTE = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm");
		}
	};
	/**
	 * yyyy-MM-dd
	 */
	private static final ThreadLocal<DateFormat> FORMAT_MONTH = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM");
		}
	};
	
	
	/**
	 * yyyy-MM-dd
	 */
	private static final ThreadLocal<DateFormat> FORMAT_DATE = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	/**
	 * HH:mm
	 */
	private static final ThreadLocal<DateFormat> FORMAT_HOUR_MINUTE = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("HH:mm");
		}
	};
	/**
	 * MM-dd HH:mm
	 */
	private static final ThreadLocal<DateFormat> FORMAT_MONTH_DAY_HOUR_MINUTE = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("MM-dd HH:mm");
		}
	};

	/**
	 * MM-dd
	 */
	private static final ThreadLocal<DateFormat> FORMATE_MONTH_DAY = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("MM-dd");
		}
	};
	
	/**
	 * MM月dd日
	 */
	private static final ThreadLocal<DateFormat> FORMATE_MONTH_DAY_TEXT = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("MM月dd日");
		}
	};
	
	private static final ThreadLocal<DateFormat> FORMATE_MILLI_SECOND=new ThreadLocal<DateFormat>(){
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		}
	};
	
	/**
	 *  yyyy-MM-dd hh:mm:ss SSS 转日期
	 */
	public static final Date parseDateMilliSecondTime(String dateStr){
		try {
			return FORMATE_MILLI_SECOND.get().parse(dateStr);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * 日期转 yyyy-mm-dd HH:mm:ss SSS
	 */
	public static final String formatDateMilliSecondDateTime(Date dateTime){
		return FORMATE_MILLI_SECOND.get().format(dateTime);
	}
	/**
	 * 时间戳转 yyyy-mm-dd HH:mm:ss SSS
	 */
	public static final String formatDateMilliSecondDateTime(long longDateTime) {
		return FORMATE_MILLI_SECOND.get().format(new Date(longDateTime));
	}
	
	

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static Date parseDateTime(String dateStr) {
		try {
			return FORMAT_DATE_TIME.get().parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static Date parseDateHourMinute(String dateStr) {
		try {
			return FORMAT_DATE_HOUR_MINUTE.get().parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * yyyy-MM-dd
	 */
	public static Date parseDate(String dateStr) {
		try {
			return FORMAT_DATE.get().parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * HH:mm
	 */
	public static Date parseHourMinute(String dateStr) {
		try {
			return FORMAT_HOUR_MINUTE.get().parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDateTime(Date date) {
		return FORMAT_DATE_TIME.get().format(date);
	}
	/**
	 * yyyy年MM月dd日 HH时mm分
	 */
	public static String formatDateTimeText(Date date) {
		return FORMAT_DATE_TIME_TEXT.get().format(date);
	}
	/**
     * yyyy-MM-dd HH:mm
     */
    public static String formatDateHourMinute(Date date) {
        return FORMAT_DATE_HOUR_MINUTE.get().format(date);
    }

	/**
	 * yyyy-MM
	 */
	public static String formatMonth(Date date) {
		return FORMAT_MONTH.get().format(date);
	}
	
	/**
	 * yyyy-MM-dd
	 */
	public static String formatDate(Date date) {
		return FORMAT_DATE.get().format(date);
	}

	/**
	 * MM-dd HH:mm
	 */
	public static String formatMonthDayHourMinute(Date date) {
		return FORMAT_MONTH_DAY_HOUR_MINUTE.get().format(date);
	}

	/**
	 * 日期转 MM-dd
	 */
	public static String formatMonthDay(Date date) {
		return FORMATE_MONTH_DAY.get().format(date);
	}
	
	public static String formatMonthDayText(Date date) {
		return FORMATE_MONTH_DAY_TEXT.get().format(date);
	}
	

	/**
	 * HH:mm
	 */
	public static String formatHourMinute(Date date) {
		return FORMAT_HOUR_MINUTE.get().format(date);
	}

	public static Date addHourDate(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}
	
	
	public static Date addDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

    //前一天
	public static Date beforeDate(Date date) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);  
		Date beforeDate =  calendar.getTime();   
		return parseDate(formatDate(beforeDate));
	}
	
	
	public static boolean beforeCurrentDate(String edate){
		Date cdate = new Date();
		Date date = parseDate(edate);
		return date.before(cdate);
	}
	
	public static boolean beforeCurrentDate(Date edate){
		Date cdate = new Date();
		long i = cdate.getTime() - edate.getTime();
		if(i>=0){
			return true;
		}
		return false;
	}
	
	public static Date addMinuteDate(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}
	
	public static Date getNextDateBeginTime(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	
	
	/** 
	* 计算时间差小时
	*/
	public static int getDifferentHours(Date date1,Date date2){
		if(null == date1){
			return 0;
		}
		Date tempDate1= date1;
		Date tempDate2 = date2;
		if(null == tempDate2){
			Calendar calendar = Calendar.getInstance();
			tempDate2= calendar.getTime();
		}
		long hour1 = tempDate1.getTime()/(1000 *60 *60);
		long hour2 =  tempDate2.getTime()/(1000 *60 *60);
		return Math.abs((int) (hour1-hour2));
	}
	
	/** 
	* 计算时间差天数
	*/
	public static int getDiffrentDays(Date date1,Date date2){
		if(null == date1){
			return 0;
		}
		Date tempDate1= date1;
		Date tempDate2 = date2;
		if(null == tempDate2){
			Calendar calendar = Calendar.getInstance();
			tempDate2= calendar.getTime();
		}
		long hour1 = tempDate1.getTime()/(1000 *60 *60*24);
		long hour2 =  tempDate2.getTime()/(1000 *60 *60*24);
		return Math.abs((int) (hour1-hour2));
		
		
	}
	

	/**
	 * 日期转字符串
	 */
	public static String formatTxtTime(Date createAt) {
		return FORMAT_DATE_TIME.get().format(createAt);
	}
	public static String getFormatTime(Date date, String sdf) {
		return (new SimpleDateFormat(sdf)).format(date);
	}
	

	private static final int[] TIMEAPPEND = { 535680, 44640, 1440, 60, 1 };
	
	/**
	 * 日期转整形
	 */
	public static int getSimpleDateValue(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR)%100;
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int value = 0;
		value = year * TIMEAPPEND[0];
		value += month * TIMEAPPEND[1];
		value += day * TIMEAPPEND[2];
		value += hour * TIMEAPPEND[3];
		value += min * TIMEAPPEND[4];
		return value;
	}
	
	public static Date convertDoubleToDate(double score){
		
//		Long time =Double.doubleToLongBits(score-10000000000000l);
		long time = Math.round(score);
		return new Date(time);
	}
	
	/**
	 * 随机时间
	 */
	public static String randomDateBetweenMinAndMax(String beginDate,String endDate) {
		
		Date start = parseDate(beginDate);
	    Date end = parseDate(endDate);
	    return randomDateBetweenMinAndMax(start, end);
	}
	
	

	public static String randomDateBetweenMinAndMax(Date beginDate,Date endDate) {
	
		long min = beginDate.getTime();
		
		long max = endDate.getTime();

		double randomDate = Math.random() * (max - min) + min;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Math.round(randomDate));
		return  formatDate(calendar.getTime()) ;
	}
	
	
	
	public static int differentDaysByMillisecond(Date date1,Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
		return days;
	}
	
	
	public static String getDatePoor(String stime,String etime) {
		Date nowDate =  DateUtils.parseDateHourMinute(stime);
		Date endDate =  DateUtils.parseDateHourMinute(etime); 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    String datePoor=null;
	    if(day<=0&&hour<=0){
	    	datePoor = min + "分钟";
	    }else if(day<=0&&hour>0){
	    	datePoor = hour + "小时" + min + "分钟";
	    }else {
	    	datePoor = day + "天" + hour + "小时" + min + "分钟";
	    }
	    
	    
	    return datePoor;
	}
	
	
	public static String getSpecifiedDayAfter(String specifiedDay){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+1); 

		String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		return dayAfter; 
	} 
	
	public static int getDiscrepantDays(String start, String end) {
		Date dateStart = parseDate(start);
		Date dateEnd = parseDate(end);
		return getDiscrepantDays(dateStart, dateEnd);
	}
	
	public static int getDiscrepantDays(Date dateStart, Date dateEnd) {
		return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
	}

}
