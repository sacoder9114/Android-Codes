package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{
	
 Button start,startfor;
 EditText sendEt;
 TextView gotAnswer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}
	private void initialize() {
		// TODO Auto-generated method stub
	start = (Button) findViewById(R.id.bSA);	
	startfor = (Button) findViewById(R.id.bSAFR);
	sendEt = (EditText) findViewById(R.id.etSend);
	gotAnswer = (TextView) findViewById(R.id.tvGot);
	start.setOnClickListener(this);
	startfor.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSA :
		{
			String bread = sendEt.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("Key", bread);
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		}
		case R.id.bSAFR:
			
		{	
			Intent i = new Intent(Data.this, OpenedClass.class);
			startActivityForResult(i,0);
			break;
		}
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK)
		{
			Bundle basket = data.getExtras();
			String s = basket.getString("answer");
			gotAnswer.setText(s);
		}
	}
	

}
