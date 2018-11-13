package hxing.com.puncheveryday.punch;

import android.content.Context;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.HashMap;
import java.util.Map;

public class PunchPresenter implements PunchConstract.PunchPresenter{

    private PunchConstract.PunchView mPunchView;
    private Context context;

    public PunchPresenter(Context Ctx,PunchConstract.PunchView punchView) {
        this.context = Ctx;
        this.mPunchView = punchView;
    }

    @Override
    public void getData() {

        int year = mPunchView.getCalendarView().getCurYear();
        int month = mPunchView.getCalendarView().getCurMonth();
        int day = mPunchView.getCalendarView().getCurDay();

        mPunchView.setYearTv(String.valueOf(year));
        mPunchView.setmTextCurrentDay(String.valueOf(day));
        mPunchView.setLunarTv("今日");
        mPunchView.setmTextMonthDay(month + "月" + day +"日");

        Map<String, Calendar> map = new HashMap<>();

        map.put(getSchemeCalendar(year, month, day, 0xFF40db25, "假").toString(),
                getSchemeCalendar(year, month, day, 0xFF40db25, "假"));


        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mPunchView.getCalendarView().setSchemeDate(map);

    }


    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }


}
