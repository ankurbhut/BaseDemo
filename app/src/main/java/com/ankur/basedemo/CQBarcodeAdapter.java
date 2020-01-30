package com.ankur.basedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ankur.basedemo.db.dbmodel.SyncCG;

import java.util.List;

public class CQBarcodeAdapter extends RecyclerView.Adapter<CQBarcodeAdapter.ViewHolder> {

    private final List<SyncCG> lpStockList;
    private Context mContext;
    private ClickListener mClickListener;


    public CQBarcodeAdapter(Context mContext, List<SyncCG> lpStockList) {
        this.mContext = mContext;
        this.lpStockList = lpStockList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barcode, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        if (position == 0) {
            // Header Cells. Main Headings appear here
            holder.mTvSoNo.setText(mContext.getResources().getString(R.string.so_no));
            holder.mTvItemCode.setText(mContext.getResources().getString(R.string.item_code));
            holder.mTvBatch.setText(mContext.getResources().getString(R.string.batch));
            holder.mTvQty.setText(mContext.getResources().getString(R.string.serial_number));


            holder.mTvSoNo.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle_white));
            holder.mTvItemCode.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle_white));
            holder.mTvBatch.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle_white));
            holder.mTvQty.setBackground(mContext.getResources().getDrawable(R.drawable.rectangle_white));


            holder.mTvSoNo.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.mTvItemCode.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.mTvBatch.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.mTvQty.setTextColor(mContext.getResources().getColor(R.color.white));

        } else {
            SyncCG bean = lpStockList.get(position - 1);
            holder.mTvSoNo.setText(String.valueOf(bean.getSoNO()));
            holder.mTvItemCode.setText(String.valueOf(bean.getItemCode()));
            holder.mTvBatch.setText(String.valueOf(bean.getBatch()));
            holder.mTvQty.setText(String.valueOf(bean.getSerialNo()));

        }

    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lpStockList.size() + 1;
    }

    public SyncCG getItem(int position) {
        return lpStockList.get(position);
    }

    public void clear() {
        int size = lpStockList.size();
        lpStockList.clear();
        notifyItemRangeRemoved(0, size);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvSoNo;
        private TextView mTvItemCode;
        private TextView mTvBatch;
        private TextView mTvQty;

        ViewHolder(View view) {
            super(view);
            mTvSoNo = (TextView) itemView.findViewById(R.id.tvSoNo);
            mTvItemCode = (TextView) itemView.findViewById(R.id.tvItemCode);
            mTvBatch = (TextView) itemView.findViewById(R.id.tvBatch);
            mTvQty = (TextView) itemView.findViewById(R.id.tvQty);

            //mTvViewStock.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

}
