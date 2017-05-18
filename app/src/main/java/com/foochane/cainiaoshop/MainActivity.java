package com.foochane.cainiaoshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.foochane.cainiaoshop.fragment.HomeFragment;
import com.foochane.cainiaoshop.widget.FragmentTabHost;


//Activity要继承FragmentActivity
//AppCompatActivity已经继承了FragmentActivity
public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;

    private FragmentTabHost mTabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);

        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent); //不是tabcontent


        View view = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(R.mipmap.icon_home);
        text.setText("主页");

        TabHost.TabSpec  tabSpec = mTabhost.newTabSpec("home");
        tabSpec.setIndicator(view);
        mTabhost.addTab(tabSpec , HomeFragment.class,null);
    }
}
