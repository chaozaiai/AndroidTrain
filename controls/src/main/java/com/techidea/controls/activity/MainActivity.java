package com.techidea.controls.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.techidea.controls.R;
import com.techidea.controls.wiget.MessageDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.textview_spinner)
    void textviewSpinnerClick() {
        startActivity(new Intent(this, SpinnerActivity.class));
    }

    @OnClick(R.id.textview_radiolist)
    void textviewRadioList() {
        startActivity(new Intent(this, RadioListActivity.class));
    }

    @OnClick(R.id.textview_commondialog)
    void msgDialog() {
        showMessageDialog("messagdialog");
    }

    @OnClick(R.id.textview_startapp)
    void startApp() {
        AppUtil.startAppByPackageName(this, "com.techidea.demand");
    }

    @OnClick(R.id.textview_appcompat)
    void appcompat() {
        startActivity(new Intent(this, AppCompatTestActivity.class));
    }

    @OnClick(R.id.textview_vedio)
    void vedioClick() {
        startActivity(new Intent(this, VedioActivity.class));
//        try {
//            String vedio_url = "https://html5demos.com/assets/dizzy.mp4";
//            Uri uri = Uri.parse(vedio_url);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            Log.v("URI:::::::::", uri.toString());
//            intent.setDataAndType(uri, "video/*");
//            startActivity(intent);
//        } catch (ActivityNotFoundException nofound) {
//            nofound.printStackTrace();
//            Log.d("TAG", "notfound");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();

    }

    public void showMsg(String msg) {
        if (coordinatorLayout != null) {
            Snackbar snackbar = Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_LONG)
                    .setAction("Action", null);
            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.orangeLevel));
            ((TextView) snackbar.getView().findViewById(R.id.snackbar_text))
                    .setTextColor(getResources().getColor(R.color.white));
            snackbar.show();
        }
    }

    private void showMessageDialog(String msg) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prv = getSupportFragmentManager().findFragmentByTag("msg");
        if (prv != null) {
            ft.remove(prv);
        }
        ft.addToBackStack(null);
        final MessageDialog newFragment = MessageDialog.newInstance();
        newFragment.setMessage(msg);
        newFragment.setConfirmListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg("confirmListener");
                newFragment.dismiss();
            }
        });
        newFragment.show(ft, "msg");
    }

}
