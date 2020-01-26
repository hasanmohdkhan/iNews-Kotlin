package khan.zian.hasan.inews_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import khan.zian.hasan.inews_kotlin.R

class InewsHomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = InewsHomeScreenFragment()
    }

    private lateinit var viewModel: InewsHomeScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.inews_home_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InewsHomeScreenViewModel::class.java)
        // TODO: Use the ViewModel



    }


}
