package com.example.codemingleapp.ui.home;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.codemingleapp.ui.dashboard.DashboardViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private DashboardViewModel dm;
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Example>list=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
//        ActionBar actionBar=getActivity().getActionBar();
//        actionBar.hide();

        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        dm=ViewModelProviders.of(getActivity()).get(DashboardViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        recyclerView=root.findViewById(R.id.recycle);
        recyclerView.addOnItemTouchListener(new MyItemClickListener(getContext(), recyclerView, new MyItemClickListener.TouchClick() {
            @Override
            public void SwipLeft(View view, int Pos) {

            }

            @Override
            public void SwipRight(View view, int Pos) {

            }

            @Override
            public void OnTouch(View view, int Pos) {
                if(view!=null) {
                    TextView textViewClick = view.findViewById(R.id.button);
                    TextView name=view.findViewById(R.id.textTitle);
                    TextView loc=view.findViewById(R.id.text1);
                    TextView contact=view.findViewById(R.id.text2);
                    TextView email=view.findViewById(R.id.text3);
                    TextView desig=view.findViewById(R.id.text4);
                    String nm=name.getText().toString().trim();
                    String location=loc.getText().toString().trim();
                    String contac=contact.getText().toString().trim();
                    String emailId=email.getText().toString().trim();
                    String designation=desig.getText().toString().trim();
                    Example example2=new Example(nm,location,contac,emailId,designation);
                    list.add(example2);

                    if (view == null) return;
                    textViewClick.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_dashboard);
                            dm.setResponseProfile(list);

                        }
                    });
                }

            }
        }));
        adapter=new Adapter(getContext());

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        homeViewModel.getResponseData().observe(this, new Observer<List<Example>>() {
            @Override
            public void onChanged(List<Example> examples) {

                adapter.setData((ArrayList<Example>) examples);

                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


        return root;
    }
}