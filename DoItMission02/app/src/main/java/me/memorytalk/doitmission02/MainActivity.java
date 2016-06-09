package me.memorytalk.doitmission02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText editText;
    TextView textView;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged() : " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(String.valueOf(s.length()));
                Log.d(TAG, "onTextChanged() : " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged() : " + s);
            }
        });
    }

    public void onButton1Clicked(View v) {
        toast = Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_LONG);
        toast.show();
    }

    public void onButton2Clicked(View v) {
        if (toast != null) {
            toast.cancel();
        }
    }
}
