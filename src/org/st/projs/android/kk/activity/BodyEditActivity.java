package org.st.projs.android.kk.activity;

import org.st.projs.android.kk.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BodyEditActivity extends Activity{

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.body_edit);
		
		// register
		Button btn_body_edit = (Button)findViewById(R.id.btn_body_edit);
		btn_body_edit.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
				// TEST
			}
		});

	}
	
}
