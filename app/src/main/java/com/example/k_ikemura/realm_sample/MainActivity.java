package com.example.k_ikemura.realm_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRealm();
    }

    private void initRealm() {
        RealmConfiguration realmConfiguration
                = new RealmConfiguration.Builder()
                .name("app_cache.realm")
                .schemaVersion(0)
                .migration(new MyRealmMigration())
                .build();
        Realm realm = Realm.getInstance(realmConfiguration);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
