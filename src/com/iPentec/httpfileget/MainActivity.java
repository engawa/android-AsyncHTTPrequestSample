package com.iPentec.httpfileget;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

  public void button1_click(View view){
	    String url = "https://www.google.co.jp/";
	    AsyncHttpRequest task = new AsyncHttpRequest(this);
	    task.owner = this;
	    task.execute(url);
	  }
}
