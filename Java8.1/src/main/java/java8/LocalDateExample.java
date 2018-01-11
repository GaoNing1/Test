package java8;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * LocalDate Examples
 * @author pankaj
 *
 */
public class LocalDateExample {

	public static void main(String[] args) {
		
		//当前时间
		LocalDate today = LocalDate.now();
		System.out.println("Current Date="+today);
		
		//通过输入参数创建LocalDate
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date="+firstDay_2014);
		
		
		//通过提供无效的输入来创建日期
		//LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		//线程“main”中的异常java.time.DateTimeException： 
		//“2014年2月29日”无效日期不是闰年
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST="+todayKolkata);

	
		//从1970.01.01获取日期
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("1970.01.01的第365天= "+dateFromBase);
		
		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("2014年的第100天="+hundredDay2014);
	}

}
