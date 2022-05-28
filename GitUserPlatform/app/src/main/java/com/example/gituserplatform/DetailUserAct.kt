package com.example.gituserplatform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gituserplatform.databinding.GituserDetailBinding

class DetailUserAct : AppCompatActivity() {
    companion object{
        const val DATA = "data"
    }

    private lateinit var binding: GituserDetailBinding
    private lateinit var user: ListUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GituserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra(DATA)!!

        binding.apply {
            tvNameDetail.text = user.name
            tvUsername.text = user.username
            tvFollowers.text = user.followers
            tvFollowing.text = user.following
            tvRepository.text = user.repository
            tvCompany.text = user.company
            tvLocationDetail.text = user.location
            circleImgDetail.setImageResource(user.avatar)
        }
    }
}