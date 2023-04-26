package com.example.mytodolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytodolist.data.TaskItem
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.databinding.FragmentItemListBinding

class TaskFragment : Fragment(), ToDoListListener {
    private lateinit var binding: FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater, container, false)

        //Set the adapter
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyTaskRecyclerViewAdapter(Tasks.ITEMS, this@TaskFragment)
        }

        binding.addButton.setOnClickListener { addButtonClick() }
        return binding.root
    }


    private fun addButtonClick() {
        findNavController().navigate(R.id.action_taskFragment_to_addTaskFragment)

    }

    override fun onItemClick(position: Int) {
        val actionTaskFragmentToDisplayTaskFragment =
            TaskFragmentDirections.actionTaskFragmentToDisplayTaskFragment(Tasks.ITEMS[position])
                findNavController().navigate(actionTaskFragmentToDisplayTaskFragment)
    }

    override fun onItemLongClick(position: Int) {
        TODO("Not yet implemented")
    }

}