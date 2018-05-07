package rashmi.umkc.edu.insertcalendarevent;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.insertcalendareventintent.R;



public class MainActivity extends Activity {
    TextView date_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the items from ui
        date_display = (TextView) findViewById(R.id.DisplayDate);
        CalendarView cal = (CalendarView) findViewById(R.id.Cal);

        //display the current date
        Date current = new Date(cal.getDate()); // get from cal api
        SimpleDateFormat format = new SimpleDateFormat("M/d/Y"); //set up formatting
        date_display.setText("Date: " + format.format(current.getTime())); // set text and format it
        //detect when date is selected on calendar
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                //set text to the selected date.
                date_display.setText("Date: " + String.valueOf(month+1) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}