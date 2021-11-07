package com.example.letschat

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(val context: Context, val messageList: ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder.javaClass == SendViewHolder::class.java) {
            // do the stuff for send view holder
            val viewHolder = holder as SendViewHolder
        } else {

            // do the stuff for receive view holder
            val viewHolder = holder as ReceiveViewHolder
        }
    }

    override fun getItemCount(): Int {

    }

    class SendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class ReceiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}