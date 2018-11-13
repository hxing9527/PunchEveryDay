package hxing.com.puncheveryday.punch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hxing.com.puncheveryday.R;
import hxing.com.puncheveryday.adapter.PunchRecyclerViewListAdapter;
import hxing.com.puncheveryday.base.BaseFragment;
import hxing.com.puncheveryday.base.BaseRecyclerAdapter;
import hxing.com.puncheveryday.bean.Punch;

public class PunchFragment extends BaseFragment implements PunchConstract.PunchView,CalendarView.OnYearChangeListener,CalendarView.OnCalendarSelectListener {

    CalendarView mCalendarView;
    TextView mTextYear,mTextLunar,mTextMonthDay,mTextCurrentDay;
    PunchPresenter punchPresenter;
    RecyclerView recyclerView;

    public static PunchFragment newInstance(){
        return new PunchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         View view = inflater.inflate(R.layout.frag_punch,container,false);
         mCalendarView = (CalendarView) view.findViewById(R.id.calendarView);
         mTextYear = (TextView) view.findViewById(R.id.tv_year);
         mTextLunar = (TextView) view.findViewById(R.id.tv_lunar);
         mTextMonthDay = view.findViewById(R.id.tv_month_day);
         mTextCurrentDay = view.findViewById(R.id.tv_current_day);
         recyclerView = view.findViewById(R.id.recyclerView);
         view.findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
         });
         mCalendarView.setOnCalendarSelectListener(this);
         mCalendarView.setOnYearChangeListener(this);
         punchPresenter = new PunchPresenter(getContext(),this);
         punchPresenter.getData();
         init();
         return view;
    }

    private void init(){
        List<Punch> data = new ArrayList<>();
        for (int i= 0;i<=20;i++){
            Punch punch = new Punch();
            punch.setDate_build("2018-11-13 8:30");
            punch.setDate_warn("15:00");
            punch.setId(i);
            punch.setTitle("日常打卡" + i + " 条");
            punch.setStatus("0");
            data.add(punch);
        }

       PunchRecyclerViewListAdapter adapter = new PunchRecyclerViewListAdapter(getActivity(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, long itemId) {
                Toast.makeText(getContext(),"aa" + position,Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void setYearTv(String str) {
        mTextYear.setText(str);
    }

    @Override
    public void setLunarTv(String str) {
        mTextLunar.setText(str);
    }

    @Override
    public void setmTextCurrentDay(String str) {
        mTextCurrentDay.setText(str);
    }

    @Override
    public void setmTextMonthDay(String str) {
        mTextMonthDay.setText(str);
    }

    @Override
    public void setmCalendarView(Map<String, Calendar> map) {
        mCalendarView.setSchemeDate(map);
    }

    @Override
    public CalendarView getCalendarView() {
        return mCalendarView;
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {

        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());

    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }
}
