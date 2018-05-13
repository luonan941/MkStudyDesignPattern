package com.mkleo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mkleo.S1工厂模式.CarFactory;
import com.mkleo.S1工厂模式.产品.ChanganCar;
import com.mkleo.S1工厂模式.产品.HongqiCar;
import com.mkleo.S1工厂模式.产品.IProduct;
import com.mkleo.S1工厂模式.产品.ZhongtaiCar;
import com.mkleo.S2抽象工厂模式.TransporterFactory;
import com.mkleo.S2抽象工厂模式.产品.AudiCar;
import com.mkleo.S2抽象工厂模式.产品.BMWCar;
import com.mkleo.S2抽象工厂模式.产品.BenziCar;
import com.mkleo.S2抽象工厂模式.产品.IBoat;
import com.mkleo.S2抽象工厂模式.产品.ICar;
import com.mkleo.S2抽象工厂模式.产品.PleasureBoat;
import com.mkleo.S2抽象工厂模式.产品.SteamBoat;
import com.mkleo.S3单例模式.Singleton;
import com.mkleo.S4建造者模式.UserBuilder;
import com.mkleo.S5原型模式.User;
import com.mkleo.S5原型模式.UserCache;
import com.mkleo.S6适配器模式.AudioPlayer;
import com.mkleo.S6适配器模式.MediaAdapter;
import com.mkleo.S6适配器模式.VideoPlayer;
import com.mkleo.S7桥接模式.TextView;
import com.mkleo.S8过滤器模式_标准模式.GalaxyS8;
import com.mkleo.S8过滤器模式_标准模式.IPhone6;
import com.mkleo.S8过滤器模式_标准模式.Xiaomi6;
import com.mkleo.S8过滤器模式_标准模式.base.AbsCriterion;
import com.mkleo.S8过滤器模式_标准模式.base.Phone;
import com.mkleo.S8过滤器模式_标准模式.base.WaterproofPhone;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern);

//        this.工厂模式();
//        this.抽象工厂模式();
//        this.单例模式();
//        this.建造者模式();
//        this.原型模式();
//        this.适配器模式();
//        this.桥接模式();
        this.过滤器模式();

    }


    void 工厂模式() {

        Log.d("Mkleo", "工厂模式");

        CarFactory carsFactory = new CarFactory();

        IProduct changanCar = carsFactory.produceCar(ChanganCar.class);
        changanCar.obtain();

        IProduct hongqiCar = carsFactory.produceCar(HongqiCar.class);
        hongqiCar.obtain();

        IProduct zhongtaiCar = carsFactory.produceCar(ZhongtaiCar.class);
        zhongtaiCar.obtain();
    }

    void 抽象工厂模式() {

        Log.d("Mkleo", "抽象工厂模式");

        TransporterFactory factory = new TransporterFactory();

        ICar car1 = factory.produceCar(BMWCar.class);
        ICar car2 = factory.produceCar(BenziCar.class);
        ICar car3 = factory.produceCar(AudiCar.class);

        car1.obtain();
        car2.obtain();
        car3.obtain();

        IBoat boat = factory.produceBoat(SteamBoat.class);
        IBoat boat2 = factory.produceBoat(PleasureBoat.class);

        boat.obtain();
        boat2.obtain();

    }

    void 单例模式() {

        Log.d("Mkleo", "单例模式");

        new Thread() {
            @Override
            public void run() {
                super.run();

                int i = 0;

                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Log.d("Mkleo", "hashCode:" + Singleton.getSingleton().hashCode() + "  " + i++);
                }

            }
        }.start();
    }

    void 建造者模式() {
        Log.d("Mkleo", "建造者模式");

        UserBuilder userBuilder = new UserBuilder.Builder()
                .setUserAge("9")
                .setUserName("Mkleo")
                .build();
    }

    void 原型模式() {

        Log.d("Mkleo", "原型模式");

        UserCache.loadUsers();

        try {
            User user1 = UserCache.getUser(0);
            Log.d("Mkleo", "User " + user1.getName());

            User user2 = UserCache.getUser(1);
            Log.d("Mkleo", "User " + user2.getName());

            User user3 = UserCache.getUser(2);
            Log.d("Mkleo", "User " + user3.getName());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    void 适配器模式() {

        Log.d("Mkleo", "适配器模式");

        MediaAdapter adapter = new MediaAdapter(AudioPlayer.class);
        adapter.play("播放");

        adapter = new MediaAdapter(VideoPlayer.class);
        adapter.play("播放");
    }

    void 桥接模式() {
        TextView textView = new TextView();
        textView.display();
    }

    void 过滤器模式() {

        GalaxyS8 galaxyS8 = new GalaxyS8("112", "三星S8");
        IPhone6 iPhone6 = new IPhone6("113", "苹果6");
        Xiaomi6 xiaomi6 = new Xiaomi6("114", "小米6");

        List<Phone> phones = new ArrayList<>();
        phones.add(galaxyS8);
        phones.add(iPhone6);
        phones.add(xiaomi6);

        AbsCriterion<Phone> criterion = new AbsCriterion<Phone>(WaterproofPhone.class) {
        };

        for (Phone cPhone : criterion.execCriterion(phones)) {
            Log.d("Mkleo", "Name:" + cPhone.getPhoneName());
        }
    }


}