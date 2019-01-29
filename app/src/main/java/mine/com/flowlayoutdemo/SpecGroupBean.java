package mine.com.flowlayoutdemo;

import java.util.List;

public class SpecGroupBean {
    private String Name;
    private List<SpecBean> ListGuiGe;

    public SpecGroupBean(String groupName,List<SpecBean> specBeans){
        this.Name = groupName;
        this.ListGuiGe = specBeans;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<SpecBean> getListGuiGe() {
        return ListGuiGe;
    }

    public void setListGuiGe(List<SpecBean> ListGuiGe) {
        this.ListGuiGe = ListGuiGe;
    }

    public static class SpecBean {
        /**
         * Name : 红色
         */

        private String Name;
        private boolean isSelect = false;

        public SpecBean(String specName){
            this.Name = specName;
        }
        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }
}
