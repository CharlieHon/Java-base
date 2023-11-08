package exercise_;

import java.util.ArrayList;

public class Homework01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒去恒河\"圣浴\"引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起以看赶紧放生");
        ArrayList<News> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);
        list.add(new News(null));
        int size = list.size();
        for (int i = size-1; i >= 0; i--) {
//            System.out.println(list.get(i));
            String content = list.get(i).getTitle();
            if (content == null || content.length() == 0) {
                System.out.println("内容不能为空");
                continue;
            }
            if (content.length() > 15) {
                System.out.println(content.substring(0, 15));
            } else {
                System.out.println(content);
            }
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}