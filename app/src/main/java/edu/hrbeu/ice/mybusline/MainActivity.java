package edu.hrbeu.ice.mybusline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.overlay.BusLineOverlay;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AMap.OnMapLoadedListener {
    MapView mapView;
    private AMap aMap;
    private BusLineOverlay busLineOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        mapView.onCreate(savedInstanceState);
        init();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        aMap.setOnMapLoadedListener(this);// 设置amap加载成功事件监听器


        List<BusStationItem> busStationItemList = new ArrayList<>();

        BusStationItem item1 = new BusStationItem();
        BusStationItem item2 = new BusStationItem();
        BusStationItem item3 = new BusStationItem();
        BusStationItem item4 = new BusStationItem();
        BusStationItem item5 = new BusStationItem();
        BusStationItem item6 = new BusStationItem();
        BusStationItem item7 = new BusStationItem();
        BusStationItem item8 = new BusStationItem();
        BusStationItem item9 = new BusStationItem();

        item1.setBusStationName("车站1");
        item2.setBusStationName("车站2");
        item3.setBusStationName("车站3");
        item4.setBusStationName("车站4");
        item5.setBusStationName("车站5");
        item6.setBusStationName("车站6");
        item7.setBusStationName("车站7");
        item8.setBusStationName("车站8");
        item9.setBusStationName("车站9");

        item1.setLatLonPoint(new LatLonPoint(45.775461, 126.668084));
        item2.setLatLonPoint(new LatLonPoint(45.780235, 126.673535));
        item3.setLatLonPoint(new LatLonPoint(45.784829, 126.678277));
        item4.setLatLonPoint(new LatLonPoint(45.783332, 126.685648));
        item5.setLatLonPoint(new LatLonPoint(45.77799, 126.689832));
        item6.setLatLonPoint(new LatLonPoint(45.772869, 126.691322));
        item7.setLatLonPoint(new LatLonPoint(45.76742, 126.692674));
        item8.setLatLonPoint(new LatLonPoint(45.765669, 126.678812));
        item9.setLatLonPoint(new LatLonPoint(45.770788, 126.678383));


        busStationItemList.add(item1);
        busStationItemList.add(item2);
        busStationItemList.add(item3);
        busStationItemList.add(item4);
        busStationItemList.add(item5);
        busStationItemList.add(item6);
        busStationItemList.add(item7);
        busStationItemList.add(item8);
        busStationItemList.add(item9);


        List<LatLonPoint> pointList = new ArrayList<>();
        pointList.add(new LatLonPoint(45.775461, 126.668084));
        pointList.add(new LatLonPoint(45.780235, 126.673535));
        pointList.add(new LatLonPoint(45.784829, 126.678277));
        pointList.add(new LatLonPoint(45.783332, 126.685648));
        pointList.add(new LatLonPoint(45.77799, 126.689832));
        pointList.add(new LatLonPoint(45.772869, 126.691322));
        pointList.add(new LatLonPoint(45.76742, 126.692674));
        pointList.add(new LatLonPoint(45.765669, 126.678812));
        pointList.add(new LatLonPoint(45.770788, 126.678383));


        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setDirectionsCoordinates(pointList);
        busLineItem.setBusStations(busStationItemList);

        busLineOverlay = new BusLineOverlay(this, aMap, busLineItem);
        busLineOverlay.addToMap();

    }

    @Override
    public void onMapLoaded() {
        // 设置所有maker显示在当前可视区域地图中

//        busLineOverlay.zoomToSpan();
        
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(new LatLng(45.775461, 126.668084))
                .include(new LatLng(45.780235, 126.673535))
                .include(new LatLng(45.784829, 126.678277))
                .include(new LatLng(45.783332, 126.685648))
                .include(new LatLng(45.77799, 126.689832))
                .include(new LatLng(45.772869, 126.691322))
                .include(new LatLng(45.76742, 126.692674))
                .include(new LatLng(45.765669, 126.678812))
                .include(new LatLng(45.770788, 126.678383)).build();
        //第二个参数，与地图边缘边距
        aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 30));
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

}

