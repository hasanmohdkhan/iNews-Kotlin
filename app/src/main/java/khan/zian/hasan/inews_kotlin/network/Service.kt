package khan.zian.hasan.inews_kotlin.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface NewsService {

    @GET("search?api-key=441da542-bd64-4060-b81c-eff647cb6f27")
    fun getResponse() : Deferred<NetworkResponse>
}

private val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                         .build()

object Network {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://content.guardianapis.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val news = retrofit.create(NewsService::class.java)


}