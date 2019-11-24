package com.example.codemingleapp.ui.home;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.logging.Handler;

public class MyItemClickListener implements RecyclerView.OnItemTouchListener {

    GestureDetector gestureDetectorCompat;
    Context context;
    interface TouchClick{
        void SwipLeft(View view,int Pos);
        void SwipRight(View view,int Pos);
        void OnTouch(View view, int Pos);

    }
    TouchClick touchClick;
    MyItemClickListener(Context context, final RecyclerView recyclerView, final TouchClick touchClick){
        this.touchClick=touchClick;
        this.context=context;
        this.gestureDetectorCompat=new GestureDetector(context, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View view= recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
               if((touchClick!=null)&&(view!=null)){
                   touchClick.OnTouch(view,recyclerView.getChildAdapterPosition(view));

               }

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        });
    }
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        if((touchClick!=null)&&(gestureDetectorCompat!=null)){
            int pos=rv.getChildAdapterPosition(rv.findChildViewUnder(e.getX(),e.getY()));
            touchClick.OnTouch(rv.findChildViewUnder(e.getX(),e.getY()),pos);
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
