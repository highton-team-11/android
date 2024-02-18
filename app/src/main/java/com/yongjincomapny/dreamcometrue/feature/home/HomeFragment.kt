package com.yongjincomapny.dreamcometrue.feature.home

import android.content.Intent
import android.net.Uri
import android.text.Spannable
import android.text.style.ImageSpan
import android.text.style.QuoteSpan
import android.text.style.URLSpan
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.databinding.FragmentHomeBinding
import com.yongjincomapny.dreamcometrue.feature.home.adapter.DetailImageAdapter
import com.yongjincomapny.dreamcometrue.feature.home.adapter.NewHomePostAdapter
import com.yongjincomapny.dreamcometrue.feature.home.adapter.NewHomePostThreeAdapter
import com.yongjincomapny.dreamcometrue.feature.home.adapter.NewHomePostTwoAdapter
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private var newHomePostAdapter: NewHomePostAdapter? = null
    private var newHomePostTwoAdapter: NewHomePostTwoAdapter? = null
    private var newHomePostThreeAdapter: NewHomePostThreeAdapter? = null
    private var newHomePostJobAdapter: DetailImageAdapter? = null

    override fun init() {
        super.init()

        val postApi = RetrofitClient.postApi()

        val jobList = listOf<Int>(R.drawable.mask_group, R.drawable.maskgroup_1, R.drawable.maskgroup_2, R.drawable.maskgroup3, R.drawable.maskgroup4, R.drawable.maskgroup5, R.drawable.maskgroup6, R.drawable.maskgroup7, R.drawable.maskgroup8, R.drawable.maskgroup9)
        newHomePostJobAdapter = DetailImageAdapter(jobList) {
            when (it) {
                R.drawable.mask_group -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do;jsessionid=9E1C454AE9F1D9CE740D72135177FC80")
                        )
                    )
                }

                R.drawable.maskgroup_1 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do;jsessionid=9E1C454AE9F1D9CE740D72135177FC80")
                        )
                    )
                }

                R.drawable.maskgroup_2 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do;jsessionid=9E1C454AE9F1D9CE740D72135177FC80")
                        )
                    )
                }
                R.drawable.maskgroup3 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup4 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup5 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup6 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup7 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup8 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
                R.drawable.maskgroup9 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.career.go.kr/cnet/front/counsel/jinsolView.do")
                        )
                    )
                }
            }
        }

        lifecycleScope.launch {
            runCatching {
                postApi.getAllPosts()
            }.onSuccess {
                newHomePostAdapter?.setData(it.filter { it.indexa == 0 })
                newHomePostTwoAdapter?.setData(it.filter { it.indexa == 1 })
                newHomePostThreeAdapter?.setData(it.filter { it.indexa == 2 })
            }
        }
        binding.rvJob.adapter = newHomePostJobAdapter
        val imageAdapter = DetailImageAdapter(
            listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
        ) {
            when (it) {
                R.drawable.banner1 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.cyber1388.kr:447/")
                        )
                    )
                }

                R.drawable.banner2 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.gov.kr/portal/yngbgsSportSvc.do?yngbgsSvcClsCd=01")
                        )
                    )
                }

                R.drawable.banner3 -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.gov.kr/portal/yngbgsFcltyYgList.do")
                        )
                    )
                }
            }
        }

        binding.viewpager.adapter = imageAdapter


        newHomePostAdapter = NewHomePostAdapter()
        binding.rvNoWantAnything.adapter = newHomePostAdapter

        newHomePostTwoAdapter = NewHomePostTwoAdapter()
        binding.rvFindOneJob.adapter = newHomePostTwoAdapter

        newHomePostThreeAdapter = NewHomePostThreeAdapter()
        binding.rvInterestingJob.adapter = newHomePostThreeAdapter

        val strongList = arguments?.getStringArray("strongList")
        val interestList = arguments?.getStringArray("interestList")

        binding.linearHomeMyPage.setOnDebounceClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_myPageFragment,
                bundleOf("strongList" to strongList, "interestList" to interestList)
            )
        }

        binding.wormDotsIndicator.attachTo(binding.viewpager)
        // displayHtml()
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
