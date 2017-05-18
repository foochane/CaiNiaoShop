# CaiNiaoShop

1、用FragmentTagHost实现底部菜单</br>
（1）FragmentTagHost的用法</br> 
    ①Activity要继承FragmentActivity.</br>
    ②调用setup()方法</br>
    ③添加TabSpec</br>
（2）Selector背景选择器</br>
（3）底部菜单的几种实现方式</br>

![image](https://github.com/foochane/CaiNiaoShop/blob/master/Screenshot/FragmentTabHost.pn)
![image](https://github.com/foochane/CaiNiaoShop/blob/master/Screenshot/一个fragment.pn)



```java
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
```
