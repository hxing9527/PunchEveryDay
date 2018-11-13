package hxing.com.puncheveryday.punch;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.Map;

import hxing.com.puncheveryday.base.BasePresenter;
import hxing.com.puncheveryday.base.BaseView;

public interface PunchConstract {

    interface PunchView extends BaseView<PunchPresenter>{
        void setYearTv(String str);
        void setLunarTv(String str);
        void setmTextCurrentDay(String str);
        void setmTextMonthDay(String str);
        void setmCalendarView( Map<String, Calendar> map );
        CalendarView getCalendarView();
    }

    interface PunchPresenter extends BasePresenter{
        void getData();
    }
}
