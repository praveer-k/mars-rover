package marsrover;

import java.util.Arrays;

/**
 * @version 1.0.0
 * @since 10/30/2016
 * @author Praveer Kumar
 */
public class MarsRover{

    private int x, y;
    private int maxX, maxY;
    private final char[] directions="NESW".toCharArray();
        
    public MarsRover(int m, int n, int a, int b, char o) throws Exception{
        setLimit(m, n);
        setPosition(a, b, o);
    }
    private void setLimit(int x, int y) throws Exception{
        if(x>=0 && y>=0){
            maxX = x;
            maxY = y;
        }else{
            throw new Exception("Boundary limits cannot be negative.");
        }        
    }
    private boolean isInDirections(char a){
        boolean flag = false;
        for(int i=0; i<directions.length; i++){
            if(a==directions[i]){
                flag=true;
            }
        }
        return flag;
    }
    private int getIndexOf(char o){
        int i;
        for(i=0; i<directions.length-1; i++){
            if(Character.toUpperCase(o)==directions[i]){
                break;
            }
        }
        return i;
    }
    private void rotateRight(){
        char temp = directions[0];
        for(int i=0; i<directions.length-1; i++){
            directions[i]=directions[i+1];
        }
        directions[directions.length-1]=temp;
    }
    private void rotateLeft(){
        char temp = directions[directions.length-1];
        for(int i=directions.length-1; i>0; i--){
            directions[i]=directions[i-1];
        }
        directions[0]=temp;
    }
    private void setOrientation(char o){
        int len = directions.length/2;
        while(directions[0]!=o){
            if(getIndexOf(o)>len){
                rotateLeft();
            }else{
                rotateRight();
            }
        }
    }
    private void setPosition(int a, int b, char o) throws Exception{
        if(a>=0 && a<=maxX && b>=0 && b<=maxY){
            x = a;
            y = b;
        }else{
            throw new Exception("Trying to assign position beyond boundaries.");
        }
        if(isInDirections(o)){
            setOrientation(o);
        }else{
            throw new Exception("Given orientation not in available set.");
        }       
    }
    private boolean move(){
        if(directions[0]=='N' && y<maxY){
            y++;
            return true;
        }else if(directions[0]=='S' && y>0){
            y--;
            return true;
        }else if(directions[0]=='E' && x<maxX){
            x++;
            return true;
        }else if(directions[0]=='W' && x>0){
            x--;
            return true;
        }
        return false;
    }
    public String getPosition(){
        String loc = Integer.toString(x) + " " + Integer.toString(y) + " " + directions[0];
        return loc;
    }
    
    public String explore(String instructions){
        String execSeq="";
        for(int i=0; i<instructions.length(); i++){
            char c=Character.toUpperCase(instructions.charAt(i));
            switch (c) {
                case 'L':
                    rotateLeft();
                    execSeq+="true, ";
                    break;
                case 'R':
                    rotateRight();
                    execSeq+="true, ";
                    break;
                case 'M':
                    boolean status = move();
                    execSeq+=Boolean.toString(status)+", ";
                    break;
                default:
                    execSeq+="false, ";
                    break;
            }
        }
        execSeq = execSeq.length()>2? execSeq.substring(0, execSeq.length()-2):execSeq;
        return execSeq;
    }

}
