package com.vaidoos.foodvaidoos.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.vaidoos.foodvaidoos.R;

public class DialogLogOut extends Dialog implements android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public DialogLogOut(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_log_out);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        yes = (Button) findViewById(R.id.btnDigLogLoginOut);
        no = (Button) findViewById(R.id.btnDigLogCancle);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDigLogLoginOut:
                c.finish();
                break;
            case R.id.btnDigLogCancle:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}