package me.memorytalk.doitmission04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }

    public void onButton7Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra(GlobalConstants.RESPONSE_MENU_NAME, GlobalConstants.RESPONSE_MENU_GOODS);
        setResult(RESULT_OK, intent);
        finish();
    }
}
