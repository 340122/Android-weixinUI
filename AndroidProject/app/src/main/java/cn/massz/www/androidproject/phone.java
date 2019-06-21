package cn.massz.www.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class phone extends AppCompatActivity {
    private EditText viewById;
    private Button button1;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        viewById = (EditText) findViewById(R.id.et_ph);
        button1 = (Button) findViewById(R.id.btn_login1);
        ImageView exit = (ImageView) findViewById(R.id.exit);
        spinner = (Spinner) findViewById(R.id.spinner);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.this.viewById.getText() != null && phone.this.viewById.getText().length() == 11){
                    Intent intent = new Intent(phone.this,phone2.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("phone", phone.this.viewById.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(phone.this,"手机号输入有误",Toast.LENGTH_LONG).show();
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("    ");
        list.add("北京");
        list.add("上海");
        list.add("合肥");
        list.add("武汉");
        list.add("南京");
        list.add("深圳");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
