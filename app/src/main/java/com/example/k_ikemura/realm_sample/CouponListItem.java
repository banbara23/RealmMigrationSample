package com.example.k_ikemura.realm_sample;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CouponListItem extends RealmObject {

    private String shopId;

    private int couponId;

    private String name;

    private String thumbnail;

    private int type;

    private String periodDate;

    private long periodTimeStamp;

    private int isRead;

    private String shopFloorName;
    private String brandName;

    private String onlineStoreType;
    private String startData;

    private long startDataTimeStamp;
    private int couponType;
    private RealmList<CouponCategory> couponCategoryIds;

    private int isToshin;
}

