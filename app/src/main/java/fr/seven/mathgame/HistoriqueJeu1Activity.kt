package fr.seven.mathgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap


class HistoriqueJeu1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historique_jeu1)
        if(FirebaseAuth.getInstance().currentUser!=null){
            showData();
        }
    }
    var Eq : HashMap<String, Pair<String,Boolean>> = HashMap()


    fun showData(){
        val database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
        val databaseReference =
            FirebaseAuth.getInstance().currentUser?.let { database.getReference("userdata").child(it.uid) }
                ?.child("equations")?.orderByKey()
        if (databaseReference != null) {
            databaseReference.addChildEventListener(object : ChildEventListener {
                @SuppressLint("SetTextI18n")
                override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                    println("onChildAdded:" + dataSnapshot.key!!)
                    val content = dataSnapshot.child("content").value
                    val status = dataSnapshot.child("status").value
                    if(status!=null && content != null){
                        Eq.set(dataSnapshot.key!!,Pair(content as String,status as Boolean))
                        var sortedEq = Eq.toList()
                            .sortedBy { (key, value) -> key }.reversed()
                            .toMap()
                        updateViews(sortedEq)
                    }
                }

                @SuppressLint("SetTextI18n")
                override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                    val content = dataSnapshot.child("content").value
                    val status = dataSnapshot.child("status").value
                    if(status!=null && content != null){
                        Eq.set(dataSnapshot.key!!,Pair(content as String,status as Boolean))
                        var sortedEq = Eq.toList()
                            .sortedBy { (key, value) -> key }.reversed()
                            .toMap()
                        updateViews(sortedEq)
                    }
                }

                override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                    Eq.remove(dataSnapshot.key!!)
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
        }
    }


    fun updateViews(sortedEq: Map<String, Pair<String,Boolean>>) {
        val layout = findViewById<LinearLayout>(R.id.linearlayout)
        while(layout.childCount<sortedEq.count()) {
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
            (view2.layoutParams as LinearLayout.LayoutParams).weight = 1.0f
            (view2.layoutParams as LinearLayout.LayoutParams).width =0
            (view2.layoutParams as LinearLayout.LayoutParams).height =
                LinearLayout.LayoutParams.MATCH_PARENT
            (view2.layoutParams as ViewGroup.MarginLayoutParams).setMargins(10,0,10,0)

        }
        while(layout.childCount>sortedEq.count()){
            layout.removeViewAt(layout.childCount-1)
        }
        for(i in 0 until layout.childCount){

            var view: LinearLayout = layout.getChildAt(i) as LinearLayout;
            (view.getChildAt(0) as TextView).setText(sortedEq.get(sortedEq.keys.elementAtOrNull(i))?.first);
            if(sortedEq.get(sortedEq.keys.elementAtOrNull(i))?.second==true) {
                (view.getChildAt(0)).setBackgroundResource(R.drawable.answer_right)
            }
            else{
                (view.getChildAt(0)).setBackgroundResource(R.drawable.answer_wrong)
            }
        }

    }
}