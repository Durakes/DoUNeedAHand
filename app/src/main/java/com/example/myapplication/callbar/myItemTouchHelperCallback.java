package com.example.myapplication.callbar;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adaptadores.RecycleViewTarjetas;
import com.example.myapplication.interfaces.CallBackItemTouch;

public class myItemTouchHelperCallback extends ItemTouchHelper.Callback {

    CallBackItemTouch callBackItemTouch;

    public myItemTouchHelperCallback(CallBackItemTouch callBackItemTouch) {
        this.callBackItemTouch = callBackItemTouch;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final int dragflags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swripeflags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragflags,swripeflags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

        callBackItemTouch.itemTouchOnMode(viewHolder.getAdapterPosition(),
                target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        callBackItemTouch.onSwiped(viewHolder,viewHolder.getAdapterPosition());

    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if(actionState==ItemTouchHelper.ACTION_STATE_DRAG){
            super.onChildDraw(c,recyclerView,
                    viewHolder,dX,dY,actionState,isCurrentlyActive);
        }else   {
            final View foregorundView =((RecycleViewTarjetas.ViewHolder)viewHolder).viewB;
            getDefaultUIUtil().onDrawOver(c,recyclerView,
                    foregorundView,dX,dY,actionState,isCurrentlyActive);

        }
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if(actionState!=ItemTouchHelper.ACTION_STATE_DRAG){
            final View foregorundView =((RecycleViewTarjetas.ViewHolder)viewHolder).viewF;
            getDefaultUIUtil().onDraw(c,recyclerView, foregorundView,dX,dY,
                    actionState,isCurrentlyActive);
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final View foregorundView =((RecycleViewTarjetas.ViewHolder)viewHolder).viewF; //la lista
        foregorundView.setBackgroundColor(ContextCompat.getColor(((
                RecycleViewTarjetas.ViewHolder
                )viewHolder).viewF.getContext(),R.color.white));
        getDefaultUIUtil().clearView(foregorundView);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if(viewHolder!=null)    {
            final View foregorundView =((RecycleViewTarjetas.ViewHolder)viewHolder).viewF;
            if(actionState==ItemTouchHelper.ACTION_STATE_DRAG){
                foregorundView.setBackgroundColor(Color.LTGRAY);


            }
            getDefaultUIUtil().onSelected(foregorundView);
        }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }
}















