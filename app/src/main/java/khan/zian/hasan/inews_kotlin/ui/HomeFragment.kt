package khan.zian.hasan.inews_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import khan.zian.hasan.inews_kotlin.R
import khan.zian.hasan.inews_kotlin.adapter.Adapter
import khan.zian.hasan.inews_kotlin.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.view.*
import timber.log.Timber

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("Fragment")
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container, false)
        return  binding.root 
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val adapter = Adapter()
        view.recycler.adapter = adapter

        viewModel.newsList.observe(viewLifecycleOwner , Observer {
              adapter.submitList(it)
             Timber.d("list live data observer "+it.size)
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }


}
