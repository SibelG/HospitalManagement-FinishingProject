package com.example.hbyssystemmanagement.View

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hbyssystemmanagement.Model.Message
import com.example.hbyssystemmanagement.R
import com.example.hbyssystemmanagement.adapters.SendMessageAdapter
import com.google.firebase.database.*

class SendMessageActivity : AppCompatActivity() {

    var databaseReference: DatabaseReference? = null
    lateinit var mainActivityRecyclerView:RecyclerView
    lateinit var linearLayoutManager : LinearLayoutManager
    var data: ArrayList<Message>?=null
    lateinit var sendText:EditText
    lateinit var sendMessageButton: ImageView
    var doctorId:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)



        mainActivityRecyclerView=findViewById(R.id.sendRecyclerView)
        databaseReference = FirebaseDatabase.getInstance().reference
        linearLayoutManager = LinearLayoutManager(this)
        mainActivityRecyclerView.layoutManager = linearLayoutManager
        sendText=findViewById(R.id.sendText)
        sendMessageButton=findViewById(R.id.sendMessageButton)


        if(intent.getStringExtra("doctorId")!=null){
            doctorId= intent.getStringExtra("doctorId")!!
            getMessageFirebase(doctorId)
        }



        sendMessageButton.setOnClickListener {
            sendData(doctorId)
        }

    }

    private fun sendData(doctorId: String){
        if (!sendText.text.toString().isEmpty()){
            databaseReference?.child("Messages")?.child(doctorId)?.
            child(java.lang.String.valueOf(System.currentTimeMillis()))?.
            setValue(Message(sendText.text.toString()))

            //clear the text
            sendText.setText("")
            getMessageFirebase(doctorId)
        } else{
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
        }

    }


    private fun getMessageFirebase(doctorId:String){
        databaseReference?.child("Messages")?.child(doctorId)?.addValueEventListener( object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val toReturn: ArrayList<Message> = ArrayList();

                for(data in snapshot.children){
                    val messageData = data.getValue(Message::class.java)
                    val message = messageData?.let { it } ?: continue
                    toReturn.add(message)
                    //toReturn.add(messageData!!)
                    //unwrap
                    //val message = messageData?.let { it } ?: continue

                }

                toReturn.sortBy { message ->
                    message.timestamp
                }

                mainActivityRecyclerView.adapter = SendMessageAdapter(toReturn)

                //scroll to bottom
                mainActivityRecyclerView.scrollToPosition(toReturn.size - 1)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}


