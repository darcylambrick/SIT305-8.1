package com.example.llamaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_USER = 0;
    private static final int VIEW_TYPE_BOT = 1;

    private Context context;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        return message.isUser() ? VIEW_TYPE_USER : VIEW_TYPE_BOT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_USER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_message_user, parent, false);
            return new UserMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_message_bot, parent, false);
            return new BotMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (holder instanceof UserMessageViewHolder) {
            ((UserMessageViewHolder) holder).textMessage.setText(message.getMessage());
        } else if (holder instanceof BotMessageViewHolder) {
            ((BotMessageViewHolder) holder).textMessage.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage;
        ImageView avatarImage;

        public UserMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessage = itemView.findViewById(R.id.text_message);
            avatarImage = itemView.findViewById(R.id.avatar_image);
        }
    }

    public static class BotMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage;
        ImageView avatarImage;

        public BotMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessage = itemView.findViewById(R.id.text_message);
            avatarImage = itemView.findViewById(R.id.avatar_image);
        }
    }
}
