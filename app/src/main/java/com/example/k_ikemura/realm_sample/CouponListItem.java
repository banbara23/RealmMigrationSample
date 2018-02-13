package com.example.k_ikemura.realm_sample;

import io.realm.RealmObject;

public class CouponListItem extends RealmObject {

    String id;

    String name;

    String thumbnail;

    int type;

    String date;

    int isRead;

    String shopFloorName;

    String brandName;

    String onlineStoreType;
}

