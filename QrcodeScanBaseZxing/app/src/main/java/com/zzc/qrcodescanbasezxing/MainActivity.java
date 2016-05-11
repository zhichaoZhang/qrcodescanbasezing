package com.zzc.qrcodescanbasezxing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zzc.qrcodescan.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private final static int CODE_QRCODE_SACAN = 1;
    TextView tvQrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQrcode = (TextView)findViewById(R.id.tv_qrcode_result);
    }

    public void onClickScanQrcodeBtn(View view) {
        startActivityForResult(CaptureActivity.getCallingIntent(this), CODE_QRCODE_SACAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if(requestCode == CODE_QRCODE_SACAN) {
                if(data != null) {
                    String qrcode = data.getStringExtra(CaptureActivity.RESULT_KEY_QRCODE);
                    if(!TextUtils.isEmpty(qrcode)) {
                        tvQrcode.setText(qrcode);
                    }
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }
}
