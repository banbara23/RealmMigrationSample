package com.example.k_ikemura.realm_sample;

import android.text.TextUtils;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

class MyRealmMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        RealmObjectSchema listSchema = realm.getSchema().get("CouponListItem");
        if (oldVersion == 0) {
            RealmObjectSchema categorySchema = null;
            if (!schema.contains("CouponCategory")) {
                categorySchema
                        = schema.create("CouponCategory")
                        .addField("categoryId", Integer.class, FieldAttribute.REQUIRED);
            }
            if (!listSchema.hasField("couponId")) {
                listSchema.addField("couponId", Integer.class, FieldAttribute.REQUIRED);
                if (listSchema.hasField("id")) {
                    listSchema.transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            if (TextUtils.isEmpty(obj.getString("id"))) {
                                obj.set("couponId", 0);
                            } else {
                                obj.set("couponId", Integer.valueOf(obj.getString("id")));
                            }
                        }
                    });
                }
            }
            if (listSchema.hasField("id")) {
                listSchema.removeField("id");
            }
            if (!listSchema.hasField("shopId")) {
                listSchema.addField("shopId", String.class);
            }
            if (!listSchema.hasField("periodDate")) {
                listSchema.addField("periodDate", String.class);
                if (listSchema.hasField("data")) {
                    listSchema.transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("periodDate", obj.getString("data"));
                        }
                    });
                }
            }
            if (listSchema.hasField("date")) {
                listSchema.removeField("date");
            }
            if (!listSchema.hasField("periodTimeStamp")) {
                listSchema.addField("periodTimeStamp", Long.class, FieldAttribute.REQUIRED);
            }
            if (!listSchema.hasField("startData")) {
                listSchema.addField("startData", String.class);
            }
            if (!listSchema.hasField("startDataTimeStamp")) {
                listSchema.addField("startDataTimeStamp", Long.class, FieldAttribute.REQUIRED);
            }
            if (!listSchema.hasField("couponType")) {
                listSchema.addField("couponType", Integer.class, FieldAttribute.REQUIRED);
            }
            if (!listSchema.hasField("couponCategoryIds")) {
                listSchema.addRealmListField("couponCategoryIds", categorySchema);
            }
            if (!listSchema.hasField("isToshin")) {
                listSchema.addField("isToshin", Integer.class, FieldAttribute.REQUIRED);
            }
        }
    }
}
