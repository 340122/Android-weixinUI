package cn.massz.www.androidproject;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
 
/**
 * <p>Title:PopWindow</p>
 * <p>Description: popupWindow
 * @author
 * @date
 */
public class PopWindow extends PopupWindow{
	private View conentView;
	public PopWindow(final Activity context){
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.popup_window, null);
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		this.setContentView(conentView);
		this.setWidth(w / 2 + 30);
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		this.update();
		//透明色
		ColorDrawable dw = new ColorDrawable(0000000000);
		this.setBackgroundDrawable(dw);

		conentView.findViewById(R.id.about).setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				//do something you need here
				PopWindow.this.dismiss();
			}
		});
		conentView.findViewById(R.id.ability_logout).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// do something before signing out
				context.finish();
				PopWindow.this.dismiss();
			}
		});
		conentView.findViewById(R.id.settings).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// do something you need here
				PopWindow.this.dismiss();
			}
		});
	}
	
	/**
	 * popupWindow
	 * 
	 * @param parent
	 */
	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 5);
		} else {
			this.dismiss();
		}
	}
}
