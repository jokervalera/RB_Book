package com.samples.ui.expandablelistview;

import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.text.GetChars;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class ImageAdapter extends   BaseAdapter implements SpinnerAdapter  {
	
	private Context mcontext;
	
	public static Integer[] Thumbslbs = { R.drawable.a1, R.drawable.a2,
			R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
			R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, };

	public static Integer[] Thumbslbs2 = { R.array.Thumbslbs2};

	public static Integer[] Thumbslbs3 = { R.drawable.a11 };

	public ImageAdapter(Context Context) {
		// TODO Auto-generated constructor stub
		mcontext = Context;
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView ImageView = null;
		if (convertView == null) {
			ImageView = new ImageView(mcontext);
			ImageView.setLayoutParams(new Gallery.LayoutParams(115, 100));
		} else {
			ImageView = (ImageView) convertView;
		}

		ImageView.setImageResource(Thumbslbs[position]);
		return ImageView;
	}

	@Override
	public int getCount() {	
		switch (222) {
		case 111:
			return Thumbslbs.length;
		case 222:
			return Thumbslbs2.length;
		default:
			return Thumbslbs3.length;
		}
	}

	
}

