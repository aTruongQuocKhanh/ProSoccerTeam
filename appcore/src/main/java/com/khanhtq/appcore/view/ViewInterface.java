package com.khanhtq.appcore.view;

import java.util.List;

/**
 * Created by khanhtq on 4/7/16.
 */
public class ViewInterface {
    public interface CallBackView<T> {
        public void callBack(List<T> datas);
    }
}
