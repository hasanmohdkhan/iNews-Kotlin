package khan.zian.hasan.inews_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import khan.zian.hasan.inews_kotlin.network.Network
import khan.zian.hasan.inews_kotlin.network.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class HomeViewModel : ViewModel() {


    private val defaultValue: Int = 1
    private val apiKey = "441da542-bd64-4060-b81c-eff647cb6f27"
    private val showFields = "all"

    /* This is for getting news item list */
    private val _newsList = MutableLiveData<List<News>>()
    private val _viewState = MutableLiveData<ViewState>()
    val newsList: LiveData<List<News>> = _newsList
    val viewState: LiveData<ViewState> = _viewState

    private val _nextPage = MutableLiveData<Int>()

    //  val page :LiveData<Int> = _nextPage
    private var count: Int = defaultValue
    private var isLoading: Boolean = false


    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        Timber.d("init running....")
        _nextPage.value = count
        viewModelScope.launch {
            Timber.d("init running.... launch")
            refreshVideos()
        }
    }

    fun nextPage() {
        if (!isLoading) {
            count += 1
            Timber.d("nextPage running....  $count ")
            viewModelScope.launch { refreshVideos() }
        }
    }

    private suspend fun refreshVideos() {
        isLoading = true
        _viewState.postValue(ViewState.Loading(isLoading))

        withContext(Dispatchers.IO) {
            Timber.d("Network request")
            val playlist = Network.news.getResponseAsync(apiKey, showFields, count).await()

            val list = playlist.response?.news

//            Timber.d("url " + (list?.size ?: "No response"))

            if (list != null) {
                _viewState.postValue(ViewState.Success(list))
                isLoading = false
                ViewState.Loading(isLoading)
              //  _viewState.postValue(ViewState.Loading(isLoading))
                for (i in list) {
                    Timber.d("Heading : " + (i.webTitle))
                }
            }

        }
    }

    sealed class ViewState {
        // loading return a boolean
        data class Loading(val isLoading: Boolean) : ViewState()

        //success must return real object in this case news objects list
        data class Success(val List: List<News>) : ViewState()

        // failed return a error msg
        data class Failed(val error: String) : ViewState()

    }

}
