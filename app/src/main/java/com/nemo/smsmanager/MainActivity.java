package com.nemo.smsmanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendManager = (Button)findViewById(R.id.sendManager);
        sendManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendManager();
            }
        });

        Button sendIntent = (Button)findViewById(R.id.sendIntent);
        sendIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendIntent();
            }
        });
    }

    private void sendIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra("address", new String("0123456789"));
        intent.putExtra("sms_body" , "Test SMS to Angilla");
        intent.setData(Uri.parse("smsto:"));
        intent.setType("vnd.android-dir/mms-sms");
        try {
            startActivity(intent);
        }catch (Exception  e){

        }
    }

    private void sendManager() {

        String phoneNum = "0123456789";
        String textSms  = "hi";

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNum, null, textSms, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
