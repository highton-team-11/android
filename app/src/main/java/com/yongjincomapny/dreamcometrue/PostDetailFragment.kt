package com.yongjincomapny.dreamcometrue

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ImageSpan
import android.text.style.QuoteSpan
import android.text.style.URLSpan
import android.util.Log
import android.view.View
import androidx.core.net.toUri
import androidx.core.text.HtmlCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.databinding.FragmentPostDetailBinding
import com.yongjincomapny.dreamcometrue.feature.ImageGetter
import com.yongjincomapny.dreamcometrue.feature.home.QuoteSpanClass
import kotlinx.coroutines.launch

class PostDetailFragment : BaseFragment<FragmentPostDetailBinding>(R.layout.fragment_post_detail) {

    override fun init() {
        super.init()
        val name = arguments?.getString("title") ?: ""

        val postApi = RetrofitClient.postApi()

        binding.icBack.setOnDebounceClickListener {
            findNavController().popBackStack()
        }

        lifecycleScope.launch {
            runCatching {
                postApi.fetchPostDetail(name)
            }.onSuccess {
                /*Glide.with(requireContext())
                    .load(it.cdnLink.toUri())
                    .into(binding.ivProfile)*/

                //binding.tvTitle.text = it.title
                displayHtml(it)
            }.onFailure {
                Log.d("TEST", it.toString())
            }
        }
    }

    private fun displayHtml(source: String) {
        // Creating object of ImageGetter class you just created
        val imageGetter = ImageGetter(resources, binding.tvContent)

        // Using Html framework to parse html
        val styledText =
            HtmlCompat.fromHtml(
                source, HtmlCompat.FROM_HTML_MODE_COMPACT, imageGetter, null
            )

        replaceQuoteSpans(styledText as Spannable)
        ImageClick(styledText as Spannable)

        // setting the text after formatting html and downloading and setting images
        binding.tvContent.text = styledText

        // to enable image/link clicking
        binding.tvContent.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun replaceQuoteSpans(spannable: Spannable) {
        val quoteSpans: Array<QuoteSpan> =
            spannable.getSpans(0, spannable.length - 1, QuoteSpan::class.java)

        for (quoteSpan in quoteSpans) {
            val start: Int = spannable.getSpanStart(quoteSpan)
            val end: Int = spannable.getSpanEnd(quoteSpan)
            val flags: Int = spannable.getSpanFlags(quoteSpan)
            spannable.removeSpan(quoteSpan)
            spannable.setSpan(
                QuoteSpanClass(
                    // background color
                    R.color.black,
                    // strip color
                    R.color.primary,
                    // strip width
                    10F, 50F
                ),
                start, end, flags
            )
        }
    }

    // Function to parse image tags and enable click events
    fun ImageClick(html: Spannable) {
        for (span in html.getSpans(0, html.length, ImageSpan::class.java)) {
            val flags = html.getSpanFlags(span)
            val start = html.getSpanStart(span)
            val end = html.getSpanEnd(span)
            html.setSpan(object : URLSpan(span.source) {
                override fun onClick(v: View) {
                    Log.d("Main", "onClick: url is ${span.source}")
                }
            }, start, end, flags)
        }
    }
}
