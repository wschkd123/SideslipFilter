package com.example.study.android.androidscreening.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.study.android.androidscreening.R;
import com.example.study.android.androidscreening.adapter.RightSideslipLayAdapter;
import com.example.study.android.androidscreening.model.AttrList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性选择的布局及逻辑
 */
public class FilterSpecAttrView extends RelativeLayout {
    private Context mContext;
    private ListView mSpecAttrList;
    private Button resetBrand;
    private Button okBrand;
    private RightSideslipLayAdapter slidLayFrameAdapter;
    private List<AttrList.Attr.Vals> ValsData;

    private static final int EXPAND_COUNT = 8;
    private String jsonAttr = "{\n" +
            "    \"brands\": [\n" +
            "        \"adidas\",\n" +
            "        \"nike\",\n" +
            "        \"新百伦\",\n" +
            "        \"adi\"\n" +
            "    ],\n" +
            "    \"attrs\": [\n" +
            "        {\n" +
            "            \"id\": 1001,\n" +
            "            \"values\": [],\n" +
            "            \"name\": \"价格\",\n" +
            "            \"type\": 2\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1002,\n" +
            "            \"values\": [\n" +
            "                \"有\",\n" +
            "                \"无\"\n" +
            "            ],\n" +
            "            \"name\": \"购买收据\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1003,\n" +
            "            \"values\": [\n" +
            "                \"有\",\n" +
            "                \"无\"\n" +
            "            ],\n" +
            "            \"name\": \"商品标签\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"values\": [\n" +
            "                \"雪纺\",\n" +
            "                \"蕾丝\",\n" +
            "                \"牛仔\",\n" +
            "                \"皮革\",\n" +
            "                \"棉布\",\n" +
            "                \"麻布\",\n" +
            "                \"羊毛/羊绒\",\n" +
            "                \"丝绸\",\n" +
            "                \"呢绒\",\n" +
            "                \"化纤\",\n" +
            "                \"混纺\",\n" +
            "                \"马海毛\"\n" +
            "            ],\n" +
            "            \"name\": \"材质\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"values\": [\n" +
            "                \"喇叭\",\n" +
            "                \"阔腿\",\n" +
            "                \"直筒\",\n" +
            "                \"修身\"\n" +
            "            ],\n" +
            "            \"name\": \"裤型\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"values\": [\n" +
            "                \"帆布\",\n" +
            "                \"漆皮\",\n" +
            "                \"尼龙\",\n" +
            "                \"人造皮/革\",\n" +
            "                \"棉麻\",\n" +
            "                \"羊皮\",\n" +
            "                \"牛皮\",\n" +
            "                \"鳄鱼皮\"\n" +
            "            ],\n" +
            "            \"name\": \"材质\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 4,\n" +
            "            \"values\": [\n" +
            "                \"平/低跟 (1-3cm)\",\n" +
            "                \"中跟 (3-6 cm)\",\n" +
            "                \"高跟 (6-10)\",\n" +
            "                \"超高跟 (>10cm)\"\n" +
            "            ],\n" +
            "            \"name\": \"跟高\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"values\": [\n" +
            "                \"粗跟\",\n" +
            "                \"细跟\",\n" +
            "                \"坡跟\",\n" +
            "                \"松糕\"\n" +
            "            ],\n" +
            "            \"name\": \"鞋跟风格\",\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 6,\n" +
            "            \"values\": [\n" +
            "                \"短款\",\n" +
            "                \"齐地\",\n" +
            "                \"拖尾\",\n" +
            "                \"鱼尾\",\n" +
            "                \"A字裙\",\n" +
            "                \"蓬蓬裙\",\n" +
            "                \"抹胸\",\n" +
            "                \"单肩\",\n" +
            "                \"一字肩\",\n" +
            "                \"V领\",\n" +
            "                \"心形领\",\n" +
            "                \"无袖\",\n" +
            "                \"中袖\",\n" +
            "                \"长袖\",\n" +
            "                \"蕾丝\",\n" +
            "                \"缎面\"\n" +
            "            ],\n" +
            "            \"name\": \"风格\",\n" +
            "            \"type\": 1\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    private String JsonStr = "{\n" +
            "    \"attrs\": [\n" +
            "        {\n" +
            "            \"name\": \"品牌\",\n" +
            "            \"vals\": [\n" +
            "                {\n" +
            "                    \"val\": \"雅格\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"志高/Chigo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"格东方\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"Chigo\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"格OW\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"志go\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"格LLOW\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"志o\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"LLOW\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"众桥\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"超人/SID\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"扬子342\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"扬舒服\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"扬子东方\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"荣事达/Royalstar\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"是否进口\",\n" +
            "            \"vals\": [\n" +
            "                {\n" +
            "                    \"val\": \"国产\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"进口\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"灭蚊器类型\",\n" +
            "            \"vals\": [\n" +
            "                {\n" +
            "                    \"val\": \"光触媒灭蚊器\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"个数\",\n" +
            "            \"vals\": [\n" +
            "                {\n" +
            "                    \"val\": \"1个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"1个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"1个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"1个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"1个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"2个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"3个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"4个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"5个\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"5个以上\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"10个以上\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"型号\",\n" +
            "            \"vals\": [\n" +
            "                {\n" +
            "                    \"val\": \"SI23\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"SI23\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"SI343\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"SI563\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"val\": \"Sgt23\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public FilterSpecAttrView(Context context) {
        super(context);
        mContext = context;
        inflateView();
    }

