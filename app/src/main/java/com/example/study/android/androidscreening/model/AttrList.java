package com.example.study.android.androidscreening.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by songyan on 2017/2/5.
 */

public class AttrList implements Serializable {

    private List<Attr> attrs;

    public List getAttrs() {
        return attrs;
    }

    public void setAttrs(List attrs) {
        this.attrs = attrs;
    }

    public static class Attr implements Serializable {
        //属性值的title
        private String name;
        //属性值的title对应的数据
        private List<Vals> vals;
        //设置选中的数据
        private List<Vals> selectValues;
        // 设置临时属性值的title临时的数据
        private List<Vals> tempVals;
        //状态是否打开
        private boolean isoPen = true;
        private String showStr = "";


        public boolean isoPen() {
            return isoPen;
        }

        public void setIsoPen(boolean isoPen) {
            this.isoPen = isoPen;
        }

        public List<Vals> getSelectValues() {
            return selectValues;
        }

        public void setSelectValues(List<Vals> selectValues) {
            this.selectValues = selectValues;
        }

        public List<Vals> getTempVals() {
            return tempVals;
        }

        public void setTempVals(List<Vals> tempVals) {
            this.tempVals = tempVals;
        }

        public String getShowStr() {
            return showStr;
        }

        public void setShowStr(String showStr) {
            this.showStr = showStr;
        }

        public List<Vals> getVals() {
            return vals;
        }

        public void setVals(List<Vals> vals) {
            this.vals = vals;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class Vals implements Serializable {
            private String val;
            private boolean isChick;

            public boolean isChick() {
                return isChick;
            }

            public void setChick(boolean chick) {
                isChick = chick;
            }

            public String getV() {
                return val;
            }

            public void setV(String v) {
                this.val = v;
            }
        }
    }
}
