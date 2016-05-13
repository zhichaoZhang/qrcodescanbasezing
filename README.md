# qrcodescanbasezing

### 一个基于Zxing的二维码扫描测试工程

#### 使用：compile 'com.zzc.qrcodescan.zxing:qrcodescan:1.0.1'

--
启动扫码页面
startActivityForResult(CaptureActivity.getCallingIntent(this), 1);

接收扫码结果

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
--
