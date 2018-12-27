package bean;

import java.util.List;

public class StringBean {
    public String msg;
    public String code;
    public String page;
    public List<Data> data;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getPage() {
        return page;
    }

    public List<Data> getData() {
        return data;
    }

    public class Data{
        public String title;
        public String subhead;
        public String images;

        public String getTitle() {
            return title;
        }

        public String getSubhead() {
            return subhead;
        }

        public String getImages() {
            return images;
        }
    }
}
