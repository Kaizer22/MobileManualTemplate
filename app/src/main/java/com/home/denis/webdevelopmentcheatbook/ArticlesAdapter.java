package com.home.denis.webdevelopmentcheatbook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticlesAdapter extends BaseAdapter{
    private ArrayList<Article> articles;
    private LayoutInflater layoutInflater;
    private Context context;

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int i) {
        return articles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_article_layout, null);
            holder = new ViewHolder();
            holder.languageView = convertView.findViewById(R.id.imageView_language);
            holder.articleNameView = convertView.findViewById(R.id.textView_articleName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article article = this.articles.get(position);
        holder.articleNameView.setText(article.getHeadline());

        int imageId = this.getMipmapResIdByName(article.getLanguage().toString().toLowerCase());

        holder.languageView.setImageResource(imageId);

        return convertView;
    }

    static class ViewHolder {
        ImageView languageView;
        TextView articleNameView;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    private class Article{
        private Language language;
        private String headline;

        Article(Language language, String headline){
            this.language = language;
            this.headline = headline;
        }

        Language getLanguage() {
            return language;
        }

        String getHeadline() {
            return headline;
        }
    }

    ArticlesAdapter(Context aContext){
        this.context = aContext;
        layoutInflater = LayoutInflater.from(aContext);

        loadArticles();
    }


    public String[] getHeadLines(){
        ArrayList<String> result = new ArrayList<>();


        for (Article a:articles) {
            result.add(a.getHeadline());
        }

        String[] f = new String[result.size()];
        return result.toArray(f);
    }

    private void loadArticles(){
        articles = new ArrayList<>();
        articles.add(new Article(Language.HTML, "1. Структура файла"));
        articles.add(new Article(Language.HTML, "2. Теги"));
        articles.add(new Article(Language.JavaScript, "1. JavaSript"));
        articles.add(new Article(Language.CSS, "1. CSS"));
    }

    public enum Language{
        HTML, CSS, JavaScript;
    }
}
