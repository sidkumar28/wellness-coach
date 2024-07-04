package com.example.wellnesscoach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder>{

    private Context context;
    private ArrayList customer_snum,customer_date,customer_name,customer_mob,customer_city,customer_age,customer_weight,
            customer_iweight,customer_extra,customer_less,customer_bodyfat,customer_visceralfat,customer_restmeta
            ,customer_bmi,customer_bodyage,customer_wholebodysub,customer_trunkfat,customer_armfat,customer_legfat,
            customer_skelmuscle,customer_trunkmus,customer_armmus,customer_legmus;

    CustomerAdapter(Context context,
                    ArrayList customer_snum,
                    ArrayList customer_date,
                    ArrayList customer_name,
                    ArrayList customer_mob
                    ){
        this.context=context;
        this.customer_snum= customer_snum;
        this.customer_date=customer_date;
        this.customer_name=customer_name;
        this.customer_mob=customer_mob;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.cust_serial_num.setText(String.valueOf(customer_snum.get(position)));
    holder.custname.setText(String.valueOf(customer_name.get(position)));
    holder.mobile_txt.setText(String.valueOf(customer_mob.get(position)));
    holder.reg_date.setText(String.valueOf(customer_date.get(position)));
    }

    @Override
    public int getItemCount() {
        return customer_snum.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cust_serial_num,custname,mobile_txt,reg_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cust_serial_num = itemView.findViewById(R.id.cust_serial_num);
            custname = itemView.findViewById(R.id.custname);
            mobile_txt = itemView.findViewById(R.id.mobile_txt);
            reg_date = itemView.findViewById(R.id.reg_date);
        }
    }
}
