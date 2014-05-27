package com.heineck.mydynamicfragmentssample;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BodyActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		// check orientation to avoid crash (this activity is not necessary in landscape)
		if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		} else 
			setContentView(R.layout.activity_body);
	      
		// show body content as requested in Intent extra
	    Bundle extras = getIntent().getExtras();
	    if (extras != null) {
	    	// get data from Intent extra
	        String s = extras.getString("value");
        	// get body fragment
	        BodyFragment fragment = (BodyFragment) getSupportFragmentManager().findFragmentById(R.id.bodyFragment);
	        // if fragment is not null and in layout set text
	        if ((fragment!=null)&&fragment.isInLayout()) {
	        	fragment.setText(s);
	        }
	      }
	}
}
