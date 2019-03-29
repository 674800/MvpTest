package app.ybf.com.mvp.Login;

/**
 * Created by ybf on 2019/3/29.
 */
public class ModeImple implements ModeInterface {

    /**
     * 登陆判断逻辑在Mode 里面处理，通过model 接口回调给present
     * Mode 持有view的 引用
     * @param longin
     */
    @Override
    public void login(LoginIngerface longin) {
        String userName = longin.getUserName();
        String password = longin.getPassWord();
        if(userName.equals("admin") || password.equals("admin")){
            longin.onSuccess();
        }else {
            longin.onFail();
        }
    }
}
