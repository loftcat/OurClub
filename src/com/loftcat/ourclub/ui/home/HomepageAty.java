package com.loftcat.ourclub.ui.home;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.loftcat.ourclub.R;
import com.loftcat.ourclub.app.Config;
import com.loftcat.ourclub.model.vo.VedioVo;
import com.loftcat.ourclub.ui.BaseAty;
import com.loftcat.ourclub.ui.adapter.HomepageAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class HomepageAty extends BaseAty {
	@ViewInject(id = R.id.homepageaty_gridview, click = "gridviewItem_click")
	GridView _gridview;
	private ArrayList<VedioVo> _vedioLists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepageaty);
		loadDATA();
	}


	protected void loadDATA() {
		AjaxParams params = new AjaxParams();
		params.put("media_prefix", "/juv/201314/");
		FinalHttp fh = new FinalHttp();
		fh.post(Config.VEDIO_LIST_URL, params, new AjaxCallBack() {
			@Override
			public void onLoading(long count, long current) {
			}

			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
				String str = (String) t;
				Gson gson = new GsonBuilder()
						.setDateFormat("yyyy-MM-dd hh:mm:ss")
						.registerTypeAdapter(Date.class, new DateTypeAdapter())
						.create();
				// json转为带泛型的list
				_vedioLists = gson.fromJson(str,
						new TypeToken<ArrayList<VedioVo>>() {
						}.getType());

				_gridview.setAdapter(new HomepageAdapter(_vedioLists,
						HomepageAty.this));

				_gridview
						.setOnItemClickListener(new GridView.OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int arg2, long arg3) {
								Intent intent = new Intent(Config.ACTION_INTENT_VEDIO);
								intent.putExtra(Config.INTENT_NAME_VEDIO, _vedioLists.get(arg2));
								startActivity(intent);
							}
						});

			}
		});
	}

}
