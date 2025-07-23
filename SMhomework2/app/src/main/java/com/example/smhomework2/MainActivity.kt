package com.example.smhomework2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private val picturesList = listOf(
        "https://avtospravochnaya.com/images/Novosti/2025/04/08/%D0%A1%D0%BA%D1%80%D0%B8%D0%BD%D1%88%D0%BE%D1%82%2025-04-2025%20124703.jpg",
        "https://petrograph.ru/wp-content/uploads/2023/12/drift-toiota-mark-2-iaponiia-noch-1.webp",
        "https://photobooth.cdn.sports.ru/preset/message/c/fc/6295d081b4c8aab323a284292434f.jpeg?f=webp&q=90&s=2x&w=730",
        "https://balthazar.club/uploads/posts/2023-01/1674334544_balthazar-club-p-estetika-snoubord-vkontakte-4.jpg",
        "https://img3.akspic.ru/crops/3/4/2/6/3/136243/136243-zanyatie_sportom-zamorazhivanie-ekstremalnyj_vid_sporta-zima-gornye_lyzhi-1920x1080.jpg",
        "https://vetacademy.ru/upload/medialibrary/3c2/nnq12ksakmngrcmcaeiged5195hz2gbj.jpg",
        "https://static.tildacdn.com/tild6437-6239-4261-a536-643464613562/461A5032.jpg",
        "https://opis-cdn.tinkoffjournal.ru/mercury/kung-fu-panda-4-review-in-out.zy7kgud4ytt6..jpg",
        "https://img-webcalypt.ru/uploads/admin/images/meme-templates/9734d07ebef0361ad54f99270260522b.jpg",
        "https://hdpic.club/uploads/posts/2021-12/1640769033_1-hdpic-club-p-nissan-skailain-iz-forsazha-1.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val loadImageButton = findViewById<Button>(R.id.loadImageButton)
        val goToSecondScreenButton = findViewById<Button>(R.id.goToSecondScreenButton)

        loadImageButton.setOnClickListener() {
            val randomIndex = (0..9).random()
            val imageRandom = picturesList[randomIndex]

            Glide.with(this)
                .load(imageRandom)
                .into(imageView)
        }

        goToSecondScreenButton.setOnClickListener() {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


}