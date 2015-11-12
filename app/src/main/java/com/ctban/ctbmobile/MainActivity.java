package com.ctban.ctbmobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ctban.ctblib.controller.UserController;
import com.ctban.ctblib.ctbretro.CTBanServer;
import com.ctban.ctblib.ctbretro.bean.WeatherInfo;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable<WeatherInfo> weaInfo = CTBanServer.instance().getUserService().getWeather("101010100.html");
                weaInfo.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<WeatherInfo>() {
                            @Override
                            public final void onCompleted() {
                                // do nothing
                            }

                            @Override
                            public final void onError(Throwable e) {
//                                Log.e("GithubDemo", e.getMessage());
                            }

                            @Override
                            public final void onNext(WeatherInfo response) {
                                UserController controller = new UserController();
                                Log.v("dagger", "user  " + controller.getLoginUser());
                                ((TextView) findViewById(R.id.content))
                                        .setText(response.weatherinfo.getCity() + " temp "
                                                + response.weatherinfo.getTemp());
//                                ((TextView) findViewById(R.id.content))
//                                        .setText("onNext " + response);
                            }
                        });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
