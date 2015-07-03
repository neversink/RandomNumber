package com.example.randomNumber;

import java.util.Set;

import com.example.testproject.R;

import android.app.Activity;
import android.graphics.Canvas.VertexMode;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Count extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(android.widget.LinearLayout.VERTICAL);

        Bundle extras = getIntent().getExtras();
        Set<String> keySet = extras.keySet();
        for(String key : keySet) {
            LayoutInflater inflater = getLayoutInflater();
            ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.statistics, null);
            TextView tv1 = (TextView)viewGroup.findViewById(R.id.textView8);
        	TextView tv2 = (TextView)viewGroup.findViewById(R.id.textView9);
        	tv1.setText(key);
        	tv2.setText(extras.get(key).toString());   
        	linear.addView(viewGroup);
        }
        Toast.makeText(this, "hello", 0).show();
        setContentView(linear);
        Log.w("adsf", "dsa");
        Log.w("adsf", "dsa");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
