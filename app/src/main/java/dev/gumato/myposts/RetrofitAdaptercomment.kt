package dev.gumato.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.gumato.myposts.databinding.ActivityCommentsBinding

class RetrofitAdaptercomment (var commentlist:List<Post>):RecyclerView.Adapter<RetrofitAdaptercomment.CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding=ActivityCommentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)


    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComments=commentlist.get(position)

        var context = holder.itemView.context
        holder.binding.cvComments.setOnClickListener {
           val intent = Intent(context, CommentsActivity::class.java)
            intent.putExtra("COMMENT_ID", currentComments.id)
            context.startActivity(intent)
        }

        with(holder.binding){
            tvPostTitle.text=currentComments.title
            tvPostBody.text=currentComments.body
        }
    }

    override fun getItemCount(): Int {
        return commentlist.size
    }



class CommentsViewHolder(var binding: ActivityCommentsBinding):
    RecyclerView.ViewHolder(binding.root)
}
