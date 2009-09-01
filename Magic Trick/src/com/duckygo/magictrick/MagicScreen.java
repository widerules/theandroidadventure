package com.duckygo.magictrick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MagicScreen extends Activity implements OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int stage = getIntent().getIntExtra("stage", 0);
        char card = getIntent().getCharExtra("card", 'c');
        
        if (stage == 1) { 
        	setContentView(R.layout.card2);
        } else {
        	setContentView(R.layout.card);
        }

        ImageView imageView = (ImageView) findViewById(R.id.ImageView01);
        
        switch(card) {
        case 'c':
        	imageView.setImageResource(R.drawable.c1 + stage);
        	break;
        case 'd':
        	imageView.setImageResource(R.drawable.d1 + stage);
        	break;
        }
        
        Button button = (Button)findViewById(R.id.Button01);
        
        if (stage == 1 && card == 'd') {
        	button.setText("Start Again");
        }
        button.setOnClickListener(this);
    }

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	setResult(RESULT_OK);
    	finish();
    }
    
    
    private void setIntentParams(Intent i, int stage, char card) {
        
       	i.putExtra("stage", (1 - stage));
       	if (stage == 0) {
           	i.putExtra("card", card);
       	} else {
           	i.putExtra("card", card == 'c' ? 'd': 'c');
       	}
    }
    
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.Button01) {
	        int stage = getIntent().getIntExtra("stage", 0);
	        char card = getIntent().getCharExtra("card", 'c');
			
	        if (stage == 1 && card == 'd') {
	        	setResult(RESULT_OK);
	        	finish();
	        } else {
	        	Intent intent = new Intent(this, MagicScreen.class);
	        	setIntentParams(intent, stage, card);
			
	        	startActivityForResult(intent, 1);
	        }
		}
	}
    
    
    
}