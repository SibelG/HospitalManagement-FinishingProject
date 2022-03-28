package com.example.hbyssystemmanagement.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.hbyssystemmanagement.Model.Rating
import com.example.hbyssystemmanagement.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ShowCommentActivity() : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var database: FirebaseDatabase
    lateinit var ref: DatabaseReference
    lateinit var refreshLayout: SwipeRefreshLayout
    var doctorId: String? = ""
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_comment)
        database = FirebaseDatabase.getInstance()
        ref = database!!.getReference("Rating")
        recyclerView = findViewById(R.id.recyclerComment)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        refreshLayout = findViewById(R.id.swipeLayout)

            if (intent != null) {
                doctorId = intent.getStringExtra("doctorId")
                if (!doctorId!!.isEmpty() && doctorId != null) {
                    val query = ref!!.orderByChild("doctorId").equalTo(doctorId)
                    val rating: FirebaseRecyclerOptions<Rating> =
                        FirebaseRecyclerOptions.Builder<Rating>()
                            .setQuery(query, Rating::class.java)
                            .build()
                    val adapter =
                        object : FirebaseRecyclerAdapter<Rating, ShowCommentViewHolder>(rating) {
                            protected override fun onBindViewHolder(
                                showCommentViewHolder: ShowCommentViewHolder,
                                i: Int,
                                rating: Rating
                            ) {
                                showCommentViewHolder.userRating.rating =
                                    rating.rateValue!!.toFloat()
                                showCommentViewHolder.userComment.setText(rating.comment)
                                showCommentViewHolder.userEmail.setText(rating.userEmail)
                            }

                            override fun onCreateViewHolder(
                                parent: ViewGroup,
                                viewType: Int
                            ): ShowCommentViewHolder {
                                val view: View = LayoutInflater.from(parent.context)
                                    .inflate(R.layout.comment_layout_item, parent, false)
                                return ShowCommentViewHolder(view)
                            }
                        }
                    adapter.startListening()
                    recyclerView.setAdapter(adapter)

                }
            }
    }
    inner class ShowCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var  userEmail = itemView.findViewById(R.id.email) as EditText
        var userComment = itemView.findViewById(R.id.Address) as EditText
        var userRating = itemView.findViewById(R.id.rating) as RatingBar

    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }
}