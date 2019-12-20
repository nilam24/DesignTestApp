package com.example.codemingleapp.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.codemingleapp.R;
import com.example.codemingleapp.model.Example;
import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {


    ArrayList<Example>list=new ArrayList<>();
    Context context;
    ProfileAdapter(){

    }
    ProfileAdapter(Context context){
        this.context=context;
    }
    public void setData(ArrayList<Example>list){
        this.list.clear();
        this.list=list;
    }
    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item_layout,parent,false);
       ProfileViewHolder profileViewHolder=new ProfileViewHolder(view);
        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {

        if(list.isEmpty()){
            holder.text6.setText("clientMobileNo");
            holder.emergencyNum.setText("EMail");
            holder.compName.setText("MName");
            holder.text4.setText("MName");
        }

        Example examples=list.get(position);
        examples.getOccupation();
        holder.text6.setText(examples.getClientMobileNo());
        holder.emergencyNum.setText(examples.getEMail());
        holder.compName.setText(examples.getClientCompanyName());
        examples.getAddressDes();
        examples.getCityId();
        examples.getClientNo();
        examples.getCountryId();
//        holder.emailText.setText(examples.getEMail());
        holder.text4.setText(examples.getClientCompanyName());
        examples.getDob();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder{

        ImageView backArrow,externalLink,profilImage,img1,img2,img3,img4;
        TextView text1,compName,text3,text4,text5,text6,text7,emergencyNum,emailText,nameText;
        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.imgProfile1);
            img2=itemView.findViewById(R.id.imgProfile2);
            img3=itemView.findViewById(R.id.imgProfile3);
            img4=itemView.findViewById(R.id.imgProfile4);

            text1=itemView.findViewById(R.id.text11);
            compName=itemView.findViewById(R.id.text12);
            text3=itemView.findViewById(R.id.text31);
            text4=itemView.findViewById(R.id.text32);
            text5=itemView.findViewById(R.id.text21);
            text6=itemView.findViewById(R.id.text22);
            text7=itemView.findViewById(R.id.text41);
            emergencyNum=itemView.findViewById(R.id.text42);
            emailText=itemView.findViewById(R.id.email);
            nameText=itemView.findViewById(R.id.name);
        }
    }
}
