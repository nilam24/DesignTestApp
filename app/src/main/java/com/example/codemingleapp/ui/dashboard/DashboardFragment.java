package com.example.codemingleapp.ui.dashboard;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codemingleapp.R;
import com.example.codemingleapp.model.Example;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    ImageView backArrow,externalLink,profilImage,img1,img2,img3,img4;
    TextView text1,compName,text3,text4,text5,text6,text7,emergencyNum,emailText,nameText;
    RecyclerView recyclerView;
    ProfileAdapter profileAdapter=new ProfileAdapter(getContext());
    ArrayList<Example> arrayList=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        dashboardViewModel =
                ViewModelProviders.of(getActivity()).get(DashboardViewModel.class);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        backArrow=root.findViewById(R.id.backButton);
        externalLink=root.findViewById(R.id.link);
        profilImage=root.findViewById(R.id.imgProfile);
        recyclerView=root.findViewById(R.id.recyclerProfile);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
//        img1=root.findViewById(R.id.imgProfile1);
//        img2=root.findViewById(R.id.imgProfile2);
//        img3=root.findViewById(R.id.imgProfile3);
//        img4=root.findViewById(R.id.imgProfile4);
//
//        text1=root.findViewById(R.id.text11);
//        compName=root.findViewById(R.id.text12);;
//        text3=root.findViewById(R.id.text31);
//        text4=root.findViewById(R.id.text32);
//        text5=root.findViewById(R.id.text21);
//        text6=root.findViewById(R.id.text22);
//        text7=root.findViewById(R.id.text41);
//        emergencyNum=root.findViewById(R.id.text42);
        emailText=root.findViewById(R.id.email);
        nameText=root.findViewById(R.id.name);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_dashboard_to_navigation_home);
            }
        });

        externalLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"go to external link",Toast.LENGTH_LONG).show();
            }
        });
        dashboardViewModel.getProfileDetail().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example examples) {
              if(examples!=null){
                  emailText.setText(examples.getEMail());
                  nameText.setText(examples.getClientCompanyName());
                  arrayList.add(examples);
                  profileAdapter.setData(arrayList);
                  recyclerView.setAdapter(profileAdapter);
                  profileAdapter.notifyDataSetChanged();

              }
            }
        });
        return root;
    }
}