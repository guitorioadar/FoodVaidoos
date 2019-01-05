package com.vaidoos.foodvaidoos.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.vaidoos.foodvaidoos.R;

public class BottomSheetImageChoose {

    private Context context;
    private BottomSheetDialog mBottomSheetDialog;
    private TextView name,address;

    public BottomSheetImageChoose(Context context) {
        this.context = context;
    }

    public void showBottomSheet(){

        /*final View view = getLayoutInflater().inflate(R.layout.sheet_basic, null);
        ((TextView) view.findViewById(R.id.name)).setText(people.name);
        ((TextView) view.findViewById(R.id.address)).setText(R.string.middle_lorem_ipsum);
        (view.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetDialog.dismiss();
            }
        });*/

        mBottomSheetDialog = new BottomSheetDialog(context,R.style.SheetDialog);
        mBottomSheetDialog.setContentView(R.layout.sheet_temp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        //mBottomSheetDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        /*name = mBottomSheetDialog.findViewById(R.id.name);
        name.setText("This is the name");
        address = mBottomSheetDialog.findViewById(R.id.address);
        address.setText("This is the content and the address");*/

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }

}
