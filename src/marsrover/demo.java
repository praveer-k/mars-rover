package marsrover;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version 1.0.0
 * @since 10/30/2016
 * @author Praveer Kumar
 */
public class demo {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs;
        try {
            /*System.out.print("Enter the number of Rovers : ");*/
            int i = Integer.parseInt(br.readLine());
            /* Enter Max Co-ordinates, upper-right coordinates */
            strs = br.readLine().split(" ");
            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);                
            for(int j=0;j<i;j++){
                /* Enter initial position */
                strs = br.readLine().split(" ");
                int x = Integer.parseInt(strs[0]);
                int y = Integer.parseInt(strs[1]);
                char o = strs[2].charAt(0);
                MarsRover mr = new MarsRover(m,n,x,y,o);
                /* Enter instructions telling the rover how to explore the plateau */
                mr.explore(br.readLine());
                String output = mr.getPosition();
                System.out.println(output);
            }            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
