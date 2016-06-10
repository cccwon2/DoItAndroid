package me.memorytalk.doitmission03;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {

        String username = editText.getText().toString().trim();
        String password = editText2.getText().toString().trim();

        if (username.length() == 0) {
            Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
            editText.requestFocus();

            inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return;
        }

        if (password.length() == 0) {
            Toast.makeText(getApplicationContext(), "패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
            editText2.requestFocus();

            inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return;
        }

        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }

        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);

        startActivityForResult(intent, GlobalConstants.REQUEST_CODE_MENU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(GlobalConstants.TAG, "requestCode : " + requestCode);
        Log.d(GlobalConstants.TAG, "resultCode : " + resultCode);
        Log.d(GlobalConstants.TAG, "data : " + data.getExtras().getString(GlobalConstants.RESPONSE_MENU_NAME));

        if (requestCode == GlobalConstants.REQUEST_CODE_MENU) {
            if (resultCode == RESULT_OK) {
                String menuName = data.getExtras().getString(GlobalConstants.RESPONSE_MENU_NAME);
                Toast.makeText(getApplicationContext(), menuName, Toast.LENGTH_LONG).show();
            }
        }
    }
}
