package fr.seven.mathgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import org.intellij.lang.annotations.JdkConstants
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        showData()

    }
    var players : HashMap<String, Long> = HashMap<String, Long> ()


    fun showData(){
        val database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
        val databaseReference = database.getReference("userdata")
        val query = databaseReference.orderByChild("score")
        query.addChildEventListener(object : ChildEventListener {
            @SuppressLint("SetTextI18n")
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                println("onChildAdded:" + dataSnapshot.key!!)
                val name = dataSnapshot.child("username").value
                val sc = dataSnapshot.child("score").value
                if(sc!=null && name != null){
                    players.set(name as String,sc as Long)
                    var sortedPlayers: LinkedHashMap<String,Long> = players.entries.sortedBy { -it.value }.associate { it.toPair() } as LinkedHashMap<String, Long>
                    updateViews(sortedPlayers)
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                val name = dataSnapshot.child("username").value
                val sc = dataSnapshot.child("score").value
                if(sc!=null && name != null) {
                    players.set(name as String,sc as Long)
                    var sortedPlayers: LinkedHashMap<String,Long> = players.entries.sortedBy { -it.value }.associate { it.toPair() } as LinkedHashMap<String, Long>
                    updateViews(sortedPlayers)                }
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                val name = dataSnapshot.child("username").value
                if(name!=null) {
                    players.remove(name)
                    var sortedPlayers: LinkedHashMap<String,Long> = players.entries.sortedBy { -it.value }.associate { it.toPair() } as LinkedHashMap<String, Long>
                    updateViews(sortedPlayers)
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }


    fun updateViews(sortedPlayers: LinkedHashMap<String,Long>) {
        val layout = findViewById<LinearLayout>(R.id.linearlayout)
        while(layout.childCount<sortedPlayers.count()) {
            val horizontalLayout = LinearLayout(applicationContext)
            horizontalLayout.setBackgroundResource(R.drawable.playerscore_back)
            horizontalLayout.orientation = LinearLayout.HORIZONTAL
            horizontalLayout.weightSum = 1.0f
            layout.addView(horizontalLayout)
            (horizontalLayout.layoutParams as LinearLayout.LayoutParams).width =
                LinearLayout.LayoutParams.MATCH_PARENT
            (horizontalLayout.layoutParams as ViewGroup.MarginLayoutParams).setMargins(20, 20, 20, 20)

            (horizontalLayout.layoutParams as LinearLayout.LayoutParams).height = 150

            val view2 = TextView(applicationContext);
            view2.setBackgroundResource(R.drawable.playerscore)
            view2.gravity = Gravity.CENTER
            view2.width=0;
            view2.setTextColor(resources.getColor(R.color.colorText))
            view2.textSize = 24.0f
            horizontalLayout.addView(view2);
            (view2.layoutParams as LinearLayout.LayoutParams).weight = 0.7f
            (view2.layoutParams as LinearLayout.LayoutParams).width =0
            (view2.layoutParams as LinearLayout.LayoutParams).height =
                LinearLayout.LayoutParams.MATCH_PARENT
            (view2.layoutParams as ViewGroup.MarginLayoutParams).setMargins(10,0,5,0)



            val view3 = TextView(applicationContext);
            view3.setBackgroundResource(R.drawable.playerscore)
            view3.setTextColor(resources.getColor(R.color.colorText))
            view3.textSize = 24.0f
            view3.width=0;
            view3.gravity = Gravity.CENTER
            horizontalLayout.addView(view3);
            (view3.layoutParams as LinearLayout.LayoutParams).weight = 0.3f
            (view3.layoutParams as LinearLayout.LayoutParams).width =0
            (view3.layoutParams as LinearLayout.LayoutParams).height =
                LinearLayout.LayoutParams.MATCH_PARENT
            (view3.layoutParams as ViewGroup.MarginLayoutParams).setMargins(5,0,10,0)
        }
        while(layout.childCount>sortedPlayers.count()){
            layout.removeViewAt(layout.childCount-1)
        }
        for(i in 0 until layout.childCount){
            var view: LinearLayout = layout.getChildAt(i) as LinearLayout;
            (view.getChildAt(0) as TextView).setText(sortedPlayers.keys.elementAtOrNull(i));
            (view.getChildAt(1) as TextView).setText(sortedPlayers.get(sortedPlayers.keys.elementAtOrNull(i)).toString());
            if(i==0){
                (view.getChildAt(0)).setBackgroundResource(R.drawable.playerscore_golden)
                (view.getChildAt(1)).setBackgroundResource(R.drawable.playerscore_golden)

            }
        }

    }


}