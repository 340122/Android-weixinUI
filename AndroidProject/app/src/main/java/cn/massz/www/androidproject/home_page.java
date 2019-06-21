package cn.massz.www.androidproject;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static cn.massz.www.androidproject.R.id.et2;

public class home_page extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup radioGroup;
    private FragmentTransaction transaction;
    private RadioButton rbtn1;
    private RadioButton rbtn2;
    private RadioButton rbtn3;
    private RadioButton rbtn4;
    private List<Author> list;
    private ImageView mores;
    private ListView listView;
    private TextView name;
    private TextView jilu;
    private  ImageView img1;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        mores = (ImageView)findViewById(R.id.mores);
        mores.setOnClickListener(this);
        img1 = (ImageView) findViewById(R.id.img1);

        bitmap= BitmapFactory.decodeResource(getResources(), R.id.img1);

         name = (TextView) findViewById(R.id.textname);
         jilu = (TextView) findViewById(R.id.textbook);
        radioGroup =(RadioGroup) findViewById(R.id.group);
        rbtn1 = (RadioButton)findViewById(R.id.xiaoxi);
        rbtn2 = (RadioButton)findViewById(R.id.tongxun);
        rbtn3 = (RadioButton)findViewById(R.id.faxian);
        rbtn4 = (RadioButton)findViewById(R.id.wo);
        rbtn1.setOnClickListener(this);
        rbtn2.setOnClickListener(this);
        rbtn3.setOnClickListener(this);
        rbtn4.setOnClickListener(this);

        listView=(ListView) findViewById(R.id.listview1);
        list = new ArrayList<Author>();
        list.add(new Author(R.drawable.tu1, "IT招聘技术聊天修仙群", "深圳-Java-大大大：996一直爽","18:20"));
        list.add(new Author(R.drawable.tu2, "微信团队", "登陆操作通知","10:25"));
        list.add(new Author(R.drawable.tu3, "文件传输助手", "[小程序]慕课网收费实战","19/4/29"));
        list.add(new Author(R.drawable.tu11, "平凡的生活", "[图片]","12:20"));
        list.add(new Author(R.drawable.tu4, "张三", "嘿嘿","10:45"));
        list.add(new Author(R.drawable.tu10, "好男人", "哼哼哈嘿","06:20"));
        list.add(new Author(R.drawable.tu5, "王二麻子", "再见","10:20"));
        list.add(new Author(R.drawable.tu6, "不良少年", "菜的抠脚","08:20"));
        list.add(new Author(R.drawable.tu7, "神游", "来年再见","12:12"));
        list.add(new Author(R.drawable.tu8, "蓝天", "白云","01:50"));
        list.add(new Author(R.drawable.tu9, "牲畜", "是的","18:20"));

        MyAdapter myAdapter= new MyAdapter(list,home_page.this);
        listView.setAdapter(myAdapter);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(home_page.this,list.get(arg2).getNameString(), Toast.LENGTH_SHORT).show();
            }
        });*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long arg3) {
                Author author=list.get(position);
                Intent intent=new Intent(home_page.this,update.class);
                int icons = author.getImgIcons();
                String bookString = author.getBookString();
                String name = author.getNameString();

                Bundle bundle = new Bundle();
                bundle.putInt("icons",icons);
                bundle.putString("bookString",bookString);
                bundle.putString("name",name);
                intent.putExtra("bundle",bundle);
                /*intent.putExtra("author", String.valueOf(author));*/
                intent.putExtra("position", position);
                startActivityForResult(intent, 0);


                Intent it = getIntent();
                Bundle bundle1 = it.getExtras();
               String text1 =  bundle1.getString("text1");
                String text2 =  bundle1.getString("text2");
                /*String text1 = it.getStringExtra("text1");
                String text2 = it.getStringExtra("text2");*/
                TextView name1 = (TextView) findViewById(R.id.textname);
                TextView name2 = (TextView) findViewById(R.id.textbook);
                name1.setText(text1);
                name2.setText(text2);
                /*name2.setText(text2);*/
            }
        });
    }
    @Override
    public void onClick(View view) {
            // TODO Auto-generated method stub
        if(view.getId() == R.id.mores){
            PopWindow popWindow = new PopWindow(this);
            popWindow.showPopupWindow(findViewById(R.id.mores));
        }
        ListView listView=(ListView) findViewById(R.id.listview1);
        TextView weixin = (TextView) findViewById(R.id.weixin);
        ImageView mores = (ImageView) findViewById(R.id.mores);
        EditText sousuo = (EditText) findViewById(R.id.sousuo);
        FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (view.getId()) {
                case R.id.xiaoxi:
                    listView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    weixin.setVisibility(View.VISIBLE);
                    mores.setVisibility(View.VISIBLE);
                    sousuo.setVisibility(View.VISIBLE);
                    transaction.replace(R.id.lin, new Fragement1());
                    break;
                case R.id.tongxun:
                    listView.setVisibility(View.GONE);
                    transaction.replace(R.id.lin, new Fragement2());
                    break;
                case R.id.faxian:
                    listView.setVisibility(View.GONE);
                    transaction.replace(R.id.lin, new Fragement3());
                    break;
                default:
                    listView.setVisibility(View.GONE);

                    transaction.replace(R.id.lin, new Fragement4());
                    break;
            }
            transaction.commit();
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (requestCode == 0 && resultCode == 0) {
            if (result == null) {
                return;
            }

            Bundle authorBundle = result.getBundleExtra("authorBundle");
            int icons = authorBundle.getInt("icons");
            String data = authorBundle.getString("data");
            String BookString = authorBundle.getString("bookString");
            String name = authorBundle.getString("name");

            int pos = result.getIntExtra("position", 0);

            //todo 更新你的数据
        }
    }*/
}
