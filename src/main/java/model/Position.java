package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * Position represents the coordinates in a two-dimension coordinate system.
 *
 * */
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    public void moveRightAlongXcoordinates(){
        x++;
    }

    public void moveLeftAlongXcoordinates(){
        x--;
    }

    public void moveUpAlongYcoordinates(){
        y++;
    }

    public void moveDownAlongYcoordinates(){
        y--;
    }

}
