package com.example.fury.youthmake.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fury.youthmake.R;
import com.example.fury.youthmake.fragment.Message;
import com.example.fury.youthmake.fragment.NavigationDrawerFragment;
import com.example.fury.youthmake.fragment.Setting;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,View.OnClickListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    /**
     * 用于展示消息的Fragment
     */
    private Message messageFragment;
    /**
     * 消息界面布局
     */
    private View messageLayout;
    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView messageImage;
    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView messageText;
    /**
     * 设置界面布局
     */
    private View settingLayout;
    /**
     * 用于展示设置的Fragment
     */
    private Setting settingFragment;
    /**
     * 在Tab布局上显示设置图标的控件
     */
    private ImageView settingImage;
    /**
     * 在Tab布局上显示设置标题的控件
     */
    private TextView settingText;
    /**
     *  用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    /**
     * 退出时间间隔为 0 ~ 2000
     */
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化布局元素
        initViews();
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        // 第一个参数  指定自定义fragment的区域 二、用本DrawerLayout 来创建自定义的DrawerFragment
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //fragmentManager = getFragmentManager();
        //fragmentManager = getSupportFragmentManager();
        //fragmentManager = getSupportFragmentManager().getFragments();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        //FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager = getSupportFragmentManager();
        // 开启一个Fragment事务

        transaction = fragmentManager.beginTransaction();
        if(messageImage != null)
            clearSelection();
        hideFragments(transaction);
        transaction.add(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.

            getMenuInflater().inflate(R.menu.main, menu);

            restoreActionBar();

            MenuInflater inflater = new MenuInflater(
                    MainActivity.this);
            inflater.inflate(R.menu.contextmenu, menu);
            //return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            // action with ID action_refresh was selected
            /*
            case R.id.action_example:

                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT).show();
                break;*/
            // action with ID action_settings was selected
            case R.id.action_settings:
                /*
                // 生成一个SpinnerAdapter
                SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.student, android.R.layout.simple_spinner_dropdown_item);
                // 得到ActionBar
                ActionBar actionBar = getSupportActionBar();
                // 将ActionBar的操作模型设置为NAVIGATION_MODE_LIST
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
                // 为ActionBar设置下拉菜单和监听器
                actionBar.setListNavigationCallbacks(adapter, new DropDownListenser());*/
                Toast.makeText(this, "Settings selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.ToLogin:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(this, "登陆界面", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        //return true;
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment getFragment() {
            return fragment;
        }

        public static void setFragment(PlaceholderFragment fragment) {
            PlaceholderFragment.fragment = fragment;
        }

        private static PlaceholderFragment fragment;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    /**
     *  在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        messageLayout = findViewById(R.id.message_layout);
        messageImage = (ImageView) findViewById(R.id.message_image);
        messageText = (TextView) findViewById(R.id.message_text);
        messageLayout.setOnClickListener(MainActivity.this);

        settingLayout = findViewById(R.id.setting_layout);
        settingImage = (ImageView) findViewById(R.id.setting_image);
        settingText = (TextView) findViewById(R.id.setting_text);
        settingLayout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }
    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.RED);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new Message();
                    //transaction.replace(R.id.container, messageFragment);
                    transaction.add(R.id.container, messageFragment);
                } else {
                    //transaction.replace(R.id.container, messageFragment);
                    //如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;

            case 3:
            default:

                //  当点击了设置tab时，改变控件的图片和文字颜色
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.BLUE);
                if (settingFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment = new Setting();
                    //transaction.replace(R.id.container, settingFragment);
                    transaction.add(R.id.container, settingFragment);
                } else {
                    //transaction.replace(R.id.container, settingFragment);
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }
    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }
    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *          用于对Fragment执行操作的事务
     */

    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
        if (PlaceholderFragment.getFragment() != null) {
            transaction.hide(PlaceholderFragment.getFragment());
        }
    }
    /**
     * 实现 ActionBar.OnNavigationListener接口
     */
    class DropDownListenser implements ActionBar.OnNavigationListener
    {
        //得到和SpinnerAdapter里一致的字符数组
        String[] listNames = getResources().getStringArray(R.array.student);

        // 当选择下拉菜单项的时候，将Activity中的内容置换为对应的Fragment
        public boolean onNavigationItemSelected(int itemPosition, long itemId)
        {
            // 生成自定的Fragment
            Log.d("nimeiya", "itemPosition is:" + itemPosition + " ItemId is:" + itemId);
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
