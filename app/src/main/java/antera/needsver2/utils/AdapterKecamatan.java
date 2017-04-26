package antera.needsver2.utils;

/**
 * Created by Fajar on 4/26/2017.
 */

        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

        import antera.needsver2.R;
        import antera.needsver2.model.Kecamatan;

public class AdapterKecamatan extends RecyclerView.Adapter<AdapterKecamatan.MyViewHolder> {

    private List<Kecamatan> kecamatanList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView kecamatan;

        public MyViewHolder(View view) {
            super(view);
            kecamatan = (TextView) view.findViewById(R.id.tv_kecamatan);
        }
    }


    public AdapterKecamatan(List<Kecamatan> moviesList) {
        this.kecamatanList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_kecamatan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Kecamatan kecamatan = kecamatanList.get(position);
        String kecafullname = kecamatan.getKecamatan()+", "+kecamatan.getKota()+", "+kecamatan.getProvinsi();
        holder.kecamatan.setText(kecafullname);
    }

    @Override
    public int getItemCount() {
        return kecamatanList.size();
    }
}