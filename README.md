# Android-UI-Flexible
Build ui once run on all screen size.

##System requirements
Android 2.3.3 or higher

##How to use
### First<br>
Confirm the base size of your ui according to UI design, set params below in SupportDisplay.java:<br>
 BASIC_SCREEN_WIDTH (default 640f)<br>
 BASIC_SCREEN_HEIGHT (default 960f)<br>
 BASIC_DENSITY (default 2.0f)<br>

### Second<br>
Call the "SupportDisplay.initLayoutSetParams(this)" method in your APP entrance, such as onCreate() of SplashActivity or Application. <br>
Then Create your Activities extends UIBuildBaseActivity and BaseFragment extends UIBuildBaseFragment.

For example:<br>
`
public class LoginActivity extends BaseActivity {
	
	public LoginActivity() {
		super(R.id.rl_login_bg);
	}

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_login);`


### Third<br>
Write layout.xml files. <br>
Make an ID for the root layout.<br>
Set the widget sizes(width, height, margin, padding...) by "px" instead of "dp" according to UI design.<br>
TextSize unit use "sp".<br>
Drawables should be put in "drawable-nodpi" folder.<br>

For example:<br>
`
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rl_login_bg"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:ignore="PxUsage" >

    <TextView
        android:id="@+id/tv_login_watertitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="200px"
        android:text="@string/login_title"
        android:textSize="22sp" />

    <LinearLayout
        android:id="@+id/ll_login_name_bg"
        android:layout_width="500px"
        android:layout_height="80px"
        android:layout_below="@id/tv_login_watertitle"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="70px"
        android:background="@drawable/et_login_bg"
        android:orientation="horizontal" >

        <ImageView
            android:layout_width="80px"
            android:layout_height="80px"
            android:contentDescription="@string/action_settings"
            android:padding="20px"
            android:src="@drawable/user" />

        <EditText
            android:id="@+id/et_login_name"
            android:layout_width="match_parent"
            android:layout_height="80px"
            android:layout_marginLeft="10px"
            android:background="@null"
            android:hint="@string/login_name"
            android:padding="10px"
            android:singleLine="true"
            android:textSize="14sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/ll_login_pass_bg"
        android:layout_width="500px"
        android:layout_height="80px"
        android:layout_below="@id/ll_login_name_bg"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30px"
        android:background="@drawable/et_login_bg"
        android:orientation="horizontal" >

        <ImageView
            android:layout_width="80px"
            android:layout_height="80px"
            android:contentDescription="@string/action_settings"
            android:padding="20px"
            android:src="@drawable/lock" />

        <EditText
            android:id="@+id/et_login_pass"
            android:layout_width="match_parent"
            android:layout_height="80px"
            android:layout_marginLeft="10px"
            android:background="@null"
            android:singleLine="true"
            android:password="true"
            android:hint="@string/login_pass"
            android:padding="10px"
            android:textSize="14sp" />
    </LinearLayout>

    <Button
        android:id="@+id/btn_login"
        android:layout_width="500px"
        android:layout_height="80px"
        android:layout_below="@id/ll_login_pass_bg"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30px"
        android:background="@drawable/btn_login_bg"
        android:text="@string/login"
        android:textColor="@color/bg_color_white"
        android:textSize="16sp" />

    <TextView
        android:id="@+id/tv_login_version"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="30px"
        android:text="@string/login_app"
        android:textSize="14sp" />

</RelativeLayout>`

That's all.
