package algo.recursive;

public class StringTokener {

    private char[] tlxmsg = null;
    private int pos = 0;
    public char[] getMsg() {
        return tlxmsg;
    }
    public int getPos(){
        return pos;
    }

    public StringTokener(String line){
        tlxmsg = line.toCharArray();
    }

    public StringTokener(char[] tlxmsg, int pos){
        this.tlxmsg = tlxmsg;
        this.pos = pos;
    }

    public StringTokener copy(){
        return  new StringTokener(tlxmsg,pos);
    }

    public boolean startWith(String msg){
        char[] chars = msg.toCharArray();
        if(pos + chars.length > this.tlxmsg.length){
            return false;
        }
        for(int i =pos,j = 0; j < chars.length;i++,j++){
            if(this.tlxmsg[i] != chars[j]){
                return false;
            }
        }
        return true;
    }

    public String getString(int len){
        return new String(tlxmsg,pos,len);
    }

    public void next(int len){
        this.pos += len;
    }

    public void setPos(StringTokener tk){
        this.pos = tk.pos;
    }

    public char get() {
        char c = tlxmsg[pos];
        pos++;
        return c;
    }

    public char peek() {
        if(pos >= tlxmsg.length){
            return 'e';
        }
        char c = tlxmsg[pos];
        System.out.println(pos + " " + c);
        return c;
    }
}
