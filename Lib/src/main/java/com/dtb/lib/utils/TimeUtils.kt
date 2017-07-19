package com.dtb.lib.utils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Bill on 2016/9/14 15:13.
 * emal:1750352866@qq.com
 */
object TimeUtils {

    /**
     * 将 String 转为 DATE

     * @param date 时间
     * *
     * @return date
     * *
     * @throws ParseException
     */
    @Throws(ParseException::class)
    fun StringToDate(date: String): Date? {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.parse(date)
    }

    /**
     * @param strTime 时间
     * *
     * @return long 时间
     * *
     * @throws ParseException
     */
    @Throws(ParseException::class)
    fun stringToLong(strTime: String): Long {
        val date = StringToDate(strTime) // String类型转成date类型
        if (date == null) {
            return 0
        } else {
            return date.time
        }
    }

    /**
     * 获取 月份的差值

     * @param date1 <String>
     * *
     * @return string
     * *
     * @throws ParseException
    </String> */
    @Throws(ParseException::class)
    fun getMonthSpace(date1: String?): String {
        if (date1 == null) {
            return "未知"
        }
        var resultM = 0
        var resultY = 0
        val date2 = localTime
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val c1 = Calendar.getInstance()
        val c2 = Calendar.getInstance()
        c1.time = sdf.parse(date1)
        c2.time = sdf.parse(date2)
        resultM = Math.abs(c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH))
        resultY = Math.abs(c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR))

        val str = StringBuilder()
        if (resultY != 0) {
            str.append(resultY.toString() + "年")
        }
        str.append(resultM.toString() + "个月")

        return str.toString()
    }

    /**
     *
     */
    fun dateFormat(date1: String?, fromFormat: String, endFromat: String): String? {
        try {
            val sdf = SimpleDateFormat(fromFormat, Locale.getDefault())
            val date: Date = sdf.parse(date1)
            val sdf2 = SimpleDateFormat(endFromat, Locale.getDefault())
            return sdf2.format(date)
        } catch (e: Exception) {
            return date1
        }
    }

    /**
     * 获取年限差值，收整计算
     * @author Thames_Lu
     */
    fun getYearSpace(date1: String?): Int {
        if (date1 == null) {
            return -1
        }
        var resultM = 0
        var resultY = 0
        val date2 = localTime
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val c1 = Calendar.getInstance()
        val c2 = Calendar.getInstance()
        c1.time = sdf.parse(date1)
        c2.time = sdf.parse(date2)
        resultM = Math.abs(c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH))
        resultY = Math.abs(c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR))

        if (resultM > 0) {
            resultY++
        }

        return resultY
    }

    /**
     * 将时间转换为时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(s: String, fromFormat: String): Long {
        val res: String
        val simpleDateFormat = SimpleDateFormat(fromFormat, Locale.getDefault())
        val date = simpleDateFormat.parse(s)
        val ts = date.time
        return ts
    }

    /**
     * 将时间戳转换为时间
     */
    fun stampToDate(s: String): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val lt = java.lang.Long.valueOf(s)!!
        val date = Date(lt)
        res = simpleDateFormat.format(date)
        return res
    }

    /**
     * 将时间戳转换为时间
     */
    fun changeTime(time: String): String {
        val date: String
        if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 60 < 1000)
            date = "当前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 60 < 5000)
            date = "1分钟前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 60 < 10000)
            date = "5分钟前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 60 < 30000)
            date = "10分钟前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 60 < 60000)
            date = "30分钟前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 3600 < 2000)
            date = "1小时前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 3600 < 5000)
            date = "2小时前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 3600 < 12000)
            date = "5小时前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 3600 < 24000)
            date = "12小时前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 86400 < 2000)
            date = "1天前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 86400 < 5000)
            date = "2天前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 86400 < 30000)
            date = "5天前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 86400 < 60000)
            date = "1个月前"
        else if ((System.currentTimeMillis() - java.lang.Long.valueOf(time)!!) / 86400 < 180000)
            date = "2个月前"
        else
            date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(Date(java.lang.Long.valueOf(time)!!))
        return date
    }


    private val zodiacArr = arrayOf("猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊")

    private val constellationArr = arrayOf("水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座")

    private val constellationEdgeDay = intArrayOf(20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22)


    /**
     * 根据日期获取生肖

     * @return string
     */
    fun getZodica(date: Date): String {
        val cal = Calendar.getInstance()
        cal.time = date
        return zodiacArr[cal.get(Calendar.YEAR) % 12]
    }

    /**
     * 根据日期获取星座

     * @return string
     */
    fun getConstellation(date: Date?): String {
        if (date == null) {
            return ""
        }
        val cal = Calendar.getInstance()
        cal.time = date
        var month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        if (day < constellationEdgeDay[month]) {
            month -= 1
        }
        if (month >= 0) {
            return constellationArr[month]
        }
        // default to return 魔羯
        return constellationArr[11]
    }

    val localTime: String
        get() = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())


    /**
     * 使用用户格式提取字符串日期

     * @param strDate 日期字符串
     * *
     * @param pattern 日期格式
     * *
     * @return
     */
    fun parse(strDate: String, pattern: String): Date? {

        if (StringUtils.isEmpty(strDate)) {
            return null
        }
        try {
            val df = SimpleDateFormat(pattern, Locale.getDefault())
            return df.parse(strDate)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    /**
     * 使用用户格式格式化日期

     * @param date    日期
     * *
     * @param pattern 日期格式
     * *
     * @return
     */

    fun format(date: Date?, pattern: String): String {
        var returnValue = ""
        if (date != null) {
            val df = SimpleDateFormat(pattern, Locale.getDefault())
            returnValue = df.format(date)
        }
        return returnValue
    }

    /**
     * 依照年限 进行时间的偏移
     * @param amount
     * *
     * @return
     */
    fun getAmountTime(amount: Int): String {
        val calendar = Calendar.getInstance()
        var date = Date(System.currentTimeMillis())
        calendar.time = date
        calendar.add(Calendar.YEAR, amount)
        date = calendar.time
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return df.format(date)
    }
}