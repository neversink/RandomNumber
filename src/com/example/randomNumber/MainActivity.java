package com.example.randomNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.example.testproject.R;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
	
public class MainActivity extends ActionBarActivity {

	EditText et1;
	EditText et2;
	TextView tv1;
	TextView tv2;
	int random;
	int randomOld;
	Bundle extras = new Bundle();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView4);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void createRandomNumber(View view) {
    	
    	if(!TextUtils.isEmpty(et1.getText().toString()) && !TextUtils.isEmpty(et2.getText().toString())) {
    		int value;
    		int min = Integer.parseInt(et1.getText().toString());
        	int max = Integer.parseInt(et2.getText().toString());
        	if(min <= max) {
	        	Random r = new Random();
	        	random = r.nextInt(max+1);
	        	while(random < min) {
	        		random = r.nextInt(max+1);
	        	}
	        	tv1.setText(String.valueOf(random)); 
	        	tv2.setText(String.valueOf(randomOld)); 
	        	randomOld = random;
	        	if(extras.get(String.valueOf(random)) != null) {
		        	value = extras.getInt(String.valueOf(random));
	        	} else {
	        		value = 0;
	        	}
	        	extras.putInt(String.valueOf(random), ++value);
        	} else Toast.makeText(this, "最小数不能大于最大数!", 0).show();
    	} else Toast.makeText(this, "最小数和最大数不能为空!", 0).show();
    }
    
    public void gotoCount(View view) {
    	Intent intent = new Intent();
    	intent.setClass(this, Count.class);
    	intent.putExtras(extras);
    	startActivity(intent);
    
    }
    
}
