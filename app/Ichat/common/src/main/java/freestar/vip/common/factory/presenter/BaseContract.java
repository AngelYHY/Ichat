package freestar.vip.common.factory.presenter;

import android.support.annotation.StringRes;

import freestar.vip.common.common.widget.recycler.BaseRecyclerAdapter;

/**
 * 描述：
 * 作者：一颗浪星
 * 日期：2017/9/30 0030
 * github：
 */

public interface BaseContract {

    interface BaseView<T extends Presenter> {
        // 公共的：显示一个字符串错误
        void showError(@StringRes int str);

        // 公共的：显示进度条
        void showLoading();

        // 支持设置一个 Presenter
        void setPresenter(T presenter);
    }

    // 基本的 Presenter 职责
    interface Presenter {
        // 共用的开始触发
        void start();

        // 共用的销毁触发
        void destroy();
    }

    // 基本的一个列表的 view 的职责
    interface BaseRecyclerView<T extends Presenter, ViewMode> extends BaseView<T> {
        // 界面端只能刷新整个数据集合，不能精确到每一条数据更新
        // void onDone(List<User user>);

        // 拿到一个适配器，然后自己自主的进行刷新
        BaseRecyclerAdapter<ViewMode> getRecyclerAdapter();

        // 当适配器数据更改了的时候触发
        void onAdapterDataChange();
    }
}
