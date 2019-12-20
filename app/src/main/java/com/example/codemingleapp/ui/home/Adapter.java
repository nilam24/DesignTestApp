package com.example.codemingleapp.ui.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codemingleapp.R;
import com.example.codemingleapp.model.Example;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.StatusViewHolder> {

    Context context;
    ArrayList<Example>list=new ArrayList<>();
    Adapter(Context context){
        this.context=context;
    }
    public void setData(ArrayList<Example>list){

        this.list=list;
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        StatusViewHolder statusViewHolder=new StatusViewHolder(rootView);
        return statusViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StatusViewHolder holder, int position) {

//        if(list.isEmpty()){
//            holder.text1.setText("Address");
//            holder.text2.setText("CompanyName");
//            holder.text3.setText("ClientMobileNo");
//            holder.text4.setText("Occupation");
//            holder.text5.setText("CompanyName");
//            String name="Mname";
//            holder.textImage.setText(name.charAt(0)+"");
//        }
//        else {
        Example example=list.get(position);
        holder.text1.setText(example.getAddressDes());
        holder.text2.setText(example.getClientCompanyName());
        holder.text3.setText(example.getClientMobileNo());
        holder.text4.setText(example.getOccupation());
        holder.text5.setText(example.getClientCompanyName());
        String name=example.getClientCompanyName();
        Log.e("","name--"+name);
        holder.textImage.setText(name.charAt(0)+"");
        int colorRes=0;


        switch (position % 4){
            case 0:{
             Drawable drawable=context.getResources().getDrawable(R.drawable.roundedcorner);
             holder.textImage.setBackground(drawable);

             break;
            }
            case 1:{
                Drawable drawable=context.getResources().getDrawable(R.drawable.roundedcorner2);
                holder.textImage.setBackground(drawable);
               break;
            }
            case 2:{
                Drawable drawable=context.getResources().getDrawable(R.drawable.roundedcorner3);
                holder.textImage.setBackground(drawable);
              break;
            }
            case 3:{
                Drawable drawable=context.getResources().getDrawable(R.drawable.roundedcorner4);
                holder.textImage.setBackground(drawable);
              break;
            }


        }
      //  drawable= Resources.getSystem().getDrawable(R.drawable.roundedcorner,null);
       // drawable.setColorFilter(colorRes,PorterDuff.Mode.SRC_ATOP);
        //holder.textImage.setBackgroundColor(ContextCompat.getColor(context,colorRes));

//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_dashboard);
//                Toast.makeText(holder.view.getContext(),"clicked",Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class StatusViewHolder extends RecyclerView.ViewHolder{


        TextView text1,text2,text3,text4,text5,textImage,
         view;

    public StatusViewHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView.findViewById(R.id.button);
        text1=itemView.findViewById(R.id.text1);
        text2=itemView.findViewById(R.id.text2);
        text3=itemView.findViewById(R.id.text3);
        text4=itemView.findViewById(R.id.text4);
        text5=itemView.findViewById(R.id.textTitle);
        textImage=itemView.findViewById(R.id.text11);

    }
}
}
