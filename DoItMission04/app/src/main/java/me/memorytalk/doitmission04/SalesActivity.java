package me.memorytalk.doitmission04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
    }

    public void onButton6Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra(GlobalConstants.RESPONSE_MENU_NAME, GlobalConstants.RESPONSE_MENU_SALES);
        setResult(RESULT_OK, intent);
        finish();
    }
}
