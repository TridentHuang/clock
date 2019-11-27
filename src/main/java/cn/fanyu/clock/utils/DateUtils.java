package cn.fanyu.clock.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @version V3.0
 * @Title: DateUtils
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/27 下午10:12
 */
public class DateUtils {
    //获取当天日期
    public static String getNowDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDate = sdf.format(date);
        return nowDate;
    }

    //获取昨日日期
    public static String getYesterdayStr() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd");
        return startSdf.format(c.getTime());
    }
}
