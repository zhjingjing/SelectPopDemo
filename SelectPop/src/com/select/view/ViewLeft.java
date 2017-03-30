package com.select.view;


import com.select.activity.R;
import com.select.adapter.TextAdapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class ViewLeft extends RelativeLayout implements ViewBaseAction{

	private ListView mListView;
	   private final String[] items = new String[] { "1km", "2km", "3km", "4km", "5km", "6km" };//��ʾ�ֶ�
	    private final String[] itemsVaule = new String[] { "1", "2", "3", "4", "5", "6" };//����id
	private OnSelectListener mOnSelectListener;
	private TextAdapter adapter;
	private String mDistance;
	private String showText = "1km";
	private Context mContext;

	public String getShowText() {
		return showText;
	}

	public ViewLeft(Context context) {
		super(context);
		init(context);
	}

	public ViewLeft(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ViewLeft(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_distance, this, true);
		setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_left));
		mListView = (ListView) findViewById(R.id.listView);
		adapter = new TextAdapter(context, items, R.drawable.choose_item_right, R.drawable.choose_eara_item_selector);
		adapter.setTextSize(17);
		if (mDistance != null) {
			for (int i = 0; i < itemsVaule.length; i++) {
				if (itemsVaule[i].equals(mDistance)) {
					adapter.setSelectedPositionNoNotify(i);
					showText = items[i];
					break;
				}
			}
		}
		mListView.setAdapter(adapter);
		adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

			@Override
			public void onItemClick(View view, int position) {

				if (mOnSelectListener != null) {
					showText = items[position];
					mOnSelectListener.getValue(itemsVaule[position], items[position]);
				}
			}
		});
	}

	public void setOnSelectListener(OnSelectListener onSelectListener) {
		mOnSelectListener = onSelectListener;
	}

	public interface OnSelectListener {
		public void getValue(String distance, String showText);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void show() {
		
	}

}
