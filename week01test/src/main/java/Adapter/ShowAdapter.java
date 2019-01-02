package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week01test.R;

import java.util.ArrayList;
import java.util.List;

import entuty.UserMain;

public class ShowAdapter extends BaseAdapter {
    private Context context;
    private List<UserMain.DataBean.FenleiBean> list;

    public ShowAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserMain.DataBean.FenleiBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.toobar,parent,false);
      viewHolder.icon = convertView.findViewById(R.id.icon);
      viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
      viewHolder.tv_time = convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        }else{
           viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tv_time.setText(list.get(position).getCreatetime());
        viewHolder.tv_name.setText(list.get(position).getName());
        return convertView;
    }
    class ViewHolder{
        ImageView icon;
        TextView tv_name,tv_time;
    }
}
