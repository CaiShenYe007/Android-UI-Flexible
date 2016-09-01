package com.caishenye.uiBuildSupport;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/**
 * Activity基类。BaseClass for Activity.<br>
 * 提供Activity的公共方法。<br>
 * 1 Override了setContentView方法，在setContentView后增加了重新设置子控件参数的处理。<br>
 * Override the setContentView method, reset widgets size process added.<br>
 * 2 增加了构造方法，要求子类必须指定根Layout的ID，用于多屏幕适应处理。<br>
 * Modified construct method, subclass must set the ID of root layout to reset
 * the widgets' size.<br>
 * 
 * @author CaiShenye
 * 
 */
@SuppressLint("NewApi")
public abstract class UIBuildBaseActivity extends FragmentActivity {

	/**
	 * 根Layout的ID用于取得所有子控件，进行多屏幕适应处理。<br>
	 * Root layout id, used to get and resize all the sub widgets.<br>
	 */
	private int mRootLayoutID = -1;

	/**
	 * 设置根Layout的ID用于取得所有子控件，进行多屏幕适应处理。<br>
	 * 如果rootLayoutID设置成-1，不会再重新设置所有控件的大小。<br>
	 * Set root layout id to get and resize all the sub widgets.<br>
	 * If rootLayoutID is set to -1, it will not resize widgets.<br>
	 * 
	 * @param rootLayoutID
	 *            画面布局中的根Layout的ID.Root layout ID.
	 */
	public UIBuildBaseActivity(int rootLayoutID) {
		mRootLayoutID = rootLayoutID;
	}

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		resetLayout();
	}

	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		resetLayout();
	}

	@Override
	public Resources getResources() {
		Resources res = super.getResources();
		Configuration config = new Configuration();
		config.setToDefaults();
		res.updateConfiguration(config, res.getDisplayMetrics());
		return res;
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		super.setContentView(view, params);
		resetLayout();
	}

	private void resetLayout() {
		if (mRootLayoutID == -1) {
		} else {
			ViewGroup rootView = (ViewGroup) findViewById(mRootLayoutID);
			SupportDisplay.resetAllChildViewParam(rootView);
		}
	}
}
