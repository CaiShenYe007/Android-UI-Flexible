package com.caishenye.uiBuildSupport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

/**
 * Fragment的基类。<br>
 * Supper class for Fragment.<br>
 * 共通功能：<br>
 * Commnet functions:<br>
 * 1 重新计算子控件参数；<br>
 * Resize all the widgets' size;
 * 
 * @author CaiShenye
 * 
 */
public abstract class UIBuildBaseFragment extends Fragment {

	private int mRootLayoutID = -1;

	/**
	 * 设置根Layout的ID用于取得所有子控件，进行多屏幕适应处理。<br>
	 * 如果rootLayoutID设置成-1，不会再重新设置所有控件的大小。<br>
	 * Set root layout id to get and resize all the sub widgets.<br>
	 * If rootLayoutID is set to -1, it will not resize widgets.<br>
	 * 
	 * @param rootLayoutID
	 *            If rootLayoutID is set to -1, it will not resize widgets.
	 */
	public UIBuildBaseFragment(int rootLayoutID) {
		mRootLayoutID = rootLayoutID;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		resetLayout();
	}

	private void resetLayout() {
		if (mRootLayoutID != -1) {
			ViewGroup rootView = (ViewGroup) getView().findViewById(
					mRootLayoutID);
			SupportDisplay.resetAllChildViewParam(rootView);
		}
	}
}
