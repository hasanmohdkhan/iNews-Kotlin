package khan.zian.hasan.inews_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import khan.zian.hasan.inews_kotlin.network.Network
import khan.zian.hasan.inews_kotlin.network.News
import kotlinx.coroutines.*
import timber.log.Timber

class HomeViewModel : ViewModel() {


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

    /* This is for getting news item list */
    private  val  _newsList = MutableLiveData<List<News>>()
    val newsList : LiveData<List<News>> = _newsList


    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        Timber.d("init running....")
        viewModelScope.launch {
            Timber.d("init running.... lauch")
            refreshVideos()

        }
    }


    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            Timber.d("Network request")
            val playlist = Network.news.getResponse("441da542-bd64-4060-b81c-eff647cb6f27", "all").await()
            val list = playlist.response?.news
            Timber.d("url "+ (list?.size ?:"No response" ))

            if(list != null){
                _newsList.postValue(list)
                for ( i in list ){
                    Timber.d("Heading : "+ (i.webTitle ))
                }
            }


        }
    }
}
