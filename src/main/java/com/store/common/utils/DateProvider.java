package com.store.common.utils;

import java.util.Date;

public interface DateProvider {

     Date getCurrentTime() throws Exception;

     String formatDateTime(Date date) throws Exception;

     /**
      * 将日期字符串转换成date对象
      * @param dateTime
      * @return
      * @throws Exception
      */
     Date parseDateTime(String dateTime) throws  Exception;
}
