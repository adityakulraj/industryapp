package aarnav100.developer.iitd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Work extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        int pic = getIntent().getIntExtra("pic",-1);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        switch (pic){
            case 1:iv.setImageResource(R.drawable.worka);
                break;
            case 2:iv.setImageResource(R.drawable.machinea);
                break;
        }
    }
}
