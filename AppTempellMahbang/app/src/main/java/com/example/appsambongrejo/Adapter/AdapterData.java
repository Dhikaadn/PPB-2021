package com.example.appsambongrejo.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appsambongrejo.API.APIRequestData;
import com.example.appsambongrejo.Database;
import com.example.appsambongrejo.Model.DataModel;
import com.example.appsambongrejo.R;
import com.example.appsambongrejo.ResponseModel;
import com.example.appsambongrejo.RetroServer;
import com.example.appsambongrejo.UpdateActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listHotel;
    private int idBelanja;
    private List<DataModel> listBelanja;

    public AdapterData(Context ctx, List<DataModel> listHotel) {
        this.ctx = ctx;
        this.listHotel = listHotel;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm =listHotel.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvPaket1.setText(dm.getPaket1());
        holder.tvPaket2.setText(dm.getPaket2());
        holder.tvPaket3.setText(dm.getPaket3());
        holder.tvPaket4.setText(dm.getPaket4());
        holder.tvPaket5.setText(dm.getPaket5());
        holder.tvPaket6.setText(dm.getPaket6());
        holder.tvTotal.setText(dm.getTotal());
        holder.tvHarga.setText(dm.getHarga());
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView  tvId, tvPaket1, tvPaket2, tvPaket3, tvPaket4, tvPaket5, tvPaket6, tvTotal, tvHarga;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvPaket1 = itemView.findViewById(R.id.tv_paket1);
            tvPaket2 = itemView.findViewById(R.id.tv_paket2);
            tvPaket3 = itemView.findViewById(R.id.tv_paket3);
            tvPaket4 = itemView.findViewById(R.id.tv_paket4);
            tvPaket5 = itemView.findViewById(R.id.tv_paket5);
            tvPaket6 = itemView.findViewById(R.id.tv_paket6);
            tvTotal = itemView.findViewById(R.id.tv_total);
            tvHarga = itemView.findViewById(R.id.tv_harga);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih operasi yang akan dilakukan!");
                    dialogPesan.setCancelable(true);

                    idBelanja = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            ((Database)ctx).retrieveData();
                        }
                    });

                    dialogPesan.setNegativeButton("ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.show();
                    return false;
                }
            });
        }

        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idBelanja);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                }
            });
        }

        private void getData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> ambilData = ardData.ardGetData(idBelanja);

            ambilData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    listBelanja = response.body().getData();

                    int varIdBelanja = listBelanja.get(0).getId();
                    String varPaket1Belanja = listBelanja.get(0).getPaket1();
                    String varPaket2Belanja = listBelanja.get(0).getPaket2();
                    String varPaket3Belanja = listBelanja.get(0).getPaket3();
                    String varPaket4Belanja = listBelanja.get(0).getPaket4();
                    String varPaket5Belanja = listBelanja.get(0).getPaket5();
                    String varPaket6Belanja = listBelanja.get(0).getPaket6();
                    String varTotalBelanja = listBelanja.get(0).getTotal();
                    String varHargaBelanja = listBelanja.get(0).getHarga();

                    Intent kirim = new Intent(ctx, UpdateActivity.class);
                    kirim.putExtra("xId", varIdBelanja);
                    kirim.putExtra("xPaket1", varPaket1Belanja);
                    kirim.putExtra("xPaket2", varPaket2Belanja);
                    kirim.putExtra("xPaket3", varPaket3Belanja);
                    kirim.putExtra("xPaket4", varPaket4Belanja);
                    kirim.putExtra("xPaket5", varPaket5Belanja);
                    kirim.putExtra("xPaket6", varPaket6Belanja);
                    kirim.putExtra("xTotal", varTotalBelanja);
                    kirim.putExtra("xHarga", varHargaBelanja);
                    ctx.startActivity(kirim);

                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                }
            });
        }
    }
}

