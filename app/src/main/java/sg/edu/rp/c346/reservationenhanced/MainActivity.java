package sg.edu.rp.c346.reservationenhanced;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etSize;
    EditText etDay;
    EditText etTime;
    CheckBox cbSmoke;

    Button btnReserve;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextSize);
        etDay = findViewById(R.id.editTextDay);
        etTime = findViewById(R.id.editTextTime);

        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        cbSmoke = findViewById(R.id.checkBoxSmoke);



        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        etDay.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity. this, myTimeListener, hour , min ,true);

                myTimeDialog.show();

            }
        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity. this);
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage("New Reservation" +
                        "Name: ");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", null);

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
    }
}
