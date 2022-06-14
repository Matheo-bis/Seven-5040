package fr.seven.mathgame

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.view.View;
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import java.util.*
class MatchmakingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchmaking)
        showData()
    }

    var Matches : HashMap<String, String> = HashMap()
    var server = false;
    var enemy = ""
    var selectedMatchId = "";

    fun start_game(){
        val intent = Intent(this, JeuMultiActivity::class.java)
        intent.putExtra("server",server);
        intent.putExtra("enemy",enemy);
        intent.putExtra("MatchID",selectedMatchId);
        startActivity(intent)
        finish()
    }
    fun create_match(view: View?) {
        server = true;
        findViewById<TextView>(R.id.textView9).setText("Attente d'un joueur...")
        val parent = (findViewById<TextView>(R.id.textView9)).parent as ConstraintLayout
        parent.removeView(findViewById(R.id.buttoncreatematch))
        findViewById<ScrollView>(R.id.scrollView2).isVisible=false

        findViewById<TextView>(R.id.textView9).setText("Attente d'un joueur...")

        try {
            val database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
            val databaseReference = database
                    .getReference("matchmaking")
                    .push()
            selectedMatchId = databaseReference.key as String
            databaseReference.child("host").setValue(FirebaseAuth.getInstance().currentUser!!.uid)
            databaseReference.addChildEventListener(object: ChildEventListener{
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    println(snapshot.key!! as String)
                    if(snapshot.key!! as String == "guest"){
                        databaseReference.removeValue()
                        enemy = snapshot.value as String
                        start_game()
                    }
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onChildRemoved(snapshot: DataSnapshot) {}

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onCancelled(error: DatabaseError) {}

            })
        } catch (e: Exception) {
            println(e)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (server)
        FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("matchmaking").child(selectedMatchId).removeValue()
    }

    fun showData() {
        val database =
            FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
        FirebaseAuth.getInstance().currentUser?.let { database.getReference("matchmaking") }
            ?.addChildEventListener(object : ChildEventListener {
                @SuppressLint("SetTextI18n")
                override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                    println("onChildAdded:" + dataSnapshot.key!!)
                    val hostID = dataSnapshot.child("host").value as String
                    println(hostID)
                    val reference = database.getReference("userdata").child(
                        hostID
                    )
                    reference.child("username").get().addOnCompleteListener { task ->
                        if (task.result.exists()) {
                            Matches[dataSnapshot.key!!] = task.result.value as String
                            println(task.result.value)
                            updateViews()
                        }
                    }
                }

                @SuppressLint("SetTextI18n")
                override fun onChildChanged(
                    dataSnapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    println("onChildChanged:" + dataSnapshot.key!!)
                    val hostID = dataSnapshot.child("host").value as String
                    val reference = database.getReference("userdata").child(
                        hostID
                    )
                    reference.child("username").get().addOnCompleteListener { task ->
                        if (task.result.exists()) {
                            Matches[dataSnapshot.key!!] = task.result.value as String
                            updateViews()
                        }
                    }
                }

                override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                    Matches.remove(dataSnapshot.key!!)
                    updateViews();
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
    }


    fun updateViews() {
        val layout = findViewById<LinearLayout>(R.id.linearlayout)
        while(layout.childCount<Matches.count()) {
            val horizontalLayout = LinearLayout(applicationContext)
            horizontalLayout.setBackgroundResource(R.drawable.answer_wrong)
            horizontalLayout.orientation = LinearLayout.HORIZONTAL
            horizontalLayout.weightSum = 1.0f
            layout.addView(horizontalLayout)
            (horizontalLayout.layoutParams as LinearLayout.LayoutParams).width =
                LinearLayout.LayoutParams.MATCH_PARENT
            (horizontalLayout.layoutParams as ViewGroup.MarginLayoutParams).setMargins(20, 20, 20, 20)

            (horizontalLayout.layoutParams as LinearLayout.LayoutParams).height = 150

            val view2 = androidx.appcompat.widget.AppCompatButton(applicationContext);
            view2.setBackgroundResource(R.drawable.button)
            view2.gravity = Gravity.CENTER
            view2.width=0;
            view2.setTextColor(resources.getColor(R.color.colorText))
            view2.textSize = 24.0f
            view2.setBackgroundResource(R.drawable.button)
            horizontalLayout.addView(view2);
            (view2.layoutParams as LinearLayout.LayoutParams).weight = 1.0f
            (view2.layoutParams as LinearLayout.LayoutParams).width =0
            (view2.layoutParams as LinearLayout.LayoutParams).height =
                LinearLayout.LayoutParams.MATCH_PARENT
            (view2.layoutParams as ViewGroup.MarginLayoutParams).setMargins(10,0,10,0)

        }
        while(layout.childCount>Matches.count()){
            layout.removeViewAt(layout.childCount-1)
        }
        for(i in 0 until layout.childCount){

            var view: LinearLayout = layout.getChildAt(i) as LinearLayout;
            (view.getChildAt(0) as androidx.appcompat.widget.AppCompatButton)
                .setText(Matches.get(Matches.keys.elementAtOrNull(i)));
            (view.getChildAt(0) as androidx.appcompat.widget.AppCompatButton)
                .setOnClickListener(object :View.OnClickListener {
                    override fun onClick(v: View?) {
                        val database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        val databaseReference = database
                            .getReference("matchmaking")
                            .child(Matches.keys.elementAtOrNull(i) as String)
                            .child("guest")
                            .setValue(FirebaseAuth.getInstance().currentUser?.displayName)
                        enemy = Matches.get(Matches.keys.elementAtOrNull(i)) as String
                        selectedMatchId = Matches.keys.elementAtOrNull(i) as String
                        start_game()
                    }
                })

        }

    }

}