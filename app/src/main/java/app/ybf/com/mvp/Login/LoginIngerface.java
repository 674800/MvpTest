package app.ybf.com.mvp.Login;

/**
 * Created by ybf on 2019/3/29.
 * View 的回调接口
 */
public interface LoginIngerface {
    void onSuccess();
    void  onFail();
    String getUserName();
    String getPassWord();
}
