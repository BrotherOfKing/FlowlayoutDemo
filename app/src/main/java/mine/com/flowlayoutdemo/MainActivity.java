package mine.com.flowlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView specLv;
    private List<SpecGroupBean> groupBeans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        specLv = findViewById(R.id.spec_lv);
        initData();
        setSpec();
    }
    private void initData(){
        groupBeans.clear();
        List<SpecGroupBean.SpecBean> specBeans1 = new ArrayList<>();
        specBeans1.add(new SpecGroupBean.SpecBean("红色"));
        specBeans1.add(new SpecGroupBean.SpecBean("绿色"));
        specBeans1.add(new SpecGroupBean.SpecBean("卡其色"));
        specBeans1.add(new SpecGroupBean.SpecBean("高山流水绿"));
        specBeans1.add(new SpecGroupBean.SpecBean("深海波涛蓝"));
        specBeans1.add(new SpecGroupBean.SpecBean("红霞满天绯红色"));
        specBeans1.add(new SpecGroupBean.SpecBean("深海波涛蓝"));
        specBeans1.add(new SpecGroupBean.SpecBean("红霞满天绯红色"));
        groupBeans.add(new SpecGroupBean("颜色",specBeans1));
        List<SpecGroupBean.SpecBean> specBeans2 = new ArrayList<>();
        specBeans2.add(new SpecGroupBean.SpecBean("红霞满天绯红色"));
        specBeans2.add(new SpecGroupBean.SpecBean("红色"));
        specBeans2.add(new SpecGroupBean.SpecBean("深海波涛蓝23542"));
        specBeans2.add(new SpecGroupBean.SpecBean("卡其色"));
        specBeans2.add(new SpecGroupBean.SpecBean("高山流水绿"));
        specBeans2.add(new SpecGroupBean.SpecBean("绿色"));
        specBeans2.add(new SpecGroupBean.SpecBean("深海波涛蓝"));
        specBeans2.add(new SpecGroupBean.SpecBean("深海波涛蓝353945"));
        groupBeans.add(new SpecGroupBean("颜色22222",specBeans2));
    }

    private CommentAdapter<SpecGroupBean> specModeCommentAdapter;

    private void setSpec() {
        if (specModeCommentAdapter != null) {
            specModeCommentAdapter.notifyDataSetChanged();
        } else {
            specModeCommentAdapter = new CommentAdapter<SpecGroupBean>(MainActivity.this, groupBeans, R.layout.item_spec_lay) {
                @Override
                protected void setItem(View convertView, final SpecGroupBean item, int position) {
                    TextView spec_type = convertView.findViewById(R.id.spec_type);
                    final FlowLayout specFlowLayout = convertView.findViewById(R.id.spec_flow_layout);
                    spec_type.setText(item.getName());
                    specFlowLayout.removeAllViews();
                    for (int i = 0; i < item.getListGuiGe().size(); i++) {
                        TextView tv = (TextView) mInflater.inflate(
                                R.layout.spec_item, specFlowLayout, false);
                        tv.setText(item.getListGuiGe().get(i).getName());
                        specFlowLayout.addView(tv);
                    }
                    specFlowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() {
                        @Override
                        public void click(View view, int position) {
                            for (int i = 0; i < specFlowLayout.getChildCount(); i++) {
                                if (i == position) {
                                    item.getListGuiGe().get(i).setSelect(true);
                                    TextView tv = (TextView) specFlowLayout.getChildAt(i);
                                    tv.setBackgroundResource(R.drawable.spec_selected_bg);
                                    tv.setTextColor(getResources().getColor(R.color.app_red));

                                } else {
                                    item.getListGuiGe().get(i).setSelect(false);
                                    TextView tv = (TextView) specFlowLayout.getChildAt(i);
                                    tv.setBackgroundResource(R.drawable.spec_select_bg);
                                    tv.setTextColor(getResources().getColor(R.color.goods_spec_color));
                                }
                            }

                        }
                    });
                }
            };
            specLv.setAdapter(specModeCommentAdapter);
        }
    }
}
