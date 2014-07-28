package com.example.BarcodeScanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void scan(View view) {
        Intent scanIntent = new Intent("com.google.zxing.client.android.SCAN");
        scanIntent.putExtra("SCAN_MODE", "*");
        startActivityForResult(scanIntent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test:", data + "");
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contentId = data.getStringExtra("SCAN_RESULT");
                String format = data.getStringExtra("SCAN_RESULT_FORMAT");
                Log.d("test:", "contentId" + contentId);
                Log.d("test:", "format" + format);
            } else if (resultCode == RESULT_CANCELED) {
                Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            }
        }


    }
}
