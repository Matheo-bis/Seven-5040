package fr.seven.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.seven.mathgame.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.auth.FirebaseAuth
import fr.seven.mathgame.ScoreActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
    }

    companion object {
        private var score = 0
        private var database: FirebaseDatabase? = null
        private var reference: DatabaseReference? = null
        @JvmStatic
        fun initScore() {
            val firebaseAuth = FirebaseAuth.getInstance()
            if (firebaseAuth.currentUser != null) {
                database =
                    FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                reference = database!!.getReference("userdata").child(
                    firebaseAuth.currentUser!!.uid
                )
                reference!!.child("score").get().addOnCompleteListener { task ->
                    if (task.result.exists()) score =
                        (task.result.value as Long).toInt() else score = 0
                }
            } else {
                score = 0
            }
        }

        @JvmStatic
        fun getScore(): Int {
            return score
        }

        @JvmStatic
        fun setScore(x: Int) {
            val firebaseAuth = FirebaseAuth.getInstance()
            score = score + x
            if (firebaseAuth.currentUser != null) reference!!.child("score").setValue(score)
        }


    }
}