    public FilterSpecAttrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        inflateView();
    }

    private void inflateView() {
        View.inflate(getContext(), R.layout.include_right_sideslip_layout, this);
        mSpecAttrList = (ListView) findViewById(R.id.selsectFrameLV);
        resetBrand = (Button) findViewById(R.id.fram_reset_but);
        okBrand = (Button) findViewById(R.id.fram_ok_but);
        //触发点击事件
        resetBrand.setOnClickListener(mOnClickListener);
        okBrand.setOnClickListener(mOnClickListener);
        getData();
    }


    // 此处为了将超过9个个数的类目进行缩略显示
    private List<AttrList.Attr> setUpBrandList(List<AttrList.Attr> mAttrList) {
        for (AttrList.Attr item : mAttrList) {
            item.setTempVals(getValsDatas(item.getVals()));
        }
        return mAttrList;
    }

    // 声明AttrList字符串实体类
    private AttrList attr;

    // 获取当前Sides列表数据
    private void getData() {
        attr = new Gson().fromJson(JsonStr.toString(), AttrList.class);
        if (slidLayFrameAdapter == null) {
            slidLayFrameAdapter = new RightSideslipLayAdapter(mContext, setUpBrandList(attr.getAttrs()));
            mSpecAttrList.setAdapter(slidLayFrameAdapter);
        } else {
            // 当popupwindow消失时调用，更新第一页界面
            slidLayFrameAdapter.replaceAll(attr.getAttrs());
        }
        slidLayFrameAdapter.setAttrCallBack(new RightSideslipLayAdapter.SelechDataCallBack() {
            @Override
            public void setupAttr(List<String> mSelectData, String key) {
                if (Boolean.valueOf(key)) {
                    Log.i("List111", key);
                }
            }
        });

        slidLayFrameAdapter.setMoreCallBack(new RightSideslipLayAdapter.SelechMoreCallBack() {

            @Override
            public void setupMore(List<AttrList.Attr.Vals> mSelectData, List<AttrList.Attr.Vals> ValsData, int position, String title) {
                getPopupWindow(mSelectData, ValsData, position, title);
                mDownMenu.setOnMeanCallBack(meanCallBack);
            }
        });

    }

    // 在第二个页面改变后，返回时第一个界面随之改变，使用的接口回调
    private RightSideslipChildLay.onMeanCallBack meanCallBack = new RightSideslipChildLay.onMeanCallBack() {
        @Override
        public void isDisMess(int position, List<AttrList.Attr.Vals> mTotalData, String str) {
            AttrList.Attr res = (AttrList.Attr) attr.getAttrs().get(position);
            if (mTotalData != null) {
                res.setSelectValues(setSelectItem(mTotalData));
                res.setTempVals(getValsDatas(mTotalData));
                res.setShowStr(str);
                slidLayFrameAdapter.replaceAll(attr.getAttrs());
            }

            dismissMenuPop();
        }
    };

    private List<AttrList.Attr.Vals> setSelectItem(List<AttrList.Attr.Vals> list) {
        List<AttrList.Attr.Vals> rets = new ArrayList<>();
        for (AttrList.Attr.Vals baseRet: list) {
            if (baseRet.isChick()) {
                rets.add(baseRet);
            }
        }
        return rets;
    }

    // 获取"查看更多"数据，超过8个时设为查看更多，当前为"品牌"类目
    private List<AttrList.Attr.Vals> getValsDatas(List<AttrList.Attr.Vals> mTotalData) {
        List<AttrList.Attr.Vals> mVals = new ArrayList<AttrList.Attr.Vals>();
        if (mTotalData != null && mTotalData.size() > 0) {
            for (int i = 0; i < mTotalData.size(); i++) {
                if (mVals.size() >= EXPAND_COUNT) {
                    AttrList.Attr.Vals valsAdd = new AttrList.Attr.Vals();
                    valsAdd.setV("查看更多 >");
                    mVals.add(valsAdd);
                    continue;
                } else {
                    mVals.add(mTotalData.get(i));
                }
            }
            mVals = mVals.size() >= 9 ? mVals.subList(0, 9) : mVals;
            return mVals;

        }
        return null;
    }

    // 点击事件的继承
    private OnClickListenerWrapper mOnClickListener = new OnClickListenerWrapper() {
        @Override
        protected void onSingleClick(View v) {
            switch (v.getId()) {
                case R.id.select_brand_back_im:
                case R.id.fram_ok_but:
                    menuCallBack.setupCloseMean();
                    break;

                case R.id.fram_reset_but:
                    slidLayFrameAdapter = null;
                    getData();
                    break;
            }
        }
    };


    //设置第二屏内容
    /**
     * 关闭窗口
     */
    private void dismissMenuPop() {
        if (mMenuPop != null) {
            mMenuPop.dismiss();
            mMenuPop = null;
        }

    }

    /***
     * 获取PopupWindow实例
     * @param mSelectData 已选择的List
     * @param ValsData 所有元素List
     */
    private void getPopupWindow(List<AttrList.Attr.Vals> mSelectData, List<AttrList.Attr.Vals> ValsData, int pos, String title) {
        if (mMenuPop != null) {
            dismissMenuPop();
            return;
        } else {
            initPopupWindow(mSelectData, ValsData, pos, title);
        }
    }

    /**
     * 创建PopupWindow
     */
    private PopupWindow mMenuPop;
    public RightSideslipChildLay mDownMenu;

    protected void initPopupWindow(List<AttrList.Attr.Vals> mSelectData, List<AttrList.Attr.Vals> ValsData, int pos, String title) {
        mDownMenu = new RightSideslipChildLay(getContext(), ValsData, mSelectData, pos, title);
        if (mMenuPop == null) {
            mMenuPop = new PopupWindow(mDownMenu, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        }
        mMenuPop.setBackgroundDrawable(new BitmapDrawable());
        mMenuPop.setAnimationStyle(R.style.popupWindowAnimRight);
        mMenuPop.setOutsideTouchable(true);
        mMenuPop.setFocusable(true);
        mMenuPop.showAtLocation(FilterSpecAttrView.this, Gravity.TOP, 100, UiUtils.getStatusBarHeight(mContext));
        mMenuPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                dismissMenuPop();
            }
        });
    }


    /**
     * 创建CloseMenuCallBack接口
     */
    private CloseMenuCallBack menuCallBack;

    public interface CloseMenuCallBack {
        void setupCloseMean();
    }

    public void setCloseMenuCallBack(CloseMenuCallBack menuCallBack) {
        this.menuCallBack = menuCallBack;
    }
}
