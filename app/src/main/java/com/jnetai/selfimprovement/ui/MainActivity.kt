package com.jnetai.selfimprovement.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jnetai.selfimprovement.SelfImprovement
import com.jnetai.selfimprovement.R
import com.jnetai.selfimprovement.binding.ActivityMainBinding
import com.jnetai.selfimprovement.model.Improvement
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val app get() = application as SelfImprovement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        val adapter = ImprovementAdapter { item -> startActivity(Intent(this, DetailActivity::class.java).putExtra("item_id", item.id)) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        refreshList()
        binding.fab.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }
    }

    override fun onResume() { super.onResume(); refreshList() }

    private fun refreshList() {
        lifecycleScope.launch {
            val items = app.database.dao().getAllImprovements()
            (binding.recyclerView.adapter as ImprovementAdapter).items = items
            (binding.recyclerView.adapter as ImprovementAdapter).notifyDataSetChanged()
            binding.emptyView.visibility = if (items.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { menuInflater.inflate(R.menu.menu_main, menu); return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_about -> { startActivity(Intent(this, AboutActivity::class.java)); true }
        else -> super.onOptionsItemSelected(item)
    }
}