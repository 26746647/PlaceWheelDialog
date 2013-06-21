package com.view.WheelView;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;

public class WheelViewActivity extends Activity {
    
    private WheelView clockadd_hour = null;

    private WheelView clockadd_minutes = null;

    private WheelView am_pm = null;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findView();
        initiWheelView();
       
       
    }

    private void findView()
    {
        am_pm = (WheelView) findViewById(R.id.am_pm);
        clockadd_hour = (WheelView) findViewById(R.id.clockadd_hour);
        clockadd_minutes = (WheelView) findViewById(R.id.clockadd_minutes);
    }
    
    private void initiWheelView()
    {
        String[] mins = getResources().getStringArray(
                R.array.clockadd_mins_array);
        String[] am_pm_data = getResources().getStringArray(R.array.am_pm);

        String[] hour = getResources().getStringArray(R.array.clockadd_hour_array);

        clockadd_minutes.setAdapter(new ArrayWheelAdapter<String>(mins));
        clockadd_minutes.setVisibleItems(7);
        clockadd_minutes.setCyclic(true);
        clockadd_minutes.setCurrentItem(new Date().getMinutes());

        clockadd_hour.setAdapter(new ArrayWheelAdapter<String>(hour));
        clockadd_hour.setVisibleItems(7);
        clockadd_hour.setCyclic(true);
        clockadd_hour.setCurrentItem(new Date().getHours());

        am_pm.setAdapter(new ArrayWheelAdapter<String>(am_pm_data));
        am_pm.setVisibleItems(7);
        am_pm.setCyclic(false);
        am_pm.setCurrentItem(Calendar.getInstance().get(Calendar.AM_PM));
        String time="目前时间是："+am_pm_data[am_pm.getCurrentItem()]+" "+hour[clockadd_hour.getCurrentItem()]+":"+mins[clockadd_minutes.getCurrentItem()];
        System.out.println("time"+time);
}
    
}