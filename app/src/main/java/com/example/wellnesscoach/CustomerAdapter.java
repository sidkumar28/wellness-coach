package com.example.wellnesscoach;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder>{

    private Context context;
    private Activity activity;
    private ArrayList customer_snum,customer_date,customer_name,customer_mob,customer_city,customer_age,customer_weight,
            customer_iweight,customer_extra,customer_less,customer_bodyfat,customer_visceralfat,customer_restmeta
            ,customer_bmi,customer_bodyage,customer_wholebodysub,customer_trunkfat,customer_armfat,customer_legfat,
            customer_skelmuscle,customer_trunkmus,customer_armmus,customer_legmus;


    CustomerAdapter(Activity activity,
                    Context context,
                    ArrayList customer_snum,
                    ArrayList customer_date,
                    ArrayList customer_name,
                    ArrayList customer_mob,
                    ArrayList customer_city,
                    ArrayList customer_age,
                    ArrayList customer_weight,
                    ArrayList customer_iweight,
                    ArrayList customer_extra,
                    ArrayList customer_less,
                    ArrayList customer_bodyfat,
                    ArrayList customer_visceralfat,
                    ArrayList customer_restmeta,
                    ArrayList customer_bmi,
                    ArrayList customer_bodyage,
                    ArrayList customer_wholebodysub,
                    ArrayList customer_trunkfat,
                    ArrayList customer_armfat,
                    ArrayList customer_legfat,
                    ArrayList customer_skelmuscle,
                    ArrayList customer_trunkmus,
                    ArrayList customer_armmus,
                    ArrayList customer_legmus
                    ){
        this.activity=activity;
        this.context=context;
        this.customer_snum= customer_snum;
        this.customer_date=customer_date;
        this.customer_name=customer_name;
        this.customer_mob=customer_mob;
        this.customer_city=customer_city;
        this.customer_age=customer_age;
        this.customer_weight=customer_weight;
        this.customer_iweight=customer_iweight;
        this.customer_extra=customer_extra;
        this.customer_less=customer_less;
        this.customer_bodyfat=customer_bodyfat;
        this.customer_visceralfat=customer_visceralfat;
        this.customer_restmeta=customer_restmeta;
        this.customer_bmi=customer_bmi;
        this.customer_bodyage=customer_bodyage;
        this.customer_wholebodysub=customer_wholebodysub;
        this.customer_trunkfat=customer_trunkfat;
        this.customer_armfat=customer_armfat;
        this.customer_legfat=customer_legfat;
        this.customer_skelmuscle=customer_skelmuscle;
        this.customer_trunkmus=customer_trunkmus;
        this.customer_armmus=customer_armmus;
        this.customer_legmus=customer_legmus;



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

        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Updatedata.class);
                intent.putExtra("num", String.valueOf(customer_snum.get(position)));
                intent.putExtra("date", String.valueOf(customer_date.get(position)));
                intent.putExtra("name", String.valueOf(customer_name.get(position)));
                intent.putExtra("mobile", String.valueOf(customer_mob.get(position)));
                intent.putExtra("city", String.valueOf(customer_city.get(position)));
                intent.putExtra("age", String.valueOf(customer_age.get(position)));
                intent.putExtra("weight", String.valueOf(customer_weight.get(position)));
                intent.putExtra("iweight", String.valueOf(customer_iweight.get(position)));
                intent.putExtra("extra", String.valueOf(customer_extra.get(position)));
                intent.putExtra("less", String.valueOf(customer_less.get(position)));
                intent.putExtra("bodyfat", String.valueOf(customer_bodyfat.get(position)));
                intent.putExtra("visceralfat", String.valueOf(customer_visceralfat.get(position)));
                intent.putExtra("restmeta", String.valueOf(customer_restmeta.get(position)));
                intent.putExtra("bmi", String.valueOf(customer_bmi.get(position)));
                intent.putExtra("bodyage", String.valueOf(customer_bodyage.get(position)));
                intent.putExtra("wholebodysub", String.valueOf(customer_wholebodysub.get(position)));
                intent.putExtra("trunkfat", String.valueOf(customer_trunkfat.get(position)));
                intent.putExtra("armfat", String.valueOf(customer_armfat.get(position)));
                intent.putExtra("legfat", String.valueOf(customer_legfat.get(position)));
                intent.putExtra("skelmus", String.valueOf(customer_skelmuscle.get(position)));
                intent.putExtra("trunkmus", String.valueOf(customer_trunkmus.get(position)));
                intent.putExtra("armmus", String.valueOf(customer_armmus.get(position)));
                intent.putExtra("legmus", String.valueOf(customer_legmus.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customer_snum.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cust_serial_num,custname,mobile_txt,reg_date;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cust_serial_num = itemView.findViewById(R.id.cust_serial_num);
            custname = itemView.findViewById(R.id.custname);
            mobile_txt = itemView.findViewById(R.id.mobile_txt);
            reg_date = itemView.findViewById(R.id.reg_date);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
