package com.example.k_ikemura.realm_sample;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;

class MyRealmMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0) {
            RealmObjectSchema schema = realm.getSchema().get("CouponListItem");
            schema.addField("couponId", Integer.class);
        }
    }
}
