public class MushCoord {
    public int x,y;
    public boolean used;
    public MushCoord(int nX,int nY){
        this.x = nX;
        this.y =nY;
        used=false;
    }
    public void print(){
        System.out.print("("+x+","+y+") ");
    }
    @Override
    public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof MushCoord){
            MushCoord ptr = (MushCoord) v;
            if(ptr.x==this.x&&ptr.y==this.y&&ptr.used==false){
                retVal=true;
            }
            //retVal = ptr.id.longValue() == this.id;
        }

        return retVal;
    }
}
