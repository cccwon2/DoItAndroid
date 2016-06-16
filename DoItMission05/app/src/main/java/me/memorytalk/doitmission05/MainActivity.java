package me.memorytalk.doitmission05;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText editText;
    EditText editText2;
    Button button;

    DatePickerDialog dialog;
    InputMethodManager inputMethodManager;
    String buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
    }

    public void onButton1Clicked(View v) {
        buttonText = button.getText().toString();
        Log.d(TAG, buttonText);
        int year = Integer.valueOf(buttonText.substring(0, 4));
        String sMonth = buttonText.substring(buttonText.indexOf("년") + 1, buttonText.indexOf("월")).trim();
        int month = Integer.valueOf(sMonth) - 1;
        String sDay = buttonText.substring(buttonText.indexOf("월") + 1, buttonText.indexOf("일")).trim();
        int day = Integer.valueOf(sDay);
        int theme = AlertDialog.THEME_HOLO_LIGHT;
        dialog = new DatePickerDialog(this, theme, listener, year, month, day);
        dialog.show();
    }

    public void onButton2Clicked(View v) {
        String username = editText.getText().toString().trim();
        String userage = editText2.getText().toString().trim();

        if (username.length() == 0) {
            Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            editText.requestFocus();

            inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return;
        }

        if (userage.length() == 0) {
            Toast.makeText(getApplicationContext(), "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
            editText2.requestFocus();

            inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return;
        }

        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }

        String button2Text = username + ", " + userage + ", " + button.getText();
        Toast.makeText(getApplicationContext(), button2Text, Toast.LENGTH_LONG).show();
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            buttonText = year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일";
            Log.d(TAG, buttonText);
            button.setText(buttonText);
        }
    };
}
