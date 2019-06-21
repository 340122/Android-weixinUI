package cn.massz.www.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class phone2 extends AppCompatActivity {
    private TextView textView;
    private EditText psd;
    private final char CUT = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone2);
        textView= (TextView) findViewById(R.id.phone_show);
        Button button2 = (Button) findViewById(R.id.btn_login2);
        psd = (EditText) findViewById(R.id.et_psd);
        ImageView sreturn = (ImageView) findViewById(R.id.sreturn);
        ImageView mnore = (ImageView) findViewById(R.id.more);
        Intent it = getIntent();
        Bundle bundle=it.getExtras();
        String phone = bundle.getString("phone");
/*        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone.length(); i++) {//添加分割符
            if (i != 3 && i != 8 && phone.charAt(i) == CUT) {
                continue;
            } else {
                sb.append(phone.charAt(i));
                if ((sb.length() == 4 || sb.length() == 9)
                        && sb.charAt(sb.length() - 1) != CUT) {
                    sb.insert(sb.length() - 1, CUT);
                }
            }
        }*/
        textView.setText(phone);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (psd.getText().toString().trim().equals("yl123")){
                    Intent intent = new Intent(phone2.this,home_page.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("phone", psd.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(phone2.this,"密码输入错误",Toast.LENGTH_LONG).show();
                }
            }
        });
        sreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
