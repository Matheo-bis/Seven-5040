package fr.seven.mathgame

import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.RequiresApi
import android.os.Build
import android.os.Bundle
import fr.seven.mathgame.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.TextView
import com.squareup.picasso.Picasso
import android.widget.VideoView
import android.content.Intent
import android.view.View
import android.widget.ImageView
import fr.seven.mathgame.Jeu1Activity
import fr.seven.mathgame.Jeu2Activity
import fr.seven.mathgame.Jeu3Activity
import fr.seven.mathgame.CalculatriceActivity
import fr.seven.mathgame.EcranFinActivity
import fr.seven.mathgame.ParametresActivity
import fr.seven.mathgame.RankingActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val firebaseAuth = FirebaseAuth.getInstance()
            val User = firebaseAuth.currentUser
            if (User!!.displayName != null && User.displayName!!.compareTo("") != 0) {
                (findViewById<View>(R.id.textView4) as TextView).text = User.displayName
            } else {
                (findViewById<View>(R.id.textView4) as TextView).text = User.email!!.split("@").toTypedArray()[0]
            }
            Picasso.get().load(User.photoUrl).into(findViewById<View>(R.id.imageView) as ImageView)
        } catch (e: Exception) {
            System.err.print(e)
        }
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        val videoView = findViewById<VideoView>(R.id.videoView)
    }

    fun goto_jeu1(view: View?) {
        val intent = Intent(this, Jeu1Activity::class.java)
        startActivity(intent)
    }

    fun goto_jeu2(view: View?) {
        val intent = Intent(this, Jeu2Activity::class.java)
        startActivity(intent)
    }

    fun goto_jeu3(view: View?) {
        val intent = Intent(this, Jeu3Activity::class.java)
        startActivity(intent)
    }

    fun goto_calc(view: View?) {
        val intent = Intent(this, CalculatriceActivity::class.java)
        startActivity(intent)
    }

    fun goto_win(view: View?) {
        val intent = Intent(this, EcranFinActivity::class.java)
        intent.putExtra("action", "win")
        startActivity(intent)
    }

    fun goto_lose(view: View?) {
        val intent = Intent(this, EcranFinActivity::class.java)
        intent.putExtra("action", "lose")
        startActivity(intent)
    }

    fun goto_wide(view: View?) {
        val intent = Intent(this, EcranFinActivity::class.java)
        intent.putExtra("action", "wide")
        startActivity(intent)
    }

    fun goto_settings(view: View?) {
        val intent = Intent(this, ParametresActivity::class.java)
        startActivity(intent)
    }

    fun goto_ranking(view: View?) {
        val intent = Intent(this, RankingActivity::class.java)
        startActivity(intent)
    }


}