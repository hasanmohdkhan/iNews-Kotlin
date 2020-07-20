package khan.zian.hasan.inews_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import khan.zian.hasan.inews_kotlin.R
import khan.zian.hasan.inews_kotlin.adapter.Adapter
import khan.zian.hasan.inews_kotlin.databinding.HomeFragmentBinding
import khan.zian.hasan.inews_kotlin.network.News
import khan.zian.hasan.inews_kotlin.others.PaginationScrollListener
import timber.log.Timber


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private  val viewModel : HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private val loading = false
    private val lastPage = false
    private val TOTAL_PAGES = 50
    private val list = mutableListOf<News>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("Fragment")
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = Adapter()
        adapter.submitList(list)

        viewModel.viewState.observe(viewLifecycleOwner, Observer {
           state ->
            when(state){
                is HomeViewModel.ViewState.Success-> {

                    for ( i in state.List){
                        list.add(i)
                    }

                    adapter.notifyDataSetChanged()
                    binding.recycler.smoothScrollToPosition(list.size - state.List.size)

                    Timber.d("list live data observer " + list.size)
                }
                is HomeViewModel.ViewState.Loading->{
                    if(state.isLoading){
                        Toast.makeText(context,"Loading...",Toast.LENGTH_SHORT).show()
                    }
                }
                is HomeViewModel.ViewState.Failed->{}

            }
        })


        binding.recycler.adapter = adapter

        val layout = LinearLayoutManager(requireContext())
        binding.recycler.layoutManager = layout

        binding.recycler.addOnScrollListener(object : PaginationScrollListener(layout) {
            override fun isLastPage(): Boolean {
                return lastPage
            }

            override fun isLoading(): Boolean {
                Timber.d("isLoading ...... ")
                return loading
            }

            override fun loadMoreItems() {
                viewModel.nextPage()
            }
        })

    }

}
