package app.android.wfn.graphqldemo.ui.launchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import app.android.wfn.graphqldemo.LaunchListQuery
import app.android.wfn.graphqldemo.databinding.LaunchFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : Fragment(){
    companion object {
        fun newInstance() =
            LaunchFragment()
    }

    private val viewModel: LaunchViewModel by viewModels()
    private lateinit var binding: LaunchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LaunchFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            viewModel.response.observe(
                viewLifecycleOwner,
                Observer<com.apollographql.apollo.api.Response<LaunchListQuery.Data>> { list ->
                    list?.let {
                        setupListAdapter(list)
                    }
                })
        }
    }

    private fun setupListAdapter(launchList: com.apollographql.apollo.api.Response<LaunchListQuery.Data>) {
        binding.rvLaunchList.layoutManager = LinearLayoutManager(context)
        binding.rvLaunchList.adapter = LaunchListAdapter(launchList)
    }

}