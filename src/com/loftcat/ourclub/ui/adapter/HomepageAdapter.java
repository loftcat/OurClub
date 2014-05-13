package com.loftcat.ourclub.ui.adapter;

import java.util.ArrayList;
import java.util.Formatter.BigDecimalLayoutForm;

import com.loftcat.ourclub.R;
import com.loftcat.ourclub.model.vo.VedioVo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class HomepageAdapter extends BaseAdapter {

	DisplayImageOptions options;
	ImageLoader imageLoader=ImageLoader.getInstance();
	private Context _context;
	private ArrayList<VedioVo> _vedioLists;
	public HomepageAdapter(ArrayList<VedioVo> vedioLists,Context context){
		_vedioLists = vedioLists;
		_context=context;
		options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.load_default)
		.showImageForEmptyUri(R.drawable.load_default)
		.showImageOnFail(R.drawable.load_default)
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
		
	}
		
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		if(arg1==null){
			arg1=new ImageView(_context);
		}
		imageLoader.displayImage("http://lcpublictest.qiniudn.com/default.jpg", (ImageView)arg1,options);
		return arg1;
	}

}
