package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理的工具类
 * @author Administrator
 *
 */
public class DateUtil {
	/*
	* 根据某种格式把字符串转化为日期
	* dateFormat   日期格式
	* dateStr   日期字符串
	*/
	public static Date toDate(String dateFormat ,String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 根据某种日期格式把日期转化为字符串
     * @param dateFormat  日期格式
     * @param date
     * @return
     */
	public static String dateToString(String dateFormat,Date date){
		return new SimpleDateFormat(dateFormat).format(date);
	}
}
