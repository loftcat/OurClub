package com.loftcat.ourclub.ui.vedio;

import android.os.Bundle;
import android.util.Log;

import com.loftcat.ourclub.app.Config;
import com.loftcat.ourclub.model.vo.VedioVo;
import com.loftcat.ourclub.ui.BaseAty;

public class VedioAty extends BaseAty {
	private VedioVo _vedioVo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_vedioVo=(VedioVo) getIntent().getSerializableExtra(Config.INTENT_NAME_VEDIO);
		Log.d("H", _vedioVo.getMedia_name());
	}

}
