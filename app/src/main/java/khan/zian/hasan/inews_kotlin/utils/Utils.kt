package khan.zian.hasan.inews_kotlin.utils

import android.R
import android.annotation.SuppressLint
import com.bumptech.glide.request.RequestOptions
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class Utils {

    companion object {
        /**
         * formats the date in the required format
         *
         * @param publishDate date to be formatted
         * @return formatted date in the form of a string
         */
        fun formatDate(publishDate: String?): String? {
            var formattedDate = ""
            //define input date format
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            //define output date format
            val output = SimpleDateFormat("dd MMM yyyy, HH:mm ", Locale.getDefault())
            try {
                //parse and format the input date
                val date: Date = input.parse(publishDate)
                formattedDate = output.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return formattedDate
        }
    }


}