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

            listSchema.addField("couponId", Integer.class, FieldAttribute.REQUIRED)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            if (TextUtils.isEmpty(obj.getString("id"))) {
                                obj.set("couponId", 0);
                            } else {
                                obj.set("couponId", Integer.valueOf(obj.getString("id")));
                            }
                        }
                    })
                    .removeField("id")
                    .addField("shopId", String.class)
                    .addField("periodDate", String.class)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("periodDate", obj.getString("data"));
                        }
                    })
                    .removeField("date")
                    .addField("periodTimeStamp", Long.class, FieldAttribute.REQUIRED)
                    .addField("startData", String.class)
                    .addField("startDataTimeStamp", Long.class, FieldAttribute.REQUIRED)
                    .addField("couponType", Integer.class, FieldAttribute.REQUIRED)
                    .addRealmListField("couponCategoryIds", categorySchema)
                    .addField("isToshin", Integer.class, FieldAttribute.REQUIRED);
        }
    }
}
