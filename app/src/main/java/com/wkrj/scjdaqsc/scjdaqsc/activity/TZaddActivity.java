package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.camera.PhotoUtils;
import com.wkrj.scjdaqsc.scjdaqsc.camera.ToastUtils;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmName;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmType;
import com.wkrj.scjdaqsc.scjdaqsc.model.DuchaModel;
import com.wkrj.scjdaqsc.scjdaqsc.util.GetPhotoUrl;
import com.wkrj.scjdaqsc.scjdaqsc.view.BottomMenu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TZaddActivity extends BaseActivity {
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri;
    private Uri imageUri;
    private Uri cropImageUri;

    private Spinner sp_tzadd_type;
    private TextView et_tzadd_time,tv_tzadd_zgsj;
    private EditText et_tzadd_address,et_tzadd_name,et_tzadd_tel
            ,et_tzadd_czwt,et_tzadd_zgcs,et_tzadd_fcdw,et_tzadd_remark;
    private AutoCompleteTextView atv_tzadd_firmname;
    private Button btn_tzadd_tj;
    private LinearLayout ll_tzadd_back;
    private ImageView iv1,iv2,iv3;
    private ArrayList<FirmType> types;
    private DuchaModel model;
    private List<String> str1 = new ArrayList<>();
    private List<String> StrName = new ArrayList<>();
    private BottomMenu menuWindow;
    private List<Bitmap> images = new ArrayList<>();
    private List<String> urls = new ArrayList<>();
    private long typeId;
    private Bitmap img;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ArrayAdapter<String> arr_adapter1 = new ArrayAdapter<String>(TZaddActivity.this, android.R.layout.simple_spinner_dropdown_item, str1);
                    //设置样式
                    arr_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_tzadd_type.setAdapter(arr_adapter1);
                    sp_tzadd_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            typeId = types.get(position).getType_id();
                        }
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                    break;
                case 2:
                    Toast.makeText(TZaddActivity.this,"上传完成",Toast.LENGTH_SHORT).show();
                    et_tzadd_address.setText("");
                    et_tzadd_name.setText("");
                    et_tzadd_tel.setText("");
                    et_tzadd_czwt.setText("");
                    et_tzadd_zgcs.setText("");
                    et_tzadd_fcdw.setText("");
                    et_tzadd_remark.setText("");
                    atv_tzadd_firmname.setText("");
                    et_tzadd_time.setText("");
                    tv_tzadd_zgsj.setText("");
                    images.clear();
                    urls.clear();
                    iv1.setImageResource(R.drawable.iamge);
                    iv2.setImageDrawable(null);
                    iv3.setImageDrawable(null);
                    break;
                case 3:
                    Toast.makeText(TZaddActivity.this,"上传失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private long firmId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tzadd);
        setView();
        setAdapter();
        setListener();
    }

    private void setAdapter(){
        // 创建一个ArrayAdapter封装数组
        final List<FirmName> names = App.getFirmName();
        for (int i =0;i<names.size();i++){
            String name = names.get(i).getEnterprise_name();
            StrName.add(name);
        }
        ArrayAdapter<String> av = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, StrName);
        atv_tzadd_firmname.setAdapter(av);
        atv_tzadd_firmname.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0;i<names.size();i++){
                    if(names.get(i).getEnterprise_name().equals(atv_tzadd_firmname.getText().toString())){
                        firmId =  names.get(i).getEnterprise_id();
                    }
                }
            }
        });
    }
    private void setListener() {
        model = new DuchaModel();
        model.firmType(new ICallBack() {
            @Override
            public void succeed(Object object) {
                types = (ArrayList<FirmType>) object;
                for (int i=0;i<types.size();i++){
                    str1.add(types.get(i).getType_name());
                }
                Message message =Message.obtain();
                message.what = 1;
                handler.sendMessage(message);
            }
            public void error(Object object) {
            }
        });
        ll_tzadd_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.size()==0) {
                    menuWindow = new BottomMenu(TZaddActivity.this, clickListener);
                    menuWindow.show();
                    hintKbTwo();
                }else {
                    AlertDialog.Builder builder  = new AlertDialog.Builder(TZaddActivity.this);
                    builder.setTitle("删除" ) ;
                    builder.setMessage("是否删除该图片" ) ;
                    builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            remove(0);
                        }
                    });
                    builder.show();
                }
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.size()==1) {
                    menuWindow = new BottomMenu(TZaddActivity.this, clickListener);
                    menuWindow.show();
                    hintKbTwo();
                }else {
                    AlertDialog.Builder builder  = new AlertDialog.Builder(TZaddActivity.this);
                    builder.setTitle("删除" ) ;
                    builder.setMessage("是否删除该图片" ) ;
                    builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            remove(1);
                        }
                    });
                    builder.show();
                }
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(images.size()==2) {
                    menuWindow = new BottomMenu(TZaddActivity.this, clickListener);
                    menuWindow.show();
                    hintKbTwo();
                }else {
                    AlertDialog.Builder builder  = new AlertDialog.Builder(TZaddActivity.this);
                    builder.setTitle("删除" ) ;
                    builder.setMessage("是否删除该图片" ) ;
                    builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            remove(2);
                        }
                    });
                    builder.show();
                }
            }
        });
        et_tzadd_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(new ICallBack() {
                    public void succeed(Object object) {
                        String s = (String) object;
                        et_tzadd_time.setText(s);
                    }
                    public void error(Object object) {
                    }
                });
            }
        });
        tv_tzadd_zgsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(new ICallBack() {
                    public void succeed(Object object) {
                        String s = (String) object;
                        tv_tzadd_zgsj.setText(s);
                    }
                    public void error(Object object) {
                    }
                });
            }
        });
        btn_tzadd_tj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }
    /**
     * 删除图片
     * @param i
     */
    private void remove(int i){
        switch (i){
            case 0:
                try {
                    images.remove(0);
                    urls.remove(0);
                    judge();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    images.remove(1);
                    urls.remove(1);
                    judge();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    images.remove(2);
                    urls.remove(2);
                    judge();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * 刷新图片
     */
    private void judge(){
        iv1.setImageDrawable(null);
        iv2.setImageDrawable(null);
        iv3.setImageDrawable(null);
        if(images.size()==0){
            iv1.setImageResource(R.drawable.iamge);
        }
        if (images.size()==1){
            iv1.setImageBitmap(images.get(0));
            iv2.setImageResource(R.drawable.iamge);
        }
        if (images.size()==2){
            iv1.setImageBitmap(images.get(0));
            iv2.setImageBitmap(images.get(1));
            iv3.setImageResource(R.drawable.iamge);
        }
        if (images.size()==3){
            iv1.setImageBitmap(images.get(0));
            iv2.setImageBitmap(images.get(1));
            iv3.setImageBitmap(images.get(2));
        }
    }
    //此方法只是关闭软键盘
    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    /**
     * 显示日期对话框
     */
    private void showDateDialog(final ICallBack callBack) {
        new android.app.DatePickerDialog(TZaddActivity.this, new android.app.DatePickerDialog.OnDateSetListener() {
            public String day;
            public String month;
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear+1;
                if(monthOfYear<10){
                    month = "0" + monthOfYear;
                }else {
                    month = monthOfYear+"";
                }
                if(dayOfMonth<10){
                    day = "0" + dayOfMonth;
                }else {
                    day =dayOfMonth+"";
                }
                callBack.succeed(year+"-"+month+"-"+day);
            }
        },2017,1,2).show();
    }
    /**
     * 提交
     */
    private void submit() {
        SharedPreferences preferences = this.getSharedPreferences("wwj", Context.MODE_PRIVATE);
        long user_id = preferences.getLong("user_id", 0);
        String addtime = et_tzadd_time.getText().toString();
        String address = et_tzadd_address.getText().toString();
        String name = et_tzadd_name.getText().toString();
        String tel = et_tzadd_tel.getText().toString();
        String zgsj = tv_tzadd_zgsj.getText().toString();
        String czwt = et_tzadd_czwt.getText().toString();
        String zgcs = et_tzadd_zgcs.getText().toString();
        String fcdw = et_tzadd_fcdw.getText().toString();
        String remark = et_tzadd_remark.getText().toString();
        if(addtime.equals("")||address.equals("")||name.equals("")||tel.equals("")
                ||czwt.equals("")||zgcs.equals("")||fcdw.equals("")||remark.equals("")){
            Toast.makeText(this,"数据不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        model.addDucha(user_id,typeId, addtime, firmId, address, name, tel, czwt, zgcs,zgsj, fcdw, remark, urls,new ICallBack() {
            @Override
            public void succeed(Object object) {
                Message message =Message.obtain();
                message.what = 2;
                handler.sendMessage(message);
            }
            @Override
            public void error(Object object) {
                Message message =Message.obtain();
                message.what = 3;
                handler.sendMessage(message);
            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener(){

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    autoObtainCameraPermission();
                    break;
                case R.id.btn2:
                    autoObtainStoragePermission();
                    break;
            }
        }
    };

    /**
     * 自动获取相机权限
     */
    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    imageUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST_CODE: {//调用系统相机申请拍照权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShort(this, "请允许打开相机！！");
                }
                break;
            }
            case STORAGE_PERMISSIONS_REQUEST_CODE://调用系统相册申请Sdcard权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtils.showShort(this, "请允许打操作SDCard！！");
                }
                break;
        }
    }

    private static final int output_X = 480;
    private static final int output_Y = 480;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_CAMERA_REQUEST://拍照完成回调
                    fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo"+main()+".jpg");
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    break;
                case CODE_GALLERY_REQUEST://访问相册完成回调
                    if (hasSdcard()) {
                        fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo"+main()+".jpg");
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            newUri = FileProvider.getUriForFile(this, "com.xixi.fileprovider", new File(newUri.getPath()));
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);

                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    String u = fileCropUri.toString();

                    img = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if(images.size()<4){
                        images.add(img);
                        urls.add(u);
                    }
                    if(images.size()==1) {
                        iv1.setImageBitmap(img);
                        iv2.setImageResource(R.drawable.iamge);
                    }else if(images.size()==2){
                        iv2.setImageBitmap(img);
                        iv3.setImageResource(R.drawable.iamge);
                    }else if(images.size()==3){
                        iv3.setImageBitmap(img);
                    }
                    break;
            }
        }
    }
    /**
     * 随机数
     */
    public static int main() {
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            return r.nextInt();
        }
        return 0;
    }
    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }
    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    private void setView() {
        sp_tzadd_type = (Spinner) findViewById(R.id.sp_tzadd_type);
        et_tzadd_time = (TextView) findViewById(R.id.et_tzadd_time);
        atv_tzadd_firmname = (AutoCompleteTextView) findViewById(R.id.atv_tzadd_firmname);
        et_tzadd_address = (EditText) findViewById(R.id.et_tzadd_address);
        et_tzadd_name = (EditText) findViewById(R.id.et_tzadd_name);
        et_tzadd_tel = (EditText) findViewById(R.id.et_tzadd_tel);
        et_tzadd_czwt = (EditText) findViewById(R.id.et_tzadd_czwt);
        et_tzadd_zgcs = (EditText) findViewById(R.id.et_tzadd_zgcs);
        et_tzadd_fcdw = (EditText) findViewById(R.id.et_tzadd_fcdw);
        et_tzadd_remark = (EditText) findViewById(R.id.et_tzadd_remark);
        tv_tzadd_zgsj = (TextView) findViewById(R.id.et_tzadd_zgsj);

        iv1 = (ImageView) findViewById(R.id.iv_tzadd_1);
        iv2 = (ImageView) findViewById(R.id.iv_tzadd_2);
        iv3 = (ImageView) findViewById(R.id.iv_tzadd_3);
        btn_tzadd_tj = (Button) findViewById(R.id.btn_tzadd_tj);

        ll_tzadd_back = (LinearLayout) findViewById(R.id.ll_tzadd_back);
    }
}
