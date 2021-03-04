package kg.nurik.genericapiclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import kg.nurik.genericapiclient.databinding.ActivityMainBinding
import kg.nurik.genericapiclient.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val vm by viewModel<MainViewModel>()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        setupViews()
        setupListener()
    }

    private fun setupViews() {
        vm.data.observe(this, Observer {
            adapter.update(it)
        })
    }
    private fun setupListener() {
        binding.btnRefresh.setOnClickListener {
            adapter.notifyDataSetChanged()
        }
        binding.swipeRefreshLayout.setOnRefreshListener(OnRefreshListener{
            vm.data.observe(this, Observer {
                adapter.update(it)
            })
            binding.swipeRefreshLayout.isRefreshing = false

        })
    }
}