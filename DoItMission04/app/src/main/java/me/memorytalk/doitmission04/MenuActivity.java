package me.memorytalk.doitmission04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button button2;
    Button button3;
    Button button4;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
    }

    public void onButton2Clicked(View v) {
        Log.d(GlobalConstants.TAG, "onButton2Clicked : " + button2.getText().toString());

        intent = new Intent(getApplicationContext(), CustomerActivity.class);
        intent.putExtra(GlobalConstants.RESPONSE_MENU_NAME, button2.getText().toString());
        startActivityForResult(intent, GlobalConstants.REQUEST_CODE_MENU);
    }

    public void onButton3Clicked(View v) {
        Log.d(GlobalConstants.TAG, "onButton3Clicked : " + button3.getText().toString());

        intent = new Intent(getApplicationContext(), SalesActivity.class);
        intent.putExtra(GlobalConstants.RESPONSE_MENU_NAME, button3.getText().toString());
        startActivityForResult(intent, GlobalConstants.REQUEST_CODE_MENU);
    }

    public void onButton4Clicked(View v) {
        Log.d(GlobalConstants.TAG, "onButton4Clicked : " + button4.getText().toString());

        intent = new Intent(getApplicationContext(), GoodsActivity.class);
        intent.putExtra(GlobalConstants.RESPONSE_MENU_NAME, button4.getText().toString());
        startActivityForResult(intent, GlobalConstants.REQUEST_CODE_MENU);
    }

    public void onButton8Clicked(View v) {
        finish();
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
