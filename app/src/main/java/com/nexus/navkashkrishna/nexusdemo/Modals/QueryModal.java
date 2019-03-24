package com.nexus.navkashkrishna.nexusdemo.Modals;

public class QueryModal {
    String question,ans;


    public QueryModal(String question, String ans) {

        this.question=question;
        this.ans=ans;


    }
    public QueryModal()
    {

    }

    public String getAns() {
        return ans;
    }

    public String getQuestion() {
        return question;
    }
}
