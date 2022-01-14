package utils;
/**
 * @desc   日期处理工具类
 * @author wyh
 * @time   2022-01-06
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


	/**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
	 * @throws ParseException 
     */
    public static int differentDaysByMillisecond(String dateStr,String dateStr2) throws ParseException
    {
    	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fDate=format.parse(dateStr);
            Date oDate=format.parse(dateStr2);
            //初始化日历工具类
            Calendar aCalendar = Calendar.getInstance();
            //设定开始的日期
            aCalendar.setTime(fDate);
            int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);//DAY_OF_YEAR:一年的第多少天
            
            //设定结束的日期
            aCalendar.setTime(oDate);
            int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
            
            int days=day2-day1;
            System.out.print(days);
            return days;
    }
    
    public static void main(String[] args) throws ParseException {
    	
   	    String dateStr = "2022-1-12 ";
        Date now=new Date();//获取当前的日期
        SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd");//对当前日期进行格式化处理
        System.out.println("dateStr2:"+dFormat.format(now));
        System.out.println("两个日期的差距：" + differentDaysByMillisecond(dateStr,dFormat.format(now)));
   }
	
	
	
	
}
