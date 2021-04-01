package app.android.wfn.graphqldemo.ui.launchlist

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.android.wfn.graphqldemo.LaunchListQuery
import app.android.wfn.graphqldemo.R
import com.apollographql.apollo.api.Response
import com.bumptech.glide.Glide

class LaunchListAdapter (private val launchList: Response<LaunchListQuery.Data>) :
RecyclerView.Adapter<LaunchListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.launcherName.text = launchList.data?.launches?.launches?.get(position)?.site

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Glide.with(holder.imgLauncher.context)
                .load(launchList.data?.launches?.launches?.get(position)?.mission?.missionPatch)
                .placeholder(holder.imgLauncher.context.getDrawable(R.drawable.ic_launcher_background))
                .into(holder.imgLauncher)
        }
    }

    override fun getItemCount(): Int {
        return launchList.data?.launches?.launches?.size!!
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imgLauncher: ImageView = v.findViewById<View>(R.id.imgLauncher) as ImageView
        var launcherName: TextView = v.findViewById<View>(R.id.tvLauncherName) as TextView

    }
}