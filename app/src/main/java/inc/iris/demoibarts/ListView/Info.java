package inc.iris.demoibarts.ListView;

import inc.iris.demoibarts.R;

/**
 * Created by Sud on 1/23/18.
 */

public class Info {
    String name, post;
    byte[] dp;

    public Info(String name, String post) {
        this.name = name;
        this.post = post;
        dp=null;
    }

  public Info(String name, String post, byte[] dp) {
        this.name = name;
        this.post = post;
       this.dp = dp;
    }

    public byte[] getDp() {
        return dp;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public void setDp(byte[] dp) {
        this.dp = dp;
    }
}
