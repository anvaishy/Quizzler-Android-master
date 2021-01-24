package com.londonappbrewery.quizzler;

public class Data {
    private int q;
    private boolean ans;
    public Data(int questionnum, boolean exp)
    {
        q=questionnum;
        ans=exp;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
