package com.example.gituserplatform

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gituserplatform.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listUserAdapter: ListUserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataAvatar: TypedArray

    private val listUser = arrayListOf<ListUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listUserAdapter = ListUserAdapter(listUser)
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listUserAdapter
        }
        prepare()
        addItem()
    }

    private fun prepare() {
        resources.apply {
            dataName = getStringArray(R.array.name)
            dataLocation = getStringArray(R.array.location)
            dataAvatar = obtainTypedArray(R.array.avatar)
            dataRepository = getStringArray(R.array.repository)
            dataUsername = getStringArray(R.array.username)
            dataCompany = getStringArray(R.array.company)
            dataFollowers = getStringArray(R.array.followers)
            dataFollowing = getStringArray(R.array.following)
        }
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = ListUser(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position, -1)
            )
            listUser.add(user)
        }
        listUserAdapter.listUser = listUser
    }
}