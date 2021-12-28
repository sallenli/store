package com.store.common.utils;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期辅助组件
 *
 */
@Component
public class DateProviderImpl implements  DateProvider{
    //获取当前时间
    public Date getCurrentTime() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        return  currentTime;
    }
    //将date对象格式话成yyy-mm-dd hh:mm:ss

    /**
     *
     * @param date
     * @return 格式化日期
     * @throws Exception
     */
    @Override
    public String formatDateTime(Date date) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(date);
    }

    /**
     * 将日期字符串转换成date对象
     * @param dateTime
     * @return
     * @throws Exception
     */
    @Override
    public Date parseDateTime(String dateTime) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.parse(dateTime);

    }
}
