package com.example.k_ikemura.realm_sample;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CouponListItem extends RealmObject {

    private String shopId;

    private Integer couponId;

    private String name;

    private String thumbnail;

    private Integer type;

    private String periodDate;

    private Long periodTimeStamp;

    private Integer isRead;

    private String shopFloorName;
    private String brandName;

    private String onlineStoreType;
    private String startData;

    private Long startDataTimeStamp;
    private Integer couponType;
    private RealmList<CouponCategory> couponCategoryIds;

    private Boolean isToshin;
}

