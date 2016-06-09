package me.memorytalk.doitmission01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void onImageButton1Clicked(View v) {
        imageView1.setImageResource(R.drawable.picture01);
        imageView2.setImageBitmap(null);
    }

    public void onImageButton2Clicked(View v) {
        imageView1.setImageBitmap(null);
        imageView2.setImageResource(R.drawable.picture01);
    }
}
