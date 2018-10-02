package sample;

public class test {
    public static  void main(String args[]){
        Segment seg=new Segment();
        //System.out.println(seg.toString());
        //list_test();
        Player player=new Player();
        //player.moveDown();
        player.moveUp();
        player.moveDown();
        System.out.println(player.getPos());
    }
    private static void list_test(){
        SegmentList seggy=new SegmentList();
        int counter=0;
        while(counter<3){
            System.out.println(seggy.toString());
            seggy.update();
            counter=counter+1;
        }
    }
}
