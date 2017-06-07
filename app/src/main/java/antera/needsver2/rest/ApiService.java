package antera.needsver2.rest;

import antera.needsver2.model.Bangunan;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fajar on 5/12/2017.
 */

public interface ApiService {
    @GET("getBangunan.php")
    Call<Bangunan> getBangunan();
}
