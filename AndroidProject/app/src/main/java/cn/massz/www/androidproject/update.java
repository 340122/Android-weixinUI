package cn.massz.www.androidproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class update extends AppCompatActivity {
    private Button btn;
    private EditText et1;
    private EditText et2;
    private ImageView img;
    private int icons;
    private String data;
    private String bookString;
    private String name;
    private int pos;
    private Bitmap bitmap;
    private Button btn2;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
         btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
         et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        img = (ImageView) findViewById(R.id.img);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        icons = bundle.getInt("icons");
         bookString = bundle.getString("bookString");
         name = bundle.getString("name");
         pos = intent.getIntExtra("position",0);
        et1.setText(name);
        et2.setText(bookString);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(update.this,home_page.class);
                Bundle bundle = new Bundle();
                String  text1 = et1.getText().toString();
                String text2 =  et2.getText().toString();
                bundle.putString("text1",text1);
                bundle.putString("text2",text2);
                it.putExtras(bundle);


                /*it.putExtra("text2",text2);*/
                startActivity(it);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    /*private void editData() {
        // TODO: 2019/4/30 修改数据

        Intent result = new Intent();
        Bundle authorBundle = new Bundle();
        authorBundle.putInt("icons", icons);
        authorBundle.putString("bookString", bookString);
        authorBundle.putString("data", data);
        authorBundle.putString("name", name);
        result.putExtra("authorBundle", authorBundle);

        result.putExtra("position", pos);
        setResult(0, result);

       finish();
    */
}



