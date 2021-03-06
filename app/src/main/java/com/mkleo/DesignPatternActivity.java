package com.mkleo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mkleo.S10装饰器模式.Clothes;
import com.mkleo.S10装饰器模式.ClothesDecorator;
import com.mkleo.S11外观模式.Computer;
import com.mkleo.S12享元模式.BitmapCache;
import com.mkleo.S13代理模式.ProxyPicture;
import com.mkleo.S14责任链模式.例子2.Activity;
import com.mkleo.S14责任链模式.例子2.OnTouchListener;
import com.mkleo.S14责任链模式.例子2.View;
import com.mkleo.S14责任链模式.例子2.ViewGroup;
import com.mkleo.S15命令模式.CmdCloseComputer;
import com.mkleo.S15命令模式.CmdExecutor;
import com.mkleo.S15命令模式.CmdOpenComputer;
import com.mkleo.S15命令模式.CmdSleepComputer;
import com.mkleo.S17迭代器模式.Iterator;
import com.mkleo.S17迭代器模式.NameRepository;
import com.mkleo.S18中介者模式.ChatUser;
import com.mkleo.S19备忘录模式.Data;
import com.mkleo.S19备忘录模式.MemoryCache;
import com.mkleo.S1工厂模式.CarFactory;
import com.mkleo.S1工厂模式.产品.ChanganCar;
import com.mkleo.S1工厂模式.产品.HongqiCar;
import com.mkleo.S1工厂模式.产品.IProduct;
import com.mkleo.S1工厂模式.产品.ZhongtaiCar;
import com.mkleo.S20观察者模式.IQQUser;
import com.mkleo.S20观察者模式.QQSpace;
import com.mkleo.S21状态模式.FreeState;
import com.mkleo.S21状态模式.Player;
import com.mkleo.S21状态模式.ReadyState;
import com.mkleo.S22空对象模式.UserTable;
import com.mkleo.S23策略模式.AdditionStrategy;
import com.mkleo.S23策略模式.SpellStrategy;
import com.mkleo.S24模版模式.QQCar;
import com.mkleo.S25访问者模式.Keyboard;
import com.mkleo.S25访问者模式.Mouse;
import com.mkleo.S25访问者模式.MyComputer;
import com.mkleo.S25访问者模式.SoundBox;
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
import com.mkleo.S9组合模式.Node;

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
//        this.过滤器模式();
//        this.组合模式();
//        this.装饰器模式();
//        this.外观模式();
//        this.享元模式();
//        this.代理模式();
//        this.责任链模式();
//        this.命令模式();
//        this.迭代器模式();
//        this.中介者模式();
//        this.备忘录模式();
//        this.观察者模式();
//        this.状态模式();
//        this.空对象模式();
//        this.策略模式();
//        this.模版模式();
//        this.访问者模式();

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
            Log.d("Mkleo", "ChatUser " + user1.getName());

            User user2 = UserCache.getUser(1);
            Log.d("Mkleo", "ChatUser " + user2.getName());

            User user3 = UserCache.getUser(2);
            Log.d("Mkleo", "ChatUser " + user3.getName());

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
        Log.d("Mkleo", "桥接模式");

        TextView textView = new TextView();
        textView.display();
    }

    void 过滤器模式() {

        Log.d("Mkleo", "过滤器模式");

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

    void 组合模式() {
        Log.d("Mkleo", "组合模式");

        Node node_董事会 = new Node(1, "董事会", null);
        Node node_总经办 = new Node(2, "总经办", node_董事会);
        Node node_北京总部 = new Node(3, "北京总部", node_总经办);
        Node node_上海分部 = new Node(4, "上海分部", node_总经办);
        Node node_北京财务部 = new Node(5, "北京财务部", node_北京总部);
        Node node_上海财务部 = new Node(6, "上海财务部", node_上海分部);
        Node node_北京技术部 = new Node(7, "北京技术部", node_北京总部);
        Node node_上海营销部 = new Node(8, "上海营销部", node_上海分部);

        List<Node> nodes = new ArrayList();

        nodes.add(node_董事会);
        nodes.add(node_总经办);
        nodes.add(node_北京总部);
        nodes.add(node_上海分部);
        nodes.add(node_北京财务部);
        nodes.add(node_上海财务部);
        nodes.add(node_北京技术部);
        nodes.add(node_上海营销部);

        for (Node node : nodes) {

            Log.d("Mkleo", node.toString());
        }

    }

    void 装饰器模式() {

        Log.d("Mkleo", "装饰器模式");

        //创建装饰器
        Clothes clothes = new Clothes();
        ClothesDecorator clothesDecorator1 = new ClothesDecorator(clothes, "衣服图案");
        ClothesDecorator clothesDecorator2 = new ClothesDecorator(clothesDecorator1, "衣服口袋");
        ClothesDecorator clothesDecorator3 = new ClothesDecorator(clothesDecorator2, "衣服商标");
        clothesDecorator3.clip();

    }

    void 外观模式() {

        Log.d("Mkleo", "外观模式");
        Computer computer = new Computer();
        computer.open();
        computer.close();

    }

    void 享元模式() {
        Log.d("Mkleo", "享元模式");

        Log.d("Mkleo", BitmapCache.getBitmap(BitmapCache.BitmapPool.BITMAP_DOG).toString());
        Log.d("Mkleo", BitmapCache.getBitmap(BitmapCache.BitmapPool.BITMAP_BIRD).toString());
        Log.d("Mkleo", BitmapCache.getBitmap(BitmapCache.BitmapPool.BITMAP_CAT).toString());

    }

    void 代理模式() {
        Log.d("Mkleo", "代理模式");

        ProxyPicture proxyPicture = new ProxyPicture("SB.jpg");
        proxyPicture.display();
        proxyPicture.display();
    }


    void 责任链模式() {

        Log.d("Mkleo", "责任链模式");
//        Logger.logger(LoggerLevel.MAIN,"责任链模式 例子1");

        //创建Activity
        Activity activity = new Activity();
        //创建ViewGroup
        ViewGroup viewGroup = new ViewGroup();
        //创建View
        View view = new View();
        //设置上层图形
        activity.setSuperWindow(viewGroup);
        viewGroup.setSuperWindow(view);


        viewGroup.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch() {
                return true;
            }
        });

        view.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch() {
                return false;
            }
        });

        //模拟点击
        activity.dispatchTouch();
    }

    void 命令模式() {

        Log.d("Mkleo", "命令模式");

        com.mkleo.S15命令模式.Computer computer = new com.mkleo.S15命令模式.Computer();
        CmdOpenComputer cmd1 = new CmdOpenComputer(computer);
        CmdSleepComputer cmd2 = new CmdSleepComputer(computer);
        CmdCloseComputer cmd3 = new CmdCloseComputer(computer);

        CmdExecutor executor = new CmdExecutor();
        executor.addCmd(cmd1);
        executor.addCmd(cmd2);
        executor.addCmd(cmd3);
        executor.execute();
    }

    void 迭代器模式() {

        Log.d("Mkleo", "迭代器模式");

        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            Log.d("Mkleo", "Name:" + name);
        }

    }

    void 中介者模式() {

        Log.d("Mkleo", "中介者模式");

        ChatUser john = new ChatUser("john");
        ChatUser robot = new ChatUser("robot");

        john.sendMsg("hello man!");

        robot.sendMsg("i am robot");

    }

    void 备忘录模式() {

        Log.d("Mkleo", "备忘录模式");

        Data data = new Data();
        MemoryCache memoryCache = new MemoryCache();

        data.setState("State 1");
        data.setState("State 2");
        memoryCache.addMemory(data.saveStateToMemory());
        data.setState("State 3");
        memoryCache.addMemory(data.saveStateToMemory());

        data.setState("State 4");
        Log.d("Mkleo", "当前状态:" + data.getState());

        data.getStateByMemory(memoryCache.getMemory(0));
        Log.d("Mkleo", "变更为初始保存状态:" + data.getState());

        data.getStateByMemory(memoryCache.getMemory(memoryCache.theLastPosition()));
        Log.d("Mkleo", "变更为最终保存状态:" + data.getState());
    }

    void 观察者模式() {

        Log.d("Mkleo", "观察者模式");

        IQQUser mkleo = new IQQUser() {
            @Override
            public void onSpaceUpdate() {
                Log.d("Mkleo", "Mkleo 接到QQ空间更新");
            }
        };

        IQQUser lemon = new IQQUser() {
            @Override
            public void onSpaceUpdate() {
                Log.d("Mkleo", "Lemon 接到QQ空间更新");
            }
        };

        IQQUser admin = new IQQUser() {
            @Override
            public void onSpaceUpdate() {
                Log.d("Mkleo", "Admin 接到QQ空间更新");
            }
        };

        QQSpace qqSpace = new QQSpace();
        qqSpace.subscribe(admin);
        qqSpace.subscribe(lemon);
        qqSpace.subscribe(mkleo);
        qqSpace.updateSpace();
        Log.d("Mkleo", "---- 过了一个小时 ----");
        //有人取消了订阅
        qqSpace.unSubscribe(admin);
        qqSpace.updateSpace();


    }

    void 状态模式() {
        Log.d("Mkleo", "状态模式");

        Player player = new Player();

        FreeState freeState = new FreeState();
        freeState.action(player);

        ReadyState readyState = new ReadyState();
        readyState.action(player);
    }

    void 空对象模式() {

        com.mkleo.S22空对象模式.User user = UserTable.getUser("Jimi");

        Log.d("Mkleo", user.getUserName());

        com.mkleo.S22空对象模式.User user2 = UserTable.getUser("jimi");

        Log.d("Mkleo", user2.getUserName());

    }

    void 策略模式() {

        AdditionStrategy additionStrategy = new AdditionStrategy();
        int sum1 = additionStrategy.execStrategy(1, 2, 3, 4, 5, 6);
        int sum2 = additionStrategy.execStrategy(2, 1, 31, 51, 12);
        Log.d("Mkleo", "sum1:" + sum1 + "  sum2:" + sum2);

        SpellStrategy spellStrategy = new SpellStrategy();
        String result = spellStrategy.execStrategy("S", "A", "M", "N");
        Log.d("Mkleo", "result:" + result);

    }

    void 模版模式() {

        QQCar qqCar = new QQCar();
        qqCar.drive();
    }

    void 访问者模式(){

        MyComputer myComputer = new MyComputer();
        myComputer.addPeripherals(new Mouse(),new Keyboard(),new SoundBox());
        myComputer.open();
    }


}
