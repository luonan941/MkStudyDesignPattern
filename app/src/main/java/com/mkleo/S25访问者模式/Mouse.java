package com.mkleo.S25访问者模式;

import android.util.Log;

/**
 * @说明:
 * @作者: Wang HengJin
 * @日期: 2018/5/21 9:31 星期一
 */
public class Mouse implements ComputerPeripherals {

    @Override
    public void load() {
        Log.d("Mkleo","加载外置鼠标");
    }

}
