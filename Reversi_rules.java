package TheGame;

import java.util.Vector;

/**
 * Created by sagi on 15/01/2018.
 */
public class Reversi_rules extends GameRules {

    public Reversi_rules(){}



    public boolean play(Board board, Disk disk){
        boolean didHePlayd = false;

        //checks if to move is ok
        if (disk.getRow() > board.getRow() || disk.getRow() < 0 || disk.getColumn() < 0 || disk.getColumn() > board.getColumn()) {
            return didHePlayd;
        }
        if (board.getCell(disk.getRow(),disk.getColumn()) != 0) {
            return didHePlayd;
        }

        int[] allsides = new int[8];
        lookAround(board, disk, allsides);
        for (int i = 0; i < 8; i++) {
            if (allsides[i] == 1) {
                boolean t = lookForDisk(board,disk, i , true);
                if (t) {
                    didHePlayd = true;
                    board.setCell(disk);
                }
            }
            
        }

        return didHePlayd;

    }

    private void lookAround(Board board, Disk disk, int[] v){
        if(disk.getColumn()-1>=0) {
            if(board.getCell(disk.getRow(),disk.getColumn()-1)==-disk.getColor()){
                v[0]=1;
            }
        }
        if((disk.getColumn()-1)>=0&&(disk.getRow()-1)>=0){
            if(board.getCell(disk.getRow()-1,disk.getColumn()-1)==-disk.getColor()){
                v[1]=1;
            }
        }
        if (disk.getRow()-1>=0) {
            if(board.getCell(disk.getRow()-1,disk.getColumn())==-disk.getColor()){
                v[2]=1;
            }
        }
        if (disk.getRow()-1>=0&&disk.getColumn()+1<board.getColumn()) {
            if(board.getCell(disk.getRow()-1,disk.getColumn()+1)==-disk.getColor()){
                v[3]=1;
            }
        }
        if (disk.getColumn()+1<board.getColumn()) {
            if(board.getCell(disk.getRow(),disk.getColumn()+1)==-disk.getColor()){
                v[4]=1;
            }
        }
        if (disk.getColumn()+1<board.getColumn()&&disk.getRow()+1<board.getRow()) {
            if(board.getCell(disk.getRow()+1,disk.getColumn()+1)==-disk.getColor()){
                v[5]=1;
            }
        }
        if (disk.getRow()+1<board.getRow()) {
            if(board.getCell(disk.getRow()+1,disk.getColumn())==-disk.getColor()){
                v[6]=1;
            }
        }
        if (disk.getColumn()-1>=0&&disk.getRow()+1<board.getRow()) {
            if(board.getCell(disk.getRow()+1,disk.getColumn()-1)==-disk.getColor()){
                v[7]=1;
            }
        }
    }


    private boolean lookForDisk(Board b, Disk d, int direction , boolean changePath){
        boolean isthereadisk = false;

        if (direction==0){
            for (int i = 2; i <= d.getColumn(); ++i) {
                if(b.getCell(d.getRow(),d.getColumn()-i)==0){
                    break;
                }
                else {
                    if (b.getCell(d.getRow(), d.getColumn() - i) == d.getColor()) {
                        if (changePath) {
                            for (int j = i - 1; j > 0; --j) {
                                b.setCell(new Disk(d.getRow(), d.getColumn()-j, d.getColor()));
                            }
                            if(d.getColor()==1){updateScore(i,1);}
                            else{updateScore(i,2);}
                        }
                        isthereadisk = true;
                        break;
                    }
                }
            }
        }
        if (direction==1){
            for (int i = 2; i <= d.getColumn()&&i<=d.getRow(); ++i) {
                if (b.getCell(d.getRow()-i,d.getColumn()-i)==0){break;}
                if(b.getCell(d.getRow()-i,d.getColumn()-i)==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()-j, d.getColumn()-j , d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==2){
            for (int i = 2; i <= d.getRow(); ++i) {
                if (b.getCell(d.getRow()-i,d.getColumn())==0){break;}
                if(b.getCell(d.getRow()-i,d.getColumn())==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()-j, d.getColumn(), d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==3){
            for (int i = 2; d.getColumn()+i < b.getColumn()&&i<=d.getRow(); ++i) {
                if (b.getCell(d.getRow()-i,d.getColumn()+i)==0){break;}
                if(b.getCell(d.getRow()-i,d.getColumn()+i)==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()-j, d.getColumn()+j, d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==4){
            for (int i = 2; d.getColumn()+i < b.getColumn(); ++i) {
                if (b.getCell(d.getRow(),d.getColumn()+i)==0){break;}
                if(b.getCell(d.getRow(),d.getColumn()+i)==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow(), d.getColumn()+j, d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==5){
            for (int i = 2; d.getColumn()+i < b.getColumn()&& d.getRow()+i<b.getRow(); ++i) {
                if (b.getCell(d.getRow()+i,d.getColumn()+i)==0){break;}
                if(b.getCell(d.getRow()+i,d.getColumn()+i)==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()+j, d.getColumn()+j, d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==6){
            for (int i = 2; d.getRow()+i<b.getRow(); ++i) {
                if (b.getCell(d.getRow()+i,d.getColumn())==0){break;}
                if(b.getCell(d.getRow()+i,d.getColumn())==d.getColor()){
                    if(changePath){
                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()+j, d.getColumn(), d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        if (direction==7){
            for (int i = 2; i <= d.getColumn() && d.getRow()+i < b.getRow(); ++i) {
                if (b.getCell(d.getRow()+i,d.getColumn()-i)==0){break;}
                if(b.getCell(d.getRow()+i,d.getColumn()-i)==d.getColor()){
                    if(changePath){

                        for (int j = i-1; j > 0; --j) {
                            b.setCell(new Disk(d.getRow()+j, d.getColumn()-j, d.getColor()));
                        }
                        if(d.getColor()==1){updateScore(i,1);}
                        else{updateScore(i,2);}
                    }
                    isthereadisk = true;
                    break;
                }
            }
        }
        return isthereadisk;
    }

    public boolean canPlay(Board b,Player p) {

        for (int i = 0; i < b.getRow(); ++i) {
            for (int j = 0; j < b.getColumn(); ++j) {
                if(b.getCell(i,j)==0){
                    int[] lookarray = new int[8];
                    lookAround(b,new Disk(i,j,p.getpNum()),lookarray);
                    for (int k = 0; k < 8; ++k) {
                        if (lookarray[k]==1) {
                            boolean bol =  lookForDisk(b, new Disk(i,j,p.getpNum()), k, false);
                            if(bol){return bol;}
                        }
                    }
                }
            }
        }

        return false;
    }
}
