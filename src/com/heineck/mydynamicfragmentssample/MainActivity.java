package com.heineck.mydynamicfragmentssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity  implements MenuFragment.OnMenufragListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// MenuFragment listener
	@Override
	public void onMenufrag(String s) {
	      
		// get body fragment (native method is getFragmentManager)
		BodyFragment fragment = (BodyFragment) getSupportFragmentManager().findFragmentById(R.id.bodyFragment);
		      
		// if fragment is not null and in layout, set text, else launch BodyActivity
		if ((fragment!=null)&&fragment.isInLayout()) {
			fragment.setText(s);
		} else {
			Intent intent = new Intent(this,BodyActivity.class);
		    intent.putExtra("value",s);
		    startActivity(intent);
		}
	      
	}
}
