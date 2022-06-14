package fr.seven.mathgame

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import java.lang.annotation.Native

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

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        val tuto_5 = AlertDialog.Builder(this)
                .setTitle("Bienvenue!")
                .setMessage("Le bouton en haut à gauche permet d'accéder aux paramètres, et la photo de profil (ainsi que le nom) permet d'accéder au profil")
                .setPositiveButton("Fini!") { dialogInterface: DialogInterface?, i: Int -> }
        val tuto_4 = AlertDialog.Builder(this)
                .setTitle("Bienvenue!")
                .setMessage("Il y a aussi une calculatrice, des cours et un classement")
                .setPositiveButton("Suivant") { dialogInterface: DialogInterface?, i: Int -> tuto_5.show() }
        val tuto_3 = AlertDialog.Builder(this)
                .setTitle("Bienvenue!")
                .setMessage("... Et le jeu 3 est un duel en multijoueur!")
                .setPositiveButton("Suivant") { dialogInterface: DialogInterface?, i: Int -> tuto_4.show() }
        val tuto_2 = AlertDialog.Builder(this)
                .setTitle("Bienvenue!")
                .setMessage("... Le jeu 2 est un désamorçage en temps limité (oui oui)...")
                .setPositiveButton("Suivant") { dialogInterface: DialogInterface?, i: Int -> tuto_3.show() }
        if (!sharedPreferences.getBoolean("Tuto_fini", false)) {
            editor.putBoolean("Tuto_fini", true)
            editor.apply()
            AlertDialog.Builder(this)
                    .setTitle("Bienvenue!")
                    .setMessage("Voici le menu principal, Le jeu 1 est un quiz d'entraînement...")
                    .setPositiveButton("Suivant") { dialogInterface: DialogInterface?, i: Int -> tuto_2.show() }
                    .show()
        }
    }

    fun goto_jeu1(view: View?) {
        val intent = Intent(this, Jeu1Activity::class.java)
        startActivity(intent)
    }

    fun goto_jeu2(view: View?) {
        val intent = Intent(this, LancementJeu2Activity::class.java)
        startActivity(intent)
    }

    fun goto_jeu3(view: View?) {
        val intent = Intent(this, LancementJeu3Activity::class.java)
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

    fun goto_profil(view: View?) {
        val intent = Intent(this, ProfilActivity::class.java)
        startActivity(intent)
    }

    fun goto_cours(view: View?) {
        val intent = Intent(this, CoursActivity::class.java)
        startActivity(intent)
    }

}