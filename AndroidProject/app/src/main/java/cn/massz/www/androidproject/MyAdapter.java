package cn.massz.www.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter  extends BaseAdapter{
	private List<Author> mList;
	private Context mycontext;
	
	

	public MyAdapter(List<Author> mList, Context mycontext) {
		super();
		this.mList = mList;
		this.mycontext = mycontext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup arg2) {

		ViewHolder holder;
		if(convertview==null){
			convertview=LayoutInflater.from(mycontext).inflate(R.layout.item, null);
			holder=new ViewHolder();
			holder.imgView=(ImageView) convertview.findViewById(R.id.img1);
			holder.textname=(TextView) convertview.findViewById(R.id.textname);
			holder.textbook=(TextView) convertview.findViewById(R.id.textbook);
			holder.date=(TextView) convertview.findViewById(R.id.datetime);
			convertview.setTag(holder);
		}else{
			holder=(ViewHolder) convertview.getTag();
		}

		
		holder.imgView.setImageResource(mList.get(position).imgIcons);
		holder.textname.setText(mList.get(position).nameString);
		holder.textbook.setText(mList.get(position).bookString);
		holder.date.setText(mList.get(position).data);
		
		return convertview;
	}
	
	class ViewHolder{
		ImageView imgView;
		TextView textname;
		TextView textbook;
		TextView date;
		
	}

}
