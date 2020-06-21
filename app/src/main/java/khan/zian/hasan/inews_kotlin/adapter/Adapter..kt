package khan.zian.hasan.inews_kotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import khan.zian.hasan.inews_kotlin.R
import khan.zian.hasan.inews_kotlin.databinding.NewsItemBinding
import khan.zian.hasan.inews_kotlin.network.News
import khan.zian.hasan.inews_kotlin.utils.Utils


class Adapter : ListAdapter<News, Adapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val from = LayoutInflater.from(parent.context)
        val newsItemBinding : NewsItemBinding = DataBindingUtil.inflate(from,R.layout.news_item, parent, false)

        return ViewHolder(newsItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            val context = binding.cardView.context

            return with(binding) {

                binding.heading.text = news.webTitle
                // Format string to format
                val formattedString: String? = Utils.formatDate(news.webPublicationDate)
                binding.date.text = formattedString
                binding.section.text = news.sectionName
                binding.author.text = "by " + news.fields.authors

                Glide.with(context).setDefaultRequestOptions(requestOptions())
                                   .load(news.fields.thumbnail)
                                   .into(binding.image)
//                Glide.with(context).setDefaultRequestOptions(QueryUtils.requestOptions())
//                    .load(mList.get(position).getAuthorImage()).into(binding.mAuthorImage)


            }
        }

        /**
         * Glide place holder setup
         *
         * @return RequestOptions
         */
        @SuppressLint("CheckResult")
        fun requestOptions(): RequestOptions {
            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.drawable.ic_launcher_foreground)
            requestOptions.error(R.drawable.gurdian)
            return requestOptions
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}