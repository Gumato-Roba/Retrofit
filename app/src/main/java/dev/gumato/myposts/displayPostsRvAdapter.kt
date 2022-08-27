package dev.gumato.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.gumato.myposts.databinding.PostsListItemBinding

class displayPostsRvAdapter(var displayPosts:List<Post>):
    RecyclerView.Adapter<displayPostsRvAdapter.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
        var binding = PostsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: displayPostsRvAdapter.PostViewHolder, position: Int) {
        var currentPosts = displayPosts.get(position)
        holder.binding.tvtitle.text = currentPosts.title
        holder.binding.tvBody.text = currentPosts.body

        val context = holder.itemView.context
        holder.binding.cvPost.setOnClickListener{
            val intent = Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID",currentPosts.id)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return displayPosts.size
    }
    class PostViewHolder(var binding: PostsListItemBinding): RecyclerView.ViewHolder(binding.root)

}
