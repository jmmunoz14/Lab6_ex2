package com.example.kcjm_comp304sec005_lab6_ex2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServicesActivity extends AppCompatActivity {
    private TextView textView;

    private TextView textViewInt;
    //replace with your package name
    public static final String INFO_INTENT =
            "com.example.kcjm.comp304sec005_lab6_ex2.INFO_UPDATE";

    public static final String INFO_INTENT_INT =
            "com.example.kcjm.comp304sec005_lab6_ex2.INFO_UPDATE_INT";

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(SimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra(INFO_INTENT);
                textView.setText(info);
            }

            if(action.equals(SimpleService.INFO_INTENT_INT)){
                int infoInt = intent.getIntExtra(INFO_INTENT_INT, 0);
                textViewInt.setText(String.valueOf(infoInt));

            }
        }
    };

    public void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));
        registerReceiver(receiver, new IntentFilter(INFO_INTENT_INT));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = (TextView) findViewById(R.id.textView);
        textViewInt = findViewById(R.id.textViewInt);
    }

    //
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                SimpleService.class));
    }

}