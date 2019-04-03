# MvpTest
<<<<<<< HEAD
=======

>>>>>>> origin/master
##搭建UI框架
<br>简单的写了一个MVP模式的登陆功能。
<br>1.搭建UI框架
<br>2.写了一个登陆功能，用MVP模式：
<br>简单说明：
  <br> --LoginIngerface 接口就是Activity里面处理UI的接口。
  <br>--ModeInterface 接口就是处理数据的接口，需要传入更新的UI接口。
  <br>--ModeImple 类实现ModeInterface接口，进行逻辑处理，根据逻辑处理调用相关的View 回调函数。
  <br> --present 只做代理，会持有View的接口，在present里面去初始化（new）一个Mode实例。
  <br> --在present中可以直接调用Mode里面的函数，进行封装供 UI层调用。
<<<<<<< HEAD
  <br>UI层只需要实现LoginIngerface接口，设置监听即可。UI层就不会处理相关逻辑了。
=======
  <br>UI层只需要实现LoginIngerface接口，设置监听即可。UI层就不会处理相关逻辑了。
>>>>>>> origin/master
