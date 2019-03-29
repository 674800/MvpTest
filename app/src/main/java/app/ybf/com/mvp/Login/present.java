package app.ybf.com.mvp.Login;

/**
 * Created by ybf on 2019/3/29.
 * MVP
 * M层定义接口，就是longin的接口，写一个M的实现类。
 * present只做代理，不处理逻辑。
 */


public class present {
    public  LoginIngerface longin;
    public ModeInterface modeInterface;


    /**
     * 设置UI监听
     * @param longin   哪个View调用我们，就需要传哪个View的参数
     */
    public void setPresentLinister(LoginIngerface longin){
        this.longin = longin;
        modeInterface = new ModeImple();//new出我们业务处理接口的具体实现类
    }

    public void Login (){
        modeInterface.login(longin);
    }


}
