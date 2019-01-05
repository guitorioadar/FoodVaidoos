package com.vaidoos.foodvaidoos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vaidoos.foodvaidoos.R;
import com.vaidoos.foodvaidoos.activity.profile.ProfileChangePasswordActivity;
import com.vaidoos.foodvaidoos.activity.profile.ProfileEditActivity;
import com.vaidoos.foodvaidoos.activity.profile.ProfileShippingActivity;

public class UserProfileFragment extends Fragment{

    private TextView btnProfileEdit;
    private TextView tvProChangePass;
    private TextView tvProShipping;

    public UserProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        initializeView(view);

        btnProfileEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProfileEditActivity.class));
            }
        });

        tvProChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProfileChangePasswordActivity.class));
            }
        });

        tvProShipping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProfileShippingActivity.class));
            }
        });

        return view;
    }

    private void initializeView(View view) {

        btnProfileEdit = view.findViewById(R.id.btnProfileEdit);

        tvProChangePass = view.findViewById(R.id.tvProChangePass);
        tvProShipping = view.findViewById(R.id.tvProShipping);

    }

}
