package dev.gumato.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Display_Posts (var post: List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.posts_list_item,parent,false)
        return  PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(post[position])
    }

    override fun getItemCount(): Int {
        return post.size
    }
}
class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    private var tvtitle:TextView=itemView.findViewById(R.id.tvtitle)
    private var tvBody:TextView=itemView.findViewById(R.id.tvBody)
    private var tvId :TextView=itemView.findViewById(R.id.tvId)
    private var tvUserId: TextView=itemView.findViewById(R.id.tvUserId)

    fun bindView(post: Post){
        tvtitle.text=post.title
        tvBody.text=post.body
        tvUserId.text=post.userId.toString()
        tvId.text=post.id.toString()
    }
}
