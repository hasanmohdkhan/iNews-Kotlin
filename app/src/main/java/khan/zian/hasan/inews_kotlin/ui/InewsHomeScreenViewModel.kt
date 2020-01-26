package khan.zian.hasan.inews_kotlin.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import khan.zian.hasan.inews_kotlin.network.Network
import kotlinx.coroutines.*

class InewsHomeScreenViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    /**
     * This is the job for all coroutines started by this ViewModel.
     *
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     *
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling
     * viewModelJob.cancel()
     */
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        viewModelScope.launch {
            refreshVideos()
        }
    }


    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            val playlist = Network.news.getResponse().await()
            Log.d("url",""+ (playlist.response?.results?.size ?:"No response" ))
        }
    }
}
