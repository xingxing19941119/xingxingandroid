package com.example.villagesoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FristPage extends Activity implements OnClickListener
{

	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private List<View> mViews = new ArrayList<View>();
	// TAB

	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSetting;

	private ImageButton mWeixinImg;
	private ImageButton mFrdImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingImg;
	
	private ListView listView1;
	private ListView listView2;
	private ListView listView3;
	private ListView listView4;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		
		initEvents();

	}

	private void initEvents()
	{
		mTabWeixin.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int arg0)
			{
				int currentItem = mViewPager.getCurrentItem();
				resetImg();
				switch (currentItem)
				{
				case 0:
					mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mAddressImg
							.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mSettingImg
							.setImageResource(R.drawable.tab_settings_pressed);
					break;

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{

			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{

			}
		});
	}

	private void initView()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		// tabs
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
		// ImageButton
		mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
		mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
		mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
		mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
		
		

		LayoutInflater mInflater = LayoutInflater.from(this);
		
		View tab01 = mInflater.inflate(R.layout.tab01, null);
		setTab01Contents(tab01);
		
	    View tab02 = mInflater.inflate(R.layout.tab02, null);
	    setTab02Contents(tab02);
	    
		View tab03 = mInflater.inflate(R.layout.tab03, null);
		setTab03Contents(tab03);
		
		View tab04 = mInflater.inflate(R.layout.tab04, null);
		setTab04Contents(tab04);
		
		mViews.add(tab01);
		mViews.add(tab02);
		mViews.add(tab03);
		mViews.add(tab04);

		mAdapter = new PagerAdapter()
		{

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object)
			{
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public int getCount()
			{
				return mViews.size();
			}
		};

		mViewPager.setAdapter(mAdapter);
		

	}

	@Override
	public void onClick(View v)
	{
		resetImg();
		switch (v.getId())
		{
		case R.id.id_tab_weixin:
			mViewPager.setCurrentItem(0);
			mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case R.id.id_tab_frd:
			mViewPager.setCurrentItem(1);
			mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case R.id.id_tab_address:
			mViewPager.setCurrentItem(2);
			mAddressImg.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.id_tab_settings:
			mViewPager.setCurrentItem(3);
			mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
			break;

		default:
			break;
		}
	}

	/**
	 * 将所有的图片切换为暗色的
	 */
	private void resetImg()
	{
		mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
		mAddressImg.setImageResource(R.drawable.tab_address_normal);
		mSettingImg.setImageResource(R.drawable.tab_settings_normal);
	}
	
	private void setTab01Contents(View view)
	{
		listView1=(ListView) view.findViewById(R.id.listView1);
		ArrayList<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for(int i=0;i<10;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "内容"+i);
			list.add(map);
		}
		SimpleAdapter Simple_Adapter=new SimpleAdapter(this, list, R.layout.item, new String[]{"image","text"},new int[]{R.id.imageView1,R.id.textView1});
		listView1.setAdapter(Simple_Adapter);
	}
	
	
	private void setTab02Contents(View view)
	{
		listView2=(ListView) view.findViewById(R.id.listView2);
		ArrayList<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for(int i=0;i<10;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "内容"+i);
			list.add(map);
		}
		SimpleAdapter Simple_Adapter=new SimpleAdapter(this, list, R.layout.item, new String[]{"image","text"},new int[]{R.id.imageView1,R.id.textView1});
		listView2.setAdapter(Simple_Adapter);
	}
	
	
	private void setTab03Contents(View view)
	{
		listView3=(ListView) view.findViewById(R.id.listView3);
		ArrayList<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for(int i=0;i<10;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "内容"+i);
			list.add(map);
		}
		SimpleAdapter Simple_Adapter=new SimpleAdapter(this, list, R.layout.item, new String[]{"image","text"},new int[]{R.id.imageView1,R.id.textView1});
		listView3.setAdapter(Simple_Adapter);
	}
	
	
	private void setTab04Contents(View view)
	{
		listView4=(ListView) view.findViewById(R.id.listView4);
		ArrayList<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		for(int i=0;i<10;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("text", "内容"+i);
			list.add(map);
		}
		SimpleAdapter Simple_Adapter=new SimpleAdapter(this, list, R.layout.item, new String[]{"image","text"},new int[]{R.id.imageView1,R.id.textView1});
		listView4.setAdapter(Simple_Adapter);
	}
}

