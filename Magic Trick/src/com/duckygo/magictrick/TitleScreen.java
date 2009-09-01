package com.duckygo.magictrick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TitleScreen extends Activity implements OnClickListener {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        
        Button button = (Button)findViewById(R.id.Button01);
        
        button.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.Button01) {
			Intent intent = new Intent(this, MagicScreen.class);
	       	intent.putExtra("stage", 0);
	       	intent.putExtra("card", 'c');

			startActivity(intent);
		}
		
	}
    
    
}